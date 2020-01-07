package com.example.myapplication.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.interfaces.OnFragmetIteractionListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class lista extends BaseFragmentListener {


    public lista() {
        // Required empty public constructor
    }
    public static lista newInstance(OnFragmetIteractionListener onFragmetIteractionListener)
    {
        lista fragment = new lista();
        fragment.setOnFragmetIteractionListener(onFragmetIteractionListener);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false);
    }

}
