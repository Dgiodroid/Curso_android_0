package com.example.myapplication.interfaces;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.myapplication.Enums.FragmentType;


public interface OnFragmetIteractionListener {
    /**OnFragmetIteractionListener es una interfas de tipo publica la cual sera usada para cambiar un fragmet
     * la cual utiliza el metodo onFragmentIteractionChangeFragment y recibe los siguientes parametros
     * @param fragmentType nombre del fragment a cambiar
     * @param addToBackStack representa si el fragment sera agregado a la pila de vistas
     * @param args el cual es nullable lo que quiere decir que este parametro puede ser nulo ayuda a pasar datos entre fragments*/
    void onFragmentIteractionChangeFragment(FragmentType fragmentType, boolean addToBackStack, @Nullable Bundle args);

}
