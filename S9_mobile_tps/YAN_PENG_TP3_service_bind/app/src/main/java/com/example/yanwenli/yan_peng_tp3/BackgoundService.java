package com.example.yanwenli.yan_peng_tp3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class BackgoundService extends Service implements IBackgroundService
{
	private Timer timer;
	private ArrayList<IBackgroundServiceListener> listeners = null;
	private BackgroundServiceBinder binder;
	public BackgoundService()
	{
	}
	
	@Override
	public IBinder onBind(Intent intent)
	{
		return binder;
	}
	
	@Override
	public void onCreate()
	{
		super.onCreate();
		timer = new Timer();
		listeners = new ArrayList<>();
		binder = new BackgroundServiceBinder(this);
		Log.d(this.getClass().getName(), "onCreate");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		
		final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		
		Log.d(this.getClass().getName(), "onStart");
		timer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				String t = format.format(new Date());
				
				fireDataChanged(t);
				
				// Executer de votre tâche
			}
		}, 0, 1000);
		
		return START_NOT_STICKY;
	}
	
	@Override
	public void onDestroy()
	{
		Log.d(this.getClass().getName(), "onDestroy");
		this.timer.cancel();
	}
	
	@Override
	public void addListener(IBackgroundServiceListener listener)
	{
		
		if(listeners != null)
		{
			listeners.add(listener);
		}
	}
	
	@Override
	public void removeListener(IBackgroundServiceListener listener)
	{
		
		if(listeners != null)
		{
			listeners.remove(listener);
		}
	}
	
	private void fireDataChanged(Object data)
	{
		Log.i("time", data.toString());
		if(listeners != null)
		{
			for(IBackgroundServiceListener listener : listeners)
			{
				listener.dataChanged(data);
			}
		}
	}
}
