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
import vn.com.assignmentht.model.LoaiThu;
import vn.com.assignmentht.sqlite.Database;

public class LoaiThuAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<LoaiThu> loaiThuList;

    public LoaiThuAdapter(Context context, int layout, List<LoaiThu> loaiThuList) {
        this.context = context;
        this.layout = layout;
        this.loaiThuList = loaiThuList;
    }

    @Override
    public int getCount() {
        return loaiThuList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private  class ViewHoder{
        TextView txtloaithu;
        ImageView loaithusua;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoder holder;
        if(view==null){
            holder=new ViewHoder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(layout,null);
            holder.txtloaithu=(TextView)view.findViewById(R.id.txtloaithu);
            holder.loaithusua=(ImageView)view.findViewById(R.id.loaithusua);
            view.setTag(holder);

        }else {
            holder=(ViewHoder) view.getTag();
        }
        final  LoaiThu lt=loaiThuList.get(i);
        holder.txtloaithu.setText(lt.getLoaithu());

        holder.loaithusua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua=(EditText) dialog.findViewById(R.id.edt_sua);
                edtsua.setText(lt.getLoaithu());
                Button btnsua=(Button)dialog.findViewById(R.id.btn_sua);
                btnsua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String a=edtsua.getText().toString();
                        int b=lt.getIdthu();
                        if(a.isEmpty()){
                            Toast.makeText(context,"Vui lòng không để trống loai thu",Toast.LENGTH_SHORT).show();

                        }else{
                            Database database=new Database(context);
                            database.SendData("UPDATE THU SET LOAITHU = '"+a+"' WHERE IDTHU = "+b+" ");
                            Toast.makeText(context,"Cập nhập loai thu thành công" ,Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            ((MainActivity)context).recreate();
                        }
                    }
                });
                dialog.show();
            }
        });

        return view;
    }
}
