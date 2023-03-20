package com.example.employeeinfo.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.employeeinfo.R;

public class ThirdFragment extends Fragment {

    TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
//        textView = view.findViewById(R.id.text);
//        textView.setText("Third");
        return view;
    }
}
