package com.example.employeeinfo.DashBoard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeeinfo.R;

import java.util.Calendar;

public class Product extends AppCompatActivity {
    Spinner sp;
    LinearLayout l1,l2;
    AutoCompleteTextView e;
    Button b;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    TextView date;
    Button b1,ok;
    ImageView calid;
    LinearLayout one,two;
    TextView d1;
    String[] arr = { "M.Ramesh--emp1001", "S.Surya Prakash--emp1002","M.Madhav Rao--emp1003",
            "M.Ramesh--emp1004", "L.Lokesh--emp1005","emp1001","emp1002"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_product);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        DisplayActionBar();
        sp=findViewById(R.id.spinnerzone);
        l1=findViewById(R.id.ll);
        l2=findViewById(R.id.wl);
        e=findViewById(R.id.e1);
        d1=findViewById(R.id.d1);
        b=findViewById(R.id.b1);
        date=findViewById(R.id.date);
        calid=findViewById(R.id.calid);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        ok=findViewById(R.id.okid);

        ok.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),DashBoard.class));
    }
});
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setVisibility(View.VISIBLE);
                two.setVisibility(View.GONE);
            }
        });
        b1=findViewById(R.id.goid);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sdate=date.getText().toString();
                if(sdate.isEmpty()){
                    Toast.makeText(Product.this, "Select Date", Toast.LENGTH_SHORT).show();
                }
                else {
                    one.setVisibility(View.GONE);
                    two.setVisibility(View.VISIBLE);
                }
            }
        });
        calid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                calendar.add(Calendar.DAY_OF_MONTH, 1);
                calendar.add(Calendar.YEAR, 1);
                datePickerDialog = new DatePickerDialog(Product.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, arr);

        e.setThreshold(1);
        e.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>=1){
                    l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SS=e.getText().toString();
                if(SS.isEmpty()){
                    Toast.makeText(Product.this, "Enter Employee Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.VISIBLE);
                }
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
        Intent refresh = new Intent(this, Product.class);
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
        textviewTitle.setText("Employee Productivity  Details");
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
            Intent i1 = new Intent(getApplicationContext(), DashBoard.class);
            startActivity(i1);
            finish();
        }}

}