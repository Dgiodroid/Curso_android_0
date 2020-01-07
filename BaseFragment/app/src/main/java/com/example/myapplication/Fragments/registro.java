package com.example.myapplication.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.Utils.Constants;
import com.example.myapplication.interfaces.OnFragmetIteractionListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class registro extends BaseFragmentListener {


    public registro() {
        // Required empty public constructor
    }
    public static registro newInstance(OnFragmetIteractionListener onFragmetIteractionListener)
    {
        registro fragment = new registro();
        fragment.setOnFragmetIteractionListener(onFragmetIteractionListener);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (getArguments()!=null){
            Toast.makeText(getActivity(), "hola : " +getArguments().get(Constants.USER), Toast.LENGTH_SHORT).show();
        }
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

}
