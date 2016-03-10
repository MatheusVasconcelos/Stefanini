package com.example.jpadm.projetoinicial.parse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jpadm on 15/12/2015.
 */
public interface Parser<T> {


    public T parse(String jsonContent) throws JsonParseException, JsonMappingException, IOException;

    public T parse(InputStream jsonContent) throws JsonParseException, JsonMappingException,
            IOException;
}
