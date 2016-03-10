package com.example.jpadm.projetoinicial.parse;

import com.example.jpadm.projetoinicial.model.Demanda;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;

/**
 * Created by jpadm on 15/12/2015.
 */
public class DemandaParser extends RootUnwrappedParser<Demanda> {

    @Override
    public Demanda parse(String jsonContent)throws JsonParseException, JsonMappingException, IOException{



        return OBJECT_MAPPER.readValue(jsonContent,Demanda.class);
    }
}
