package com.example.employeeinfo.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.employeeinfo.R;

public class FourthFragment extends Fragment {

    TextView textView;
    Spinner leavespin;
    LinearLayout leaveid;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);
       leavespin = view.findViewById(R.id.leavespin);
       leaveid = view.findViewById(R.id.leaveid);
       leavespin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if(position>=1){
                   leaveid.setVisibility(View.VISIBLE);
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
//        textView.setText("Third");
        return view;
    }
}
