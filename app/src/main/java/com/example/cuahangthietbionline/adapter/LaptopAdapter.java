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

public class LaptopAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayListLaptop;

    public LaptopAdapter(Context context, ArrayList<Sanpham> arrayListDienThoai) {
        this.context = context;
        this.arrayListLaptop = arrayListDienThoai;
    }


    @Override
    public int getCount() {
        return arrayListLaptop.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListLaptop.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    //khi co du lieu se load lai tranh viec load lai nhieu lan
    public class ViewHolder{
        public TextView txtTenLt,txtGiaLt,txtMotaLt;
        public ImageView imglaptop;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.dong_laptop,null);
            viewHolder.txtTenLt=view.findViewById(R.id.txtLaptop);
            viewHolder.txtGiaLt=view.findViewById(R.id.txtGiaLaptop);
            viewHolder.txtMotaLt=view.findViewById(R.id.txtMotaLt);
            viewHolder.imglaptop=view.findViewById(R.id.imgLaptop);
            view.setTag(viewHolder);
        }else{
            viewHolder= (LaptopAdapter.ViewHolder) view.getTag();
        }
        Sanpham sanpham= (Sanpham) getItem(i);
        viewHolder.txtTenLt.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.txtGiaLt.setText("Giá: "+decimalFormat.format(sanpham.getGiasanpham())+" đ");
        viewHolder.txtMotaLt.setMaxLines(2);
        viewHolder.txtMotaLt.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtMotaLt.setText(sanpham.getMotasanpham());
        Picasso.with(context).load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.noimg)
                .error(R.drawable.error).into(viewHolder.imglaptop);
        return view;
    }

}
