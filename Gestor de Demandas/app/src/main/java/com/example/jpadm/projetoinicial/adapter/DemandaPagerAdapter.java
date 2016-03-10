package com.example.jpadm.projetoinicial.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.jpadm.projetoinicial.R;
import com.example.jpadm.projetoinicial.fragment.StatusDemandaFragment;
import com.example.jpadm.projetoinicial.model.Demanda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpadm on 11/12/2015.
 */
public class DemandaPagerAdapter extends FragmentStatePagerAdapter {

    String mCadastradas;
    String mDesenvolvimento;
    String mHomologacao;
    String mImpedimento;
    String mFinalizada;

    List<Demanda> mDemand;

    public DemandaPagerAdapter(FragmentManager fm, List<Demanda> mDemand, Context context) {
        super(fm);

        this.mDemand = mDemand;

        mCadastradas = context.getResources().getString(R.string.demandas_cadastradas);
        mDesenvolvimento = context.getResources().getString(R.string.desenvolvimento);
        mHomologacao = context.getResources().getString(R.string.homologacao);
        mImpedimento = context.getResources().getString(R.string.impedimento);
        mFinalizada = context.getResources().getString(R.string.finalizada);



    }

    protected DemandaPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

       StatusDemandaFragment statusDemandaFragment = new StatusDemandaFragment();

        switch (position){

            case 0:

                statusDemandaFragment.setmDemanda(mDemand);
                break;

            case 1:

                statusDemandaFragment.setmDemanda(filtrarPorStatus(mDemand,mDesenvolvimento));

               break;

            case 2:

                statusDemandaFragment.setmDemanda(filtrarPorStatus(mDemand, mImpedimento));

                break;

            case 3:

                statusDemandaFragment.setmDemanda(filtrarPorStatus(mDemand,mHomologacao));

                break;

            case 4:

                statusDemandaFragment.setmDemanda(filtrarPorStatus(mDemand, mFinalizada));

            break;

            default:
                break;

        }

        return statusDemandaFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){

            case 0:
                return mCadastradas;

            case 1:
                return mDesenvolvimento;

            case 2:
                return mImpedimento;

            case 3:
                return mHomologacao;

            case 4:
                return mFinalizada;

            default:
                return "";


        }


    }

    @Override
    public int getCount() {
        return 5;
    }

    private List<Demanda> filtrarPorStatus(List<Demanda> demandas, String statusDemanda) {

        List<Demanda> demandasFiltradas = new ArrayList<>();

        for (Demanda demanda : demandas) {

            if (statusDemanda.equals(demanda.getmStatusOF())) {
                demandasFiltradas.add(demanda);
            }

        }

        return demandasFiltradas;

    }
}
