package com.savion.mvpreader.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.savion.mvpreader.GlideApp;
import com.savion.mvpreader.R;
import com.savion.mvpreader.bean.News;

import java.util.List;

/**
 * Created by Administrator on 2018-01-02.
 */

public class NewsContentItemAdapter extends RecyclerView.Adapter<NewsContentItemAdapter.NewsHolder> {

    private final Context mContext;
    private final List<News> mNews;

    public NewsContentItemAdapter(Context context, List<News> news) {
        this.mContext = context;
        this.mNews = news;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        NewsHolder holder = new NewsHolder(inflater.inflate(R.layout.news_item_view, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        holder.tvFrom.setText(mNews.get(position).getFrom());
        holder.tvTitle.setText(mNews.get(position).getTitle());
        holder.tvDate.setText(mNews.get(position).getDate());
        holder.tvContent.setText(mNews.get(position).getContent());
        GlideApp.with(mContext).load(mNews.get(position).getIcon()).centerCrop().placeholder(R.mipmap.ic_launcher).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvContent, tvDate, tvFrom;
        private ImageView imageView;

        public NewsHolder(View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.news_item_content);
            tvDate = itemView.findViewById(R.id.news_item_date);
            tvTitle = itemView.findViewById(R.id.news_item_title);
            tvFrom = itemView.findViewById(R.id.news_item_from);
            imageView = itemView.findViewById(R.id.news_item_icon);
        }
    }
}
