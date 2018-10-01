package com.example.yanwenli.a02_recycleview;

import java.util.List;

/**
 * Created by yanwenli on 2018/6/17.
 */

public class GroupTitle extends Item
{
	
	private final int TYPE_TITLE = 0xa01;
	private final int TYPE_ARTICLE = 0xa02;
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	private String title;
	
	
	
	@Override
	public int getType()
	{
		return TYPE_TITLE ;
	}
}
