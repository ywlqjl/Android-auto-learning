package com.example.yanwenli.a02_recycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by yanwenli on 2018/6/17.
 */

public class CommandAdapter extends RecyclerView.Adapter<CommandAdapter.MyViewHolder> {
	
	private List<Command> lstCommand;
	private List<Article> lstArticle;
	
	
	public class MyViewHolder extends RecyclerView.ViewHolder {
		
		public TextView idCommand, idTable;
		public RecyclerView articleView;
		
		public MyViewHolder(View view)
		{
			super(view);
			
			idCommand = (TextView) view.findViewById(R.id.id_command);
			idTable = (TextView) view.findViewById(R.id.id_Table);
			articleView = (RecyclerView) view.findViewById(R.id.ArticleView);
			articleView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
		}
	}
	
	public CommandAdapter(List<Command> lstCommand){
		this.lstCommand = lstCommand;
	}
	
	
	
	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int i)
	{
		View itemView = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.command, parent, false);
		
		return new MyViewHolder(itemView);
		
	}
	
	@Override
	public void onBindViewHolder(MyViewHolder holder, int position)
	{
		
		Command command = lstCommand.get(position);
		holder.idCommand.setText(String.valueOf(command.getIdCommand()));
		holder.idTable.setText(String.valueOf(command.getIdTable()));
		holder.articleView.setAdapter(new ArticleGroupAdapter(command.getLstArticles()));
		
	
	}
	@Override
	public int getItemCount()
	{
		return lstCommand.size();
	}
}
