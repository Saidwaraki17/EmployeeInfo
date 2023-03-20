package com.example.employeeinfo.DashBoard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.employeeinfo.R;
import com.google.android.material.navigation.NavigationView;

public class DashBoard extends AppCompatActivity {
LinearLayout ep,wk,at,pr;
Button em;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.content_main_dash_board);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        DisplayActionBar();
        ep=findViewById(R.id.empd);
        wk=findViewById(R.id.wpd);
        em=findViewById(R.id.emd);
        at=findViewById(R.id.atd1);
        pr=findViewById(R.id.prd);
ep.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),Dummy.class));
        finish();
    }
});
        wk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashBoard.this, WorkPlandetails.class);
                startActivity(intent);
            }
        });
        em.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashBoard.this, EmailActivity.class);
                startActivity(intent);
            }
        });
        at.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashBoard.this, Attendance.class);
                startActivity(intent);
            }
        });
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashBoard.this, Product.class);
                startActivity(intent);
            }
        });

//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_dash_board, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();

                return true;

            case R.id.action_refresh:
                refresh_Activity();
                return true;
            case R.id.action_logout:
                logout();
                return true;
            case R.id.homebutton:
                if (Login.who_login.equals("admin")) {
                    Intent i5 = new Intent(getApplicationContext(), DashBoard.class);
                    startActivity(i5);
                    finish(); }
                if (Login.who_login.equals("user")) {
                    Intent i1 = new Intent(getApplicationContext(), DashBoard.class);
                    startActivity(i1);
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.name) {
//
//
//        } else if (id == R.id.nav_message) {
////            Intent intent = new Intent(getApplicationContext(), Message.class);
////            startActivity(intent);
//
//
//        }
//
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//
//        return true;
//    }

    @Override
    public void onBackPressed() {
      //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
          finish();



    }
    private void logout() {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void refresh_Activity()
    {
        Intent refresh = new Intent(this, DashBoard.class);
        startActivity(refresh);
        this.finish(); //

    }
    private void DisplayActionBar() {
        final ActionBar abar = getSupportActionBar();
        abar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#416422")));

        View viewActionBar = getLayoutInflater().inflate(R.layout.toolbar_one, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(

                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.custom_action_bar_title);
        textviewTitle.setText("m-Performance");
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(true);

        abar.setHomeButtonEnabled(true);
        abar.show();
    }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
}

