package com.savion.mvpreader.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.savion.mvpreader.MyGlideApp;
import com.savion.mvpreader.R;
import com.savion.mvpreader.model.response.JUHENewsResponse;

import java.util.List;

/**
 * Created by Administrator on 2018-01-02.
 */

public class NewsContentItemAdapter extends RecyclerView.Adapter<NewsContentItemAdapter.NewsHolder> {

    private final Context mContext;
    private final List<JUHENewsResponse.JUHENewsResponseData> mNews;

    public NewsContentItemAdapter(Context context, List<JUHENewsResponse.JUHENewsResponseData> news) {
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
        holder.tvFrom.setText(mNews.get(position).getAuthor_name());
        holder.tvTitle.setText(mNews.get(position).getTitle());
        holder.tvDate.setText(mNews.get(position).getDate());
        holder.tvContent.setText(mNews.get(position).getTitle());
        Glide.with(mContext).load(mNews.get(position).getThumbnail_pic_s()).into(holder.imageView);
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
