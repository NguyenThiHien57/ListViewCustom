package com.example.listviewcustom;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterJava extends BaseAdapter {
    ArrayList<danhsachBH> a ;
    Context context;
    @Override
    public int getCount() {
        return a.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public AdapterJava(ArrayList<danhsachBH> a, Context context) {
        this.a = a;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imgvMusic,imgvLuachon;
        TextView txtTenBH,txtTG,txtTime;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_items,null);
        //View v = LayoutInflater.from(b).inflate(R.layout.custom_items,null);
        imgvMusic = convertView.findViewById(R.id.imgvMusic);
        imgvLuachon = convertView.findViewById(R.id.imgvLuachon);
        txtTenBH = convertView.findViewById(R.id.txtTenBH);
        txtTG = convertView.findViewById(R.id.txtTG);
        txtTime = convertView.findViewById(R.id.txtTime);

        danhsachBH DS = a.get(position);
        imgvMusic.setImageResource(DS.getAnh1());
        imgvLuachon.setImageResource(DS.getAnh2());
        txtTenBH.setText(DS.getTenBH());
        txtTG.setText(DS.getTacGia());
        txtTime.setText(DS.getTime());

        imgvLuachon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.menu);
                final Button btnSua = dialog.findViewById(R.id.btnSua);
                Button btnXoa = dialog.findViewById(R.id.btnXoa);
                btnXoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        a.remove(position);
                        notifyDataSetChanged();
                    }
                });
                btnSua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Dialog dialog1 = new Dialog(context);
                        dialog1.setContentView(R.layout.activity_sua_d_l);
                        final EditText edtBH,edtTG,edtTime;
                        Button btnXN,btnHuy;
                        edtBH = dialog1.findViewById(R.id.edtBH);
                        edtTG=dialog1.findViewById(R.id.edtTG);
                        edtTime=dialog1.findViewById(R.id.edtTime);
                        btnXN=dialog1.findViewById(R.id.btnXN);
                        btnHuy=dialog1.findViewById(R.id.btnHuy);
                        btnHuy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog1.dismiss();
                            }
                        });
                        btnXN.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                a.get(position).setTenBH(edtBH.getText().toString());
                                a.get(position).setTacGia(edtTG.getText().toString());
                                a.get(position).setTime(edtTime.getText().toString());
                                notifyDataSetChanged();
                                dialog1.dismiss();
                            }
                        });
                        dialog1.show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });




        return convertView;
    }
}
