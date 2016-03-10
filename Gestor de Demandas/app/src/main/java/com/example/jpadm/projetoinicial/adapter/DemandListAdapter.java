package com.example.jpadm.projetoinicial.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jpadm.projetoinicial.R;
import com.example.jpadm.projetoinicial.model.Demanda;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jpadm on 11/12/2015.
 */
public class DemandListAdapter extends BaseAdapter {


    List<Demanda> mDemandas;
    Context mContext;
    LayoutInflater mInflater;

    public DemandListAdapter(Activity mContext, List<Demanda> mDemandas) {
        this.mContext = mContext;
        this.mDemandas = mDemandas;
        mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount() {
        return mDemandas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDemandas.get(position);
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

            view = mInflater.inflate(R.layout.list_item_demand, parent, false);
            holder = new ViewHolder(view);
            Demanda demanda = mDemandas.get(position);

            holder.mTvNumDemanda.setText(demanda.getmNumeroOF()+"");
            holder.mTvStatusDemanda.setText(demanda.getmStatusOF());
            holder.mTvTituloDemanda.setText(demanda.getmTituloOF());
            holder.mTvPrazo.setText(demanda.getmPrazo());


        } else {

            view = convertView;
        }


        return view;
    }

    class ViewHolder {

        @Bind(R.id.number)
        TextView mTvNumDemanda;
        @Bind(R.id.title_of)
        TextView mTvTituloDemanda;
        @Bind(R.id.status_list)
        TextView mTvStatusDemanda;
        @Bind(R.id.prazo_list)
        TextView mTvPrazo;


        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
