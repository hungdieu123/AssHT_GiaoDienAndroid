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
import vn.com.assignmentht.adapter.KhoanChiAdapter;
import vn.com.assignmentht.model.KhoanChi;
import vn.com.assignmentht.sqlite.Database;

public class FMKC extends Fragment {

    @Override
    public void onStart() {
        super.onStart();
    }
    public FMKC() {
        // Required empty public constructor
    }
    private View rootview;
    KhoanChiAdapter adapter;
    ArrayList<KhoanChi> list;
    ListView lv_khoanchi;
    Database database;


    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_fmkc, container, false);
        initView();
        return rootview;
    }

    private void initView(){
        database=new Database(getActivity());
        lv_khoanchi=rootview.findViewById(R.id.lv_khoanchi);
        list=new ArrayList<>();
        adapter =new KhoanChiAdapter(getActivity(),R.layout.list_item_khoan_chi,list);
        Cursor datakhoanchi=database.GetData("SELECT * FROM CHI");
        list.clear();
        while (datakhoanchi.moveToNext()){
            String a=datakhoanchi.getString(1);
            int b=datakhoanchi.getInt(3);
            list.add(new KhoanChi(a,b));
        }
        adapter.notifyDataSetChanged();
        lv_khoanchi.setAdapter(adapter);
    }

}
