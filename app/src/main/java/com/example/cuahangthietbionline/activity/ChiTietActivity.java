package com.example.cuahangthietbionline.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.cuahangthietbionline.R;
import com.example.cuahangthietbionline.model.Giohang;
import com.example.cuahangthietbionline.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class ChiTietActivity extends AppCompatActivity {
    Toolbar toolbarChitiet;
    ImageView imgChitiet;
    TextView txtTen,txtGia,txtMota;
    Spinner spinner;
    Button btnDatmua;

    int id=0;
    String Tenchitiet="";
    int Giachitiet=0;
    String HinhanhChitiet="";
    String MotaChitiet="";
    int Idsanpham=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        AnhXa();
        ActionToolBar();
        GetInformation();
        CatchEventSpinner();
        EventButton();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                Intent intent=new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    private void EventButton(){
        btnDatmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.giohangs.size()>0){
                    int s1=Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exists=false;
                    for(int i=0;i<MainActivity.giohangs.size();i++){
                        if(MainActivity.giohangs.get(i).getIdsp()==id){
                            MainActivity.giohangs.get(i).setSoluongsp(MainActivity.giohangs.get(i).getSoluongsp() +s1);
                            if(MainActivity.giohangs.get(i).getSoluongsp()>=10){
                                MainActivity.giohangs.get(i).setSoluongsp(10);
                            }
                            MainActivity.giohangs.get(i).setGiasp(Giachitiet * MainActivity.giohangs.get(i).getSoluongsp());
                            exists=true;
                        }
                    }
                    if(exists==false){
                        int soluong=Integer.parseInt(spinner.getSelectedItem().toString());
                        long giamoi=soluong*Giachitiet;
                        MainActivity.giohangs.add(new Giohang(id,Tenchitiet,giamoi,HinhanhChitiet,soluong));
                    }
                }else{
                    int soluong=Integer.parseInt(spinner.getSelectedItem().toString());
                    long giamoi=soluong*Giachitiet;
                    MainActivity.giohangs.add(new Giohang(id,Tenchitiet,giamoi,HinhanhChitiet,soluong));

                }
                Intent intent=new Intent(getApplicationContext(),GioHangActivity.class);
                startActivity(intent);
            }
        });
    }
    private void CatchEventSpinner() {
        Integer[] soLuong=new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_dropdown_item,soLuong);
        spinner.setAdapter(arrayAdapter);
    }

    private void GetInformation() {

        Sanpham sanpham= (Sanpham) getIntent().getSerializableExtra("thongtinsanpham");
        id=sanpham.getID();
        Tenchitiet=sanpham.getTensanpham();
        Giachitiet=sanpham.getGiasanpham();
        HinhanhChitiet=sanpham.getHinhanhsanpham();
        MotaChitiet=sanpham.getMotasanpham();
        Idsanpham=sanpham.getIdsanpham();
        txtTen.setText(Tenchitiet);
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        txtGia.setText("Gia: "+decimalFormat.format(Giachitiet)+" Đ");
        txtMota.setText(MotaChitiet);
        Picasso.with(getApplicationContext()).load(HinhanhChitiet)
        .placeholder(R.drawable.noimg)
        .error(R.drawable.error)
        .into(imgChitiet);

    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarChitiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarChitiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void AnhXa() {
        toolbarChitiet=(Toolbar) findViewById(R.id.toolbarChiTiet);
        imgChitiet=(ImageView ) findViewById(R.id.imgChiTiet);
        txtTen=(TextView) findViewById(R.id.txtChitietSp);
        txtGia=(TextView) findViewById(R.id.giaChitiet);
        txtMota=(TextView) findViewById(R.id.txtMotaChitiet);
        spinner=(Spinner) findViewById(R.id.spinner);
        btnDatmua=(Button) findViewById(R.id.btnMua);
    }
}
