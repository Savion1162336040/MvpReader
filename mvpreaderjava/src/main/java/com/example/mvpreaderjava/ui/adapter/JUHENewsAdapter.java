package com.example.mvpreaderjava.ui.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.modle.bean.JUHE.JUHENewsData;
import com.example.mvpreaderjava.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;

/**
 * Created by sw116 on 2018/4/25.
 */

public class JUHENewsAdapter extends RecyclerView.Adapter<JUHENewsAdapter.ViewHolder> {
    private List<JUHENewsData> dataList;
    private Context context;

    public JUHENewsAdapter(List<JUHENewsData> data, Context context) {
        this.dataList = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_juhe_news, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.content.setText(dataList.get(position).getTitle());
        holder.athor.setText(dataList.get(position).getAuthor_name());
        holder.date.setText(dataList.get(position).getDate());
        Glide.with(context).load(dataList.get(position).getThumbnail_pic_s()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class ViewHolder extends BaseViewHolder {
        @BindView(R.id.adapter_juhe_news_icon)
        AppCompatImageView imageView;
        @BindView(R.id.adapter_juhe_news_title)
        AppCompatTextView title;
        @BindView(R.id.adapter_juhe_news_content)
        AppCompatTextView content;
        @BindView(R.id.adapter_juhe_news_date)
        AppCompatTextView date;
        @BindView(R.id.adapter_juhe_news_athor)
        AppCompatTextView athor;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
