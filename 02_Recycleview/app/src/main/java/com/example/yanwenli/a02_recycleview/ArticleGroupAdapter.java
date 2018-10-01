package com.example.yanwenli.a02_recycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by yanwenli on 2018/6/17.
 */

public class ArticleGroupAdapter extends RecyclerView.Adapter<ArticleGroupAdapter.MyViewHolderArticle>
{
	private final int TYPE_TITLE = 0xa01;
	private final int TYPE_ARTICLE = 0xa02;
	
	private List<Article> lstArticle;
	
	public class MyViewHolderArticle extends RecyclerView.ViewHolder {
		
		public TextView nbArticle, nameArticle, ordreArticle;
		public MyViewHolderArticle(View view)
		{
			super(view);
			
			nbArticle = (TextView) view.findViewById(R.id.nb_Article);
			nameArticle = (TextView) view.findViewById(R.id.name_Article);
			ordreArticle = (TextView) view.findViewById(R.id.ordre_Article);
		}
	}
	
	public ArticleGroupAdapter(List<Article> lstArticle){
		this.lstArticle = lstArticle;
	}
	
	
	
	@NonNull
	@Override
	public ArticleGroupAdapter.MyViewHolderArticle onCreateViewHolder(ViewGroup parent, int i)
	{
		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.article, parent, false);
		
		return new ArticleGroupAdapter.MyViewHolderArticle(itemView);
		
	}
	
	@Override
	public void onBindViewHolder(ArticleGroupAdapter.MyViewHolderArticle holderArticle, int position)
	{
		
		Article article = lstArticle.get(position);
		holderArticle.nbArticle.setText(String.valueOf(article.getNbArticle()));
		holderArticle.nameArticle.setText(article.getName());
		holderArticle.ordreArticle.setText(String.valueOf(article.getOrdre()));
		
	}
	
	@Override
	public int getItemCount()
	{
		return lstArticle.size();
	}
	
	
	
	
	
	
	
	
	
	private abstract class ItemVH extends RecyclerView.ViewHolder {
		public ItemVH(View itemView) {
			super(itemView);
		}
		
		public abstract int getType();
	}
	
	private class ArticleVH extends ItemVH {
		
		public TextView nbArticle, nameArticle, ordreArticle;
		public ArticleVH(View view) {
			
			super(view);
			nbArticle = (TextView) view.findViewById(R.id.nb_Article);
			nameArticle = (TextView) view.findViewById(R.id.name_Article);
			ordreArticle = (TextView) view.findViewById(R.id.ordre_Article);
		}
		
		@Override
		public int getType() {
			return TYPE_ARTICLE;
		}
	}
	
	
	private class TitleVH extends ItemVH {
		
		public TextView title;
		
		public TitleVH(View itemView) {
			super(itemView);
			title = itemView.findViewById(android.R.id.title);
		}
		
		@Override
		public int getType() {
			return TYPE_TITLE;
		}
	}
}
