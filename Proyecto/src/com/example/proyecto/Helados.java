package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Helados extends Activity{

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helados);
        
        final Button añadir= (Button)findViewById(R.id.añadir);
        añadir.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		Intent deHeladosAMenuPrincipal=new Intent(Helados.this,MenuPrincipal.class);
        		//deHeladosAMenuPrincipal.putExtra("datos_pedido", "Helados");
           		setResult(Activity.RESULT_OK,deHeladosAMenuPrincipal);
           		Helados.this.finish();
        	}
        });
	}
}
