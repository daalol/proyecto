package com.example.proyecto;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Cafes extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafes);
        
        //Inicializacion de variables
        final ArrayList<String> datos_cafes = new ArrayList<String>();
        final EditText cafe_solo= (EditText)findViewById(R.id.cafe_solo);
        final EditText cortado= (EditText)findViewById(R.id.cortado);
        final EditText cafe_con_leche= (EditText)findViewById(R.id.cafe_con_leche);
        final EditText cafe_tiempo= (EditText)findViewById(R.id.cafe_tiempo);
        final EditText carajillo_de= (EditText)findViewById(R.id.carajillo_de);
        final EditText carajillo= (EditText)findViewById(R.id.carajillo);
        final EditText bombon= (EditText)findViewById(R.id.bombon);
        final EditText capuchinno= (EditText)findViewById(R.id.capuchinno);
        final EditText descripcion= (EditText)findViewById(R.id.descripcion);

        //boton aceptar
        final Button cafes_aceptar= (Button)findViewById(R.id.cafes_aceptar);
        cafes_aceptar.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		//Bateria de if's para contruir el pedido de cafes
        		if(cafe_solo.getText().toString()!="0" || (String)cafe_solo.getText().toString()!=""){
        			datos_cafes.add("Cafe_solo: "+cafe_solo.getText().toString());
        		}
        		if(cortado.getText().toString()!="0" || (String)cortado.getText().toString()!=""){
        			datos_cafes.add("Cortado: "+cortado.getText().toString());
        		}
        		if(cafe_con_leche.getText().toString()!="0" || (String)cafe_con_leche.getText().toString()!=""){
        			datos_cafes.add("Cafe con leche: "+cafe_con_leche.getText().toString());
        		}
        		if(cafe_tiempo.getText().toString()!="0" || (String)cafe_tiempo.getText().toString()!=""){
        			datos_cafes.add("Cafe del tiempo: "+cafe_tiempo.getText().toString());
        		}
        		if(carajillo.getText().toString()!="0" || (String)carajillo.getText().toString()!=""){
        			datos_cafes.add("Carajillo de"+carajillo_de.getText().toString()+": "+carajillo.getText().toString());
        		}
        		if(bombon.getText().toString()!="0" || (String)bombon.getText().toString()!=""){
        			datos_cafes.add("Bombon: "+bombon.getText().toString());
        		}
        		if(capuchinno.getText().toString()!="0" || (String)capuchinno.getText().toString()!=""){
        			datos_cafes.add("Capuchinno: "+capuchinno.getText().toString());
        		}
        		//este si o si va a entrar en el array
        		datos_cafes.add("Descripcion: "+descripcion.getText().toString());
        		datos_cafes.add("");
        		
        		
        		//Envio el array a Seleccion de productos
        		Intent deCafesASeleccionProductos=new Intent(Cafes.this,SeleccionProductos.class);
        		deCafesASeleccionProductos.putExtra("datos_pedido", datos_cafes);
           		setResult(Activity.RESULT_OK,deCafesASeleccionProductos);
           		Cafes.this.finish();
        	}
        });
        
        //boton cancelar
        final Button cafes_cancelar= (Button)findViewById(R.id.cafes_cancelar);
        cafes_cancelar.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Cafes.this.finish();
        	}
        });
        
        //ira en la ultima posicion de los botones
        final Button cafes_borrar= (Button)findViewById(R.id.cafes_borrar);
        cafes_borrar.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		//inicializar a 0 o nada todas las variables editText
        	}
        });
	}
}
