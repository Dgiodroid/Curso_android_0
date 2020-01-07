package com.example.myapplication.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Enums.FragmentType;
import com.example.myapplication.R;
import com.example.myapplication.interfaces.OnFragmetIteractionListener;

public class BaseFragment extends AppCompatActivity implements OnFragmetIteractionListener {


    /**metodo para hacer el cambio de fragments recibe como parametros
     * @param fragmentType
     * @param addTobackStack
     * @param  args*/
    protected void changeFragment(FragmentType fragmentType,boolean addTobackStack,@Nullable Bundle args)
    {
        Fragment fragment = new Fragment();

        switch (fragmentType)
        {
            /**Atraves del swich podremos saber que tipo de FragmenType fue elegido
             * a traves de newinstance daremos lugar al nuevo fragmet
             * con set arguments en caso de tener un argumento podremos pasar dichos "argumentos o valores
             * igualamos nuestro fragment a el fragment selecionado para posteriormente hacer el replanso del fragment"*/
            case LOGING:
                loging Loging = loging.newInstance(this);
                Loging.setArguments(args);
                fragment = Loging;
                break;
            case REGISTRO:
                registro Registro = registro.newInstance(this);
                Registro.setArguments(args);
                fragment = Registro;
                break;
            case LISTA:
                break;
            case FOTOS:
                break;
            case MAPA:
                break;
            case GUARDAR:
                break;
        }
/**En esta parte del codigo comienza a realizar el cambio de fragments con una animacion de entrada y salida*/
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_rigth
        );
        /**Comprobacion para saber si estara en la pila de vistas*/
        if (addTobackStack){
            fragmentTransaction.addToBackStack(fragmentType.name());
        }
       /**Cambio de el fragment por el
        * @param  fragmentType seleccionado*/
        fragmentTransaction.replace(R.id.container,fragment).commitAllowingStateLoss();
    }
 /**Implemantacion del metodo de la interfas */
    @Override
    public void onFragmentIteractionChangeFragment(FragmentType fragmentType, boolean addToBackStack, @Nullable Bundle args) {
        changeFragment(fragmentType,addToBackStack,args);
    }

}
