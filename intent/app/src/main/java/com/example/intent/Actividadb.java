package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividadb extends AppCompatActivity {

    TextView tv;
    EditText edit;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividadb);
        tv = findViewById(R.id.tv);
        edit = findViewById(R.id.ed);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**respuesta para el activityforresults*/
                String resultado = edit.getText().toString();
                Intent intent = new Intent();
                /**envio del resultado*/
                intent.putExtra("resultado",resultado);
                setResult(2,intent);
                finish();
            }
        });
       /* Bundle params = this.getIntent().getExtras();
        if (params!=null){
            tv.setText(params.getString("key"));
        }*/
       onNewIntent(getIntent());
    }
/**metodo para gestionar todos los intents recibidos
 * se crea debido a que recibiremos un deplink el cual abrira esta aplicacion especifica
 * en caso de que nuestro link abra otra aplicacion y le envie informacion este metodo debera estar en la app por abrir y tener un metodo
 * que reciba dicha informacion*/
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent==null)return;

        String action = intent.getAction();
        String data   = intent.getDataString();
       /**comprobacion para poder manegejar el intent deste una url*/
        if (Intent.ACTION_VIEW.equals(action) && data !=null){

            tv.setText(data);
        }else {
            /**En caso de ser un un intent normar entraria en esta parte*/
            tv.setText( intent.getStringExtra("key")!=null ? intent.getStringExtra("key") : "datos inexistentes");
        }

    }
}
