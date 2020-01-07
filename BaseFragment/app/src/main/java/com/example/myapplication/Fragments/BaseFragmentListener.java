package com.example.myapplication.Fragments;

import androidx.fragment.app.Fragment;

import com.example.myapplication.interfaces.OnFragmetIteractionListener;

public class BaseFragmentListener extends Fragment {

/*Mandamos a llamar nuestra interfaz para poder hacer los cambios entre fragments
* extiende de fragment ya que sera usado principalmente por clases de tipo fragment
* tambien podremos sobre cargar de diferentes metodos esta clase para unicamente mandarlos a llamar desde cualquier fragment*/

    OnFragmetIteractionListener onFragmetIteractionListener;
/**los fragments que quieran utilizar esta interfas tendran que extender de BaseFragmentListener para poder hacer uso de esta interfas*/
    public void setOnFragmetIteractionListener(OnFragmetIteractionListener onFragmetIteractionListener){
        this.onFragmetIteractionListener = onFragmetIteractionListener;
    }



}
