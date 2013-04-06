package com.example.proyecto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Cafes extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafes);
        
        final TextView uno= (TextView)findViewById(R.id.textView1);
        final TextView dos= (TextView)findViewById(R.id.textView2);
	}
}
