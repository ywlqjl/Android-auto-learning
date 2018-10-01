package com.example.yanwenli.a02_recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CuisineActivity extends AppCompatActivity
{
	
	private List<Command> lstCommand;
	private List<Article> lstArticle;
	private RecyclerView recyclerView;
	
	private CommandAdapter commandAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cuisine);
		recyclerView = findViewById(R.id.commandView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
		lstCommand = generateCommands();
 		recyclerView.setAdapter(new CommandAdapter(lstCommand));
	}
	
	
	public List<Article> generateArticles(){
		
		lstArticle = new ArrayList<>();
		lstArticle.add(new Article(1,"poisson",1));
		lstArticle.add(new Article(2,"Salade",0));
		lstArticle.add(new Article(3,"moule",0));
		lstArticle.add(new Article(4,"poulet",2));
		return lstArticle;
	}
	
	
	
	public List<Command> generateCommands(){
		
		lstCommand = new ArrayList<>();
		Command c1 = new Command(1, 101, generateArticles());
		Command c2 = new Command(1, 102, generateArticles());
		Command c3 = new Command(3, 121, generateArticles());
		Command c4 = new Command(2, 111, generateArticles());
		lstCommand.add(c1);
		lstCommand.add(c2);
		lstCommand.add(c3);
		lstCommand.add(c4);
		return lstCommand;
	}
	
	
}
