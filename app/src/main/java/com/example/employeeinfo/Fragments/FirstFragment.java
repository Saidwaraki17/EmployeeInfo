package com.example.employeeinfo.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.employeeinfo.DashBoard.Location;
import com.example.employeeinfo.R;

public class FirstFragment extends Fragment {

    TextView textView,loc;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        textView = view.findViewById(R.id.c1);
        loc = view.findViewById(R.id.locid);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent11 = new Intent(android.content.Intent.ACTION_CALL, Uri.parse("tel: +7674820043"));
                startActivity(intent11);
            }
        });

//        loc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               startActivity(new Intent(getActivity(), Location.class));
//            }
//        });

        return view;
    }
}
