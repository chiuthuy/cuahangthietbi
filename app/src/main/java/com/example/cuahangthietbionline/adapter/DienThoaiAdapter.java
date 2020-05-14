package com.example.cuahangthietbionline.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuahangthietbionline.R;
import com.example.cuahangthietbionline.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DienThoaiAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayListDienThoai;

    public DienThoaiAdapter(Context context, ArrayList<Sanpham> arrayListDienThoai) {
        this.context = context;
        this.arrayListDienThoai = arrayListDienThoai;
    }


    @Override
    public int getCount() {
        return arrayListDienThoai.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListDienThoai.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    //khi co du lieu se load lai tranh viec load lai nhieu lan
    public class ViewHolder{
        public TextView txtTenDt,txtGiaDt,txtMotaDt;
        public ImageView imgdienthoai;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.dong_dienthoai,null);
            viewHolder.txtTenDt=view.findViewById(R.id.txtDienThoai);
            viewHolder.txtGiaDt=view.findViewById(R.id.txtGiaDt);
            viewHolder.txtMotaDt=view.findViewById(R.id.txtMotaDt);
            viewHolder.imgdienthoai=view.findViewById(R.id.imgDienThoai);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        Sanpham sanpham= (Sanpham) getItem(i);
        viewHolder.txtTenDt.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.txtGiaDt.setText("Giá: "+decimalFormat.format(sanpham.getGiasanpham())+" đ");
        viewHolder.txtMotaDt.setMaxLines(2);
        viewHolder.txtMotaDt.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtMotaDt.setText(sanpham.getMotasanpham());
        Picasso.with(context).load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.noimg)
                .error(R.drawable.error).into(viewHolder.imgdienthoai);
        return view;
    }
}
