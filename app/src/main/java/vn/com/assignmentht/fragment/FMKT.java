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
import vn.com.assignmentht.adapter.KhoanThuAdapter;
import vn.com.assignmentht.model.KhoanThu;
import vn.com.assignmentht.sqlite.Database;


public class FMKT extends Fragment {

    @Override
    public void onStart() {
        super.onStart();
    }
    public FMKT() {
        // Required empty public constructor
    }
    private View rootview;
    KhoanThuAdapter adapter;
    ArrayList<KhoanThu> list;
    ListView lv_khoanthu;
    Database database;



    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_fmkt, container, false);
        initView();
        return rootview;
    }

    private void initView(){
        database=new Database(getActivity());
        lv_khoanthu=rootview.findViewById(R.id.lv_khoanthu);
        list=new ArrayList<>();
        adapter =new KhoanThuAdapter(getActivity(),list);
getdata();
        lv_khoanthu.setAdapter(adapter);

    }
    public void getdata(){
        Cursor datakhoanthu=database.GetData("SELECT * FROM THU");
        list.clear();
        while (datakhoanthu.moveToNext()){
            String a=datakhoanthu.getString(1);
            int b=datakhoanthu.getInt(3);
            list.add(new KhoanThu(a,b));
        }
        adapter.notifyDataSetChanged();

    }

}
