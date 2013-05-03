package com.example.proyecto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Especialidades extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.especialidades);
        
     // ***** SPINNERS ******
        //Inicializo los 4 spinners 
        final Spinner spinnerGofres = (Spinner) findViewById(R.id.spinnerGofres);
		final Spinner spinnerCreppes = (Spinner) findViewById(R.id.spinnerCreppes);
		final Spinner spinnerBrownies = (Spinner) findViewById(R.id.spinnerBrownies);
		final Spinner spinnerHelado = (Spinner) findViewById(R.id.spinnerHelado);
		
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
		spinnerHelado.setAdapter(adaptador4);
		//Spinners inicializados con todo tipo de especialidades que hay en array.xml
        
	}

}
