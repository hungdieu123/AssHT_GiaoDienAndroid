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
import vn.com.assignmentht.adapter.LoaiThuAdapter;
import vn.com.assignmentht.model.LoaiThu;
import vn.com.assignmentht.sqlite.Database;

public class FMLT extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    public FMLT() {
        // Required empty public constructor
    }
private View rootview;
    Database database;
    ArrayList<LoaiThu> list;
    LoaiThuAdapter adapter;
    ListView lv_loaithu;


    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_fmlt, container, false);
        initView();
        return rootview;
    }

private void initView(){
        lv_loaithu=rootview.findViewById(R.id.lv_loaithu);
        list=new ArrayList<>();
        database=new Database(getActivity());
        adapter=new LoaiThuAdapter(getActivity(),R.layout.list_item_loai_thu,list);
    Cursor dataloaithu=database.GetData("SELECT * FROM THU");
    list.clear();
    while (dataloaithu.moveToNext()){
        String a=dataloaithu.getString(2);
        int b=dataloaithu.getInt(3);
        list.add(new LoaiThu(a,b));
    }
    adapter.notifyDataSetChanged();
    lv_loaithu.setAdapter(adapter);

}
}
