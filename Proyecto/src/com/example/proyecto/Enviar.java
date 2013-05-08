package com.example.proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Enviar extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enviar);
        
     // ***** SPINNER ******
        //Inicializo el spinner
        final Spinner spinnerMesa = (Spinner) findViewById(R.id.spinnerMesa);
      //Configuro su adaptador
      	ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.mesas, android.R.layout.simple_spinner_item);
      	adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      //Coloco el adaptador en su elemento correspondiente
      		spinnerMesa.setAdapter(adaptador);	
      //Spinner inicializado
        
      		
      //**** BOTONES VOLVER Y ENVIAR ****
       final Button volver = (Button)findViewById(R.id.volver);
       volver.setOnClickListener(new OnClickListener() {
             public void onClick(View v) {	
              	    	Enviar.this.finish();
              }
            });
            
        
       final Button enviar = (Button)findViewById(R.id.enviar);
       enviar.setOnClickListener(new OnClickListener() {
    	     public void onClick(View v) {
    	     
    	    	 ArrayList parametros = new ArrayList();
    	    	 parametros.add("Pedido");
    	    	 parametros.add("Unpedidocualquiera");
    	    	 parametros.add("Contrasena");
    	    	 parametros.add("Albert");
    	    	 // Llamada a Servidor Web PHP
    	    	 try {
    	    	    Post post = new Post();
    	    	    JSONArray datos = post.getServerData(parametros, "http://192.168.0.160/recoge.php");
    	    	    if (datos != null && datos.length() > 0) {
                        JSONObject json_data = datos.getJSONObject(0);
                        int numMesa = json_data.getInt("ID_MESA");
                        	if (numMesa > 0) {
                        		Toast.makeText(getBaseContext(),"Acierto. ", Toast.LENGTH_SHORT).show();
                        	}
    	    	    } else {
                        Toast.makeText(getBaseContext(),"Error. ", Toast.LENGTH_SHORT)
                                                                                              .show();
                        	}
    	    	 } catch (Exception e) {
                        Toast.makeText(getBaseContext(),"Error al conectar con el servidor. ", Toast.LENGTH_SHORT).show();
    	    	 					}
    	    	 	// FIN Llamada a Servidor Web PHP
    	     }
    	 });//FIN OnClickListener
       
       
	}//Fin onCreate
	
	//Clase Post
	class Post {
		 private InputStream is = null;
         private String respuesta = "";
         
         //Prepara la salida de datos hacia el servidor en un imputstream llamado 'is'
         private void conectaPost(ArrayList parametros, String URL) {
             ArrayList nameValuePairs;
             try {
            	 HttpClient httpclient = new DefaultHttpClient();

                 HttpPost httppost = new HttpPost(URL);
                 nameValuePairs = new ArrayList();
                 
                 if (parametros != null) {
                	  for (int i = 0; i < parametros.size() - 1; i += 2) {
                		  nameValuePairs.add(new BasicNameValuePair((String)parametros.get(i), (String)parametros.get(i + 1)));
                	 }
                	  httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                 }
                 HttpResponse response = httpclient.execute(httppost);
                 HttpEntity entity = response.getEntity();
                 is = entity.getContent();
             } catch (Exception e) {
            	  Log.e("log_tag", "Error en conexion http " + e.toString());
             }
         }
         
         private void getRespuestaPost() {
        	 try {
	        	 BufferedReader reader = new BufferedReader(
	        	 new InputStreamReader(is, "iso-8859-1"), 8);
	        	 StringBuilder sb = new StringBuilder();
	        	 String line = null;
		        	 while ((line = reader.readLine()) != null) {
		        	       sb.append(line + "\n");
		        	 }
	        	 is.close();
	        	 respuesta = sb.toString();
	        	 Log.e("log_tag", "Cadena JSon " + respuesta);
        	 } catch (Exception e) {
        	           Log.e("log_tag", "Error converting result " + e.toString());
        	     }
        	 }//Fin getRespuestaPost

        	 @SuppressWarnings("finally")
        	 private JSONArray getJsonArray() {
        	     JSONArray jArray = null;
        	     try {
        	           jArray = new JSONArray(respuesta);
        	         } catch (Exception e) {
        	         	} finally {
        	                  return jArray;
        	         		}
        	 }

        	 public JSONArray getServerData(ArrayList parametros, String URL) {
        	      conectaPost(parametros, URL);
        	      if (is != null) {
        	             getRespuestaPost();
        	      }
        	          if (respuesta != null && respuesta.trim() != "") {
                          return getJsonArray();
        	          } else {
        	                 return null;
        	             }
        	   }//Fin getServerData
         }//Fin clase Post
	}//Fin activity

