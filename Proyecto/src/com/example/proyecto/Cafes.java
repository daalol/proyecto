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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class Cafes extends Activity {
	
	private MenuPrincipal cerrar= new MenuPrincipal();//Para cerrar el MenuPrincipal desde aqui
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafes);
        
     // ***** SPINNERS ******
        //Inicializo los 2 spinners 
        final Spinner spinnerCafes = (Spinner) findViewById(R.id.spinnerCafes);
		final Spinner spinnerTocado = (Spinner) findViewById(R.id.spinnerTocado);
		
		//Configuro los cuatro adaptadores
		ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.cafes, android.R.layout.simple_spinner_item);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		
		ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource(this, R.array.tocados , android.R.layout.simple_spinner_item);
		adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
		
		//Coloco los adaptadores en su elemento correspondiente
		spinnerCafes.setAdapter(adaptador);
		spinnerTocado.setAdapter(adaptador2);
		//Spinners inicializados con los cafes que hay en array.xml
		
		
		// **** Control del spinner que permitira elegir el alcohol cuando el valor del spinner lo necesite ***
		 final TextView textView3 = (TextView) findViewById(R.id.textView3);
		 final CheckBox checkTocado = (CheckBox) findViewById(R.id.checkTocado);
				spinnerCafes.setOnItemSelectedListener(new OnItemSelectedListener() 
				{
					@Override
					public void onItemSelected(AdapterView<?> arg0, View v,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						if(spinnerCafes.getSelectedItem().toString().contains("Carajillo")){
								
								checkTocado.setChecked(false);
								spinnerTocado.setVisibility(v.VISIBLE);
				           		textView3.setVisibility(v.VISIBLE);
				           		
				           		checkTocado.setVisibility(v.INVISIBLE);
													
						}
						else {
								spinnerTocado.setVisibility(v.INVISIBLE);
				           		textView3.setVisibility(v.INVISIBLE);
				           		
				           		checkTocado.setVisibility(v.VISIBLE);
				           		checkTocado.setChecked(false);
						}
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				
				//Posibilidad de habilitar spinnerTocado por el checkBox "tocado"
				   checkTocado.setOnClickListener(new OnClickListener(){
			         	public void onClick(View v){
			            		if(checkTocado.isChecked()){
			            			
			            				spinnerTocado.setVisibility(v.VISIBLE);
						           		textView3.setVisibility(v.VISIBLE);
			            		}
			            		else {
			            				spinnerTocado.setVisibility(v.INVISIBLE);
						           		textView3.setVisibility(v.INVISIBLE);
			            		}
			         	}
			         });
			 		
				//Fin del control del spinner spinnerTocado y su textView
			
				   
		// ***** CONTROL DE LA VISIBILIDAD DE LAS CHECKBOX NATURAL Y CALIENTE ****
			 final CheckBox checkCaliente= (CheckBox) findViewById(R.id.checkCaliente);
			 final CheckBox checkNatural= (CheckBox) findViewById(R.id.checkNatural);
			   checkCaliente.setOnClickListener(new OnClickListener(){
		         	public void onClick(View v){
		            		if(checkCaliente.isChecked()){	
		            				checkNatural.setVisibility(v.INVISIBLE);	
		            		}
		            		else checkNatural.setVisibility(v.VISIBLE);
		            		
		         	}
		         });
			   checkNatural.setOnClickListener(new OnClickListener(){
		         	public void onClick(View v){
		            		if(checkNatural.isChecked()){	
		            				checkCaliente.setVisibility(v.INVISIBLE);	
		            		}
		            		else checkCaliente.setVisibility(v.VISIBLE);
		            		
		         	}
		         });
			
		// FIN CONTROL NATURAL Y CALIENTE
			 
			   
		// ****** BOTONES ******
	    //Boton cancelar, sirve para cerrar esta actividad sin enviar nada
	  final Button cancelar= (Button)findViewById(R.id.cancelar);
		 cancelar.setOnClickListener(new OnClickListener(){
			 public void onClick(View v){
			            Cafes.this.finish();
			   	}
		  });
			 		
		 //Boton añadir, sirve para enviar los datos al Menu Principal y cerrar esta actividad
	   
	  
	   final Button añadir= (Button)findViewById(R.id.añadir);
		 añadir.setOnClickListener(new OnClickListener(){
			 public void onClick(View v){

			        Intent deCafesAMenuPrincipal=new Intent(Cafes.this,MenuPrincipal.class);
			         		
			        deCafesAMenuPrincipal.putExtra("datos_pedido",
			         				formateaDatos(spinnerCafes,spinnerTocado
			         						,checkCaliente,checkNatural
			         						,checkTocado));
			         			
			        setResult(Activity.RESULT_OK,deCafesAMenuPrincipal);
			        Cafes.this.finish();
			         	}
			         });
				   
	}// FIN ONCREATE
	
	// ***** METODOS *****
    
				//Metodo que formateara todos los datos en solo un String
			public String formateaDatos(Spinner spinnerCafes,Spinner spinnerTocado,
					CheckBox checkCaliente,CheckBox checkNatural,
					CheckBox checkTocado){
				
					String resultado="";
					resultado+=spinnerCafes.getSelectedItem().toString()+" ";
					
					if(resultado.equals("Carajillo ")){
						resultado+="de "+spinnerTocado.getSelectedItem().toString();
					}
					
					if(checkNatural.isChecked()){
						resultado+=", natural";
					}
				final CheckBox checkTiempo= (CheckBox) findViewById(R.id.checkTiempo);
					if(checkTiempo.isChecked()){
						resultado+=", del tiempo";
					}
					if(checkTocado.isChecked()){
						resultado+=", tocado de "+spinnerTocado.getSelectedItem().toString();
					}
				 final EditText editTextMas =(EditText) findViewById(R.id.editTextMas);
				 	    resultado+=" "+editTextMas.getText().toString();
					
				 final EditText cantidad= (EditText)findViewById(R.id.cantidad);
				        resultado+=", Cantidad: "+cantidad.getText().toString();
				        
				   //Devolvemos la variable resultado 
					return resultado;
			}
				//Fin metodos
	
	
	//***** Menu *****
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
	        	Cafes.this.finish(); //cierro la aplicacion
	        	break;
	        case R.id.MnuOpc2:
	        	Intent intent2 = new Intent(Cafes.this, InstruccionesDeUsoCafes.class );
	            startActivity(intent2);
	        	break;
	        case R.id.MnuOpc3:
	        	Intent intent3 = new Intent(Cafes.this, AcercaDe.class );
	            startActivity(intent3);
	        	break;
	        	}
	        return true;
	        }
}
