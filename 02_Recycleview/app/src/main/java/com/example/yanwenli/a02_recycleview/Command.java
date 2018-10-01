package com.example.yanwenli.a02_recycleview;

import java.util.List;

/**
 * Created by yanwenli on 2018/6/17.
 */

public class Command
{
	private int idCommand, idTable;
	private List<Article> lstArticles;
	
	public Command(){
	
	}
	
	public Command(int idCommand, int idTable, List<Article> lstArticles)
	{
		this.idCommand = idCommand;
		this.idTable = idTable;
		this.lstArticles = lstArticles;
	}
	
	public int getIdCommand()
	{
		return idCommand;
	}
	
	public void setIdCommand(int idCommand)
	{
		this.idCommand = idCommand;
	}
	
	public int getIdTable()
	{
		return idTable;
	}
	
	public void setIdTable(int idTable)
	{
		this.idTable = idTable;
	}
	
	public List<Article> getLstArticles()
	{
		return lstArticles;
	}
	
	public void setLstArticles(List<Article> lstArticles)
	{
		this.lstArticles = lstArticles;
	}
}
