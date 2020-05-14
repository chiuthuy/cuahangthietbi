package com.example.cuahangthietbionline.activity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cuahangthietbionline.R;
import com.example.cuahangthietbionline.ultil.CheckConnection;
import com.example.cuahangthietbionline.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ThongTinKH extends AppCompatActivity {
    EditText edtTenKH, edtSodt, edtEmail, edtDiachi;
    Button btnXacnhan, btnTrove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_kh);
        AnhXa();
        btnTrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
            EventButton();

        } else {
            CheckConnection.ShowToast_Short(getApplicationContext(), "Haỹ kiểm tra lại kết nối của bạn !");
        }
    }

    private void EventButton() {
        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String ten = edtTenKH.getText().toString().trim();
                final String sdt = edtSodt.getText().toString().trim();
                final String email = edtEmail.getText().toString().trim();
                final String diachi = edtDiachi.getText().toString().trim();
                if (ten.length() > 0 && sdt.length() > 0 && email.length() > 0 && diachi.length() > 0) {
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.customerInformation, new Response.Listener<String>() {
                        @Override
                        public void onResponse(final String mdh) {
                            final String madonhang = mdh.substring(1);

                            Log.d("madonhang", String.valueOf(madonhang.charAt(0)));
                            final int a = Integer.parseInt(String.valueOf(madonhang.trim()));
                            if (a > 0) {
                                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                                StringRequest request = new StringRequest(Request.Method.POST, Server.orderDetail, new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        if (response.equals("1")) {
                                            MainActivity.giohangs.clear();
                                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn đã thêm dữ liệu giỏ hàng thành công");
                                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                            startActivity(intent);
                                            CheckConnection.ShowToast_Short(getApplicationContext(), "Mời quý khách tiếp tục mua hàng");

                                        } else {
                                            CheckConnection.ShowToast_Short(getApplicationContext(), "Dữ liệu giỏ hàng đã bị lỗi !! Vui lòng kiểm tra lại");

                                        }
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                    }
                                }) {
                                    @Override
                                    protected Map<String, String> getParams() throws AuthFailureError {
                                        JSONArray jsonArray = new JSONArray();
                                        for (int i = 0; i < MainActivity.giohangs.size(); i++) {
                                            JSONObject jsonObject = new JSONObject();
                                            try {
                                                jsonObject.put("madonhang", madonhang);
                                                jsonObject.put("masanpham", MainActivity.giohangs.get(i).getIdsp());
                                                jsonObject.put("tensanpham", MainActivity.giohangs.get(i).getTensp());
                                                jsonObject.put("giasanpham", MainActivity.giohangs.get(i).getGiasp());
                                                jsonObject.put("soluongsanpham", MainActivity.giohangs.get(i).getSoluongsp());
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                            jsonArray.put(jsonObject);

                                        }
                                        HashMap<String, String> hashMap = new HashMap<String, String>();
                                        hashMap.put("json", jsonArray.toString());

                                        return hashMap;
                                    }
                                };
                                queue.add(request);
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String, String> hashMap = new HashMap<String, String>();
                            hashMap.put("tenkhachhang", ten);
                            hashMap.put("sodienthoai", sdt);
                            hashMap.put("email", email);
                            hashMap.put("diachi", diachi);
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);
                } else {
                    CheckConnection.ShowToast_Short(getApplicationContext(), "Haỹ kiểm tra lại dữ liệu");
                }
            }
        });
    }

    private void AnhXa() {
        edtTenKH = (EditText) findViewById(R.id.edtTenKhachhang);
        edtSodt = (EditText) findViewById(R.id.edtSodt);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtDiachi = (EditText) findViewById(R.id.edtDiachi);
        btnXacnhan = (Button) findViewById(R.id.btnXacnhan);
        btnTrove = (Button) findViewById(R.id.btnTrove);
    }
}
