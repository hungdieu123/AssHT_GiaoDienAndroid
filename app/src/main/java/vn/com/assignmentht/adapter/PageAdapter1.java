package vn.com.assignmentht.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import vn.com.assignmentht.fragment.FMKT;
import vn.com.assignmentht.fragment.FMLT;

public class PageAdapter1 extends FragmentStatePagerAdapter {
    public PageAdapter1(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        if(i==0){
            return new FMKT();
        }else if(i==1){
            return new FMLT();
        }else {
            return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Khoản thu";
            case 1:
                return "Loại thu";
        }
        return null;
    }
}
