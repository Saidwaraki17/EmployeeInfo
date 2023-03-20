package com.example.employeeinfo.DashBoard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.employeeinfo.R;

public class Splash extends AppCompatActivity {
    ImageView logo;
    int SPLASH_DISPLAY_DURATION = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        logo=(ImageView)findViewById(R.id.image);

        GetScreenSize();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash.this, Login.class);
                startActivity(mainIntent);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
                // Dummy.this.finish();


            }
        }, SPLASH_DISPLAY_DURATION);

    }


    private void GetScreenSize() {

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int ht = displaymetrics.heightPixels;
        int wt = displaymetrics.widthPixels;

        if ((getResources().getConfiguration().screenLayout &     Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            // Toast.makeText(this, "Large screen", Toast.LENGTH_LONG).show();
        }

        else if ((getResources().getConfiguration().screenLayout &  Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
            // Toast.makeText(this, "Normal sized screen", Toast.LENGTH_LONG).show();

        } else if ((getResources().getConfiguration().screenLayout &        Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL) {
            // Toast.makeText(this, "Small sized screen", Toast.LENGTH_LONG).show();
        } else {
            //Toast.makeText(this, "Screen size is neither large, normal or small", Toast.LENGTH_LONG).show();
        }

        // Determine density
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int density = metrics.densityDpi;

        if (density == DisplayMetrics.DENSITY_HIGH) {
            //  Toast.makeText(this, "DENSITY_HIGH... Density is " + String.valueOf(density), Toast.LENGTH_LONG).show();
        } else if (density == DisplayMetrics.DENSITY_MEDIUM) {
            //  Toast.makeText(this, "DENSITY_MEDIUM... Density is " + String.valueOf(density), Toast.LENGTH_LONG).show();
        } else if (density == DisplayMetrics.DENSITY_LOW) {
            //  Toast.makeText(this, "DENSITY_LOW... Density is " + String.valueOf(density), Toast.LENGTH_LONG).show();
        } else {
            // Toast.makeText(this, "Density is neither HIGH, MEDIUM OR LOW.  Density is " + String.valueOf(density), Toast.LENGTH_LONG).show();
        }

        // These are deprecated
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay();
        int  width = display.getWidth();
        int height = display.getHeight();

    }
}
