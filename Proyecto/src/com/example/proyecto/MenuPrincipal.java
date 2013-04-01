package com.example.proyecto;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MenuPrincipal extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
        
        //ListView donde veremos los productos elegidos
        final ArrayList<String> datos = new ArrayList<String>();
        datos.add("Aqui veras los productos elegidos");
        	 
        	final ArrayAdapter<String> adaptador =
        	    new ArrayAdapter<String>(this,
        	        android.R.layout.simple_list_item_1, datos);
        	 
        	final ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        	lstOpciones.setAdapter(adaptador);
        //fin listView
        	
        //Cuando pulsemos en seleccion de productos nos llevara a otra pantalla donde
        //veremos todas las opciones
        final Button seleccion_de_productos= (Button)findViewById(R.id.seleccion_de_productos);
        seleccion_de_productos.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		/*Intent intent1 = new Intent (MenuPrincipal.this, laclase.class);
        	
        		startActivity(intent1);*/
        	}
        });
        
        //llamara a una clase que se encarga del envio de los datos a el servidor
        final Button enviar_al_camarero= (Button)findViewById(R.id.enviar_al_camarero);
        enviar_al_camarero.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		/*Intent intent2 = new Intent (MenuPrincipal.this, laclase.class);
        	
        		startActivity(intent1);*/
        	}
        });
        
        // *** BOTONES DE BORRADO ***
        
        //borra un elemento del ListView
        final Button borrar= (Button)findViewById(R.id.borrar);
        borrar.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		AlertDialog.Builder dialogo = new AlertDialog.Builder(MenuPrincipal.this);
        		dialogo.setTitle("Selecciona uno:");
        		final CharSequence[] cs = datos.toArray(new CharSequence[datos.size()]);
        		 dialogo.setItems(cs, new DialogInterface.OnClickListener() {
        		        public void onClick(DialogInterface dialog, int item) {
        		            //Log.i("Dialogos", "Opción elegida: " + cs[item]);
        		        	datos.remove(item);
        		        	adaptador.notifyDataSetChanged();//actualizo los cambios en la lista
        		            dialog.cancel();
        		        }
        		    });
        		
        		dialogo.create();
        		dialogo.show();

				
        		//datos.remove(1);
        	   // adaptador.notifyDataSetChanged(); 
        	}
        });
       
        //Borrara todos los elementos del listView
        final Button borrar_todo= (Button)findViewById(R.id.borrar_todo);
        borrar_todo.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        	
        		 adaptador.clear(); //vacio la lista
        		 datos.clear(); //vacio el array
        		 datos.add("Vuelvo a poner el mensaje inicial");
        		 adaptador.notifyDataSetChanged(); //actualizo los cambios en la lista
        		 
        	}
        });
        
        }				
}
