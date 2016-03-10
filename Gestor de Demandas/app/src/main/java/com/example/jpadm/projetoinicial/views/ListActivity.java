package com.example.jpadm.projetoinicial.views;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jpadm.projetoinicial.Interface.DemandaCallBackIF;
import com.example.jpadm.projetoinicial.controlador.ControladorDemandas;
import com.example.jpadm.projetoinicial.data.DemandasCRUD;
import com.example.jpadm.projetoinicial.model.Demanda;
import com.example.jpadm.projetoinicial.adapter.DemandaPagerAdapter;
import com.example.jpadm.projetoinicial.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity implements DemandaCallBackIF {


    @Bind(R.id.vp_demandas)
    ViewPager mVpDemandas;


    List<Demanda> mDemand;
    DemandaPagerAdapter mPagerAdapter;


    ProgressDialog mProgressDialog;

    ControladorDemandas mControladorDemanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demandas);
        ButterKnife.bind(this);

        DemandasCRUD mDemandasCRUD = new DemandasCRUD(this);


        mDemand = new ArrayList<>();
        mDemand = mDemandasCRUD.buscarTodos();
        populateData();
        retornoListaDemandas(mDemand);




        mControladorDemanda = new ControladorDemandas(this);
        //inicializarControladorDemanda();

      /*  mDemand = new ArrayList<>();

        mAdapter = new DemandListAdapter(this, mDemand);
        mList.setAdapter(mAdapter);*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);

        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.item_list:
                Toast.makeText(this, "Lista", Toast.LENGTH_LONG).show();
                return true;

            case R.id.item_grid:
                Toast.makeText(this, "Grade", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }


    public void inicializarControladorDemanda() {

        mProgressDialog = ProgressDialog.show(this, "Carregando...",
                "Buscando Demandas no servidor");
        mControladorDemanda.buscarDemandas();
    }


    public void populateData() {


        Demanda demanda = new Demanda();

        demanda.setmTituloOF("Hackathon - Tela Cadastro");
        demanda.setmResponsavelOF("Manoel");
        demanda.setmObservacoes("Fazer a tela de cadastro pra o app do Hackathon");
        demanda.setmPrazo("17/12/15");
        demanda.setmNumeroOF(02335);
        demanda.setmStatusOF("Em homologação");

        mDemand.add(demanda);

        Demanda demandaUm = new Demanda();

        demandaUm.setmTituloOF("Hackathon - Tela Listar");
        demandaUm.setmResponsavelOF("Manoel");
        demandaUm.setmObservacoes("Fazer a tela de listagem pra o app do Hackathon");
        demandaUm.setmPrazo("18/12/15");
        demandaUm.setmNumeroOF(02343);
        demandaUm.setmStatusOF("Em desenvolvimento");

        mDemand.add(demandaUm);

        Demanda demandaDois = new Demanda();

        demandaDois.setmTituloOF("Hackathon - Tela Gerentes");
        demandaDois.setmResponsavelOF("Manoel");
        demandaDois.setmObservacoes("Fazer a tela de Cadastro de gerentes pra o app do Hackathon");
        demandaDois.setmPrazo("18/12/15");
        demandaDois.setmNumeroOF(02322);
        demandaDois.setmStatusOF("Em impedimento");

        mDemand.add(demandaDois);

        Demanda demandaTres = new Demanda();

        demandaTres.setmTituloOF("Hackathon - Home");
        demandaTres.setmResponsavelOF("Manoel");
        demandaTres.setmObservacoes("Fazer a tela de Home pra o app do Hackathon");
        demandaTres.setmPrazo("10/12/15");
        demandaTres.setmNumeroOF(12342);
        demandaTres.setmStatusOF("Finalizada");

        mDemand.add(demandaTres);

        Demanda demandaQuatro = new Demanda();

        demandaQuatro.setmTituloOF("Hackathon - Protótipo");
        demandaQuatro.setmResponsavelOF("Manoel");
        demandaQuatro.setmObservacoes("Fazer a protótipo pra o app do Hackathon");
        demandaQuatro.setmPrazo("08/12/15");
        demandaQuatro.setmNumeroOF(12323);
        demandaQuatro.setmStatusOF("Finalizada");

        mDemand.add(demandaQuatro);


    }

    @Override
    public void retornoListaDemandas(List<Demanda> demandas) {

        for (Demanda demanda: demandas){
            Log.i(":", demanda.toString());
        }

        if (mProgressDialog != null && mProgressDialog.isShowing()) {

            mProgressDialog.dismiss();
            mProgressDialog = null;
        }


        mPagerAdapter = new DemandaPagerAdapter(getSupportFragmentManager(), mDemand, getBaseContext());
        mVpDemandas.setAdapter(mPagerAdapter);



    }

    @Override
    public void erroServicoDemandas(String erro) {

        if (mProgressDialog != null && mProgressDialog.isShowing()) {

            mProgressDialog.dismiss();
            mProgressDialog = null;

            Toast.makeText(this, erro, Toast.LENGTH_LONG).show();

        }
    }
}
