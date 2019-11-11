package vn.com.assignmentht.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.com.assignmentht.MainActivity;
import vn.com.assignmentht.R;
import vn.com.assignmentht.model.KhoanThu;
import vn.com.assignmentht.sqlite.Database;

public class KhoanThuAdapter extends BaseAdapter {
    Context context;
    List<KhoanThu> khoanThuList;

    public KhoanThuAdapter(Context context, List<KhoanThu> khoanThuList) {
        this.context = context;
        this.khoanThuList = khoanThuList;
    }

    @Override
    public int getCount() {
        return khoanThuList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHoder{
        TextView txtkhoanthu;
        ImageView khoanthusua,khoanthuxoa;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoder holder;
        if(view==null){
            holder=new ViewHoder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(R.layout.list_item_khoan_thu,null);
            holder.txtkhoanthu=(TextView)view.findViewById(R.id.txtkhoanthu);
            holder.khoanthusua=(ImageView)view.findViewById(R.id.khoanthusua);
            holder.khoanthuxoa=(ImageView)view.findViewById(R.id.khoanthuxoa);
            view.setTag(holder);

        }else {
            holder=(ViewHoder) view.getTag();
        }
        final KhoanThu kt=khoanThuList.get(i);
        holder.txtkhoanthu.setText(kt.getKhoanthu());
        holder.khoanthusua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua=(EditText)dialog.findViewById(R.id.edt_sua);
                Button btnsua=(Button)dialog.findViewById(R.id.btn_sua);
                edtsua.setText(kt.getKhoanthu());
                btnsua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int b=kt.getId();
                        String a=edtsua.getText().toString();
                        if(a.isEmpty()){
                            Toast.makeText(context,"Vui lòng không để trống khoản thu",Toast.LENGTH_SHORT).show();

                        }else{
                            Database database=new Database(context);
                            database.SendData("UPDATE THU SET KHOANTHU = '"+a+"' WHERE IDTHU = "+b+" ");
                            Toast.makeText(context,"Cập nhập khoản thu thành công" ,Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            ((MainActivity)context).recreate();
                        }
                    }
                });dialog.show();
            }
        });
        holder.khoanthuxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final  Dialog dialog1=new Dialog(context);
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(R.layout.dialog_xoa);

                Button btnhuy=(Button)dialog1.findViewById(R.id.btn_huyboxoa);
                Button btnchapnhan=(Button) dialog1.findViewById(R.id.btn_chapnhanxoa);
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog1.dismiss();
                    }
                });
                btnchapnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int a=kt.getId();
                        Database database=new Database(context);
                        database.SendData("DELETE FROM THU WHERE IDTHU = "+a+" ");
                        Toast.makeText(context,"Xoa thong tin thanh cong",Toast.LENGTH_SHORT).show();
                        dialog1.dismiss();
                        ((MainActivity)context).recreate();
                    }
                });
                dialog1.show();
            }
        });
        return view;
    }
}
