package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class CombinadosCafe extends Activity{
	
	private MenuPrincipal cerrar= new MenuPrincipal();//Para cerrar el MenuPrincipal desde aqui
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combinados_cafe);
        
     // ***** SPINNERS ******
        //Inicializo los 2 spinners 
        final Spinner spinnerCaliente = (Spinner) findViewById(R.id.spinnerCaliente);
		final Spinner spinnerFrio= (Spinner) findViewById(R.id.spinnerFrio);
		
		//Configuro 2 cuatro adaptadores
		
		ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.caliente , android.R.layout.simple_spinner_item);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		
		ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource(this, R.array.frio , android.R.layout.simple_spinner_item);
		adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		
		//Coloco los adaptadores en su elemento correspondiente
		spinnerCaliente.setAdapter(adaptador);
		spinnerFrio.setAdapter(adaptador2);
		//Spinners inicializados con todo tipo de combinados de cafe que hay en array.xml
		
		
		// ****** RADIO BUTTONS ******
		final RadioButton RBFrio= (RadioButton)findViewById(R.id.RBFrio);
		final RadioButton RBCaliente= (RadioButton)findViewById(R.id.RBCaliente);
		final TextView textView1= (TextView)findViewById(R.id.textView1);
		final TextView textView2= (TextView)findViewById(R.id.textView2);
		final CheckBox checkDescafeinado= (CheckBox)findViewById(R.id.checkDescafeinado);
		
		RBFrio.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//elementos visibles
           		spinnerFrio.setVisibility(v.VISIBLE);
           		textView1.setVisibility(v.VISIBLE);
           		
           		//elementos invisibles
           		textView2.setVisibility(v.INVISIBLE);
           		spinnerCaliente.setVisibility(v.INVISIBLE);
           		checkDescafeinado.setVisibility(v.INVISIBLE);
        	}
		});
		RBCaliente.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//elementos visibles
				textView2.setVisibility(v.VISIBLE);
           		spinnerCaliente.setVisibility(v.VISIBLE);
           		checkDescafeinado.setVisibility(v.VISIBLE);
           		
           		//elementos invisibles
           		spinnerFrio.setVisibility(v.INVISIBLE);
           		textView1.setVisibility(v.INVISIBLE);
        	}
		});
		
		
		  // ****** BOTONES ******
 		//Boton cancelar, sirve para cerrar esta actividad sin enviar nada
         final Button cancelar= (Button)findViewById(R.id.cancelar);
         cancelar.setOnClickListener(new OnClickListener(){
         	public void onClick(View v){
            		CombinadosCafe.this.finish();
         	}
         });
 		
 		//Boton añadir, sirve para enviar los datos al Menu Principal y cerrar esta actividad
         final Button añadir= (Button)findViewById(R.id.añadir);
         añadir.setOnClickListener(new OnClickListener(){
         	public void onClick(View v){

         		Intent deCombinadosCafeAMenuPrincipal=new Intent(CombinadosCafe.this,MenuPrincipal.class);
         		
         		deCombinadosCafeAMenuPrincipal.putExtra("datos_pedido",
         				formateaDatos(spinnerFrio,spinnerCaliente,RBFrio,RBCaliente,checkDescafeinado));
         			
            		setResult(Activity.RESULT_OK,deCombinadosCafeAMenuPrincipal);
            		CombinadosCafe.this.finish();
         	}
         });
	}
	
	
	// ***** METODOS *****
    
			//Metodo que formateara todos los datos en solo un String
		public String formateaDatos(Spinner spinnerFrio,Spinner spinnerCaliente,RadioButton RBFrio
				,RadioButton RBCaliente,CheckBox checkDescafeinado ){
			
				final EditText cantidad= (EditText)findViewById(R.id.cantidad);
		    	String formato=estaPulsado(RBFrio,RBCaliente);
		    	
		    	if(formato.equals("Frio")){
		    		return spinnerFrio.getSelectedItem().toString()
		    				+". Cantidad: "+cantidad.getText().toString();
		    	}
		    	else if (checkDescafeinado.isChecked()){
		    		return spinnerCaliente.getSelectedItem().toString()+". Descafeinado"
		    				+". Cantidad: "+cantidad.getText().toString();
		    	}
		    	else return spinnerCaliente.getSelectedItem().toString()+". Cantidad: "
		    				+cantidad.getText().toString();
		    			
		}
		
		//Metodo que chequeara que radioButton esta pulsado y devolvera un String
				public String estaPulsado(RadioButton RBFrio,RadioButton RBCaliente){
					if(RBFrio.isChecked()){
						return "Frio";
					}
					else{
						return "Caliente";
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
				    CombinadosCafe.this.finish(); //cierro la aplicacion
				    break;
				case R.id.MnuOpc2:
				    Intent intent2 = new Intent(CombinadosCafe.this, InstruccionesDeUsoCombinados.class );
				    startActivity(intent2);
				    break;
				case R.id.MnuOpc3:
				    Intent intent3 = new Intent(CombinadosCafe.this, AcercaDe.class );
				    startActivity(intent3);
				    break;
				}
				return true;
			 }

}
