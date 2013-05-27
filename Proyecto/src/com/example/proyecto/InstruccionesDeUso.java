package com.example.proyecto;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class InstruccionesDeUso extends MainActivity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instrucciones_de_uso);
        
        //Inicializo el textview con el texto que le toque:
        final TextView a = (TextView)findViewById(R.id.textView1);
        Bundle b = getIntent().getExtras();
        int controlTexto = b.getInt("valor");
        switch(controlTexto){
        	case 0: a.setText(R.string.instrucciones_uso);break;
        	case 1: a.setText(R.string.instrucciones_uso_cafes);break;
        	case 2: a.setText(R.string.instrucciones_uso_refrescos);break;
        	case 3: a.setText(R.string.instrucciones_uso_helados);break;
        	case 4: a.setText(R.string.instrucciones_uso_bolleria);break;
        	case 5: a.setText(R.string.instrucciones_uso_combinados);break;
        	case 6: a.setText(R.string.instrucciones_uso_especialidades);break;
        	
        	default : a.setText(R.string.instrucciones_uso);
        };
        
        final Button volverInstrucciones = (Button)findViewById(R.id.volverInstrucciones);
        volverInstrucciones.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		finish();
        	}
        });
	}
}
