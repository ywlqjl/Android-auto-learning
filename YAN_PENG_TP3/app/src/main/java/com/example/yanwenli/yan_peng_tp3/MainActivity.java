package com.example.yanwenli.yan_peng_tp3;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
	
	private Button btnStart;
	private Button btnConnexion;
	private Button btnDeconnexion;
	private Button btnStop;
	private EditText editText;
	private IBackgroundServiceListener iBackgroundServiceListener;
	private IBackgroundService monservice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnStart = findViewById(R.id.btn_start);
		btnConnexion = findViewById(R.id.btn_connexion);
		btnDeconnexion = findViewById(R.id.btn_deconnexion);
		btnStop = findViewById(R.id.btn_stop);
		editText = findViewById(R.id.text);
		
		final Intent intent = new Intent(MainActivity.this, BackgoundService.class);
		iBackgroundServiceListener = new IBackgroundServiceListener(){
			@Override
			public void dataChanged(final Object o)
			{
				MainActivity.this.runOnUiThread(new Runnable(){
					@Override
					public void run()
					{
						editText.setText(o.toString());
					}
				});
			}
		};
		
		final ServiceConnection cnn = new ServiceConnection(){
			@Override
			public void onServiceConnected(ComponentName name, IBinder service)
			{
				Log.i("BackgroundService", "Connected!");
				monservice = ((BackgroundServiceBinder)service).getService();
				monservice.addListener(iBackgroundServiceListener);
			}
			
			@Override
			public void onServiceDisconnected(ComponentName name)
			{
			
			}
		};
		
		btnStart.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				startService(intent);
			
			}
		});
		
		btnConnexion.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				bindService(intent, cnn, BIND_AUTO_CREATE);
			}
		});
		
		btnDeconnexion.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				unbindService(cnn);
				monservice.removeListener(iBackgroundServiceListener);
			}
		});
		
		btnStop.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				stopService(intent);
			
			}
		});
	}
}
