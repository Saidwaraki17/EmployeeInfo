package com.example.employeeinfo.Others;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.annotation.RequiresApi;

public class MyButtonFontStyle extends Button {
    public MyButtonFontStyle(Context context) {
        super(context);
        init();

    }

    public MyButtonFontStyle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyButtonFontStyle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyButtonFontStyle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "Font/four.ttf");
        setTypeface(tf ,1);

    }
}
