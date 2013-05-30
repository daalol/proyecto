package com.example.proyecto;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MenuPrincipal extends Activity{
	
	final ArrayList<String> datos = new ArrayList<String>();
	ArrayAdapter<String> adaptador;
	ListView lstOpciones;
	public static Activity cierreActivity; //Para poder cerrar la activity desde otra activity
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
        
      //Para poder cerrar la activity desde otra activity
        cierreActivity=this;
        
        // *** LIST VIEW DONDE VEREMOS LOS PRODUCTOS ELEGIDOS ***
        	adaptador =
        	    new ArrayAdapter<String>(this,
        	        android.R.layout.simple_list_item_1, datos);	 
        
        	lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        	lstOpciones.setAdapter(adaptador);
        //*** FIN LISTVIEW ***
        	
        // *** BOTONES DE PRODUCTOS ***
           final Button cafes= (Button)findViewById(R.id.cafes);
            cafes.setOnClickListener(new OnClickListener(){
            	public void onClick(View v){
               		Intent deMenuPrincipalACafes = new Intent(MenuPrincipal.this,Cafes.class);
               		MenuPrincipal.this.startActivityForResult(deMenuPrincipalACafes,0);
            	}
            });
            
          final Button refrescos= (Button)findViewById(R.id.refrescos);
            refrescos.setOnClickListener(new OnClickListener(){
            	public void onClick(View v){
            		Intent deMenuPrincipalARefrescos = new Intent(MenuPrincipal.this,Refrescos.class);
               		MenuPrincipal.this.startActivityForResult(deMenuPrincipalARefrescos,0);
            	}
            });
            
            final Button helados= (Button)findViewById(R.id.helados);
            helados.setOnClickListener(new OnClickListener(){
            	public void onClick(View v){
            		Intent deMenuPrincipalAHelados = new Intent(MenuPrincipal.this,Helados.class);
               		MenuPrincipal.this.startActivityForResult(deMenuPrincipalAHelados,0);
            	}
            });
            
            final Button bolleria= (Button)findViewById(R.id.bolleria);
            bolleria.setOnClickListener(new OnClickListener(){
            	public void onClick(View v){
            		Intent deMenuPrincipalABolleria = new Intent(MenuPrincipal.this,Bolleria.class);
               		MenuPrincipal.this.startActivityForResult(deMenuPrincipalABolleria,0);
            	}
            });
            
            final Button combinados= (Button)findViewById(R.id.combinados);
            combinados.setOnClickListener(new OnClickListener(){
            	public void onClick(View v){
            		Intent deMenuPrincipalACombinadosCafe = new Intent(MenuPrincipal.this,CombinadosCafe.class);
               		MenuPrincipal.this.startActivityForResult(deMenuPrincipalACombinadosCafe,0);
            	}
            });
           
            final Button especialidades= (Button)findViewById(R.id.especialidades);
            especialidades.setOnClickListener(new OnClickListener(){
            	public void onClick(View v){
            		Intent deMenuPrincipalAEspecialidades = new Intent(MenuPrincipal.this,Especialidades.class);
               		MenuPrincipal.this.startActivityForResult(deMenuPrincipalAEspecialidades,0);
            	}
            });
            
        // *** FIN BOTONES DE PRODUCTOS ***

        //*** Dialog para ver los productos del listView ***
            lstOpciones.setOnItemClickListener(new OnItemClickListener(){
            	public void onItemClick(AdapterView<?> parent, View view, int position, long id) { 
            		
            		AlertDialog.Builder seleccion = new AlertDialog.Builder(MenuPrincipal.this);
            		
	        		seleccion.setTitle("Descripción del pedido:");
	        		final CharSequence[] chs =datos.toArray(new CharSequence[datos.size()]);
	        		seleccion.setItems(chs, new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
						}     
        		    });
	        		seleccion.create();
	        		seleccion.show();
	        			
            	}
            	
            });
        
        // *** ENVIO DE DATOS A LA APLICACION SERVIDORA ***
        	
        final Button enviar_al_camarero= (Button)findViewById(R.id.enviar_al_camarero);
        enviar_al_camarero.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		//Si no se a añadido ningun producto muestro un toast informando, si no, voy a la actividad "enviar"
        		if(datos.isEmpty())
        			Toast.makeText(getBaseContext(),"No has añadido ningun producto!!!", Toast.LENGTH_SHORT).show();
        		else{
        		Intent deMenuPrincipalAEnviar = new Intent(MenuPrincipal.this,Enviar.class);
        		//añadimos el String que contendra todo el pedido llamando al metodo formateaPedido
        		deMenuPrincipalAEnviar.putExtra("pedido", formateaPedido(datos));
           		MenuPrincipal.this.startActivityForResult(deMenuPrincipalAEnviar,0);
        		}
        	}
        });
        // *** FIN ENVIO DE DATOS ***
        
        
        // *** BOTONES DE BORRADO ***
        
        //borra un elemento del ListView
        final Button borrar= (Button)findViewById(R.id.borrar);
        borrar.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
	        	if(!datos.isEmpty()){
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
        	}
        });
       
        //Borrara todos los elementos del listView
        final Button borrar_todo= (Button)findViewById(R.id.borrar_todo);
        borrar_todo.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		 adaptador.clear(); //vacio la lista
        		 datos.clear(); //vacio el array
        		 adaptador.notifyDataSetChanged(); //actualizo los cambios en la lista
        		 
        	}
        });
        
        // ***** FIN BOTONES DE BORRADO *****
       
       
        }	
	
	 protected void onActivityResult(int codigo,int codigo2,Intent pedido){
	      	if(codigo==0){
	  			if(codigo2==Activity.RESULT_OK){
	  			
	  				datos.add(pedido.getExtras().getString("datos_pedido"));
	  				adaptador.notifyDataSetChanged();
	  				
	  			}
	      	}
	      }
	 
	 //Este metodo se encarga de formatear los datos del arrayList para que esten todos
	 //en un solo String y con un separador
	 public String formateaPedido(ArrayList<String> datos){
		 
		 String resultado="*** "+datos.get(0);
		 for(int i=1; i<datos.size();i++){
			 resultado+=" ||| "+datos.get(i);
		 }
		return resultado;
		 
	 }
	 
	 public void cierre(){
		 MenuPrincipal.this.finish();
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
	        	MenuPrincipal.this.finish(); //cierro la aplicacion
	        	break;
	        case R.id.MnuOpc2:
	        	Intent deMenuPrincipalAInstruccionesDeUso = new Intent(MenuPrincipal.this, InstruccionesDeUso.class );
	        	deMenuPrincipalAInstruccionesDeUso.putExtra("valor", 0);
	            startActivity(deMenuPrincipalAInstruccionesDeUso);
	        	break;
	        case R.id.MnuOpc3:
	        	Intent deMenuPrincipalAAcercaDe = new Intent(MenuPrincipal.this, AcercaDe.class );
	            startActivity(deMenuPrincipalAAcercaDe);
	        	break;
	        	}
	        return true;
	        }
	
}
