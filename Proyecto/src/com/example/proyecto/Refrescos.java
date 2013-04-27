package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Refrescos extends Activity{

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refrescos);
        
     // ***** SPINNERS ******
        //Inicializo los 4 spinners 
        final Spinner bebidas = (Spinner) findViewById(R.id.spinnerBebidas);
		final Spinner refrescos = (Spinner) findViewById(R.id.spinnerRefrescos);
		final Spinner cervezas = (Spinner) findViewById(R.id.spinnerCervezas);
		final Spinner tamaño = (Spinner) findViewById(R.id.spinnerTamaño);
		
		//Configuro los cuatro adaptadores
		ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.bebidas , android.R.layout.simple_spinner_item);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		
		ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource(this, R.array.refrescos , android.R.layout.simple_spinner_item);
		adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
		
		ArrayAdapter<CharSequence> adaptador3 = ArrayAdapter.createFromResource(this, R.array.cervezas , android.R.layout.simple_spinner_item);
		adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		
		ArrayAdapter<CharSequence> adaptador4 = ArrayAdapter.createFromResource(this, R.array.tamaño , android.R.layout.simple_spinner_item);
		adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		
		//Coloco los adaptadores en su elemento correspondiente
		bebidas.setAdapter(adaptador);
		refrescos.setAdapter(adaptador2);
		cervezas.setAdapter(adaptador3);
		tamaño.setAdapter(adaptador4);
		//Spinners inicializados con todo tipo de bebidas que hay en array.xml
        
		
     // ****** BOTONES ******
     		//Boton cancelar, sirve para cerrar esta actividad sin enviar nada
             final Button cancelar= (Button)findViewById(R.id.cancelar);
             cancelar.setOnClickListener(new OnClickListener(){
             	public void onClick(View v){
                		Refrescos.this.finish();
             	}
             });
     		
     		//Boton añadir, sirve para enviar los datos al Menu Principal y cerrar esta actividad
             final Button añadir= (Button)findViewById(R.id.añadir);
             añadir.setOnClickListener(new OnClickListener(){
             	public void onClick(View v){

             		Intent deRefrescosAMenuPrincipal=new Intent(Refrescos.this,MenuPrincipal.class);
             		
             		deRefrescosAMenuPrincipal.putExtra("datos_pedido","");
             			
                		setResult(Activity.RESULT_OK,deRefrescosAMenuPrincipal);
                		Refrescos.this.finish();
             	}
             });
	}
}
