package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InstruccionesDeUso extends MainActivity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instrucciones_de_uso);
        
        final Button volverInstrucciones = (Button)findViewById(R.id.volverInstrucciones);
        volverInstrucciones.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		Intent intent4 = new Intent (InstruccionesDeUso.this, MainActivity.class);
        	
        		startActivity(intent4);
        	}
        });
	}
}
