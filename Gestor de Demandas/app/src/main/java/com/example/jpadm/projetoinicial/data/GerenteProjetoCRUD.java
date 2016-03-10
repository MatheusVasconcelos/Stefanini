package com.example.jpadm.projetoinicial.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.jpadm.projetoinicial.model.Demanda;
import com.example.jpadm.projetoinicial.model.GerenteProjeto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpadm on 14/12/2015.
 */
public class GerenteProjetoCRUD {

    private Context mContext;

    public GerenteProjetoCRUD(Context mContext) {
        this.mContext = mContext;
    }


    public void salvar(GerenteProjeto gerente) {

        ContentValues values = new ContentValues();

        values.put(GestorDemandasBD.COLUNAS_TBL_GERENTE[1], gerente.getmName());

        GestorDemandasBD.getInstance(mContext).getWritableDatabase().insert(
                GestorDemandasBD.NOME_TB_GERENTE, null, values);

        Log.i("SALVANDO", gerente.toString());


    }




    public void remover(GerenteProjeto gerente) {

        int gerenteId = gerente.getmID();


        GestorDemandasBD.getInstance(mContext).getWritableDatabase()
                .delete(GestorDemandasBD.NOME_TB_GERENTE,
                        GestorDemandasBD.COLUNAS_TBL_GERENTE[0] + "=" + gerenteId, null);
    }

    public void atualizar(GerenteProjeto gerente) {

        ContentValues values = new ContentValues();

        values.put(GestorDemandasBD.COLUNAS_TBL_GERENTE[0], gerente.getmID());
        values.put(GestorDemandasBD.COLUNAS_TBL_GERENTE[1], gerente.getmName());

        GestorDemandasBD.getInstance(mContext).getWritableDatabase().update(
                GestorDemandasBD.NOME_TB_GERENTE,
                values, GestorDemandasBD.COLUNAS_TBL_GERENTE[0] + "=" + gerente.getmID(), null);

    }


    public GerenteProjeto buscarPorId(int id) {

        Cursor cursor = GestorDemandasBD.getInstance(mContext).
                getReadableDatabase().query(GestorDemandasBD.NOME_TB_GERENTE,
                GestorDemandasBD.COLUNAS_TBL_GERENTE,
                GestorDemandasBD.COLUNAS_TBL_GERENTE[0] + "=" + id, null, null, null, null);

        List<GerenteProjeto> gerenteProjetos = new ArrayList<>();
        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            gerenteProjetos.add(cursorParseGerente(cursor));

        }


        return gerenteProjetos.get(0);

    }

    public List<GerenteProjeto> buscarTodos() {


        Cursor cursor = GestorDemandasBD.getInstance(mContext).
                getReadableDatabase().query(GestorDemandasBD.NOME_TB_GERENTE,
                GestorDemandasBD.COLUNAS_TBL_GERENTE, null, null, null, null, null);

        List<GerenteProjeto> gerenteProjetos = new ArrayList<>();
        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            gerenteProjetos.add(cursorParseGerente(cursor));

        }

        return gerenteProjetos;

    }


    public GerenteProjeto cursorParseGerente(Cursor cursor) {

        GerenteProjeto gerenteProjeto = new GerenteProjeto();

        gerenteProjeto.setmID(cursor.getInt(0));
        gerenteProjeto.setmName(cursor.getString(1));

        return gerenteProjeto;
    }

}
