package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Especialidades extends Activity{
	
	private MenuPrincipal cerrar= new MenuPrincipal();//Para cerrar el MenuPrincipal desde esta activity
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.especialidades);
        
     // ***** SPINNERS ******
        //Inicializo los 4 spinners 
        final Spinner spinnerGofres = (Spinner) findViewById(R.id.spinnerGofres);
		final Spinner spinnerCreppes = (Spinner) findViewById(R.id.spinnerCreppes);
		final Spinner spinnerBrownies = (Spinner) findViewById(R.id.spinnerBrownies);
		final Spinner spinnerHelados = (Spinner) findViewById(R.id.spinnerHelado);
		
		//Configuro los cuatro adaptadores
		ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.gofres_brownies , android.R.layout.simple_spinner_item);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		
		ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource(this, R.array.creppes , android.R.layout.simple_spinner_item);
		adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
		
		ArrayAdapter<CharSequence> adaptador3 = ArrayAdapter.createFromResource(this, R.array.gofres_brownies , android.R.layout.simple_spinner_item);
		adaptador3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		
		ArrayAdapter<CharSequence> adaptador4 = ArrayAdapter.createFromResource(this, R.array.sabores , android.R.layout.simple_spinner_item);
		adaptador4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		
		//Coloco los adaptadores en su elemento correspondiente
		spinnerGofres.setAdapter(adaptador);
		spinnerCreppes.setAdapter(adaptador2);
		spinnerBrownies.setAdapter(adaptador3);
		spinnerHelados.setAdapter(adaptador4);
		//Spinners inicializados con todo tipo de especialidades que hay en array.xml
        
		// ****** RADIO BUTTONS ******
		final RadioButton RBGofres= (RadioButton)findViewById(R.id.gofres);
		final RadioButton RBCreppes= (RadioButton)findViewById(R.id.creppes);
		final RadioButton RBBrownies= (RadioButton)findViewById(R.id.brownies);
		final TextView textView1= (TextView)findViewById(R.id.textView1);
		final TextView textView2= (TextView)findViewById(R.id.textView2);
		final TextView textView3= (TextView)findViewById(R.id.textView3);
		final TextView textView4= (TextView)findViewById(R.id.textView4);
		
		RBGofres.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//elementos visibles
           		spinnerGofres.setVisibility(v.VISIBLE);
           		textView1.setVisibility(v.VISIBLE);
	           		if(spinnerGofres.getSelectedItem().toString().contains("Helado")){
	       				spinnerHelados.setVisibility(v.VISIBLE);
							textView4.setVisibility(v.VISIBLE);
	       			}
           		
           		//elementos invisibles
           		textView2.setVisibility(v.INVISIBLE);
           		textView3.setVisibility(v.INVISIBLE);
           		spinnerCreppes.setVisibility(v.INVISIBLE);
           		spinnerBrownies.setVisibility(v.INVISIBLE);
	           		if(!spinnerGofres.getSelectedItem().toString().contains("Helado")){
	           			spinnerHelados.setVisibility(v.INVISIBLE);
	           			textView4.setVisibility(v.INVISIBLE);
	           		}
        	}
		});
		RBCreppes.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//elementos visibles
           		spinnerCreppes.setVisibility(v.VISIBLE);
           		textView2.setVisibility(v.VISIBLE);
           			if(spinnerCreppes.getSelectedItem().toString().contains("Helado")){
           				spinnerHelados.setVisibility(v.VISIBLE);
   						textView4.setVisibility(v.VISIBLE);
           			}
           		
           		//elementos invisibles
           		spinnerGofres.setVisibility(v.INVISIBLE);
           		spinnerBrownies.setVisibility(v.INVISIBLE);
           		textView1.setVisibility(v.INVISIBLE);
           		textView3.setVisibility(v.INVISIBLE);
           			if(!spinnerCreppes.getSelectedItem().toString().contains("Helado")){
           					spinnerHelados.setVisibility(v.INVISIBLE);
           					textView4.setVisibility(v.INVISIBLE);
           			}
        	}
		});
		RBBrownies.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//elementos visibles
				spinnerBrownies.setVisibility(v.VISIBLE);
				textView3.setVisibility(v.VISIBLE);
					if(spinnerBrownies.getSelectedItem().toString().contains("Helado")){
	       				spinnerHelados.setVisibility(v.VISIBLE);
							textView4.setVisibility(v.VISIBLE);
	       			}
				
           		//elementos invisibles
				spinnerGofres.setVisibility(v.INVISIBLE);
           		spinnerCreppes.setVisibility(v.INVISIBLE);
           		textView1.setVisibility(v.INVISIBLE);
           		textView2.setVisibility(v.INVISIBLE);
           			if(!spinnerBrownies.getSelectedItem().toString().contains("Helado")){
           					spinnerHelados.setVisibility(v.INVISIBLE);
           					textView4.setVisibility(v.INVISIBLE);
           			}
        	}
		});//Fin radioButtons
		
		
		// **** Control del spinner que permitira elegir helado cuando el valor del spinner lo necesite ***
		spinnerGofres.setOnItemSelectedListener(new OnItemSelectedListener() 
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View v,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if(spinnerGofres.getSelectedItem().toString().contains("Helado")){
					spinnerHelados.setVisibility(v.VISIBLE);
	           		textView4.setVisibility(v.VISIBLE);
				}
				else {
					spinnerHelados.setVisibility(v.INVISIBLE);
	           		textView4.setVisibility(v.INVISIBLE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		spinnerCreppes.setOnItemSelectedListener(new OnItemSelectedListener() 
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View v,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if(spinnerCreppes.getSelectedItem().toString().contains("Helado")){
					spinnerHelados.setVisibility(v.VISIBLE);
	           		textView4.setVisibility(v.VISIBLE);
				}
				else {
					spinnerHelados.setVisibility(v.INVISIBLE);
	           		textView4.setVisibility(v.INVISIBLE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		spinnerBrownies.setOnItemSelectedListener(new OnItemSelectedListener() 
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View v,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if(spinnerBrownies.getSelectedItem().toString().contains("Helado")){
					spinnerHelados.setVisibility(v.VISIBLE);
	           		textView4.setVisibility(v.VISIBLE);
				}
				else {
					spinnerHelados.setVisibility(v.INVISIBLE);
	           		textView4.setVisibility(v.INVISIBLE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		//Fin del control del spinner Helado y su textView
		
		
		// ****** BOTONES ******
 		//Boton cancelar, sirve para cerrar esta actividad sin enviar nada
         final Button cancelar= (Button)findViewById(R.id.cancelar);
         cancelar.setOnClickListener(new OnClickListener(){
         	public void onClick(View v){
            		Especialidades.this.finish();
         	}
         });
 		
 		//Boton añadir, sirve para enviar los datos al Menu Principal y cerrar esta actividad
         final Button añadir= (Button)findViewById(R.id.añadir);
         añadir.setOnClickListener(new OnClickListener(){
         	public void onClick(View v){

         		Intent deEspecialidadesAMenuPrincipal=new Intent(Especialidades.this,MenuPrincipal.class);
         		
         		deEspecialidadesAMenuPrincipal.putExtra("datos_pedido",
         				formateaDatos(spinnerGofres,spinnerCreppes,spinnerBrownies,spinnerHelados,
         						RBGofres,RBCreppes, RBBrownies));
         			
            		setResult(Activity.RESULT_OK,deEspecialidadesAMenuPrincipal);
            		Especialidades.this.finish();
         	}
         });
		
	}//Fin onCreate
	
	// ***** METODOS *****
    
			//Metodo que formateara todos los datos en solo un String
		public String formateaDatos(Spinner spinnerGofres,Spinner spinnerCreppes,Spinner spinnerBrownies,
				Spinner spinnerHelados,RadioButton RBGofres,RadioButton RBCreppes,
				RadioButton RBBrownies){
			
				final EditText cantidad= (EditText)findViewById(R.id.cantidad);
				String cant;
				//compruebo que no sea 0 el valor de cantidad
				if (cantidad.getText().toString().equals("0")){
			 		cant="Cantidad: 1";
			 	}
				else cant="Cantidad: "+cantidad.getText().toString();
	
		    	String formato=estaPulsado(RBGofres,RBCreppes);
		    	
		    	if(formato.equals("Gofres")){
		    		if(spinnerHelados.isShown()){
		    			return "Gofre, "+spinnerGofres.getSelectedItem().toString()
		    					+" de "+spinnerHelados.getSelectedItem().toString()
			    				+", "+cant;
		    		}
		    		else return "Gofre, "+spinnerGofres.getSelectedItem().toString()
		    				+", "+cant;
		    	}
		    	else if(formato.equals("Creppes")){
		    		if(spinnerHelados.isShown()){
		    			return "Creppe, "+spinnerCreppes.getSelectedItem().toString()
		    					+" de "+spinnerHelados.getSelectedItem().toString()
			    				+", "+cant;
		    		}
		    		else return "Creppe, "+spinnerCreppes.getSelectedItem().toString()
		    				+", "+cant;
		    	}
		    	else if(spinnerHelados.isShown()){
	    			return "Brownie, "+spinnerBrownies.getSelectedItem().toString()
	    					+" de "+spinnerHelados.getSelectedItem().toString()
		    				+", "+cant;
	    		}
	    			else return "Brownie, "+spinnerBrownies.getSelectedItem().toString()
	    				+", "+cant;
	    	
		}
		
		//Metodo que chequeara que radioButton esta pulsado y devolvera un String
				public String estaPulsado(RadioButton RBGofres,RadioButton RBCreppes){
					if(RBGofres.isChecked()){
						return "Gofres";
					}
					else if(RBCreppes.isChecked()){
						return "Creppes";
					}
					else{
						return "Brownies";
					}	
				}
			//Fin metodos
				
				 // ***** Menu *****
				 @Override
				    public boolean onCreateOptionsMenu(Menu menu) {
				    	 MenuInflater inflater = getMenuInflater();
				         inflater.inflate(R.menu.activity_main, menu);
				         return true;
				    }
				    public boolean onOptionsItemSelected(MenuItem item) {
				        switch (item.getItemId()) {
				        case R.id.MnuOpc1: 
				        	cerrar.cierreActivity.finish();
				        	Especialidades.this.finish(); //cierro la aplicacion
				        	break;
				        case R.id.MnuOpc2:
				        	Intent deEspecialidadesAInstruccionesDeUso = new Intent(Especialidades.this, InstruccionesDeUso.class );
				        	deEspecialidadesAInstruccionesDeUso.putExtra("valor", 6);
				        	startActivity(deEspecialidadesAInstruccionesDeUso);
				        	break;
				        case R.id.MnuOpc3:
				        	Intent deEspecialidadesAAcercaDe = new Intent(Especialidades.this, AcercaDe.class );
				            startActivity(deEspecialidadesAAcercaDe);
				        	break;
				        	}
				        return true;
				        }

}
