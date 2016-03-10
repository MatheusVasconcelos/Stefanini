package com.example.jpadm.projetoinicial.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by jpadm on 09/12/2015.
 */
public class Demanda implements Parcelable {




    private Integer mId;
    private String mNomeGP;
    private int mNumeroOF;
    private String mTituloOF;
    private String mStatusOF;
    private String mResponsavelOF;
    private String mPrazo;
    private String mObservacoes;

    public Demanda(){

    }


    public Demanda(Integer mId, String mNomeGP, int mNumeroOF, String mTituloOF, String mStatusOF, String mResponsavelOF, String mPrazo, String mObservacoes) {
        this.mId = mId;
        this.mNomeGP = mNomeGP;
        this.mNumeroOF = mNumeroOF;
        this.mTituloOF = mTituloOF;
        this.mStatusOF = mStatusOF;
        this.mResponsavelOF = mResponsavelOF;
        this.mPrazo = mPrazo;
        this.mObservacoes = mObservacoes;
    }




    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getmNumeroOF() {
        return mNumeroOF;
    }

    public void setmNumeroOF(Integer mNumeroOF) {
        this.mNumeroOF = mNumeroOF;
    }

    public String getmTituloOF() {
        return mTituloOF;
    }

    public void setmTituloOF(String mTituloOF) {
        this.mTituloOF = mTituloOF;
    }

    public String getmStatusOF() {
        return mStatusOF;
    }

    public void setmStatusOF(String mStatusOF) {
        this.mStatusOF = mStatusOF;
    }

    public String getmResponsavelOF() {
        return mResponsavelOF;
    }

    public void setmResponsavelOF(String mResponsavelOF) {
        this.mResponsavelOF = mResponsavelOF;
    }

    public String getmPrazo() {
        return mPrazo;
    }

    public void setmPrazo(String mPrazo) {
        this.mPrazo = mPrazo;
    }

    public String getmObservacoes() {
        return mObservacoes;
    }

    public void setmObservacoes(String mObservacoes) {
        this.mObservacoes = mObservacoes;
    }

    public static Creator<Demanda> getCREATOR() {
        return CREATOR;
    }

    public String getmNomeGP() {
        return mNomeGP;
    }

    public void setmNomeGP(String mNomeGP) {
        this.mNomeGP = mNomeGP;
    }


    protected Demanda(Parcel in) {
        mTituloOF = in.readString();
        mStatusOF = in.readString();
        mResponsavelOF = in.readString();
        mPrazo = in.readString();
        mObservacoes = in.readString();
        mNumeroOF = in.readInt();
        mId = in.readInt();
    }

    public static final Creator<Demanda> CREATOR = new Creator<Demanda>() {
        @Override
        public Demanda createFromParcel(Parcel in) {
            return new Demanda(in);
        }

        @Override
        public Demanda[] newArray(int size) {
            return new Demanda[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mNumeroOF);
        dest.writeInt(mId);
        dest.writeString(mNomeGP);
        dest.writeString(mTituloOF);
        dest.writeString(mStatusOF);
        dest.writeString(mResponsavelOF);
        dest.writeString(mPrazo);
        dest.writeString(mObservacoes);


    }

    @Override
    public String toString() {
        return "Demanda{" +
                "mId=" + mId +
                ", mNomeGP='" + mNomeGP + '\'' +
                ", mNumeroOF=" + mNumeroOF +
                ", mTituloOF='" + mTituloOF + '\'' +
                ", mStatusOF='" + mStatusOF + '\'' +
                ", mResponsavelOF='" + mResponsavelOF + '\'' +
                ", mPrazo='" + mPrazo + '\'' +
                ", mObservacoes='" + mObservacoes + '\'' +
                '}';
    }
}
