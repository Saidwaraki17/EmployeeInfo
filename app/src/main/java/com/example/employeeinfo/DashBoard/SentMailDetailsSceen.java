package com.example.employeeinfo.DashBoard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.TextView;

import com.example.employeeinfo.R;

public class SentMailDetailsSceen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sent_mail_details_sceen2);
        DisplayActionBar();
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
        textviewTitle.setText("Sent Mail Details");
        textviewTitle.setTextSize(22f);
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
                if (Login.who_login.equals("admin")) {
                    // overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);

                    Intent i = new Intent(getApplicationContext(), EmailActivity.class);
                    startActivity(i);
                    finish();
                }
//                if (Login.who_login.equals("regional")) {
//                    //  overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
//
//                    Intent i1 = new Intent(getApplicationContext(), Email.class);
//                    startActivity(i1);
//                    finish();
//                }
                if (Login.who_login.equals("user")) {
                    //    overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);

                    Intent i1 = new Intent(getApplicationContext(), EmailActivity.class);
                    startActivity(i1);
                    finish();
                }
                this.finish();
                overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
                return true;

            case R.id.action_refresh:
                refresh_Activity();
                return true;
            case R.id.action_logout:
                logout();
                return true;
            case R.id.homebutton:
                if (Login.who_login.equals("admin")) {
                    Intent i = new Intent(getApplicationContext(), DashBoard.class);
                    startActivity(i);
                    finish();
                }
//                if (Login.who_login.equals("regional")) {
//                    Intent i1 = new Intent(getApplicationContext(), UserDashboard.class);
//                    startActivity(i1);
//                    finish();
//                }
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

    private void logout() {
        Intent intent = new Intent(SentMailDetailsSceen.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void refresh_Activity() {
        // Refresh main activity upon close of dialog box
        Intent refresh = new Intent(this, SentMailDetailsSceen.class);
        startActivity(refresh);
        this.finish(); //

    }

    @Override
    public void onBackPressed() {


        if (Login.who_login.equals("admin")) {
            // overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);

            Intent i = new Intent(getApplicationContext(), EmailActivity.class);
            startActivity(i);
            finish();
        }
//        if (Login.who_login.equals("regional")) {
//            //overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
//
//            Intent i1 = new Intent(getApplicationContext(), Email.class);
//            startActivity(i1);
//            finish();
//        }
        if (Login.who_login.equals("user")) {
            //overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);

            Intent i1 = new Intent(getApplicationContext(), EmailActivity.class);
            startActivity(i1);
            finish();
        }

        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);

    }
}

