package com.example.employeeinfo.DashBoard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.employeeinfo.R;

public class EmployeeDetails extends AppCompatActivity {
LinearLayout ol,tl,thl,fl;
TextView personal,two,three,four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_employee_details);
        DisplayActionBar();
        personal=findViewById(R.id.one);
        ol=findViewById(R.id.onelay);
        two=findViewById(R.id.two);
        tl=findViewById(R.id.twolay);
        thl=findViewById(R.id.threelay);
        fl=findViewById(R.id.fourlay);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ol.setVisibility(View.VISIBLE);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tl.setVisibility(View.VISIBLE);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thl.setVisibility(View.VISIBLE);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl.setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_dash_board, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(Login.who_login.equals("admin")) {
                    Intent i = new Intent(getApplicationContext(), DashBoard.class);
                    startActivity(i);
                    finish();
                }
                if(Login.who_login.equals("user")) {
                    Intent i1=new Intent(getApplicationContext(), DashBoard.class);
                    startActivity(i1);
                    finish();
                }
                this.finish();
                // overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
                return true;

            case R.id.action_refresh:
                refresh_Activity();
                return true;
            case R.id.action_logout:
                logout();
                return true;
            case R.id.homebutton:
                if(Login.who_login.equals("admin")) {
                    Intent i = new Intent(getApplicationContext(), DashBoard.class);
                    startActivity(i);
                    finish();
                }
                if(Login.who_login.equals("user")) {
                    Intent i1=new Intent(getApplicationContext(),DashBoard.class);
                    startActivity(i1);
                    finish();
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void logout() {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void refresh_Activity()

    {
//        Intent refresh = new Intent(this, ThirdPartyList.class);
//        startActivity(refresh);
//        this.finish(); //

    }

    @Override
    public void onBackPressed() {
        if(Login.who_login.equals("admin")) {
            Intent i = new Intent(getApplicationContext(), DashBoard.class);
            startActivity(i);
            finish();
        }
        if(Login.who_login.equals("user")) {
            Intent i1=new Intent(getApplicationContext(), DashBoard.class);
            startActivity(i1);
            finish();
        }
        this.finish();
    }
    private void DisplayActionBar() {

        final ActionBar abar = getSupportActionBar();
        abar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#416422")));
        View viewActionBar = getLayoutInflater().inflate(R.layout.toolbar_one, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.custom_action_bar_title);
        textviewTitle.setText("Employee Details");
        textviewTitle.setTextSize(20f);
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(true);
        abar.setHomeButtonEnabled(true);
        abar.show();
    }}