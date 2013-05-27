package com.example.proyecto;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InstruccionesDeUsoRefrescos extends MainActivity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instrucciones_de_uso_refrescos);
        
        final Button volverInstrucciones = (Button)findViewById(R.id.volverInstrucciones);
        volverInstrucciones.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		finish();
        	}
        });
	}
}
