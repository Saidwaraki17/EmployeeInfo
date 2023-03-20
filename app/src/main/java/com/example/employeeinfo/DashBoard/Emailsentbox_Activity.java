package com.example.employeeinfo.DashBoard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.employeeinfo.R;


public class Emailsentbox_Activity extends Fragment {
    ListView listView;
    String[] names = {"prakash@gmail.com","ramyareddy@gmail.com","sureshumar@gmail.com","maheshsharma@gmail.com"};
    String[] time = {"16:01","02:45","10:10","19:45"};
    String[] date = {"17-08-2019","29-08-2019","02-09-2019","12-10-2019"};
    String[] subject = {"Status Report Submission","Work Order Documents","Flow Schematic Diagrams","Work Order Documents"};
    String[] size = {"30 KB","45 KB","30 KB","60 KB"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.sent_emails_fragment,
                container, false);
        listView=rootView.findViewById(R.id.list);

        SentMails_Adapter Adapter=new SentMails_Adapter(getContext(),names,time,date,subject,size);
        listView.setAdapter(Adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=new Intent(getActivity(), SentMailDetailsSceen.class);
                startActivity(intent);

            }
        });


        return rootView;
    }
}

