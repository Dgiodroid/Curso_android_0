package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**Arreglo  de enteros que hace referencia a los id´s aptos para algun click
     * unico tipo de dato
     * @param R.id.(x)*/
    int [] viewIds={R.id.a,R.id.b,R.id.c,R.id.d,R.id.e,R.id.f,R.id.g,R.id.h};
    Intent intent;
    /**Arreglo donde se buscara un package de aplicacion*/
    public List<ResolveInfo> maches;
    /**Variable booleana para saber si una aplicacion fue encontrada*/
    boolean appFound=false;
    TextView tv;
    int request=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tvResult);
        setDegateClick(this,viewIds);
    }

    /**metodo que delegara todos los posibles clicks
     * obtiene como parametros una vista o actividad y posteriormente enteros
     * @param view de donde hace referencia dicho id
     * @param ids grupo de ids traida a traves de una varargs esta debe ir siempre hasta el ultimo
     * Gracias ximena por tu aporte
     *
     * @dif (int i = 0 ; i<viewIds.length;i++) to (int i = 0 ; i<ids.length;i++) */
    public void setDegateClick(MainActivity view,int ... ids)
    {
        for (int i = 0 ; i<ids.length;i++)
        {
            view.findViewById(ids[i]).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            /**Lista de posibles intents*/
            case R.id.a:
                /**inten explicito con un extra*/
                intent = new Intent(MainActivity.this,Actividadb.class);
                intent.putExtra("key","hola que tal");
                break;
            case R.id.b:
                /**inten implicito hace referencia a un action personalizado con un extra*/
                intent = new Intent("android.intent.action.B");
                intent.putExtra("key","hola que tal desde un action");
                break;
            case R.id.c:
                /**inten implicito para poder abrir una aplicacion externa */
                intent = getPackageManager().getLaunchIntentForPackage("com.example.myapplication");
                break;
            case R.id.d:
                /**inten implicito para un marcador de telefono*/
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5587026781"));
                break;
            case R.id.e:
                /**inten explicito apesar de que paresca un implicito es explicito debido a que indicamos el paquete al
                 * cual enviara la informacion en este caso enviara un whatssap con el texto hola ximena*/

                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"HOLA XIMENA");
                intent.setPackage("com.whatsapp");
                break;
            case R.id.f:
                /**inten para enviar un mensaje o publicacion a twiter o facebook*/

                String data = "http://google.com.mx/";

                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,data);



                maches= this.getPackageManager().queryIntentActivities(intent,0);
                for (ResolveInfo info : maches ){
                    /**obtine la informacion local del dispositivo y empieza con la busqueda de alguna aplicacion que con tenga
                     * el paquete requerido */
                    if (info.activityInfo.packageName.toLowerCase(Locale.getDefault()).startsWith("com.twitter.android"
                            //"com.facebook.katana"
                            )){
                        intent.setPackage(info.activityInfo.packageName);
                        appFound= true;
                        break;
                    }
                }
                /**en caso de no encontrarse el paquete requerido se procedera a hacer un intent implicito para poder
                 * abrir el vinculo o direcion*/
                if (!appFound){
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                            "https://twitter.com/intent/tweet?url="
                           // "https://www.facebook.com/sharer/sharer.php?u="
                                    +data));
                }

                break;
                case R.id.g:
                    String datas = "http://google.com.mx/";

                    intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,datas);



                    maches= this.getPackageManager().queryIntentActivities(intent,0);
                    for (ResolveInfo info : maches ){
                        if (info.activityInfo.packageName.toLowerCase(Locale.getDefault()).startsWith("com.gio.mscuentas"
                                //"com.facebook.katana"
                        )){
                            intent.setPackage(info.activityInfo.packageName);
                            appFound= true;
                            break;
                        }
                    }
                    /**intent para abrir la playstore*/
                    if (!appFound){
                        intent = new Intent(Intent.ACTION_VIEW);
                                     intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.gio.mscuentas"));
                                     intent.setPackage("com.android.vending");
                    }
                    break;
                case R.id.h:
                    intent = new Intent("android.intent.action.B");
                    //new Intent(MainActivity.this,Actividadb.class);
                    //startActivityForResult(intent,2);
                    request = 2;
                    break;
        }

       if (intent!=null){
           /**Comprobacion para saber si abriremos un intent normal o un intent que espera un resultado*/
           if (request!=0){
               startActivityForResult(intent,request);
           }else {startActivity(intent);}
       }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==2){
            String resultado = data.getStringExtra("resultado");
            tv.setText(resultado);
        }
    }
}
