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

import vn.com.assignmentht.adapter.PageAdapter2;

public class flagment3 extends Fragment {

    public flagment3() {
        // Required empty public constructor
    }
    private View rootview;
    TabLayout tl;
    PageAdapter2 adapter;
    ViewPager pager;

    @Nullable
    @Override
    public View onCreateView( @Nullable LayoutInflater inflater,@Nullable ViewGroup container,
                              @Nullable  Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_flagment3, container, false);
        initView();
        return rootview;

    }
private void initView(){
    adapter=new PageAdapter2(getActivity().getSupportFragmentManager());
    tl=rootview.findViewById(R.id.tab_layout2);
    pager=rootview.findViewById(R.id.view_paper2);
    pager.setAdapter(adapter);
    tl.setupWithViewPager(pager);
}
}
