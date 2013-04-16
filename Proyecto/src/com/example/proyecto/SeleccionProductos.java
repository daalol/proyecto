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
import android.widget.TextView;


public class SeleccionProductos extends Activity {

	//ArrayList que contendra todos los datos del pedido y que enviaremos a MenuPrincipal
    final ArrayList<String> datos_pedido = new ArrayList<String>();
    String[] estoEsUnaPrueba;
    
    
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_productos);
        
        //*** BOTONES PARA LOS PRODUCTOS ***
        final Button cafes= (Button)findViewById(R.id.cafes);
        cafes.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		//para probarlo
           		Intent deSeleccionProductosACafes = new Intent(SeleccionProductos.this,Cafes.class);
           		SeleccionProductos.this.startActivityForResult(deSeleccionProductosACafes,0);
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
        */
        
        //*** BOTONES PARA EL CONTROL DE LA ACTIVIDAD ***
      
        final Button volver_ok= (Button)findViewById(R.id.volver_ok);
        volver_ok.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		//para probarlo
        		Intent as= new Intent(SeleccionProductos.this, MenuPrincipal.class);
        		as.putStringArrayListExtra("datos_pedido", datos_pedido);
        		
        		//forma parte de la prueba
        		as.putExtra("estoEsUnaPrueba", estoEsUnaPrueba);
        		
        		final TextView pruebas= (TextView)findViewById(R.id.textView111);
  				pruebas.setText(estoEsUnaPrueba[1].toString());
        		
           		setResult(Activity.RESULT_OK,as);
           		SeleccionProductos.this.finish();
        	}
        });
        
        final Button volver_no_ok= (Button)findViewById(R.id.volver_no_ok);
        volver_no_ok.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		Intent deSeleccionProductosAMenuPrincipalNoOk= new Intent (SeleccionProductos.this, MenuPrincipal.class);
        		startActivity(deSeleccionProductosAMenuPrincipalNoOk);
        	}
        });
        
      
	}
	
	  protected void onActivityResult(int codigo,int codigo2,Intent pedido){
      	if(codigo==0){
  			if(codigo2==Activity.RESULT_OK){
  				
  				datos_pedido.addAll(pedido.getExtras().getStringArrayList("datos_pedido"));
  				
  				//forma parte de la prueba
  			    estoEsUnaPrueba= pedido.getStringArrayExtra("estoEsUnaPrueba");
 
  			}
      	}
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
	        	Intent intent2 = new Intent(SeleccionProductos.this, InstruccionesDeUso.class );
	            startActivity(intent2);
	        	break;
	        case R.id.MnuOpc3:
	        	Intent intent3 = new Intent(SeleccionProductos.this, AcercaDe.class );
	            startActivity(intent3);
	        	break;
	        	}
	        return true;
	        }
}
