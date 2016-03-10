package com.example.jpadm.guiadepaises.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import com.example.jpadm.guiadepaises.R;
import com.example.jpadm.guiadepaises.model.Country;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jpadm on 10/12/2015.
 */
public class CountGridAdpter extends BaseAdapter {

    List<Country> mCountry;
    Context mContext;
    LayoutInflater mInflater;

    public CountGridAdpter(List<Country> mCountry, Context mContext) {
        this.mCountry = mCountry;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return mCountry.size();
    }

    @Override
    public Object getItem(int position) {
        return mCountry.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        ViewHolder holder;

        if (convertView == null) {

            view = mInflater.inflate(R.layout.item_grid_country, parent, false);
            holder = new ViewHolder(view);
            Country country = mCountry.get(position);
            holder.tvCountryName.setText(country.getName());
            holder.tvCountryCapital.setText(country.getCapital());
            holder.tvCountryCurrency.setText(country.getCurrency());

        } else {

            view = convertView;

        }
        return view;
    }

    static class ViewHolder {

        @Bind(R.id.tv_country_name)
        TextView tvCountryName;
        @Bind(R.id.country_capital)
        TextView tvCountryCapital;
        @Bind(R.id.country_currency)
        TextView tvCountryCurrency;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}
