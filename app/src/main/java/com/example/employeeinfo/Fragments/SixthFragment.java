package com.example.employeeinfo.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.employeeinfo.R;

public class SixthFragment extends Fragment {

    TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment6, container, false);

        textView = view.findViewById(R.id.v1);
      textView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
              View mview = getLayoutInflater().inflate(R.layout.certificatecustomview, null);
              alertDialog.setView(mview);
              final AlertDialog alertDialog1 = alertDialog.create();
            Button  s = (Button) mview.findViewById(R.id.okid);

              s.setOnClickListener(new View.OnClickListener() {
                  public void onClick(View v) {
                      alertDialog1.dismiss();
                  }
              });
              alertDialog1.show();
          }
      });





//
        return view;
    }
}
