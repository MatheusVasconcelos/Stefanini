package com.example.jpadm.projetoinicial.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.jpadm.projetoinicial.R;
import com.example.jpadm.projetoinicial.data.GerenteProjetoCRUD;
import com.example.jpadm.projetoinicial.model.Demanda;
import com.example.jpadm.projetoinicial.model.GerenteProjeto;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GerenteProjetoActivity extends AppCompatActivity {

    @Bind(R.id.gp_name)
    EditText mNomeGerente;

    GerenteProjetoCRUD gerenteProjetoCRUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerente_projeto);

        ButterKnife.bind(this);
        gerenteProjetoCRUD = new GerenteProjetoCRUD(this);

        List<GerenteProjeto> gerntes = gerenteProjetoCRUD.buscarTodos();

        for (GerenteProjeto gerente : gerntes){

            Log.i("Gerntes", gerente.toString());
        }

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadaster, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.item_save:

                salvarGerente();

                return true;

            case R.id.item_cancel:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }



    }

    public void salvarGerente(){

        GerenteProjeto gerenteProjeto = new GerenteProjeto();
        gerenteProjeto.setmName(mNomeGerente.getText()
                == null ? "" : mNomeGerente.getText().toString());

        gerenteProjetoCRUD.salvar(gerenteProjeto);
    }
}
