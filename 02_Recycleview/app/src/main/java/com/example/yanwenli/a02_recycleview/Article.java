package com.example.yanwenli.a02_recycleview;

/**
 * Created by yanwenli on 2018/6/17.
 */


public class Article extends Item
{
	
	private final int TYPE_TITLE = 0xa01;
	private final int TYPE_ARTICLE = 0xa02;
	
	private int nbArticle, ordre;
	private String name;
	
	public Article() {
	}
	
	public Article(int idArticle, String name, int ordre)
	{
		this.nbArticle = idArticle;
		this.ordre = ordre;
		this.name = name;
	}
	
	public int getNbArticle()
	{
		return nbArticle;
	}
	
	public void setNbArticle(int idArticle)
	{
		this.nbArticle = idArticle;
	}
	
	public int getOrdre()
	{
		return ordre;
	}
	
	public void setOrdre(int ordre)
	{
		this.ordre = ordre;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	@Override
	public int getType()
	{
		return TYPE_ARTICLE;
	}
}
