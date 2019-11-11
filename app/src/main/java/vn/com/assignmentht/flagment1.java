package vn.com.assignmentht;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import vn.com.assignmentht.adapter.ThongKeChiAdapter;
import vn.com.assignmentht.adapter.ThongKeThuAdapter;
import vn.com.assignmentht.model.ThongKeChi;
import vn.com.assignmentht.model.ThongKeThu;
import vn.com.assignmentht.sqlite.Database;

public class flagment1 extends Fragment {

    public flagment1() {
        // Required empty public constructor
    }
    private View rootview;
    ArrayList<ThongKeThu> list;
    ArrayList<ThongKeChi> list1;
    ThongKeThuAdapter adapter;
    ThongKeChiAdapter adapter1;
    ListView lv_thongkethu;
    ListView lv_thongkechi;
    Database database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_flagment1, container, false);
   initView();
   return rootview;

    }

    private void initView(){
        list =new ArrayList<>();

        lv_thongkethu=rootview.findViewById(R.id.lv_thongkethu);
        database=new Database(getActivity());
        adapter=new ThongKeThuAdapter(getActivity(),R.layout.list_item_thong_ke_thu,list);
        Cursor datathongkethu=database.GetData("SELECT * FROM THU");
        list.clear();
        while (datathongkethu.moveToNext()){
            String a=datathongkethu.getString(0);
            String b=datathongkethu.getString(1);
            String c=datathongkethu.getString(2);
            list.add(new ThongKeThu(a,b,c));
        }
        adapter.notifyDataSetChanged();
        lv_thongkethu.setAdapter(adapter);



        list1 =new ArrayList<>();

        lv_thongkechi=rootview.findViewById(R.id.lv_thongkechi);
        adapter1=new ThongKeChiAdapter(getActivity(),R.layout.list_item_thong_ke_chi,list1);
        Cursor datathongkechi=database.GetData("SELECT * FROM CHI");
        list1.clear();
        while (datathongkechi.moveToNext()){
            String a=datathongkechi.getString(0);
            String b=datathongkechi.getString(1);
            String c=datathongkechi.getString(2);
            list1.add(new ThongKeChi(a,b,c));
        }
        adapter1.notifyDataSetChanged();
        lv_thongkechi.setAdapter(adapter1);
    }

}
