package com.example.jpadm.projetoinicial.controlador;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.jpadm.projetoinicial.Interface.DemandaCallBackIF;
import com.example.jpadm.projetoinicial.model.Demanda;
import com.example.jpadm.projetoinicial.parse.DemandaParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpadm on 15/12/2015.
 */
public class ControladorDemandas {

    DemandaCallBackIF demandaCallBackIF;

    public ControladorDemandas(Context context){

        demandaCallBackIF = (DemandaCallBackIF) context;
    }


    public void buscarDemandas() {

        new DemandaAsyncTask().execute();
    }


    public void trataResultado(JSONArray jsonArray)  {

        List<Demanda> demandas = new ArrayList<>();

        Demanda demanda;
        JSONObject jsonObject;

        try {

            for (int i = 0; i < jsonArray.length();i++){

                jsonObject = jsonArray.getJSONObject(i);

                demanda = new DemandaParser().parse(jsonObject.toString());
            }

            demandaCallBackIF.retornoListaDemandas(demandas);

        } catch (JsonParseException e) {
          notificacaoErro(e.getMessage());
        } catch (JsonMappingException e) {
            notificacaoErro(e.getMessage());
        } catch (JSONException e) {
               notificacaoErro(e.getMessage());
        } catch (IOException e) {
          notificacaoErro(e.getMessage());
        }


    }


    public void notificacaoErro(String mensagem) {

        demandaCallBackIF.erroServicoDemandas(mensagem);
    }


    class DemandaAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            String resultado = "";
            BufferedReader bufferedReader;


            try {
                URL url = new URL("http://10.30.80.49:8080/gestordemandas/rest/demandas");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.connect();

                StringBuilder builder = new StringBuilder();
                bufferedReader = new BufferedReader
                        (new InputStreamReader(connection.getInputStream()));

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line + "\n");

                }

                resultado = builder.toString();
                Log.i("Asynctask", resultado);

            } catch (MalformedURLException e) {

                Log.e("URL BAD FUNCTION", e.getMessage());
            } catch (IOException e) {
                Log.e("URL IO", e.getMessage());
            }


            return resultado;
        }

        @Override
        protected void onPostExecute(String resultado) {

            if (resultado == null) {
                notificacaoErro("Requisição sem resultados");
            } else {
                try {
                    JSONArray jsonArray = new JSONArray(resultado);
                } catch (JSONException e) {

                    notificacaoErro(e.getMessage());
                }
            }
        }
    }

}
