package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Helados extends Activity{

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helados);
        
        // ***** SPINNERS ******
        //Inicializo los 4 spinners 
        Spinner sabor1 = (Spinner) findViewById(R.id.sabor1);
		Spinner sabor2 = (Spinner) findViewById(R.id.sabor2);
		Spinner sabor3 = (Spinner) findViewById(R.id.sabor3);
		Spinner tamaño = (Spinner) findViewById(R.id.tamaño);
		
		//Configuro los tres adaptadores
		ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.sabores , android.R.layout.simple_spinner_item);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource(this, R.array.sabores2 , android.R.layout.simple_spinner_item);
		adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
		
		ArrayAdapter<CharSequence> adaptador3 = ArrayAdapter.createFromResource(this, R.array.tamaño , android.R.layout.simple_spinner_item);
		adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		
		//Coloco los adaptadores en su elemento correspondiente
		sabor1.setAdapter(adaptador);
		sabor2.setAdapter(adaptador2);
		sabor3.setAdapter(adaptador2);
		tamaño.setAdapter(adaptador3);
		//Spinners inicializados con los sabores y tamaños que hay en array.xml
        
		
		// ****** RADIO BUTTONS ******
		
		
		// ****** BOTONES ******
		//Boton añadir, sirve para cerrar esta actividad sin enviar nada
        final Button cancelar= (Button)findViewById(R.id.cancelar);
        cancelar.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
           		Helados.this.finish();
        	}
        });
		
		//Boton añadir, sirve para enviar los datos al Menu Principal y cerrar esta actividad
        final Button añadir= (Button)findViewById(R.id.añadir);
        añadir.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){

        		Intent deHeladosAMenuPrincipal=new Intent(Helados.this,MenuPrincipal.class);
           		setResult(Activity.RESULT_OK,deHeladosAMenuPrincipal);
           		Helados.this.finish();
        	}
        });
	}
}
