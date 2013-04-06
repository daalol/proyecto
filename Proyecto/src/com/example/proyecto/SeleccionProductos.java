package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class SeleccionProductos extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_productos);
        
        //*** BOTONES PARA LOS PRODUCTOS ***
        final Button cafes= (Button)findViewById(R.id.cafes);
        cafes.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		//para probarlo
        		Intent a= new Intent (SeleccionProductos.this, Cafes.class);
        		startActivity(a);
        	}
        });
        
     /*   final Button refrescos= (Button)findViewById(R.id.refrescos);
        refrescos.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        	}
        });
        
        final Button helados= (Button)findViewById(R.id.helados);
        helados.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        	}
        });
        
        final Button bolleria= (Button)findViewById(R.id.bolleria);
        cafes.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        	}
        });
        
        final Button combinados= (Button)findViewById(R.id.combinados);
        cafes.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        	}
        });
        
        final Button especialidades= (Button)findViewById(R.id.especialidades);
        especialidades.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        	}
        });
        
        
        //*** BOTONES PARA EL CONTROL DE LA ACTIVIDAD ***
        final Button volver_ok= (Button)findViewById(R.id.volver_ok);
        volver_ok.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        	}
        });*/
        final Button volver_no_ok= (Button)findViewById(R.id.volver_no_ok);
        volver_no_ok.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		Intent deSeleccionProductosAMenuPrincipalNoOk= new Intent (SeleccionProductos.this, MenuPrincipal.class);
        		startActivity(deSeleccionProductosAMenuPrincipalNoOk);
        	}
        });
	}
}
