package com.example.jpadm.projetoinicial.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jpadm.projetoinicial.adapter.DemandListAdapter;
import com.example.jpadm.projetoinicial.model.Demanda;
import com.example.jpadm.projetoinicial.R;
import com.example.jpadm.projetoinicial.views.CadasterActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by jpadm on 11/12/2015.
 */
public class StatusDemandaFragment extends Fragment {

    @Bind(R.id.lv_staus_demand)
    ListView mLvStatusDemanda;
    DemandListAdapter mAdapter;

    List<Demanda> mDemanda;






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup conteiner, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_status_demand, null);
        ButterKnife.bind(this, view);

        mAdapter = new DemandListAdapter(getActivity(), getmDemanda());
        mLvStatusDemanda.setAdapter(mAdapter);



        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @OnItemClick(R.id.lv_staus_demand)
    protected void itemClickListener(int position){

        Toast.makeText(getActivity().getBaseContext(),
                "Click", Toast.LENGTH_LONG).show();

        Demanda demanda = (Demanda) mLvStatusDemanda.getItemAtPosition(position);

        Intent intent = new Intent(getActivity(), CadasterActivity.class);
        intent.putExtra("demanda", demanda);
        startActivity(intent);

    }



    public ListView getmLvStatusDemanda() {
        return mLvStatusDemanda;
    }

    public void setmLvStatusDemanda(ListView mLvStatusDemanda) {
        this.mLvStatusDemanda = mLvStatusDemanda;
    }

    public List<Demanda> getmDemanda() {
        if(mDemanda == null){
            mDemanda = new ArrayList<>();
        }

        return mDemanda;
    }

    public void setmDemanda(List<Demanda> mDemanda) {
        this.mDemanda = mDemanda;
    }
}
