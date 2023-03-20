package com.example.employeeinfo.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.employeeinfo.R;

public class FifthFragment extends Fragment {

    TextView textView;
    RadioButton yes,no;
    RadioGroup rgp;
    LinearLayout workid;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment5, container, false);
        workid = view.findViewById(R.id.workid);
        rgp = view.findViewById(R.id.rgp);
        yes = view.findViewById(R.id.yes);
        no = view.findViewById(R.id.no);

        rgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(yes.isChecked()){
                    workid.setVisibility(View.VISIBLE);
                }
                if(no.isChecked()){
                    workid.setVisibility(View.GONE);

                }
            }
        });
//        textView.setText("Third");
        return view;
    }
}
