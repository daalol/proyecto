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
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Enviar extends Activity{

	private MenuPrincipal cerrar= new MenuPrincipal();//Para cerrar el MenuPrincipal desde aqui
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enviar);
       
      		
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
    	    	 final EditText editTextContraseña = (EditText) findViewById(R.id.editTextContraseña);
    	    	 Bundle recibePedido = getIntent().getExtras();
    	    	 String pedido=recibePedido.getString("pedido");
    	    	 
    	    	 parametros.add("Pedido");
    	    	 parametros.add(pedido);
    	    	 parametros.add("Contrasena");
    	    	 parametros.add(editTextContraseña.getText().toString());
    	    	 // Llamada a Servidor Web PHP
    	    	 try {
    	    	    Post post = new Post();
    	    	    JSONArray datos = post.getServerData(parametros, "http://192.168.0.160/pro_android/recoge_datos.php");
    	    	    if (datos != null && datos.length() > 0) {
    	    	    
                        JSONObject json_data = datos.getJSONObject(0); 
                        int numMesa = json_data.getInt("id_mesa");
                        	if (numMesa > 0) {
                        		Toast.makeText(getBaseContext(),"Acierto, ¡El pedido a sido enviado para su elaboración!. ", Toast.LENGTH_SHORT).show();
                        		Enviar.this.finish();
                        	}
    	    	    } else {
    	    	    		if(!isOnline()){ //Compruebo si la no conexion del dispositivo a internet puede ser el problema
    	    	    			Toast.makeText(getBaseContext(),"Error, ¡no estas conectado a internet!. ", Toast.LENGTH_SHORT).show();
    	    	    		}
    	    	    		else
    	    	    			Toast.makeText(getBaseContext(),"Error, el pedido no a sido enviado. ", Toast.LENGTH_SHORT).show();
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
	
	
	//Metodo para comprobar si el dispositivo esta conectado a internet
	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo netInfo = cm.getActiveNetworkInfo();

		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}

			return false;
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
	        	cerrar.cierreActivity.finish();
	        	Enviar.this.finish(); //cierro la aplicacion
	        	break;
	        case R.id.MnuOpc2:
	        	Intent deEnviarAInstruccionesDeUso = new Intent(Enviar.this, InstruccionesDeUso.class );
	        	deEnviarAInstruccionesDeUso.putExtra("valor", 7);
	            startActivity(deEnviarAInstruccionesDeUso);
	        	break;
	        case R.id.MnuOpc3:
	        	Intent intent3 = new Intent(Enviar.this, AcercaDe.class );
	            startActivity(intent3);
	        	break;
	        	}
	        return true;
	        }
	}//Fin activity

