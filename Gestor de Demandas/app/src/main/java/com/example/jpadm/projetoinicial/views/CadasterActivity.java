package com.example.jpadm.projetoinicial.views;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jpadm.projetoinicial.R;
import com.example.jpadm.projetoinicial.data.DemandasCRUD;
import com.example.jpadm.projetoinicial.fragment.SelecionarDataDialog;
import com.example.jpadm.projetoinicial.model.Demanda;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class CadasterActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    @Bind(R.id.et_number_of)
    EditText mEtNumOF;

    @Bind(R.id.et_title_of)
    EditText mEtTitleOF;

    @Bind(R.id.et_responsible)
    EditText mEtRespOF;

    @Bind(R.id.et_observation)
    EditText mEtObservationOF;

    @Bind(R.id.et_deadline)
    EditText mEtDeadlineOF;

    @Bind(R.id.sp_status)
    Spinner mSpStatusOF;

    @Bind(R.id.gp_spinner)
    Spinner mSpinnerGP;

    @Bind(R.id.linearObs)
    LinearLayout mLayoutObs;

    DemandasCRUD demandasCRUD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadaster);

        ButterKnife.bind(this);
        mEtDeadlineOF.setOnKeyListener(null);
        demandasCRUD = new DemandasCRUD(this);




      /*  Bundle extras = getIntent().getExtras();

        if (extras.containsKey("demanda")) {

            Demanda demanda = (Demanda) extras.get("demanda");
            Toast.makeText(this, demanda.toString(), Toast.LENGTH_LONG).show();
        }*/


        List<String> mList = new ArrayList<>();
        mList.add("Selecione");
        mList.add("Alexandre Trevisani");
        mList.add("Luciano Matias");
        mList.add("Miguel Prazeres");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerGP.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadaster, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.item_cancel:

                return true;

            case R.id.item_save:
                salvarDemanda();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @OnClick(R.id.et_deadline)
    public void SelecionarData() {
        SelecionarDataDialog dialog = new SelecionarDataDialog();
        dialog.show(getSupportFragmentManager(), "selecionarData");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        String dataSelecionada = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
        mEtDeadlineOF.setText(dataSelecionada);

    }



    @OnCheckedChanged(R.id.toggle_obs)
    public void CheckObs(boolean button) {

        if (button) {
            mLayoutObs.setVisibility(View.GONE);
        } else {
            mLayoutObs.setVisibility(View.VISIBLE);
        }

    }


    private void salvarDemanda() {

        Demanda demanda = new Demanda();

        demanda.setmNomeGP(mSpinnerGP.getSelectedItem() == null ? "" :
                mSpinnerGP.getSelectedItem().toString());
        demanda.setmStatusOF
                (mSpStatusOF.getSelectedItem() == null ? "" :
                        mSpStatusOF.getSelectedItem().toString());
        demanda.setmTituloOF
                (mEtTitleOF.getText() == null ? "" : mEtTitleOF.getText().toString());
        demanda.setmNumeroOF
                (mEtNumOF.getText() == null ? 0 : Integer.parseInt(mEtNumOF.getText().toString()));
        demanda.setmPrazo
                (mEtDeadlineOF.getText() == null ? "" : mEtDeadlineOF.getText().toString());
        demanda.setmObservacoes
                (mEtObservationOF.getText() == null ? "" : mEtObservationOF.getText().toString());
        demanda.setmResponsavelOF
                (mEtRespOF.getText() == null ? "" : mEtRespOF.getText().toString());



        demandasCRUD.salvar(demanda);

        Toast.makeText(this, demanda.toString(), Toast.LENGTH_LONG).show();



    }



}
