package com.example.employeeinfo.DashBoard;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Email_Sender_PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public Email_Sender_PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Emailinbox_Activity tab1=new Emailinbox_Activity();

                return tab1;
            case 1:
                Emailsentbox_Activity tab3 = new Emailsentbox_Activity();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}