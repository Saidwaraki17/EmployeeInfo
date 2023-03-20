package com.example.employeeinfo.Others;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CheckBox;

import androidx.annotation.RequiresApi;

public class MyCheckBoxFontStyle extends CheckBox {
    public MyCheckBoxFontStyle(Context context) {
        super(context);
    }

    public MyCheckBoxFontStyle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCheckBoxFontStyle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyCheckBoxFontStyle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "Font/four.ttf");
        setTypeface(tf ,1);

    }
}
