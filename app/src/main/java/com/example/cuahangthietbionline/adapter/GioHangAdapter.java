package com.example.cuahangthietbionline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuahangthietbionline.activity.MainActivity;
import com.example.cuahangthietbionline.R;
import com.example.cuahangthietbionline.activity.GioHangActivity;
import com.example.cuahangthietbionline.model.Giohang;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GioHangAdapter extends BaseAdapter {

    Context context;
    ArrayList<Giohang> giohangArrayList;


    public GioHangAdapter(Context context, ArrayList<Giohang> giohangArrayList) {
        this.context = context;
        this.giohangArrayList = giohangArrayList;
    }

    @Override
    public int getCount() {

        return giohangArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return giohangArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder{
        public TextView txttengiohang,txtgiagiohang;
        public ImageView imgGiohang;
        public Button btnminus,btnvalues,btnplus;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.dong_giohang,null);
            viewHolder.txttengiohang=(TextView) view.findViewById(R.id.txttengiohang);
            viewHolder.txtgiagiohang=(TextView) view.findViewById(R.id.txtGiagiohang);
            viewHolder.imgGiohang=(ImageView) view.findViewById(R.id.imgGiohang);
            viewHolder.btnminus=(Button) view.findViewById(R.id.btnMinus);
            viewHolder.btnvalues=(Button) view.findViewById(R.id.btnValues);
            viewHolder.btnplus=(Button) view.findViewById(R.id.btnPlus);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        Giohang giohang= (Giohang) getItem(i);
        viewHolder.txttengiohang.setText(giohang.getTensp());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.txtgiagiohang.setText(decimalFormat.format(giohang.getGiasp())+" Đ");
        Picasso.with(context).load(giohang.getHinhsp())
        .placeholder(R.drawable.noimg).error(R.drawable.error).into(viewHolder.imgGiohang);
        viewHolder.btnvalues.setText(giohang.getSoluongsp()+"");
        int sl= Integer.parseInt(viewHolder.btnvalues.getText().toString());
        if(sl>=10){
            viewHolder.btnplus.setVisibility(View.INVISIBLE);
            viewHolder.btnminus.setVisibility(View.VISIBLE);
        }else if(sl<=1){
            viewHolder.btnplus.setVisibility(View.VISIBLE);
            viewHolder.btnminus.setVisibility(View.INVISIBLE);
        }

        final ViewHolder finalViewHolder = viewHolder;
        final ViewHolder finalViewHolder1 = viewHolder;
        final ViewHolder finalViewHolder2 = viewHolder;
        viewHolder.btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slmoinhat=Integer.parseInt(finalViewHolder.btnvalues.getText().toString())+1;
                int slht= MainActivity.giohangs.get(i).getSoluongsp();
                long giaht=MainActivity.giohangs.get(i).getGiasp();
                MainActivity.giohangs.get(i).setSoluongsp(slmoinhat);
                long giamoinhat=(giaht*slmoinhat)/slht;
                MainActivity.giohangs.get(i).setGiasp(giamoinhat);
                DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
                finalViewHolder1.txtgiagiohang.setText(decimalFormat.format(giamoinhat)+" Đ");
                GioHangActivity.EvenUltil();
                if(slmoinhat>9){
                    finalViewHolder2.btnplus.setVisibility(View.INVISIBLE);
                    finalViewHolder2.btnminus.setVisibility(View.VISIBLE);
                    finalViewHolder2.btnvalues.setText(String.valueOf(slmoinhat));
                }else{
                    finalViewHolder2.btnplus.setVisibility(View.VISIBLE);
                    finalViewHolder2.btnminus.setVisibility(View.VISIBLE);
                    finalViewHolder2.btnvalues.setText(String.valueOf(slmoinhat));
                }
            }
        });
        viewHolder.btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slmoinhat=Integer.parseInt(finalViewHolder.btnvalues.getText().toString())-1;
                int slht= MainActivity.giohangs.get(i).getSoluongsp();
                long giaht=MainActivity.giohangs.get(i).getGiasp();
                MainActivity.giohangs.get(i).setSoluongsp(slmoinhat);
                long giamoinhat=(giaht*slmoinhat)/slht;
                MainActivity.giohangs.get(i).setGiasp(giamoinhat);
                DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
                finalViewHolder1.txtgiagiohang.setText(decimalFormat.format(giamoinhat)+" Đ");
                GioHangActivity.EvenUltil();
                if(slmoinhat<2){
                    finalViewHolder2.btnplus.setVisibility(View.VISIBLE);
                    finalViewHolder2.btnminus.setVisibility(View.INVISIBLE);
                    finalViewHolder2.btnvalues.setText(String.valueOf(slmoinhat));
                }else{
                    finalViewHolder2.btnplus.setVisibility(View.VISIBLE);
                    finalViewHolder2.btnminus.setVisibility(View.VISIBLE);
                    finalViewHolder2.btnvalues.setText(String.valueOf(slmoinhat));
                }
            }
        });
        return view;
    }
}
