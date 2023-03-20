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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeeinfo.R;

public class WorkplanAddnew extends AppCompatActivity {
    TextView tt;
    LinearLayout teamlay,dlay,dlay2,sdlay,s1d1lay;
    Button ok,can,sub,bd1,bd2,sbd1,sbd2;
    Spinner deptspin;

    TextView c1,c2,c3,c4,c5;
    CheckBox cc1,cc2,cc3,cc4,cc5,cc6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_workplan_addnew);
        DisplayActionBar();
        tt=findViewById(R.id.ttid);
        teamlay=findViewById(R.id.deptlay);
        ok=findViewById(R.id.okid1);
        sub=findViewById(R.id.okid);
        can=findViewById(R.id.canid);
        c1=findViewById(R.id.c1);
        s1d1lay=findViewById(R.id.s1d1lay);
        c2=findViewById(R.id.c2);
        bd1=findViewById(R.id.bd1);
        bd2=findViewById(R.id.bd2);
        c3=findViewById(R.id.c3);
        c4=findViewById(R.id.c4);
        c5=findViewById(R.id.c5);
        cc1=findViewById(R.id.cc1);
        cc2=findViewById(R.id.cc2);
        cc3=findViewById(R.id.cc3);
        cc4=findViewById(R.id.cc4);
        cc5=findViewById(R.id.cc5);
        cc6=findViewById(R.id.cc6);
        dlay=findViewById(R.id.d1lay);
        dlay2=findViewById(R.id.d2lay);
        sdlay=findViewById(R.id.sd1lay);
        s1d1lay=findViewById(R.id.s1d1lay);
        deptspin=findViewById(R.id.deptspin);
        sbd1=findViewById(R.id.sbd1);
        //  sbd2=findViewById(R.id.sbd2);
        sbd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sdlay.setVisibility(View.GONE);
            }
        });
//        sbd2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                s1d1lay.setVisibility(View.GONE);
//            }
//        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlay.setVisibility(View.VISIBLE);
                dlay2.setVisibility(View.GONE);

            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlay2.setVisibility(View.VISIBLE);
                dlay.setVisibility(View.GONE);

            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlay.setVisibility(View.VISIBLE);
                dlay2.setVisibility(View.GONE);

            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlay2.setVisibility(View.VISIBLE);
                dlay.setVisibility(View.GONE);
            }
        });




        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlay.setVisibility(View.VISIBLE);
                dlay2.setVisibility(View.GONE);

            }
        });
        bd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlay.setVisibility(View.GONE);
             //   Toast.makeText(getApplicationContext(),"Data Submitted Successfully",Toast.LENGTH_SHORT).show();
                sdlay.setVisibility(View.VISIBLE);

            }
        });

        bd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlay2.setVisibility(View.GONE);
              //  Toast.makeText(getApplicationContext(),"Data Submitted Successfully",Toast.LENGTH_SHORT).show();
                s1d1lay.setVisibility(View.VISIBLE);

            }
        });

//        deptspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if(position>=1){
//                    dlay.setVisibility(View.VISIBLE);
//                    dlay2.setVisibility(View.GONE);
//
//                }
//                if(position==2){
//                    dlay2.setVisibility(View.VISIBLE);
//                    dlay.setVisibility(View.GONE);
//
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamlay.setVisibility(View.GONE);

            }
        });


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cc1.isChecked() || cc2.isChecked() || cc3.isChecked() ||cc4.isChecked() || cc5.isChecked() || cc6.isChecked()){
                  //  Toast.makeText(getApplicationContext(),"Data Submitted Successfully",Toast.LENGTH_SHORT).show();
                    dlay.setVisibility(View.GONE);
                }
                else {


                    Toast.makeText(getApplicationContext(),"Select Employees from Departments",Toast.LENGTH_SHORT).show();}
            }
        });
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamlay.setVisibility(View.VISIBLE);
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

                if(Login.who_login.equals("admin")) {
                    Intent i = new Intent(getApplicationContext(), WorkPlandetails.class);
                    startActivity(i);
                    finish();
                }
                if(Login.who_login.equals("user")) {
                    Intent i1=new Intent(getApplicationContext(), WorkPlandetails.class);
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
        Intent refresh = new Intent(this, WorkplanAddnew.class);
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
        textviewTitle.setText("New Work Plan");
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
        if(Login.who_login.equals("admin")) {
            Intent i = new Intent(getApplicationContext(), WorkPlandetails.class);
            startActivity(i);
            finish();
        }
        if(Login.who_login.equals("user")) {
            Intent i1=new Intent(getApplicationContext(), WorkPlandetails.class);
            startActivity(i1);
            finish();
        }}
}

