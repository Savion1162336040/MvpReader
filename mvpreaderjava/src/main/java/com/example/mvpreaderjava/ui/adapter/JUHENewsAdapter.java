package com.example.mvpreaderjava.ui.adapter;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mvpreaderjava.MyApplication;
import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.modle.bean.JUHE.JUHENewsData;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by sw116 on 2018/4/25.
 */

public class JUHENewsAdapter extends BaseQuickAdapter<JUHENewsData, BaseViewHolder> {
    @Inject
    Application application;


    public JUHENewsAdapter(int layoutResId, @Nullable List<JUHENewsData> data) {
        super(layoutResId, data);
        application = MyApplication.instance.createComponent().getApp();
    }

    @Override
    protected void convert(BaseViewHolder helper, JUHENewsData item) {
        helper.setText(R.id.adapter_juhe_news_title, item.getTitle())
                .setText(R.id.adapter_juhe_news_date, item.getDate())
                .setText(R.id.adapter_juhe_news_athor, item.getAuthor_name());
        Glide.with(application).load(item.getThumbnail_pic_s()).into((ImageView) helper.getView(R.id.adapter_juhe_news_icon));
    }
}

//        RecyclerView.Adapter<JUHENewsAdapter.ViewHolder> {
//    private List<JUHENewsData> dataList;
//    private Context context;
//
//    public JUHENewsAdapter(List<JUHENewsData> data, Context context) {
//        this.dataList = data;
//        this.context = context;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.adapter_juhe_news, null);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.title.setText(dataList.get(position).getTitle());
//        holder.content.setText(dataList.get(position).getTitle());
//        holder.athor.setText(dataList.get(position).getAuthor_name());
//        holder.date.setText(dataList.get(position).getDate());
//        Glide.with(context).load(dataList.get(position).getThumbnail_pic_s()).into(holder.imageView);
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataList == null ? 0 : dataList.size();
//    }
//
//    class ViewHolder extends BaseViewHolder {
//        @BindView(R.id.adapter_juhe_news_icon)
//        AppCompatImageView imageView;
//        @BindView(R.id.adapter_juhe_news_title)
//        AppCompatTextView title;
//        @BindView(R.id.adapter_juhe_news_content)
//        AppCompatTextView content;
//        @BindView(R.id.adapter_juhe_news_date)
//        AppCompatTextView date;
//        @BindView(R.id.adapter_juhe_news_athor)
//        AppCompatTextView athor;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//        }
//    }
//}
