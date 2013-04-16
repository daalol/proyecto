package com.example.proyecto;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AcercaDe extends MainActivity{

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerca_de);
        
        final Button volverAcerca = (Button)findViewById(R.id.volverAcerca);
        volverAcerca.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		finish();
        	}
        });
        
	}
	
}
