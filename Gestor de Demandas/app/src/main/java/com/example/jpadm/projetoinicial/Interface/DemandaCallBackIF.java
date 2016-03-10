package com.example.jpadm.projetoinicial.Interface;

import com.example.jpadm.projetoinicial.model.Demanda;

import java.util.List;

/**
 * Created by jpadm on 15/12/2015.
 */
public interface DemandaCallBackIF {

    void retornoListaDemandas(List<Demanda> demandas);

    void erroServicoDemandas(String erro);


}
