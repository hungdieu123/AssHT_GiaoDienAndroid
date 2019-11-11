package vn.com.assignmentht.fragment;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import vn.com.assignmentht.R;
import vn.com.assignmentht.adapter.LoaiChiAdapter;
import vn.com.assignmentht.model.LoaiChi;
import vn.com.assignmentht.sqlite.Database;

public class FMLC extends Fragment {


    public FMLC() {
        // Required empty public constructor
    }
    private View rootview;

    ListView lv_loaichi;
    ArrayList<LoaiChi> list;
    LoaiChiAdapter adapter;
    Database database;

    @Nullable
    @Override
    public View onCreateView( @Nullable LayoutInflater inflater,@Nullable ViewGroup container,
                              @Nullable  Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_fmlc, container, false);
        initView();
        return rootview;
    }

    private void initView(){
        lv_loaichi=rootview.findViewById(R.id.lv_loaichi);
        list=new ArrayList<>();
        database=new Database(getActivity());
        adapter=new LoaiChiAdapter(getActivity(),R.layout.list_item_loai_chi,list);
        Cursor dataloaichi=database.GetData("SELECT * FROM CHI");
        list.clear();
        while (dataloaichi.moveToNext()){
            String a=dataloaichi.getString(2);
            int b=dataloaichi.getInt(3);
            list.add(new LoaiChi(a,b));
        }
        adapter.notifyDataSetChanged();
        lv_loaichi.setAdapter(adapter);
    }

}
