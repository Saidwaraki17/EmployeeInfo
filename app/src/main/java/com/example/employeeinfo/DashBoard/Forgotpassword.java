package com.example.employeeinfo.DashBoard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeeinfo.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Forgotpassword extends AppCompatActivity {
    EditText sendtomail;
    Button send;
    int SPLASH_DISPLAY_DURATION=3000;
    String Str_mailAdress;
    ProgressDialog PD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgotpassword);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        sendtomail = (EditText) findViewById(R.id.editText);
        send = (Button) findViewById(R.id.sendpassword);
        DisplayActionBar();


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailstr=sendtomail.getText().toString();

                if(!isValidEmail(emailstr)){
                    Toast.makeText(getApplicationContext(),"Enter Email Id",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent=new Intent(Forgotpassword.this,Login.class);

                    Toast.makeText(getApplicationContext(),"Password Sent Successfully",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });
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
        textviewTitle.setText("Forgot Password");
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(false);
        //abar.setIcon(R.color.transparent);
        abar.setHomeButtonEnabled(true);
        abar.show();

    }

    private boolean isValidEmail(String Email) {
        String Email_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(Email_PATTERN);
        Matcher matcher = pattern.matcher(Email);
        return matcher.matches();
    }
}


