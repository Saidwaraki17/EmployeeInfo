package com.example.employeeinfo.DashBoard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.employeeinfo.R;


public class SentMails_Adapter extends BaseAdapter {
String[]name;
String[]time;
    String[]date;
    String[]subject;
    String[]size;


    Context context;

    LayoutInflater layoutInflater;

    public SentMails_Adapter(Context con, String[]name1, String[]time1, String[]date1, String[]subject1, String[]size1){



        context=con;
        name=name1;
        time=time1;
        date=date1;
        subject=subject1;
        size=size1;
        layoutInflater=(LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



    }


    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View view1=layoutInflater.inflate(R.layout.custom_sentmails,null);

        TextView T1=view1.findViewById(R.id.nameid);
        TextView T2=view1.findViewById(R.id.timeid);
        TextView T3=view1.findViewById(R.id.dateid);
        TextView T4=view1.findViewById(R.id.subjectid);
        TextView T5=view1.findViewById(R.id.sizeid);




        T1.setText(name[i]);
        T2.setText(time[i]);
        T3.setText(date[i]);
        T4.setText(subject[i]);
        T5.setText(size[i]);


        return view1;
    }
}

//        T1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, DashSum3.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//            }
//        });