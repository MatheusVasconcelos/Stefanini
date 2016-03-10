package com.example.jpadm.projetoinicial.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.jpadm.projetoinicial.model.Demanda;
import com.example.jpadm.projetoinicial.views.ListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpadm on 17/12/2015.
 */
public class DemandasCRUD {

    private Context mContext;

    public DemandasCRUD(Context mContext) {
        this.mContext = mContext;
    }


    public void salvar(Demanda demanda) {



        ContentValues contentValues = new ContentValues();

        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[1], demanda.getmNomeGP());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[2], demanda.getmNumeroOF());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[3], demanda.getmTituloOF());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[4], demanda.getmStatusOF());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[5], demanda.getmResponsavelOF());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[6], demanda.getmPrazo());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[7], demanda.getmObservacoes());

        Log.i("SALVANDO", demanda.toString());

    }

    public void remover(Demanda demanda) {


        DemandasBD.getInstance(mContext).getWritableDatabase().delete(DemandasBD.NOME_TB_DEMANDA,
                DemandasBD.COLUNAS_TBL_DEMANDA[0] + "=" + demanda.getmId(), null);
    }

    public void atualizar_(Demanda demanda) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[0], demanda.getmId());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[1], demanda.getmNomeGP());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[2], demanda.getmNumeroOF());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[3], demanda.getmTituloOF());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[4], demanda.getmStatusOF());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[5], demanda.getmResponsavelOF());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[6], demanda.getmPrazo());
        contentValues.put(DemandasBD.COLUNAS_TBL_DEMANDA[7], demanda.getmObservacoes());


        DemandasBD.getInstance(mContext).getWritableDatabase().update(
                DemandasBD.NOME_TB_DEMANDA, contentValues,
                DemandasBD.COLUNAS_TBL_DEMANDA[0] + "=" + demanda.getmId(), null);

    }


    public List<Demanda> buscarTodos() {

        Cursor cursor = DemandasBD.getInstance(mContext).getReadableDatabase().query(
                DemandasBD.NOME_TB_DEMANDA,
                DemandasBD.COLUNAS_TBL_DEMANDA, null, null, null, null, null);

        List<Demanda> demandas = new ArrayList<>();
        cursor.moveToFirst();

        while (cursor.moveToNext()) {

            demandas.add(cursorParseGerente(cursor));
        }

        return demandas;
    }


    public Demanda cursorParseGerente(Cursor cursor) {

        Demanda demanda = new Demanda();

        demanda.setmId(cursor.getInt(0));
        demanda.setmNomeGP(cursor.getString(1));
        demanda.setmNumeroOF(cursor.getInt(2));
        demanda.setmTituloOF(cursor.getString(3));
        demanda.setmStatusOF(cursor.getString(4));
        demanda.setmResponsavelOF(cursor.getString(5));
        demanda.setmPrazo(cursor.getString(6));
        demanda.setmObservacoes(cursor.getString(7));

        return demanda;

    }



}
