package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Refrescos extends Activity{

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refrescos);
        
     // ***** SPINNERS ******
        //Inicializo los 4 spinners 
        final Spinner spinnerBebidas = (Spinner) findViewById(R.id.spinnerBebidas);
		final Spinner spinnerRefrescos = (Spinner) findViewById(R.id.spinnerRefrescos);
		final Spinner spinnerCervezas = (Spinner) findViewById(R.id.spinnerCervezas);
		final Spinner spinnerTamaño = (Spinner) findViewById(R.id.spinnerTamaño);
		
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
		spinnerBebidas.setAdapter(adaptador);
		spinnerRefrescos.setAdapter(adaptador2);
		spinnerCervezas.setAdapter(adaptador3);
		spinnerTamaño.setAdapter(adaptador4);
		//Spinners inicializados con todo tipo de bebidas que hay en array.xml
        
		
		// ****** RADIO BUTTONS ******
				final RadioButton RBBebidas= (RadioButton)findViewById(R.id.bebidas);
				final RadioButton RBRefrescos= (RadioButton)findViewById(R.id.refrescos);
				final RadioButton RBCervezas= (RadioButton)findViewById(R.id.cervezas);
				final TextView textView1= (TextView)findViewById(R.id.textView1);
				final TextView textView2= (TextView)findViewById(R.id.textView2);
				final TextView textView3= (TextView)findViewById(R.id.textView3);
				final TextView textView4= (TextView)findViewById(R.id.textView4);
				
				RBBebidas.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						//elementos visibles
		           		spinnerBebidas.setVisibility(v.VISIBLE);
		           		spinnerTamaño.setVisibility(v.VISIBLE);
		           		textView1.setVisibility(v.VISIBLE);
		           		textView4.setVisibility(v.VISIBLE);
		           		
		           		//elementos invisibles
		           		textView2.setVisibility(v.INVISIBLE);
		           		textView3.setVisibility(v.INVISIBLE);
		           		spinnerRefrescos.setVisibility(v.INVISIBLE);
		           		spinnerCervezas.setVisibility(v.INVISIBLE);
		        	}
				});
				RBRefrescos.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						//elementos visibles
		           		spinnerRefrescos.setVisibility(v.VISIBLE);
		           		textView2.setVisibility(v.VISIBLE);
		           		
		           		//elementos invisibles
		           		spinnerBebidas.setVisibility(v.INVISIBLE);
		           		spinnerTamaño.setVisibility(v.INVISIBLE);
		           		textView1.setVisibility(v.INVISIBLE);
		           		textView4.setVisibility(v.INVISIBLE);
		           		textView3.setVisibility(v.INVISIBLE);
		           		spinnerCervezas.setVisibility(v.INVISIBLE);
		        	}
				});
				RBCervezas.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						//elementos visibles
						spinnerCervezas.setVisibility(v.VISIBLE);
						textView3.setVisibility(v.VISIBLE);
						
		           		//elementos invisibles
						spinnerBebidas.setVisibility(v.INVISIBLE);
		           		spinnerTamaño.setVisibility(v.INVISIBLE);
		           		textView1.setVisibility(v.INVISIBLE);
		           		textView4.setVisibility(v.INVISIBLE);
		           		textView2.setVisibility(v.INVISIBLE);
		           		spinnerRefrescos.setVisibility(v.INVISIBLE);
		           		
		        	}
				});
		
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
             		
             		deRefrescosAMenuPrincipal.putExtra("datos_pedido",
             				formateaDatos(spinnerBebidas,spinnerRefrescos,spinnerCervezas,spinnerTamaño,RBBebidas,RBRefrescos,
             						 RBCervezas));
             			
                		setResult(Activity.RESULT_OK,deRefrescosAMenuPrincipal);
                		Refrescos.this.finish();
             	}
             });
	}
	
	// ***** METODOS *****
    
		//Metodo que formateara todos los datos en solo un String
	public String formateaDatos(Spinner spinnerBebidas,Spinner spinnerRefrescos,Spinner spinnerCervezas,
			Spinner spinnerTamaño,RadioButton RBBebidas,RadioButton RBRefrescos,
			RadioButton RBCervezas){
		
			final EditText cantidad= (EditText)findViewById(R.id.cantidad);
	    	String formato=estaPulsado(RBBebidas,RBRefrescos,RBCervezas);
	    	
	    	if(formato.equals("Bebidas")){
	    		return spinnerBebidas.getSelectedItem().toString()+" "+spinnerTamaño.getSelectedItem().toString()
	    				+". Cantidad: "+cantidad.getText().toString();
	    	}
	    	else if(formato.equals("Refrescos")){
	    		return spinnerRefrescos.getSelectedItem().toString()+". Cantidad: "+cantidad.getText().toString();
	    	}
	    	else return spinnerCervezas.getSelectedItem().toString()+". Cantidad: "+cantidad.getText().toString();
	}
	
	//Metodo que chequeara que radioButton esta pulsado y devolvera un String
			public String estaPulsado(RadioButton RBBebidas,RadioButton RBRefrescos,
					RadioButton RBCervezas){
				if(RBBebidas.isChecked()){
					return "Bebidas";
				}
				else if(RBRefrescos.isChecked()){
					return "Refrescos";
				}
				else{
					return "Cervezas";
				}
				
			}
		//Fin metodos
}
