package com.example.employeeinfo.DashBoard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.employeeinfo.R;


public class TeamListAdapter extends BaseAdapter {


    Context context;
    String[] names;
   // String[] aadhar;


    private LayoutInflater inflater;

    public TeamListAdapter(Context con, String[] names1) {

        context=con;
        this.names = names1;
     //   this.aadhar = aadhar1;


        inflater = (LayoutInflater)con
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return names.length;
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

        View view1=inflater.inflate(R.layout.customteamlist,null);

        TextView T1=view1.findViewById(R.id.nameid);
      //  TextView T2=view1.findViewById(R.id.desigid);

        T1.setText(names[i]);
      //  T2.setText(aadhar[i]);

        return view1;
    }
}
