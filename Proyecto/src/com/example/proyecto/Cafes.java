package com.example.proyecto;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        		if(!cafe_solo.getText().toString().trim().equals("0") && cafe_solo.getText().toString().length()!=0){
        			datos_cafes.add("Cafe solo: "+cafe_solo.getText().toString());
        		}
        		if(!cortado.getText().toString().trim().equals("0") && cortado.getText().toString().length()!=0){
        			datos_cafes.add("Cortado: "+cortado.getText().toString());
        		}
        		if(!cafe_con_leche.getText().toString().trim().equals("0") && cafe_con_leche.getText().toString().length()!=0){
        			datos_cafes.add("Cafe con leche: "+cafe_con_leche.getText().toString());
        		}
        		if(!cafe_tiempo.getText().toString().trim().equals("0") && cafe_tiempo.getText().toString().length()!=0){
        			datos_cafes.add("Cafe del tiempo: "+cafe_tiempo.getText().toString());
        		}
        		if(!carajillo.getText().toString().trim().equals("0") && carajillo.getText().toString().length()!=0){
        			datos_cafes.add("Carajillo de"+carajillo_de.getText().toString()+": "+carajillo.getText().toString());
        		}
        		if(!bombon.getText().toString().trim().equals("0") && bombon.getText().toString().length()!=0){
        			datos_cafes.add("Bombon: "+bombon.getText().toString());
        		}
        		if(!capuchinno.getText().toString().trim().equals("0") && capuchinno.getText().toString().length()!=0){
        			datos_cafes.add("Capuchinno: "+capuchinno.getText().toString());
        		}
        		if(descripcion.getText().toString().length()!=0){
        			datos_cafes.add("Descripcion: "+descripcion.getText().toString());
        		}
        		
        		
        		//forma parte lde la prueba
        		String[] estoEsUnaPrueba= new String[] {"test", "test2","test3"};
        		
        		//Envio el array a Seleccion de productos
        		/*Intent deCafesASeleccionProductos=new Intent(Cafes.this,SeleccionProductos.class);
        		
        		//forma parte de la prueba
        		deCafesASeleccionProductos.putExtra("estoEsUnaPrueba", estoEsUnaPrueba);
        		
        		deCafesASeleccionProductos.putStringArrayListExtra("datos_pedido", datos_cafes);
        		//deCafesASeleccionProductos.putExtra("datos_pedido", datos_cafes);
           		setResult(Activity.RESULT_OK,deCafesASeleccionProductos);
           		Cafes.this.finish();*/
        	}
        });
        
        //boton cancelar
        final Button cafes_cancelar= (Button)findViewById(R.id.cafes_cancelar);
        cafes_cancelar.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Cafes.this.finish();
        	}
        });
        
        //inicializar a "" todas las variables editText
        final Button cafes_borrar= (Button)findViewById(R.id.cafes_borrar);
        cafes_borrar.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		cafe_solo.setText("");
        		cortado.setText("");
        		cafe_con_leche.setText("");
        		cafe_tiempo.setText("");
        		carajillo_de.setText("");
        		carajillo.setText("");
        		bombon.setText("");
        		capuchinno.setText("");
        		descripcion.setText("");
        	}
        });
	}
	
	
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
	        	System.exit(0); //cierro la aplicacion
	        	break;
	        case R.id.MnuOpc2:
	        	Intent intent2 = new Intent(Cafes.this, InstruccionesDeUso.class );
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
