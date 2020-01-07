package com.example.myapplication.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.Enums.FragmentType;
import com.example.myapplication.R;
import com.example.myapplication.Utils.Constants;
import com.example.myapplication.interfaces.OnFragmetIteractionListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class loging extends BaseFragmentListener {

private static final String TAG = loging.class.getSimpleName();
View v;
Button loging;
    public loging() {
        // Required empty public constructor
                     }

    public static loging newInstance(OnFragmetIteractionListener onFragmetIteractionListener)
    {
        loging fragment = new loging();
        fragment.setOnFragmetIteractionListener(onFragmetIteractionListener);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_loging, container, false);
        loging = v.findViewById(R.id.btnRegistro);
        loging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString(Constants.USER,"ximena");
                onFragmetIteractionListener.onFragmentIteractionChangeFragment(FragmentType.REGISTRO,true,args);
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

}
