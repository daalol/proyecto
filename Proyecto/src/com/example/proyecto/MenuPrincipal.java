package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuPrincipal extends Activity{

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
        
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
        
        }
}
