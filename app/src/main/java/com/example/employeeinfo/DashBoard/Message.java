package com.example.employeeinfo.DashBoard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.telephony.gsm.SmsManager;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeeinfo.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Message extends AppCompatActivity  {
//    private static final Uri SMS_INBOX = Uri.parse("content://sms/inbox");
//
//    private EditText etPhone;
//    private EditText etMessage;
//    private ListView lvSMS;
//    private SmsSent smsSent;
//
//
//    ImageView imageView;
//    TextView number;
//    public  static final int RequestPermissionCode  = 1 ;
//
//
//    final String DIR_SD = "SMSFiles";
//    final String FILENAME_SD = "SMSfile.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
//        imageView = (ImageView) findViewById(R.id.contactsid);
//
//        //  name = (TextView)findViewById(R.id.textView2);
//        //number = (TextView)findViewById(R.id.textView);
//
//        EnableRuntimePermission();
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
//                startActivityForResult(intent, 7);
//
//            }
//        });
//
//        DisplayActionBar();
//        initUI();
//
//        int MyVersion = Build.VERSION.SDK_INT;
//        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
//            if (!checkIfAlreadyhavePermission()) {
//                requestForSpecificPermission();
//            }
//        }
//
//
//    }
//
//    private void EnableRuntimePermission() {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(Message.this,
//                Manifest.permission.READ_CONTACTS))
//        {
//
//            Toast.makeText(Message.this,"CONTACTS permission allows us to Access CONTACTS app", Toast.LENGTH_LONG).show();
//
//        } else {
//
//            ActivityCompat.requestPermissions(Message.this,new String[]{
//                    Manifest.permission.READ_CONTACTS}, RequestPermissionCode);
//
//        }
//
//
//
//    }
//
//
//    @Override
//    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {
//
//        switch (RC) {
//
//            case RequestPermissionCode:
//
//                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {
//
//                    // Toast.makeText(Message.this,"Permission Granted, Now your application can access CONTACTS.", Toast.LENGTH_LONG).show();
//
//                } else {
//
//                    // Toast.makeText(MessageBox.this,"Permission Canceled, Now your application cannot access CONTACTS.", Toast.LENGTH_LONG).show();
//                }
//                break;
//        }
//    }
//
//    @Override
//    public void onActivityResult(int RequestCode, int ResultCode, Intent ResultIntent) {
//
//        super.onActivityResult(RequestCode, ResultCode, ResultIntent);
//
//        switch (RequestCode) {
//
//            case (7):
//                if (ResultCode == Activity.RESULT_OK) {
//
//                    Uri uri;
//                    Cursor cursor1, cursor2;
//                    String TempNameHolder, TempNumberHolder, TempContactID, IDresult = "" ;
//                    int IDresultHolder ;
//
//                    uri = ResultIntent.getData();
//
//                    cursor1 = getContentResolver().query(uri, null, null, null, null);
//
//                    if (cursor1.moveToFirst()) {
//
//                        //   TempNameHolder = cursor1.getString(cursor1.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//
//                        TempContactID = cursor1.getString(cursor1.getColumnIndex(ContactsContract.Contacts._ID));
//
//                        IDresult = cursor1.getString(cursor1.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
//
//                        IDresultHolder = Integer.valueOf(IDresult) ;
//
//                        if (IDresultHolder == 1) {
//
//                            cursor2 = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + TempContactID, null, null);
//
//                            while (cursor2.moveToNext()) {
//
//                                TempNumberHolder = cursor2.getString(cursor2.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//
//                                // name.setText(TempNameHolder);
//
//                                etPhone.setText(TempNumberHolder);
//
//                            }
//                        }
//
//                    }
//                }
//                break;
//        }
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_dash_board, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                if(Login.who_login.equals("admin")) {
//                    Intent i = new Intent(getApplicationContext(), DashBoard.class);
//                    startActivity(i);
//                    finish();
//                }
//                if(Login.who_login.equals("user")) {
//                    Intent i1=new Intent(getApplicationContext(), DashBoard.class);
//                    startActivity(i1);
//                    finish();
//                }
////                if(LoginActivity.who_login.equals("collector")) {
////                    Intent i1=new Intent(getApplicationContext(), CollectorDashboard.class);
////                    startActivity(i1);
////                    finish();
////                }
//
//                this.finish();
//                // overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
//                return true;
//
//            case R.id.action_refresh:
//                refresh_Activity();
//                return true;
//            case R.id.action_logout:
//                logout();
//                return true;
//            case R.id.homebutton:
//                if(Login.who_login.equals("admin")) {
//                    Intent i = new Intent(getApplicationContext(), DashBoard.class);
//                    startActivity(i);
//                    finish();
//                }
////                if(LoginActivity.who_login.equals("user")) {
////                    Intent i1=new Intent(getApplicationContext(),UserDashBoard.class);
////                    startActivity(i1);
////                    finish();
////                }
////                if(LoginActivity.who_login.equals("collector")) {
////                    Intent i1=new Intent(getApplicationContext(), CollectorDashboard.class);
////                    startActivity(i1);
////                    finish();
////                }
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//    private void logout() {
//        Intent intent = new Intent(getApplicationContext(), Login.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//        finish();
//    }
//
//    private void refresh_Activity()
//
//    {
//        // Refresh main activity upon close of dialog box
//        Intent refresh = new Intent(this, Message.class);
//        startActivity(refresh);
//        this.finish(); //
//
//    }
//
//
//    private void DisplayActionBar() {
//
//        //Customize the ActionBar
//        final ActionBar abar = getSupportActionBar();
//        abar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3771bf")));
//
//        // abar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_background));//line under the action bar
//        View viewActionBar = getLayoutInflater().inflate(R.layout.toolbar_one, null);
//        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
//                ActionBar.LayoutParams.WRAP_CONTENT,
//                ActionBar.LayoutParams.MATCH_PARENT,
//                Gravity.CENTER);
//        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.custom_action_bar_title);
//        textviewTitle.setText("Message");
//        // textviewTitle.setPointerIcon(R.drawable.ic_create_black_24dp);
//        abar.setCustomView(viewActionBar, params);
//        abar.setDisplayShowCustomEnabled(true);
//        abar.setDisplayShowTitleEnabled(false);
//        abar.setDisplayHomeAsUpEnabled(true);
//        //abar.setIcon(R.color.transparent);
//        abar.setHomeButtonEnabled(true);
//        abar.show();
//    }
//
//
//    private void requestForSpecificPermission() {
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS,
//                Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS, Manifest.permission.READ_EXTERNAL_STORAGE,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
//    }
//
//    private boolean checkIfAlreadyhavePermission() {
//        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS);
//        if (result == PackageManager.PERMISSION_GRANTED) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//
//
//    private void initUI() {
//        etPhone = (EditText) findViewById(R.id.etPhone1);
//        etPhone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
//
//        etMessage = (EditText) findViewById(R.id.etMessage);
//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.buttonSendSMS);
//        assert linearLayout != null;
//        linearLayout.setOnClickListener(this);
//        Button buttonLoadSMS = (Button) findViewById(R.id.buttonLoadSMS);
//        assert buttonLoadSMS != null;
//        buttonLoadSMS.setOnClickListener(this);
//        Button buttonSaveSMS = (Button) findViewById(R.id.buttonSaveSMS);
//        assert buttonSaveSMS != null;
//        buttonSaveSMS.setOnClickListener(this);
//        lvSMS = (ListView) findViewById(R.id.lvSMS);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.buttonSendSMS:
//                sendSMS();
//                break;
//            case R.id.buttonLoadSMS:
//                loadSMS();
//                break;
//            case R.id.buttonSaveSMS:
//                loadSMS();
//                writeFileSD();
//                break;
//        }
//    }
//
//
//    void writeFileSD() {
//        if (!Environment.getExternalStorageState().equals(
//                Environment.MEDIA_MOUNTED)) {
//            Toast.makeText(this, "SD not available: " + Environment.getExternalStorageState(),
//                    Toast.LENGTH_SHORT).show();
//            return;
//        }
//        File sdPath = Environment.getExternalStorageDirectory();
//        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
//        sdPath.mkdirs();
//        File sdFile = new File(sdPath, FILENAME_SD);
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
//
//            Uri uri = Uri.parse("content://sms/");
//            Cursor c = getContentResolver().query(uri, null, null, null, null);
//            assert c != null;
//            int count = 0;
//            StringBuilder stringBuilder = new StringBuilder();
//            while (c.moveToNext()){
//                stringBuilder.append("SMS: ").append(count).append(", Number: ")
//                        .append(c.getString(c.getColumnIndex("address")))
//                        .append("\n").append(c.getString(c.getColumnIndex("body"))).append("\n\n");
//                count++;
//            }
//            bw.write(stringBuilder.toString());
//
//            bw.close();
////            Toast.makeText(this, "File is recorded on the SD: " + sdFile.getAbsolutePath(),
////                    Toast.LENGTH_SHORT).show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void loadSMS() {
//        Cursor c = this.getContentResolver().query(SMS_INBOX,
//                null, null, null, null);
//        String[] from = new String[] {"address", "body"};
//        int[] to = new int[] {R.id.tvAddress, R.id.tvBody};
//        SimpleCursorAdapter lvAdapter = new SimpleCursorAdapter(this, R.layout.messagelist_items, c, from,
//                to, 0);
//        lvSMS.setAdapter(lvAdapter);
//    }
//
//    private void sendSMS() {
//        String phone = etPhone.getText().toString();
//        String message = etMessage.getText().toString();
//
//        if (phone.isEmpty() || message.isEmpty()) {
//            Toast.makeText(this, "Please fill details...", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        android.telephony.gsm.SmsManager smsManager = android.telephony.gsm.SmsManager.getDefault();
//        PendingIntent p = PendingIntent.getBroadcast(this, 0, new Intent(SmsSent.ACTION),
//                PendingIntent.FLAG_ONE_SHOT);
//        smsManager.sendTextMessage(phone, null, message, p, null);
//        etPhone.setText("");
//        etMessage.setText("");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        smsSent = new SmsSent();
//        registerReceiver(smsSent, new IntentFilter(SmsSent.ACTION));
//    }
//
//    @Override
//    protected void onPause() {
//        if (smsSent != null) {
//            unregisterReceiver(smsSent);
//        }
//        super.onPause();
//    }
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
//
//
//    private class SmsSent extends BroadcastReceiver {
//
//        public final static String ACTION = "com.example.SMS_SENT";
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//            switch (getResultCode()) {
//
//                case Activity.RESULT_OK:
//                    Toast.makeText(context, "SMS sent successfully",
//                            Toast.LENGTH_SHORT).show();
//                    break;
//                case android.telephony.gsm.SmsManager.RESULT_ERROR_GENERIC_FAILURE:
//                    Toast.makeText(context, "SMS sent successfully",
//                            Toast.LENGTH_SHORT).show();
//                    break;
//                case android.telephony.gsm.SmsManager.RESULT_ERROR_NO_SERVICE:
//                    Toast.makeText(context, "Service is currently unavailable",
//                            Toast.LENGTH_SHORT).show();
//                    break;
//                case android.telephony.gsm.SmsManager.RESULT_ERROR_NULL_PDU:
//                    Toast.makeText(context, "No pdu provided",
//                            Toast.LENGTH_SHORT).show();
//                    break;
//                case SmsManager.RESULT_ERROR_RADIO_OFF:
//                    Toast.makeText(context, "Radio was explicitly turned off",
//                            Toast.LENGTH_SHORT).show();
//                    break;
//            }
//        }
//    }
//
//
//
//    @Override
//    public void onBackPressed() {
////
//        if(Login.who_login.equals("admin")) {
//            Intent i = new Intent(getApplicationContext(), DashBoard.class);
//            startActivity(i);
//            finish();
//        }
//        if(Login.who_login.equals("user")) {
//            Intent i1=new Intent(getApplicationContext(), UserDashBoard.class);
//            startActivity(i1);
//            finish();
//        }
////
    }


}
