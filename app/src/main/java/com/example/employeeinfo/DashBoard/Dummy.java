package com.example.employeeinfo.DashBoard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeeinfo.Fragments.FifthFragment;
import com.example.employeeinfo.Fragments.FirstFragment;
import com.example.employeeinfo.Fragments.FourthFragment;
import com.example.employeeinfo.Fragments.LoanFragment;
import com.example.employeeinfo.Fragments.SecondFragment;
import com.example.employeeinfo.Fragments.SixthFragment;
import com.example.employeeinfo.Fragments.ThirdFragment;
import com.example.employeeinfo.R;

public class Dummy extends AppCompatActivity implements View.OnClickListener{
Button one,two,three,four,five,six,seven,subid;
Fragment first,second,third,fourth,fifth,sixth,loan;
EditText eid;
LinearLayout lay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dummy);
        DisplayActionBar();
eid=findViewById(R.id.eid);
subid=findViewById(R.id.subid);
lay=findViewById(R.id.lay1);


subid.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String ee=eid.getText().toString();
        if(ee.isEmpty()){
            Toast.makeText(Dummy.this, "Enter Employee ID", Toast.LENGTH_SHORT).show();
        }
        else {
            lay.setVisibility(View.VISIBLE);
            one.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.green));
            two.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.grey));
            three.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.grey));
            four.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.grey));
            five.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.grey));
            six.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.grey));
            seven.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.grey));

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.layout, first);
            fragmentTransaction.commit();
        }
    }
});
        first = new FirstFragment();
        second = new SecondFragment();
        third = new ThirdFragment();
        fourth = new SixthFragment();
        fifth = new FourthFragment();
        loan = new FifthFragment();
        sixth = new LoanFragment();

        one=findViewById(R.id.fragment1);
        two=findViewById(R.id.fragment2);
        three=findViewById(R.id.fragment3);
        four=findViewById(R.id.fragment4);
        five=findViewById(R.id.fragment5);
        six=findViewById(R.id.laonfragment);
        seven=findViewById(R.id.fragment7);


        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);







    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment1:
                one.setBackgroundColor(this.getResources().getColor(R.color.green));
                two.setBackgroundColor(this.getResources().getColor(R.color.grey));
                three.setBackgroundColor(this.getResources().getColor(R.color.grey));
                four.setBackgroundColor(this.getResources().getColor(R.color.grey));
                five.setBackgroundColor(this.getResources().getColor(R.color.grey));
                six.setBackgroundColor(this.getResources().getColor(R.color.grey));
                seven.setBackgroundColor(this.getResources().getColor(R.color.grey));

                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fm1.beginTransaction();
                fragmentTransaction1.replace(R.id.layout, first);
                fragmentTransaction1.commit();

                break;

                case R.id.fragment2:
                    one.setBackgroundColor(this.getResources().getColor(R.color.grey));
                    two.setBackgroundColor(this.getResources().getColor(R.color.green));
                    three.setBackgroundColor(this.getResources().getColor(R.color.grey));
                    four.setBackgroundColor(this.getResources().getColor(R.color.grey));
                    five.setBackgroundColor(this.getResources().getColor(R.color.grey));
                    six.setBackgroundColor(this.getResources().getColor(R.color.grey));
                    seven.setBackgroundColor(this.getResources().getColor(R.color.grey));

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.layout, second);
                    fragmentTransaction.commit();

                break;

            case R.id.fragment3:

                one.setBackgroundColor(this.getResources().getColor(R.color.grey));
                two.setBackgroundColor(this.getResources().getColor(R.color.grey));
                three.setBackgroundColor(this.getResources().getColor(R.color.green));
                four.setBackgroundColor(this.getResources().getColor(R.color.grey));
                five.setBackgroundColor(this.getResources().getColor(R.color.grey));
                six.setBackgroundColor(this.getResources().getColor(R.color.grey));
                seven.setBackgroundColor(this.getResources().getColor(R.color.grey));

                FragmentManager fm2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fm2.beginTransaction();
                fragmentTransaction2.replace(R.id.layout, third);
                fragmentTransaction2.commit();
                break;


            case R.id.fragment4:

                one.setBackgroundColor(this.getResources().getColor(R.color.grey));
                two.setBackgroundColor(this.getResources().getColor(R.color.grey));
                three.setBackgroundColor(this.getResources().getColor(R.color.grey));
                four.setBackgroundColor(this.getResources().getColor(R.color.green));
                five.setBackgroundColor(this.getResources().getColor(R.color.grey));
                six.setBackgroundColor(this.getResources().getColor(R.color.grey));
                seven.setBackgroundColor(this.getResources().getColor(R.color.grey));

                FragmentManager fm3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = fm3.beginTransaction();
                fragmentTransaction3.replace(R.id.layout, fourth);
                fragmentTransaction3.commit();
                break;
            case R.id.fragment5:

                one.setBackgroundColor(this.getResources().getColor(R.color.grey));
                two.setBackgroundColor(this.getResources().getColor(R.color.grey));
                three.setBackgroundColor(this.getResources().getColor(R.color.grey));
                four.setBackgroundColor(this.getResources().getColor(R.color.grey));
                five.setBackgroundColor(this.getResources().getColor(R.color.green));
                six.setBackgroundColor(this.getResources().getColor(R.color.grey));
                seven.setBackgroundColor(this.getResources().getColor(R.color.grey));

                FragmentManager fm4 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction4 = fm4.beginTransaction();
                fragmentTransaction4.replace(R.id.layout, fifth);
                fragmentTransaction4.commit();
                break;
            case R.id.laonfragment:

                one.setBackgroundColor(this.getResources().getColor(R.color.grey));
                two.setBackgroundColor(this.getResources().getColor(R.color.grey));
                three.setBackgroundColor(this.getResources().getColor(R.color.grey));
                four.setBackgroundColor(this.getResources().getColor(R.color.grey));
                five.setBackgroundColor(this.getResources().getColor(R.color.grey));
                six.setBackgroundColor(this.getResources().getColor(R.color.green));
                seven.setBackgroundColor(this.getResources().getColor(R.color.grey));

                FragmentManager fm5 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction5 = fm5.beginTransaction();
                fragmentTransaction5.replace(R.id.layout, loan);
                fragmentTransaction5.commit();
                break;
            case R.id.fragment7:

                one.setBackgroundColor(this.getResources().getColor(R.color.grey));
                two.setBackgroundColor(this.getResources().getColor(R.color.grey));
                three.setBackgroundColor(this.getResources().getColor(R.color.grey));
                four.setBackgroundColor(this.getResources().getColor(R.color.grey));
                five.setBackgroundColor(this.getResources().getColor(R.color.grey));
                six.setBackgroundColor(this.getResources().getColor(R.color.grey));
                seven.setBackgroundColor(this.getResources().getColor(R.color.green));

                FragmentManager fm6 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction6= fm6.beginTransaction();
                fragmentTransaction6.replace(R.id.layout, sixth);
                fragmentTransaction6.commit();
                break;


        }
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
        Intent refresh = new Intent(this, Dummy.class);
        startActivity(refresh);
        this.finish(); //

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