package com.example.employeeinfo.Others;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextViewFontStyle extends TextView {

    public MyTextViewFontStyle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MyTextViewFontStyle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextViewFontStyle(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "Font/four.ttf");
        setTypeface(tf ,1);

    }
}
