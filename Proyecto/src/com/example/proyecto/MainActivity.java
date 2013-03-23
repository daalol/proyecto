package com.example.proyecto;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	 MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.activity_main, menu);
         return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.MnuOpc1: 
        	finish(); //cierro la aplicacion
        	break;
        case R.id.MnuOpc2:
        	//Intent intent2 = new Intent(MainActivity.this, componentes_de_seleccion.class );
            //startActivity(intent2);
        	break;
        case R.id.MnuOpc3:
        	Intent intent3 = new Intent(MainActivity.this, AcercaDe.class );
            startActivity(intent3);
        	break;
        	}
        return true;
        }
}
