package com.example.jpadm.projetoinicial.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import java.util.Calendar;

/**
 * Created by PESSOAL on 17/12/2015.
 */
public class SelecionarDataDialog extends android.support.v4.app.DialogFragment {

    static Calendar sCalendar;

    int mDay;
    int mMonth;
    int mYear;

    Context mContext;
    DatePickerDialog.OnDateSetListener mCallback;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        sCalendar = Calendar.getInstance();
        mDay = sCalendar.get(Calendar.DAY_OF_MONTH);
        mMonth = sCalendar.get(Calendar.MONTH);
        mYear = sCalendar.get(Calendar.YEAR);
        mContext = getActivity();
        mCallback = (DatePickerDialog.OnDateSetListener) getActivity();

        DatePickerDialog datePickerDialog = new DatePickerDialog
                (mContext, mCallback, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMinDate(sCalendar.getTimeInMillis());

        return datePickerDialog;
    }


}
