package com.aplicaservicio01;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Triangulo extends Activity {
	EditText txtbase,txtaltura,txttriangulo;
	Button btnnuevo,btncalcular,btnsalir;
	//Variable para el resultado del metodo web
	String rs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_triangulo);
		txtbase=(EditText)findViewById(R.id.tbase);
		txtaltura=(EditText)findViewById(R.id.taltura);
		txttriangulo=(EditText)findViewById(R.id.ttriangulo);
		btnnuevo=(Button)findViewById(R.id.btnnuevo3);
		btncalcular=(Button)findViewById(R.id.btncalcular3);
		btnsalir=(Button)findViewById(R.id.btnsalir3);
		
        btnnuevo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtbase.setText("");
				txtaltura.setText("");
				txttriangulo.setText("");
				txtbase.requestFocus();
			}
		});
        btncalcular.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
                  Thread nt=new Thread(){
					
					public void run(){
						
						//Se almacena en una variable el nombre del metodo web
						String Metodo="Triangulo";
						//Se almacena en una variable la direccion webservices
						//Espacio de trabajo
					    String NameSpace="http://microsoft.com/webservices/";
					    //Es la union del namespace y el metodo web
					    String SoapAction="http://microsoft.com/webservices/Triangulo";
					    //La direccion web del servicio
					    String URL="http://ServicioWebSherild.somee.com/Service.asmx"; 
					    SoapObject request=new SoapObject(NameSpace,Metodo);
					    //Se define los valores a los parametros del meodo web 
					    request.addProperty("vbase",Integer.parseInt(txtbase.getText().toString()));
					    request.addProperty("altura",Integer.parseInt(txtaltura.getText().toString()));
					    SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
					    //Se fija que es un servicio web de visual studio 
					    envelope.dotNet=true;
					    //Se fijan los valores a la direccion web
					    envelope.setOutputSoapObject(request);
					    try{
					    	//Envio de los datos al servicio web
					    HttpTransportSE transporte=new HttpTransportSE(URL);
					    transporte.call(SoapAction, envelope);
					    //La respuesta del servicio web
					    SoapPrimitive resultado= (SoapPrimitive)envelope.getResponse();
					    rs=resultado.toString();				    
					    }catch(Exception e1){e1.toString();}
					    runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								txttriangulo.setText(rs);
								
							}
						});
					}
				};
			nt.start();
			}
		});
         btnsalir.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
        
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.triangulo, menu);
		return true;
	}

}
