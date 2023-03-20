package com.example.employeeinfo.DashBoard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeeinfo.R;

import java.util.ArrayList;

public class Attendance extends AppCompatActivity {
    RecyclerView atted_Recyclerview;
    Attend_Adapter atted_Adapter;
    ArrayList<Attend_details> Attendance_data = new ArrayList<>();
    Button okat,subid;
    EditText eid;
    LinearLayout lay;
    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_attendance);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        eid=findViewById(R.id.eid);
        subid=findViewById(R.id.subid);
        lay=findViewById(R.id.lay1);
        spin=findViewById(R.id.spinnerzone);
spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position>=1){
            lay.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});

//        subid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String ee=eid.getText().toString();
//                if(ee.isEmpty()){
//                    Toast.makeText(Attendance.this, "Enter Employee ID", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    lay.setVisibility(View.VISIBLE);
//                }
//            }
//        });
        okat=(Button)findViewById(R.id.atnid);
        okat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),DashBoard.class);
                startActivity(i);
                finish();
            }
        });

        atted_Recyclerview = (RecyclerView) findViewById(R.id.Atted_recycle);


        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        atted_Adapter = new Attend_Adapter(getApplicationContext(), Attendance_data);
//        atted_Adapter.setClickListener(new View.OnClickListener()
//
//        {
//            @Override
//            public void onClick (View v){
//                int pos = atted_Recyclerview.indexOfChild(v);
//
//            }
//        });

        atted_Recyclerview.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        atted_Recyclerview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        atted_Recyclerview.setItemAnimator(new DefaultItemAnimator());

        atted_Recyclerview.setAdapter(atted_Adapter);

        //row click listener
        atted_Recyclerview.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), atted_Recyclerview, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
////
                // showAddItemDialog(Attendance_activity.this);

            }

            @Override
            public void onLongClick(View view, int position) {
                Attend_details Atted = Attendance_data.get(2);
//
                Log.e("state=====", Atted.toString());
            }

        }));

        Attendance_Data();

    }




    private void Attendance_Data() {

        Attend_details atted_detai = new Attend_details("Radha", "EMP1001", "27", "23", "2","2");
        Attendance_data.add(atted_detai);
        atted_detai = new Attend_details("Shanthi", "EMP1002", "26", "22", "2","2");
        Attendance_data.add(atted_detai);
        atted_detai = new Attend_details("Raaju", "EMP1003", "25", "21", "2","2");
        Attendance_data.add(atted_detai);
        DisplayActionBar();

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
        Intent refresh = new Intent(this, Attendance.class);
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
        textviewTitle.setText("Attendance Details");
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
            Intent i = new Intent(getApplicationContext(), DashBoard.class);
            startActivity(i);
            finish();
        }
        if(Login.who_login.equals("user")) {
            Intent i1=new Intent(getApplicationContext(), DashBoard.class);
            startActivity(i1);
            finish();
        }
    }
}

