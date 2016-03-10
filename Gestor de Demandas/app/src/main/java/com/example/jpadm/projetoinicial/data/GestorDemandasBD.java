package com.example.jpadm.projetoinicial.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jpadm on 14/12/2015.
 */
public class GestorDemandasBD extends SQLiteOpenHelper {

    public static GestorDemandasBD instance = null;

    public final static String NOME_BD = "gestor_demandas.db";
    public final static int VERSAO = 1;

    public final static String NOME_TB_GERENTE = "gerente_tbl";

    public final static String[] COLUNAS_TBL_GERENTE = {"id", "nome"};

    public final static String CRIA_TBL_GERENTE = " CREATE TABLE "+ NOME_TB_GERENTE+"("+
            COLUNAS_TBL_GERENTE[0]+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUNAS_TBL_GERENTE[1]+" TEXT NOT NULL );";


    private GestorDemandasBD(Context context) {
        super(context, NOME_BD, null, VERSAO);
    }


    public static GestorDemandasBD getInstance(Context context){
        if(instance == null){
            instance = new GestorDemandasBD(context);
        }

        return instance;
    }



    public GestorDemandasBD(Context context, String name, SQLiteDatabase.CursorFactory factory,
                            int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CRIA_TBL_GERENTE);
        Log.i("GerenteDB", "Tabela Criada: "+ CRIA_TBL_GERENTE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
