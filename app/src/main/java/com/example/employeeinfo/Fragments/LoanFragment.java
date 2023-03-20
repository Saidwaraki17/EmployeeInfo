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

public class LoanFragment extends Fragment {

    TextView textView;
    Spinner loan;
    LinearLayout loanid;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loanfragment, container, false);
        loan = view.findViewById(R.id.loan);
        loanid = view.findViewById(R.id.loanid);
        loan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>=1){
                    loanid.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//        textView = view.findViewById(R.id.text);
//        textView.setText("Third");
        return view;
    }
}
