package com.example.employeeinfo.DashBoard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.employeeinfo.R;
import com.google.android.material.tabs.TabLayout;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_email);
        DisplayActionBar();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Compose"));
        tabLayout.addTab(tabLayout.newTab().setText("Sent Mails"));
        // tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
        tabLayout.setSelectedTabIndicatorHeight(2);
        //  tabLayout.setTextSize(TypedValue.COMPLEX_UNIT_DIP,35);
        TextView textview = new TextView(EmailActivity.this);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final Email_Sender_PageAdapter adapter = new Email_Sender_PageAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            finish();
            overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);

        }
        return true;
    }

    private void DisplayActionBar() {

        //Customize the ActionBar
        final ActionBar abar = getSupportActionBar();
        abar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#416422")));
        // abar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_background));//line under the action bar
        View viewActionBar = getLayoutInflater().inflate(R.layout.toolbar_one, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.custom_action_bar_title);
        textviewTitle.setText("E-Mail");
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(true);
        //abar.setIcon(R.color.transparent);
        abar.setHomeButtonEnabled(true);
        abar.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_dash_board, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
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
        // Refresh main activity upon close of dialog box
        Intent refresh = new Intent(this, EmailActivity.class);
        startActivity(refresh);
        this.finish(); //

    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        finish();
    }

}


