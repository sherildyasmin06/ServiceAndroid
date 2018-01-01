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

public class Sumatoria extends Activity {
	EditText txtnum1,txtnum2,txtnum3,txtsumatoria;
	Button btnnuevo,btncalcular,btnsalir;
	String rs;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sumatoria);
		txtnum1=(EditText)findViewById(R.id.tnum1);
		txtnum2=(EditText)findViewById(R.id.tnum2);
		txtnum3=(EditText)findViewById(R.id.tnum3);
		txtsumatoria=(EditText)findViewById(R.id.tsumatoria);

		btnnuevo=(Button)findViewById(R.id.btnnuevo2);
		btncalcular=(Button)findViewById(R.id.btncalcular2);
		btnsalir=(Button)findViewById(R.id.btnsalir2);
		
        btnnuevo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtnum1.setText("");
				txtnum2.setText("");
				txtnum3.setText("");
				txtsumatoria.setText("");
				txtnum1.requestFocus();
			}
		});
         btncalcular.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
               Thread nt=new Thread(){
					
					public void run(){
						
						//Se almacena en una variable el nombre del metodo web
						String Metodo="Sumatoria";
						//Se almacena en una variable la direccion webservices
						//Espacio de trabajo
					    String NameSpace="http://microsoft.com/webservices/";
					    //Es la union del namespace y el metodo web
					    String SoapAction="http://microsoft.com/webservices/Sumatoria";
					    //La direccion web del servicio
					    String URL="http://ServicioWebSherild.somee.com/Service.asmx"; 
					    SoapObject request=new SoapObject(NameSpace,Metodo);
					    //Se define los valores a los parametros del meodo web 
					    request.addProperty("x1",Integer.parseInt(txtnum1.getText().toString()));
					    request.addProperty("x2",Integer.parseInt(txtnum2.getText().toString()));
					    request.addProperty("x3",Integer.parseInt(txtnum3.getText().toString()));
					    
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
								txtsumatoria.setText(rs);
								
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
		getMenuInflater().inflate(R.menu.sumatoria, menu);
		return true;
	}

}
