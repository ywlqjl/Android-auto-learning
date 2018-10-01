package com.example.yanwenli.yan_peng_tp3;

import android.os.Binder;

/**
 * Created by yanwenli on 2018/9/17.
 */

public class BackgroundServiceBinder extends Binder
{
	private IBackgroundService service = null;
	
	public BackgroundServiceBinder(IBackgroundService service)
	{
		super();
		this.service = service;
	}
	
	public IBackgroundService getService()
	{
		return service;
	}
}
