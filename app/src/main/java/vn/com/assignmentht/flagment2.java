package vn.com.assignmentht;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import vn.com.assignmentht.adapter.PageAdapter1;

public class flagment2 extends Fragment {

    public flagment2() {
        // Required empty public constructor
    }
private View rootview;
    TabLayout tl;
    PageAdapter1 pageradapter;
    ViewPager pager;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable  Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_flagment2, container, false);
   initView();
        return rootview;

    }

  private void initView (){
        pageradapter=new PageAdapter1(getActivity().getSupportFragmentManager());
        tl=rootview.findViewById(R.id.tab_layout1);
        pager=rootview.findViewById(R.id.view_paper1);
        pager.setAdapter(pageradapter);
        tl.setupWithViewPager(pager);
    }
}
