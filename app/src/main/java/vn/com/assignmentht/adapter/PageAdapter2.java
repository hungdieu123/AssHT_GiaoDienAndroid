package vn.com.assignmentht.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import vn.com.assignmentht.fragment.FMKC;
import vn.com.assignmentht.fragment.FMLC;

public class PageAdapter2 extends FragmentStatePagerAdapter {
    public PageAdapter2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i==0){
            return new FMKC();
        }else if(i==1){
            return new FMLC();
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
                return "Khoản chi";
            case 1:
                return "Loại chi";
        }

        return null;
    }
}
