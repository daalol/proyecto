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

public class Bolleria extends Activity{

	private MenuPrincipal cerrar= new MenuPrincipal();//Para cerrar el MenuPrincipal desde esta activity
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bolleria);
        
        
        // ***** SPINNERS ******
           //Inicializo los 2 spinners 
        final Spinner spinnerDulce = (Spinner) findViewById(R.id.spinnerDulce);
   		final Spinner spinnerSalado = (Spinner) findViewById(R.id.spinnerSalado);
   		
   		
   		//Configuro los dos adaptadores
   		ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.dulce, android.R.layout.simple_spinner_item);
   		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
   		
   		ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource(this, R.array.salado , android.R.layout.simple_spinner_item);
   		adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
   		
   		//Coloco los adaptadores en su elemento correspondiente
   		spinnerDulce.setAdapter(adaptador);
   		spinnerSalado.setAdapter(adaptador2);
   		//Spinners inicializados
   		
   		
   	// ****** RADIO BUTTONS ******
		final RadioButton RBDulce= (RadioButton)findViewById(R.id.dulce);
		final RadioButton RBSalado= (RadioButton)findViewById(R.id.salado);
		final TextView textView2= (TextView)findViewById(R.id.textView2);
		final TextView textView3= (TextView)findViewById(R.id.textView3);
		final CheckBox checkDulce= (CheckBox)findViewById(R.id.checkDulce);
		final CheckBox checkSalado= (CheckBox)findViewById(R.id.checkSalado);
           		
		RBDulce.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				
				//elementos visibles
           		spinnerDulce.setVisibility(v.VISIBLE);
           		textView2.setVisibility(v.VISIBLE);
           		checkDulce.setVisibility(v.VISIBLE);
           		
           		//elementos invisibles
           		textView3.setVisibility(v.INVISIBLE);
           		spinnerSalado.setVisibility(v.INVISIBLE);
           		checkSalado.setVisibility(v.INVISIBLE);
        	}
		});
		RBSalado.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				
				//elementos visibles
           		textView3.setVisibility(v.VISIBLE);
           		spinnerSalado.setVisibility(v.VISIBLE);
           		checkSalado.setVisibility(v.VISIBLE);
           		
           	//elementos invisibles
           		spinnerDulce.setVisibility(v.INVISIBLE);
           		textView2.setVisibility(v.INVISIBLE);
           		checkDulce.setVisibility(v.INVISIBLE);
        	}
		});
		
		
		// ****** BOTONES ******
 		//Boton cancelar, sirve para cerrar esta actividad sin enviar nada
         final Button cancelar= (Button)findViewById(R.id.cancelar);
         cancelar.setOnClickListener(new OnClickListener(){
         	public void onClick(View v){
            		Bolleria.this.finish();
         	}
         });
 		
 		//Boton añadir, sirve para enviar los datos al Menu Principal y cerrar esta actividad
         final Button añadir= (Button)findViewById(R.id.añadir);
         añadir.setOnClickListener(new OnClickListener(){
         	public void onClick(View v){

         		Intent deBolleriaAMenuPrincipal=new Intent(Bolleria.this,MenuPrincipal.class);
         		
         		deBolleriaAMenuPrincipal.putExtra("datos_pedido",formateaDatos(spinnerDulce,spinnerSalado,RBDulce,checkDulce,checkSalado));
         			
            		setResult(Activity.RESULT_OK,deBolleriaAMenuPrincipal);
            		Bolleria.this.finish();
         	}
         });
}
	
	// ***** METODOS *****
    
			//Metodo que formateara todos los datos en solo un String
		public String formateaDatos(Spinner spinnerDulce,Spinner spinnerSalado,RadioButton RBDulce,
				CheckBox checkDulce,CheckBox checkSalado){
			
				final EditText cantidad= (EditText)findViewById(R.id.cantidad);
				String cant;
				//compruebo que no sea 0 el valor de cantidad
				if (cantidad.getText().toString().equals("0")){
			 		cant="Cantidad: 1";
			 	}
				else cant="Cantidad: "+cantidad.getText().toString();
	
		    	String formato=estaPulsado(RBDulce);
		    	if(formato.equals("Dulce")){
		    		if(checkDulce.isChecked()){
		    			return spinnerDulce.getSelectedItem().toString()+", Caliente, "+cant;
		    		}
		    		else return spinnerDulce.getSelectedItem().toString()+", "+cant;
		    	}
		    	
		    	else if(checkSalado.isChecked()){
		    		return spinnerSalado.getSelectedItem().toString()+", Caliente, "+cant;
		    		}
		    	
		    	else return spinnerSalado.getSelectedItem().toString()+", "+cant;
		    	
		}
		
		//Metodo que chequeara que radioButton esta pulsado y devolvera un String
				public String estaPulsado(RadioButton RBDulce){
					if(RBDulce.isChecked()){
						return "Dulce";
					}
					else{
						return "Salado";
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
				Bolleria.this.finish(); //cierro la aplicacion
				break;
			case R.id.MnuOpc2:
				Intent deBolleriaAInstruccionesDeUso= new Intent(Bolleria.this, InstruccionesDeUso.class );
				deBolleriaAInstruccionesDeUso.putExtra("valor", 4);
				startActivity(deBolleriaAInstruccionesDeUso);
				break;
			 case R.id.MnuOpc3:
				Intent deBolleriaAAcercaDe = new Intent(Bolleria.this, AcercaDe.class );
				startActivity(deBolleriaAAcercaDe);
				break;
			}
		 return true;
	 }//FIN MENU
}
