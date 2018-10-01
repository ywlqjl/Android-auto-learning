package com.example.yanwenli.yan_peng_tp3;

/**
 * Created by yanwenli on 2018/9/17.
 */

public interface IBackgroundService
{
	public void addListener(IBackgroundServiceListener listener);
	
	public void removeListener(IBackgroundServiceListener listener);
}
