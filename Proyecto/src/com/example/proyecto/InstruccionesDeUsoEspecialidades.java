package com.example.proyecto;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InstruccionesDeUsoEspecialidades extends MainActivity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instrucciones_de_uso_especialidades);
        
        final Button volverInstrucciones = (Button)findViewById(R.id.volverInstrucciones);
        volverInstrucciones.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		finish();
        	}
        });
	}
}