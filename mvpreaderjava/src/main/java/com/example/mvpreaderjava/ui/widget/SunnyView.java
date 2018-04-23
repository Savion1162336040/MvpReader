package com.example.mvpreaderjava.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.example.mvpreaderjava.R;

/**
 * Created by sw116 on 2018/4/23.
 */

public class SunnyView extends android.support.v7.widget.AppCompatTextView {
    public SunnyView(Context context) {
        this(context, null);
    }

    public SunnyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public SunnyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SunnyView);
        int color = typedArray.getColor(R.styleable.SunnyView_sunnyColor, Color.YELLOW);
        setBackgroundColor(color);
    }


}
