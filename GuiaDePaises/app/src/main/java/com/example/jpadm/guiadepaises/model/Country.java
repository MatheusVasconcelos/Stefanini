package com.example.jpadm.guiadepaises.model;

/**
 * Created by jpadm on 10/12/2015.
 */
public class Country {

    private String name;
    private String capital;
    private String language;
    private String currency;
    private String biography;
    private int flagResourceId;


    @Override
    public String toString() {
        return "Country{" +
                "nome='" + name + '\'' +
                ", Capital='" + capital + '\'' +
                ", language='" + language + '\'' +
                ", currency='" + currency + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        capital = capital;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public int getFlagResourceId() {
        return flagResourceId;
    }

    public void setFlagResourceId(int flagResourceId) {
        this.flagResourceId = flagResourceId;
    }
}
