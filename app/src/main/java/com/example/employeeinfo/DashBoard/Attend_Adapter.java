package com.example.employeeinfo.DashBoard;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;

import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeeinfo.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class Attend_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    private Activity mActivity;

    private RelativeLayout mRelativeLayout;
    private Button mButton;

    private PopupWindow mPopupWindow;

    List<Attend_details> data= Collections.emptyList();
    Attend_Adapter.MyHolder myHolder;
Button popup;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attendance, parent, false);

        final Attend_Adapter.MyHolder holder=new Attend_Adapter.MyHolder(itemView);
        return holder;
    }
    public Attend_Adapter(Context context, ArrayList<Attend_details> data1){
        this.context=context;
        this.data=data1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        myHolder= (Attend_Adapter.MyHolder) holder;
        final Attend_details current = data.get(position);
        myHolder.emp_name.setText(current.getempname());

        myHolder.emp_id.setText(current.getempid());
        myHolder.emp_working_days.setText(current.getworkingdays());
        myHolder.emp_present.setText(current.getpresent());
        myHolder.emp_obs.setText(current.getobs());
        myHolder.emp_leave.setText(current.getleave());

myHolder.emp_id.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, Product1.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

});

        myHolder.emp_obs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_layout, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = false; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height,focusable);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(false);

                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
              //  popupView.getWindow().setLayout(600, 400);
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();

                        return true;
                    }
                });
            }

        });

        myHolder.emp_leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_layout, null);

                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });
           }

        });

    }



    private void showAddItemDialog(Context c) {
        final EditText taskEditText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Add a new task")
                .setMessage("What do you want to do next?")
                .setView(taskEditText)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(taskEditText.getText());
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }
    //popupok=(Button)findViewById(R.id.popupok);
//popupok.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        Intent i=new Intent(getApplicationContext(),Attendance_activity.class);
//    }
//});
    @Override
    public int getItemCount() {
        return data.size();
    }
    private class MyHolder extends RecyclerView.ViewHolder {

        TextView emp_name,emp_id, emp_working_days, emp_present, emp_obs, emp_leave;
        ImageView Dist_details;

        //ImageView mapgifimage,mailgif,callgif;

        public MyHolder(View itemView) {
            super(itemView);
            emp_name = (TextView) itemView.findViewById(R.id.emp_name);

            emp_id = (TextView) itemView.findViewById(R.id.empid);
            emp_working_days = (TextView) itemView.findViewById(R.id.emp_work);
            emp_present = (TextView) itemView.findViewById(R.id.emp_pres);
            emp_obs = (TextView) itemView.findViewById(R.id.emp_obs);
            emp_leave = (TextView) itemView.findViewById(R.id.emp_leave);

            emp_obs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // do your stuffs

                }
            });
        }
    }
//    private void calender() {
//        calendar = Calendar.getInstance();
//        year = calendar.get(Calendar.YEAR);
//        month = calendar.get(Calendar.MONTH);
//        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
//
//        datePickerDialog = new DatePickerDialog(context,
//                new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                        date.setText(day + "/" + (month + 1) + "/" + year);
//                    }
//                }, year, month, dayOfMonth);
//        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
//        datePickerDialog.show();
//
//    }

}







//
//    AlertDialog.Builder builder = new AlertDialog.Builder(context);
//    // inflate the layout of the popup window
//    LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
//    // View popupView = inflater.inflate(R.layout.popup_layout, null);
//    View convertView = (View) inflater.inflate(R.layout.popupleave_layout, null);
//                builder.setView(convertView);
//                        builder.setTitle("List");
//                        builder.setMessage("12/03/2019 \n " +
//                        "19/03/2019");
//                        builder.show();
//// You need to use a Theme.AppCompat theme (or descendant) with this activity.