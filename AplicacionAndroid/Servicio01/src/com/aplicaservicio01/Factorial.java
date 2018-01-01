package com.aplicaservicio01;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.transport.HttpsTransportSE;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Factorial extends Activity {
	EditText txtnumero,txtfactorial;
	Button btnnuevo,btncalcular,btnsalir;
	//Variable para el resultado del metodo web
	String rs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_factorial);
		txtnumero=(EditText)findViewById(R.id.tnumero);
		txtfactorial=(EditText)findViewById(R.id.tfactorial);
		btnnuevo=(Button)findViewById(R.id.btnuevo);
		btncalcular=(Button)findViewById(R.id.btcalcular);
		btnsalir=(Button)findViewById(R.id.btsalir);
		
		btnnuevo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtnumero.setText("");
				txtfactorial.setText("");
				txtnumero.requestFocus();
			}
		});
        btncalcular.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Thread nt=new Thread(){
					
					public void run(){
						
						//Se almacena en una variable el nombre del metodo web
						String Metodo="Factorial";
						//Se almacena en una variable la direccion webservices
						//Espacio de trabajo
					    String NameSpace="http://microsoft.com/webservices/";
					    //Es la union del namespace y el metodo web
					    String SoapAction="http://microsoft.com/webservices/Factorial";
					    //La direccion web del servicio
					    String URL="http://ServicioWebSherild.somee.com/Service.asmx"; 
					    SoapObject request=new SoapObject(NameSpace,Metodo);
					    //Se define los valores a los parametros del meodo web 
					    request.addProperty("vnumero",Integer.parseInt(txtnumero.getText().toString()));
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
								txtfactorial.setText(rs);
								
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
		getMenuInflater().inflate(R.menu.factorial, menu);
		return true;
	}

}
