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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.employeeinfo.R;

public class TeamList extends AppCompatActivity {
    Button add,stat;
    String[]names={"K.SrivinasaRao","M.Madhav Reddy","D.Ramanujam","M.Parvathi ","S.Sukanya","S.Swapna","M.Prakash","N.Kumar"};
    String[]aadhar={"GT46MAC","GT46PAC","GT38ACe","EMD JT42CWRM","GT38ACe","GT46PAC","JT42CWR","GT46PAC"};
    LinearLayout addlay;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_team_list);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        DisplayActionBar();
        addlay=findViewById(R.id.btnlay);
        if(Login.who_login.equals("admin")) {
            addlay.setVisibility(View.GONE);
        }
        if(Login.who_login.equals("user")) {
            addlay.setVisibility(View.VISIBLE);

        }
        listView=findViewById(R.id.list);
        add=findViewById(R.id.addnew);





        TeamListAdapter adapter=new TeamListAdapter(getApplicationContext(),names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(TeamList.this,TeamDetails1.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent1=new Intent(TeamList.this,TeamDetails1Addnew.class);
//                startActivity(intent1);
            }
        });
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
//                if(Login.who_login.equals("admin")) {
//                    Intent i = new Intent(getApplicationContext(), Employee_Update.class);
//                    startActivity(i);
//                    finish();
//                }
//                if(Login.who_login.equals("user")) {
//                    Intent i1=new Intent(getApplicationContext(), Employee_Update.class);
//                    startActivity(i1);
//                    finish();
//                }

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
                    Intent i1=new Intent(getApplicationContext(), DashBoard.class);
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
        Intent refresh = new Intent(this, TeamList.class);
        startActivity(refresh);
        this.finish(); //

    }
    private void DisplayActionBar() {
        final ActionBar abar = getSupportActionBar();
        abar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#416422")));
// abar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_background));//line under the action bar
        View viewActionBar = getLayoutInflater().inflate(R.layout.toolbar_one, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.custom_action_bar_title);
        textviewTitle.setText("Team Details");
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(true);
//abar.setIcon(R.color.transparent);
        abar.setHomeButtonEnabled(true);
        abar.show();
    }
    @Override
    public void onBackPressed() {
//        if(Login.who_login.equals("admin")) {
//            Intent i = new Intent(getApplicationContext(), Employee_Update.class);
//            startActivity(i);
//            finish();
//        }
//        if(Login.who_login.equals("user")) {
//            Intent i1=new Intent(getApplicationContext(), Employee_Update.class);
//            startActivity(i1);
//            finish();
//        }
    }}

