package com.example.jpadm.projetoinicial.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jpadm on 17/12/2015.
 */
public class DemandasBD extends SQLiteOpenHelper {

    public static DemandasBD instance = null;

    public final static String NOME_BD = "demandas.db";
    public final static int VERSAO = 2;
    public final static String NOME_TB_DEMANDA = "demanda_tbl";
    public final static String[] COLUNAS_TBL_DEMANDA = {"id", "nomeGP", "numeroOF",
            "tituloOF", "Status", "Responsavel", "Prazo", "Observação"};
    public final static String CRIA_TBL_DEMANDA = " CREATE TABLE " + NOME_TB_DEMANDA + "(" +
            COLUNAS_TBL_DEMANDA[0] + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUNAS_TBL_DEMANDA[1] + " TEXT NOT NULL, " +
            COLUNAS_TBL_DEMANDA[2] + " INTEGER NOT NULL, " +
            COLUNAS_TBL_DEMANDA[3] + " TEXT NOT NULL, " +
            COLUNAS_TBL_DEMANDA[4] + " TEXT NOT NULL, " +
            COLUNAS_TBL_DEMANDA[5] + " TEXT NOT NULL, " +
            COLUNAS_TBL_DEMANDA[6] + " TEXT NOT NULL, " +
            COLUNAS_TBL_DEMANDA[7] + " TEXT NOT NULL );";

    private DemandasBD(Context context) {
        super(context, NOME_BD, null, VERSAO);

    }

    public static DemandasBD getInstance(Context context) {
        if (instance == null) {
            instance = new DemandasBD(context);
        }

        return instance;
    }

    public DemandasBD(Context context, String name,
                      SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DemandasBD(Context context, String name, SQLiteDatabase.CursorFactory factory,
                      int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CRIA_TBL_DEMANDA);
        Log.i("DemandasBD", "Tabela Criada: " + CRIA_TBL_DEMANDA);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + NOME_TB_DEMANDA);

        onCreate(db);
    }
}
