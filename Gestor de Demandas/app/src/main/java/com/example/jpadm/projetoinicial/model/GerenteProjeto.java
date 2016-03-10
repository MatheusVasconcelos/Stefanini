package com.example.jpadm.projetoinicial.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jpadm on 14/12/2015.
 */
public class GerenteProjeto implements Parcelable{

    @JsonProperty("id")
    private int mID;
    @JsonProperty("nome")
    private String mName;
    @JsonProperty("email")
    private String mEmail;
    @JsonProperty("projeto")
    private String mProjetc;
    @JsonProperty("demanda")
    private List<Demanda> mDemanda;

    public GerenteProjeto(int mID, String mName, String mEmail, String mProjetc, List<Demanda> mDemanda) {
        this.mID = mID;
        this.mName = mName;
        this.mEmail = mEmail;
        this.mProjetc = mProjetc;
        this.mDemanda = mDemanda;
    }

    public GerenteProjeto(){


    }

    protected GerenteProjeto(Parcel in) {
        mID = in.readInt();
        mName = in.readString();
        mEmail = in.readString();
        mProjetc = in.readString();
        mDemanda = in.createTypedArrayList(Demanda.CREATOR);
    }

    public static final Creator<GerenteProjeto> CREATOR = new Creator<GerenteProjeto>() {
        @Override
        public GerenteProjeto createFromParcel(Parcel in) {
            return new GerenteProjeto(in);
        }

        @Override
        public GerenteProjeto[] newArray(int size) {
            return new GerenteProjeto[size];
        }
    };

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmProjetc() {
        return mProjetc;
    }

    public void setmProjetc(String mProjetc) {
        this.mProjetc = mProjetc;
    }

    public List<Demanda> getmDemanda() {
        return mDemanda;
    }

    public void setmDemanda(List<Demanda> mDemanda) {
        this.mDemanda = mDemanda;
    }

    @Override
    public String toString() {
        return "GerenteProjeto{" +
                "mID=" + mID +
                ", mName='" + mName + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mProjetc='" + mProjetc + '\'' +
                ", mDemanda=" + mDemanda +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mID);
        dest.writeString(mName);
        dest.writeString(mEmail);
        dest.writeString(mProjetc);
        dest.writeTypedList(mDemanda);
    }
}
