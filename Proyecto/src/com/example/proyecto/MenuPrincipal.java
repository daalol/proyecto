package com.example.proyecto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MenuPrincipal extends Activity{
	
	final ArrayList<String> datos = new ArrayList<String>();
	ArrayAdapter<String> adaptador;
	ListView lstOpciones;
	String[] estoEsUnaPrueba;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
        
        //ListView donde veremos los productos elegidos
        
        datos.add("Aqui veras los productos elegidos");
        	adaptador =
        	    new ArrayAdapter<String>(this,
        	        android.R.layout.simple_list_item_1, datos);	 
        
        	lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        	lstOpciones.setAdapter(adaptador);
        //fin listView
        	
        //Cuando pulsemos en seleccion de productos nos llevara a otra pantalla donde
        //veremos todas las opciones
        final Button seleccion_de_productos= (Button)findViewById(R.id.seleccion_de_productos);
        seleccion_de_productos.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		Intent deMenuPrincipalASeleccionProductos = new Intent (MenuPrincipal.this, SeleccionProductos.class);
        		MenuPrincipal.this.startActivityForResult(deMenuPrincipalASeleccionProductos,0);
        		
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
        		           
        		        	datos.remove(item);
        		        	adaptador.notifyDataSetChanged();//actualizo los cambios en la lista
        		            dialog.cancel();
        		        }
        		    });
        		
        		dialogo.create();
        		dialogo.show();
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
	
	 protected void onActivityResult(int codigo,int codigo2,Intent pedido_completo){
	      	if(codigo==0){
	  			if(codigo2==Activity.RESULT_OK){
	  			
	  				adaptador.clear();
	  				datos.clear();
	  				datos.addAll(pedido_completo.getExtras().getStringArrayList("datos_pedido"));
	  				adaptador.notifyDataSetChanged();
	  				
	  				/*//forma parte de la prueba
	  			    estoEsUnaPrueba= pedido_completo.getStringArrayExtra("estoEsUnaPrueba");
	  				final TextView textView11= (TextView)findViewById(R.id.textView11);
	  				textView11.setText(estoEsUnaPrueba[2].toString());*/
	  				
	  				
	  				/*List<String>a=Arrays.asList(estoEsUnaPrueba);
	  				
	  				ArrayAdapter<String>adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, a);
	  				//lstOpciones = (ListView)findViewById(R.id.LstOpciones);
	  	        	lstOpciones.setAdapter(adaptador2);
	  	        	adaptador2.notifyDataSetChanged();*/
	  				
	  			}
	      	}
	      }
	 
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
	        	System.exit(0); //cierro la aplicacion
	        	break;
	        case R.id.MnuOpc2:
	        	Intent intent2 = new Intent(MenuPrincipal.this, InstruccionesDeUso.class );
	            startActivity(intent2);
	        	break;
	        case R.id.MnuOpc3:
	        	Intent intent3 = new Intent(MenuPrincipal.this, AcercaDe.class );
	            startActivity(intent3);
	        	break;
	        	}
	        return true;
	        }
	
}
