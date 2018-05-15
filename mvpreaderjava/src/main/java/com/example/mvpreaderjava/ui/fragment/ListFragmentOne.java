package com.example.mvpreaderjava.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.ui.activity.MainActivity;
import com.example.mvpreaderjava.ui.base.SimpleFragment;

import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by sw116 on 2018/4/19.
 */

public class ListFragmentOne extends BaseMainFragment {
    @BindView(R.id.fragment_one_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.fragment_one_toolbar)
    Toolbar toolbar;

    List<Map<String, String>> data;
    SimpleAdapter simpleAdapter;


    public static ListFragmentOne newInstance(Bundle bundle) {
        ListFragmentOne listFragmentOne = new ListFragmentOne();
        listFragmentOne.setArguments(bundle);
        return listFragmentOne;
    }

    public static ListFragmentOne newInstance(String tag) {
        Bundle bundle1 = new Bundle();
        bundle1.putString("tag", tag);
        return newInstance(bundle1);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_one;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupToolbar(toolbar,"ListFragmentOne");
        appCompatActivity.getSupportActionBar().setTitle(getArguments().getString("tag"));
//        data = new ArrayList<>();
//        Map<String, String> map = new HashMap<>();
//        for (int i = 0; i < 20; i++) {
//            map.put("title", "title:" + i);
//            map.put("subTitle", "subTitle:" + i);
//            data.add(map);
//        }
//
//        simpleAdapter = new SimpleAdapter(getContext(), data, android.R.layout.simple_list_item_2, new String[]{"title", "subTitle"}, new int[]{android.R.id.text1, android.R.id.text2});
////        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(simpleAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
