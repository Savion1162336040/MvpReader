package com.example.mvpreaderjava.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.modle.bean.wanAndroid.WanAndroidPost;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class HomePostAdapter extends BaseQuickAdapter<WanAndroidPost, BaseViewHolder> {

    public HomePostAdapter(int layoutResId, @Nullable List<WanAndroidPost> data) {
        super(layoutResId, data);
    }

    public HomePostAdapter(@Nullable List<WanAndroidPost> data) {
        super(data);
    }

    public HomePostAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, WanAndroidPost item) {
        helper.setText(R.id.adapter_home_post_author, item.getAuthor())
                .setText(R.id.adapter_home_post_date, item.getNiceDate())
                .setText(R.id.adapter_home_post_content, item.getTitle())
                .setText(R.id.adapter_home_post_type, item.getChapterName())
                .setImageResource(R.id.adapter_home_post_like, item.isCollect() ? R.drawable.ic_like : R.drawable.ic_no_like)
                .linkify(R.id.adapter_home_post_type)
                .linkify(R.id.adapter_home_post_like)
                .linkify(R.id.adapter_juhe_news_athor)
                .linkify(R.id.adapter_home_post_icon)
                .addOnClickListener(R.id.adapter_home_post_type)
                .addOnClickListener(R.id.adapter_home_post_icon)
                .addOnClickListener(R.id.adapter_home_post_like)
                .addOnClickListener(R.id.adapter_home_post_author);
    }
}
