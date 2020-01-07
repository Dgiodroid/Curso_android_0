package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Enums.FragmentType;
import com.example.myapplication.Fragments.BaseFragment;
import com.example.myapplication.Utils.Constants;

public class MainActivity extends BaseFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Al extender de BaseFragment puede hacer uso de
         * changeFragment el cual tiene como parametros
         * @param FragmentType el cual esta apuntando a un fragment de nuestro enum
         * @param addbackStack valor booleano para saber si se agrega a la pila de vistas
         * @param args argumentos a pasar a otro fragmen el cual puede ser nulo*/
onNewIntent(getIntent());
       // changeFragment(FragmentType.LOGING,false,null);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent==null)return;

        String action = intent.getAction();
        String data   = intent.getDataString();

        if (Intent.ACTION_VIEW.equals(action) && data!=null ){

            String [] goTo = data.split("/");
           // https: / /ww.curso.com/ data /tipodefragment /datos
            String fragment = goTo[4];


            changeFragment(fragment.equals("registro")?FragmentType.REGISTRO:FragmentType.LOGING,false,null);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState!=null){
            /**Recupera el estado guardado*/
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        /**Guarda el estado de la aplicaion a travez de un bundle en este caso
         * @param outState aunque en este momento no esta guardando nada*/
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
