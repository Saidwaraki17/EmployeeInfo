package com.example.employeeinfo.DashBoard;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.employeeinfo.R;

import java.util.HashMap;

public class Login extends AppCompatActivity implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener, View.OnClickListener {
    Button login;
    SliderLayout sliderLayout;
    HashMap<String, Integer> HashMapForLocalRes;

    private String username, password;
    private Button ok;
    private EditText editTextUsername, editTextPassword;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    int SPLASH_DISPLAY_DURATION = 300;
    TextView forgotpassword, newuser;
    public static String who_login = "";
    int ASK_MULTIPLE_PERMISSION_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{
                            Manifest.permission.READ_CONTACTS,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.CAMERA,
                            Manifest.permission.SEND_SMS,
                            Manifest.permission.READ_SMS,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.CALL_PHONE},
                    ASK_MULTIPLE_PERMISSION_REQUEST_CODE);
        }
        login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(this);

        editTextUsername = (EditText) findViewById(R.id.editusername);
        editTextPassword = (EditText) findViewById(R.id.editpassword);
        // editTextPassword.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        forgotpassword = (TextView) findViewById(R.id.textView_forgotpwd);
        saveLoginCheckBox = (CheckBox) findViewById(R.id.checkBox);
        // saveLoginCheckBox.setTypeface(ResourcesCompat.getFont(context, R.fonts.four.ttf));

//        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "fonts/four.ttf");
//        saveLoginCheckBox = (CheckBox) findViewById(R.id.checkBox);
//        saveLoginCheckBox.setTypeface(myTypeFace);
//        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/four.ttf");
//        saveLoginCheckBox.setTypeface(tf ,1);
        newuser = (TextView) findViewById(R.id.txt_newuser);
        newuser.setPaintFlags(newuser.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        HashMapForLocalRes = new HashMap<String, Integer>();
        sliderLayout = (SliderLayout) findViewById(R.id.slider);
        HashMapForLocalRes = new HashMap<String, Integer>();

      //  HashMapForLocalRes.put("logo", R.drawable.s5);
        HashMapForLocalRes.put("image", R.drawable.sp2);
        HashMapForLocalRes.put("Block main", R.drawable.sp3);
       // HashMapForLocalRes.put("image1", R.drawable.sp4);

        for (String name : HashMapForLocalRes.keySet()) {
            TextSliderView textSliderView = new TextSliderView(Login.this);
            textSliderView.image(HashMapForLocalRes.get(name)).setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);
        HashMapForLocalRes = new HashMap<String, Integer>();
        sliderLayout = (SliderLayout) findViewById(R.id.slider);
        HashMapForLocalRes = new HashMap<String, Integer>();

    //    HashMapForLocalRes.put("logo", R.drawable.s5);
        HashMapForLocalRes.put("image", R.drawable.sp2);
        HashMapForLocalRes.put("Block main", R.drawable.sp3);
       // HashMapForLocalRes.put("image1", R.drawable.sp4);

        for (String name : HashMapForLocalRes.keySet()) {
            TextSliderView textSliderView = new TextSliderView(Login.this);
            textSliderView.image(HashMapForLocalRes.get(name)).setScaleType(BaseSliderView.ScaleType.Fit).setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        sliderLayout.
                setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.
                setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(Login.this);

        forgotpassword.setPaintFlags(forgotpassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        forgotpassword.setOnClickListener(this);
        newuser.setOnClickListener(this);

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            editTextUsername.setText(loginPreferences.getString("username", ""));
            editTextPassword.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }
        editTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // do something, e.g. set your TextView here via .setText()
                    InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });

        editTextUsername.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // do something, e.g. set your TextView here via .setText()
                    InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {


        //overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
//        Intent a = new Intent(Intent.ACTION_MAIN);
//        a.addCategory(Intent.CATEGORY_HOME);
//        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(a);
        //  moveTaskToBack(true);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        System.exit(1);
        finish();
    }

    public void onClick(View view) {
        if (view == login) {

            username = editTextUsername.getText().toString();
            password = editTextPassword.getText().toString();

            if ((username.equalsIgnoreCase("User")) && (password.equalsIgnoreCase("12345"))) {

                if (saveLoginCheckBox.isChecked()) {
                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString("username", username);
                    loginPrefsEditor.putString("password", password);
                    loginPrefsEditor.commit();

                } else {
                    loginPrefsEditor.clear();
                    loginPrefsEditor.commit();
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        who_login = "user";

                        Intent mainIntent = new Intent(Login.this, DashBoard.class);
                        startActivity(mainIntent);
                    }
                }, SPLASH_DISPLAY_DURATION);
            } else if ((username.equalsIgnoreCase("admin")) && (password.equalsIgnoreCase("12345"))) {

                if (saveLoginCheckBox.isChecked()) {
                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString("username", username);
                    loginPrefsEditor.putString("password", password);
                    loginPrefsEditor.commit();
                } else {
                    loginPrefsEditor.clear();
                    loginPrefsEditor.commit();
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        who_login = "admin";

                        Intent mainIntent = new Intent(Login.this, DashBoard.class);
                        startActivity(mainIntent);
                    }
                }, SPLASH_DISPLAY_DURATION);
            } else if (username.equals("") && (password.equals(""))) {
                //Toast.makeText(getApplicationContext(), "Enter User Id and  Password", Toast.LENGTH_SHORT).show();
            } else {
                //Toast.makeText(LoginActivity.this, "User Id or Password is wrong", Toast.LENGTH_LONG).show();
            }
        }
        if (view == forgotpassword) {
            Intent intent=new Intent(Login.this,Forgotpassword.class);
            startActivity(intent);
        }

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}