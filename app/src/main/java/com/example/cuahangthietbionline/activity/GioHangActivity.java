package com.example.cuahangthietbionline.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cuahangthietbionline.R;
import com.example.cuahangthietbionline.adapter.GioHangAdapter;
import com.example.cuahangthietbionline.ultil.CheckConnection;

import java.text.DecimalFormat;

public class GioHangActivity extends AppCompatActivity {

    ListView lvgioHang;
    TextView txtThongbao;
    static TextView txtTongtien;
    Button btnThanhtoan,btntieptucmua;
    androidx.appcompat.widget.Toolbar toolbarGiohang;
    GioHangAdapter gioHangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        AnhXa();
        ActionToolBar();
        CheckData();
        EvenUltil();
        CatchOnItemListView();
        EventButton();
    }

    private void EventButton() {
        btntieptucmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.giohangs.size()>0){
                    Intent intent=new Intent(getApplicationContext(),ThongTinKH.class);
                    startActivity(intent);
                }else{
                    CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn chưa có sản phẩm nào trong giỏ hàng để thanh toán");
                }
            }
        });
    }

    private void CatchOnItemListView() {
        lvgioHang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int pos, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(GioHangActivity.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(MainActivity.giohangs.size() <=0){
                            txtThongbao.setVisibility(View.VISIBLE);
                        }else{
                            MainActivity.giohangs.remove(pos);
                            gioHangAdapter.notifyDataSetChanged();
                            EvenUltil();
                            if(MainActivity.giohangs.size()<=0){
                                txtThongbao.setVisibility(View.VISIBLE);

                            }else{
                                txtThongbao.setVisibility(View.INVISIBLE);
                                gioHangAdapter.notifyDataSetChanged();
                                EvenUltil();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        gioHangAdapter.notifyDataSetChanged();
                        EvenUltil();
                    }
                });
                builder.show();
                return true;
            }
        });
    }

    public static void EvenUltil() {
        long tongtien=0;
        for(int i=0;i<MainActivity.giohangs.size();i++){
            tongtien+=MainActivity.giohangs.get(i).getGiasp();

        }
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        txtTongtien.setText(decimalFormat.format(tongtien)+" Đ");
    }

    private void CheckData() {
        if(MainActivity.giohangs.size()<=0){
            gioHangAdapter.notifyDataSetChanged();
            txtThongbao.setVisibility(View.VISIBLE);
            lvgioHang.setVisibility(View.INVISIBLE);

        }
        else {
            gioHangAdapter.notifyDataSetChanged();
            txtThongbao.setVisibility(View.INVISIBLE);
            lvgioHang.setVisibility(View.VISIBLE);
        }
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarGiohang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarGiohang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void AnhXa(){
        lvgioHang=(ListView) findViewById(R.id.lsvGiohang);
        txtThongbao=(TextView) findViewById(R.id.txtThongBao);
        txtTongtien=(TextView) findViewById(R.id.txtTongtien);
        btnThanhtoan=(Button) findViewById(R.id.btnThanhtoanGH);
        btntieptucmua=(Button) findViewById(R.id.btnTieptucMua);
        toolbarGiohang= (Toolbar) findViewById(R.id.toolbarGiohang);
        gioHangAdapter=new GioHangAdapter(this, MainActivity.giohangs);
        lvgioHang.setAdapter(gioHangAdapter);
    }
}
