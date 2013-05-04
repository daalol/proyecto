package com.example.proyecto;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Cafes extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafes);
        
      
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
