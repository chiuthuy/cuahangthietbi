package com.example.cuahangthietbionline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuahangthietbionline.R;
import com.example.cuahangthietbionline.model.Loaisp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaispAdapter extends BaseAdapter {

    ArrayList<Loaisp> arrayList;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        TextView txtTenloaisp;
        ImageView imgLoaisp;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.dong_list_view,null);
            viewHolder.txtTenloaisp=view.findViewById(R.id.textviewLoaisp);
            viewHolder.imgLoaisp=view.findViewById(R.id.imageviewLoaisp);
            view.setTag(viewHolder);

        }else{
            viewHolder= (ViewHolder) view.getTag();


        }
        Loaisp loaisp= (Loaisp) getItem(i);
        viewHolder.txtTenloaisp.setText(loaisp.getTenloaisp());
        Picasso.with(context).load(loaisp.getHinhanhloaisp()).placeholder(R.drawable.noimg)
                .error(R.drawable.error)
                .into(viewHolder.imgLoaisp);
        return view;
    }
}
