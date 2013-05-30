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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Helados extends Activity{
	
	private MenuPrincipal cerrar= new MenuPrincipal();//Para cerrar el MenuPrincipal desde esta activity

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helados);
        
        // ***** SPINNERS ******
        //Inicializo los 4 spinners 
        final Spinner sabor1 = (Spinner) findViewById(R.id.spinnerSabor1);
		final Spinner sabor2 = (Spinner) findViewById(R.id.spinnerSabor2);
		final Spinner sabor3 = (Spinner) findViewById(R.id.spinnerSabor3);
		final Spinner tamaño = (Spinner) findViewById(R.id.spinnerTamaño);
		
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
		final RadioButton tarrina= (RadioButton)findViewById(R.id.tarrina);
		final RadioButton cucurucho= (RadioButton)findViewById(R.id.cucurucho);
		final RadioButton copa= (RadioButton)findViewById(R.id.copa);
		final TextView textView5= (TextView)findViewById(R.id.textView5);
		final TextView textView4= (TextView)findViewById(R.id.textView4);
		
		tarrina.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
           		sabor3.setVisibility(v.INVISIBLE);
           		tamaño.setVisibility(v.VISIBLE);
           		textView5.setVisibility(v.INVISIBLE);
           		textView4.setVisibility(v.VISIBLE);
        	}
		});
		cucurucho.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
           		sabor3.setVisibility(v.INVISIBLE);
           		tamaño.setVisibility(v.VISIBLE);
           		textView5.setVisibility(v.INVISIBLE);
           		textView4.setVisibility(v.VISIBLE);
        	}
		});
		copa.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
           		sabor3.setVisibility(v.VISIBLE);
           		tamaño.setVisibility(v.INVISIBLE);
           		textView5.setVisibility(v.VISIBLE);
           		textView4.setVisibility(v.INVISIBLE);
        	}
		});	
		
		// ****** BOTONES ******
		//Boton cancelar, sirve para cerrar esta actividad sin enviar nada
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
        		//llamo al metodo que formateara todos los datos para enviarlos despues a MenuPrincipal
        		deHeladosAMenuPrincipal.putExtra("datos_pedido",
        			formateaDatos(sabor1,sabor2,sabor3,tamaño,tarrina,cucurucho,copa));
           		setResult(Activity.RESULT_OK,deHeladosAMenuPrincipal);
           		Helados.this.finish();
        	}
        });
	}
	
	// ***** METODOS *****
	    
	//Metodo que formateara todos los datos en solo un String
	public String formateaDatos(Spinner sabor1,Spinner sabor2,Spinner sabor3,
			Spinner tamaño,RadioButton tarrina,RadioButton cucurucho,RadioButton copa){
		
			final EditText cantidad= (EditText)findViewById(R.id.cantidad);
		    String formato=estaPulsado(tarrina,cucurucho,copa);
			
			if(formato.equals("Copa")){
				return formato+": "+sabor1.getSelectedItem().toString()+" "
						+sabor2.getSelectedItem().toString()+" "+sabor3.getSelectedItem().toString()
						+". Cantidad: "+cantidad.getText().toString();
			}
			else{
				if(sabor1.getSelectedItem().toString().equals(sabor2.getSelectedItem().toString())){
					return formato+", "+tamaño.getSelectedItem().toString()+", "+sabor1.getSelectedItem().toString()
							+". Cantidad: "+cantidad.getText().toString();
				}
				else {
					return formato+", "+tamaño.getSelectedItem().toString()+", "+sabor1.getSelectedItem().toString()+" "
					+sabor2.getSelectedItem().toString()+". Cantidad: "+cantidad.getText().toString();
				}
			}
		
	}
	
	//Metodo que chequeara que radioButton esta pulsado y devolvera un String
		public String estaPulsado(RadioButton tarrina,RadioButton cucurucho,RadioButton copa){
			if(tarrina.isChecked()){
				return "Tarrina";
			}
			else if(cucurucho.isChecked()){
				return "Cucurucho";
			}
			else{
				return "Copa";
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
		        	Helados.this.finish(); //cierro la aplicacion
		        	break;
		        case R.id.MnuOpc2:
		        	Intent deHeladosAInstruccionesDeUso = new Intent(Helados.this, InstruccionesDeUso.class );
		        	deHeladosAInstruccionesDeUso.putExtra("valor", 3);
		        	startActivity(deHeladosAInstruccionesDeUso);
		        	break;
		        case R.id.MnuOpc3:
		        	Intent deHeladosAAcercaDe= new Intent(Helados.this, AcercaDe.class );
		            startActivity(deHeladosAAcercaDe);
		        	break;
		        	}
		        return true;
		        }
}
