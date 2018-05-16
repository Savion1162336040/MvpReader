package com.example.mvpreaderjava.ui.activity;

import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.ui.base.SimpleActivity;
import com.savion.loadinglayout.LoadingLayout;

import butterknife.BindView;
import butterknife.OnClick;

public class TestActivity extends SimpleActivity {
    @BindView(R.id.empty)
    Button empty;
    @BindView(R.id.error)
    Button error;
    @BindView(R.id.loading)
    Button loading;
    @BindView(R.id.content)
    Button content;
    @BindView(R.id.loadinglayout)
    LoadingLayout loadingLayout;

    @BindView(R.id.seekbar)
    SeekBar progressBar;
    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.appcompatimage)
    AppCompatImageView appCompatImageView;
    @BindView(R.id.text)
    TextView textView;
    int imageWidth;
    int imageHeight;
    int appcompatWidth;
    int appcompatHeight;
    int textHeight;
    int textWidth;
    boolean first = false;

    int xishu = 10;

    @Override
    protected int getLayout() {
        return R.layout.activity_test;
    }

    @Override
    protected void onViewCreated() {

        loadingLayout.retry(v -> Toast.makeText(TestActivity.this, "retry", Toast.LENGTH_LONG).show());
        progressBar.setMax(100);
        progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!first) {
                    imageWidth = imageView.getWidth();
                    imageHeight = imageView.getHeight();
                    appcompatWidth = appCompatImageView.getWidth();
                    appcompatHeight = appCompatImageView.getHeight();
                    textHeight = textView.getHeight();
                    textWidth = textView.getWidth();
                    first = true;
                }
                ViewGroup.LayoutParams imageParams = imageView.getLayoutParams();
                ViewGroup.LayoutParams appcompatParams = appCompatImageView.getLayoutParams();
                ViewGroup.LayoutParams textparams = textView.getLayoutParams();
                imageParams.height = (int) (imageHeight * (progress / 100.0*xishu) + imageHeight);
                imageParams.width = (int) (imageWidth * (progress / 100.0*xishu) + imageWidth);
                imageView.setLayoutParams(imageParams);

                appcompatParams.height = (int) (appcompatHeight * (progress / 100.0*xishu) + appcompatHeight);
                appcompatParams.width = (int) (appcompatWidth * (progress / 100.0*xishu) + appcompatWidth);
                appCompatImageView.setLayoutParams(appcompatParams);
                
                textparams.height = (int) (textHeight * (progress / 100.0*xishu) + textHeight);
                textparams.width = (int) (textWidth * (progress / 100.0*xishu) + textWidth);
                textView.setLayoutParams(textparams);
                
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @OnClick(value = {R.id.empty, R.id.error, R.id.loading, R.id.content})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.empty:
                loadingLayout.showEmpty();
                break;
            case R.id.error:
                loadingLayout.showError();
                break;
            case R.id.loading:
                loadingLayout.showLoading();
                break;
            case R.id.content:
                loadingLayout.showContent();
                break;
        }
    }
}
