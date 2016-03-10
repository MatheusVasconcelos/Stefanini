package com.example.jpadm.guiadepaises.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.jpadm.guiadepaises.R;
import com.example.jpadm.guiadepaises.adapter.CountGridAdpter;
import com.example.jpadm.guiadepaises.model.Country;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GridActivity extends AppCompatActivity {

    @Bind(R.id.gv_paises)
    GridView mGvPaises;

    List<Country> mCountries;
    CountGridAdpter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        ButterKnife.bind(this);

        mCountries = new ArrayList<>();
        populateData();
        mAdapter =  new CountGridAdpter(mCountries, getBaseContext());
        mGvPaises.setAdapter(mAdapter);

    }

    public void populateData() {

        Country brazil = new Country();
        brazil.setName(getResources().getString(R.string.bra_name));
        brazil.setCapital(getResources().getString(R.string.bra_capital));
        brazil.setLanguage(getResources().getString(R.string.bra_language));
        brazil.setFlagResourceId(R.drawable.imagem3);

        Country argentina = new Country();
        argentina.setName(getResources().getString(R.string.arg_name));
        argentina.setCapital(getResources().getString(R.string.arg_capital));
        argentina.setLanguage(getResources().getString(R.string.arg_language));
        argentina.setFlagResourceId(R.drawable.imagem4);

        mCountries.add(argentina);
        mCountries.add(brazil);
        mCountries.add(argentina);
        mCountries.add(brazil);
        mCountries.add(argentina);
        mCountries.add(brazil);
    }
}
