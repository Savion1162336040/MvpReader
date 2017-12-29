package com.savion.mvpreader.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.savion.mvpreader.R;
import com.savion.mvpreader.adapter.NewsFragmentAdapter;
import com.savion.mvpreader.bean.Tab;
import com.savion.mvpreader.presenter.NewsPresenter;
import com.savion.mvpreader.view.NewsFragmentView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends BaseFragment implements NewsFragmentView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private Tab mParam2;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private NewsFragmentAdapter newsFragmentAdapter;

    private NewsPresenter presenter;

    List<Tab> list;
    private OnFragmentInteractionListener mListener;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, Tab param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putSerializable(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = (Tab) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        viewPager = view.findViewById(R.id.news_pager);
        tabLayout = view.findViewById(R.id.news_tablayout);
        list = new ArrayList<>();
        newsFragmentAdapter = new NewsFragmentAdapter(getActivity().getSupportFragmentManager(), list);
        viewPager.setAdapter(newsFragmentAdapter);
        presenter = new NewsPresenter();
        presenter.attachView(this);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        initData(true);
        return view;
    }


    private void loadFragment() {
        list.clear();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        presenter.dettachView();
    }

    @Override
    void initData(boolean showLoading) {
        presenter.getTabs();
    }

    @Override
    public void changeTabs(@NotNull String tag) {
    }

    @Override
    public void showToast(@NotNull String str) {
        Snackbar.make(viewPager, str, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(@NotNull String str) {
        showToast(str);
    }

    @Override
    public void showLoading() {
        showToast("showLoading..");
    }

    @Override
    public void dismissLoading() {
        showToast("dismissLoading..");
    }

    @NotNull
    @Override
    public Context getIContext() {
        return getActivity();
    }

    @Override
    public void loadTabs(@NotNull ArrayList<Tab> tab) {
        list.clear();
        for (Tab tab1 : tab) {
            addTab(tab1);
            addTabTop(tab1.getTag());
        }
        newsFragmentAdapter.notifyDataSetChanged();
    }


    @Override
    public void addTab(@NotNull Tab tab) {
//        Fragment fragment = NewsContentFragment.newInstance(tab.getTag(), tab);
//        list.add(fragment);
        newsFragmentAdapter.addTab(tab);
    }

    @Override
    public void loadTabTops(@NotNull ArrayList<String> title) {
//        tabLayout.removeAllTabs();
//        for (String str : title) {
//            addTabTop(str);
//        }
    }

    @Override
    public void addTabTop(@NotNull String title) {
        //tabLayout.addTab(tabLayout.newTab().setTag(title).setText(title));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
