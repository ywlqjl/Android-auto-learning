package com.example.yanwenli.a02_recycleview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
	
	private Button toCusine;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		toCusine = (Button) findViewById(R.id.btn_ToCuisine);
		
		toCusine.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this, CuisineActivity.class);
				startActivity(intent);
			
			}
		});
		
	}
}
