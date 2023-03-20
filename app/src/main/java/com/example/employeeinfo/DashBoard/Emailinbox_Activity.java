package com.example.employeeinfo.DashBoard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.employeeinfo.R;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emailinbox_Activity extends Fragment {

    private static final int RESULT_OK = 0;
    private static final int REQUEST_CODE=43;
    EditText to_address_edt, subject_edt, composeEmail_edt, email_passowrd;
    Button sendMail;
    LinearLayout linearLayout;
    int SPLASH_DISPLAY_DURATION = 3000;
    String Str_mailAdress = null;
    ProgressDialog PD;
    String FromEmailAddress;
    TextView edt_from;
    TextView file;
    String toAddress;
    String subject;
    String ccdata;
    Intent data;
    String composemail;
    String password;
    String formattedDate;
    List<String> possibleEmails;
    Spinner emails_spinner;
    ArrayAdapter<String> emails_list_adapter = null;

    Uri URI = null;
    //  private static final int PICK_FROM_GALLERY = 101;
    private static final int PICKFILE_RESULT_CODE = 1;
    int columnIndex;


    ImageView iv1,iv2,iv3,iv4;
    // SharedPreferences sharedPreferences;
    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.activity_compose, container, false);
        String tomail = "";
        String to_email = getActivity().getIntent().getStringExtra("tomail");
        // getUsername();
        tomail = to_email;
        edt_from = (TextView) rootView.findViewById(R.id.spinner_emails);

        file=(TextView) rootView.findViewById(R.id.filename);

        iv1=rootView.findViewById(R.id.i1);
        iv2=rootView.findViewById(R.id.i2);
        iv3=rootView.findViewById(R.id.i3);
        iv4=rootView.findViewById(R.id.i4);

        to_address_edt = (EditText) rootView.findViewById(R.id.editText_to);
        to_address_edt.setText(tomail);

        email_passowrd=(EditText) rootView.findViewById(R.id.editText_password);
        subject_edt = (EditText) rootView.findViewById(R.id.editText_subject);
        composeEmail_edt = (EditText) rootView.findViewById(R.id.editText_composemail);
        sendMail = (Button) rootView.findViewById(R.id.send_btn);

        linearLayout = (LinearLayout)rootView.findViewById(R.id.attah);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                to_address_edt.setText("");
            }});
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email_passowrd.setText("");
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject_edt.setText("");
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                file.setText("");
            }
        });
//        sendMail.setOnClickListener(this);
        sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toAddress=to_address_edt.getText().toString();
                ccdata=email_passowrd.getText().toString();
                subject=subject_edt.getText().toString();
                composemail=composeEmail_edt.getText().toString();
                FromEmailAddress=edt_from.getText().toString();

//                    if(!isValidEmail(FromEmailAddress)){
//                       // Toast.makeText(getContext(),"Enter Valid Email",Toast.LENGTH_LONG).show();
////                    editTextEmailId.setError("Enter valid email");
//                    }



                if(!isValidEmail(toAddress)){
                    Toast.makeText(getContext(),"Enter Valid Email ", Toast.LENGTH_LONG).show();
//                    editTextEmailId.setError("Enter valid email");
                }
                else  if(!check_email_cc_validation()||email_passowrd.equals(" ")){
                    Toast.makeText(getContext(),"Enter Valid Email in CC ", Toast.LENGTH_LONG).show();
//                    editTextEmailId.setError("Enter valid email");
                }
                else if(subject.equals("")){
                    Toast.makeText(getContext(),"Please Enter Subject", Toast.LENGTH_LONG).show();

                }

                else{
                    Toast.makeText(getContext(),"Mail Sent Successfully", Toast.LENGTH_LONG).show();
                        to_address_edt.setText("");
                        subject_edt.setText("");
                        email_passowrd.setText("");
                        composeEmail_edt.setText("");
                     edt_from.setText("");
                }


            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,PICKFILE_RESULT_CODE);


            }

        });

        return rootView;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode,  @Nullable Intent data) {
        //  switch(requestCode){

        //    case PICKFILE_RESULT_CODE:
        switch(requestCode){
            case PICKFILE_RESULT_CODE:
                if(resultCode==RESULT_OK){
                    String FilePath = data.getData().getPath();
                    file.setText(FilePath);
                }
                break;

        }
    }


    private boolean isValidEmail(String Email) {
        String Email_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(Email_PATTERN);
        Matcher matcher = pattern.matcher(Email);
        return matcher.matches();
    }
    private Boolean check_email_cc_validation() {

        Boolean status = true;

        if (email_passowrd.getText().length() != 0) {

            String str_to_split = email_passowrd.getText() + "";


            String split_array[] = str_to_split.split("\\;");


            for (String c : split_array) {

                c = c.trim();
                if (!c.isEmpty()) {
                    if ((!isValidEmail(c))) {

                        email_passowrd.requestFocus();
                        email_passowrd.setError("Please enter valid email.");
                        status = false;
                    }
                }
            }


        }
        return status;
    }
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));


        } catch (android.content.ActivityNotFoundException ex) {

        }
    }



}

