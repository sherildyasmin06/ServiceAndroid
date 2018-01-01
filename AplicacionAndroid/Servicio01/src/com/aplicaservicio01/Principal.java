package com.aplicaservicio01;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Principal extends Activity {
	Button bt1,bt2,bt3,bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        bt1= (Button)findViewById(R.id.btnfactorial);
        bt2= (Button)findViewById(R.id.btnsumatoria);
        bt3= (Button)findViewById(R.id.btntriangulo);
        bt4= (Button)findViewById(R.id.btnsalir);
       
        bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent v1=new Intent(getApplicationContext(),Factorial.class);
				startActivity(v1);
			}
		});
       bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent v2=new Intent(getApplicationContext(),Sumatoria.class);
				startActivity(v2);
			}
		});
       bt3.setOnClickListener(new View.OnClickListener() {
 		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent v3=new Intent(getApplicationContext(),Triangulo.class);
			startActivity(v3);
		}
	});
      bt4.setOnClickListener(new View.OnClickListener() {
		
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
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }    
}
