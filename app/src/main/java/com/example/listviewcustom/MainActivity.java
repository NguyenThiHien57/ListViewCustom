package com.example.listviewcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtTenbaihat,edtTentg,edtThoigian;
    Button btnThem,btnXoa;
    ListView lvMusic;
    ArrayList<danhsachBH> a;
    AdapterJava adapterJava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMusic= findViewById(R.id.lvMusic);
        a = new ArrayList<>();
        adapterJava = new AdapterJava(a,this);
        a.add(new danhsachBH(R.drawable.imgmusic,R.drawable.ic_more_vert_black_24dp,"Lửng lơ","A","3:05"));
        a.add(new danhsachBH(R.drawable.imgmusic,R.drawable.ic_more_vert_black_24dp,"Chân ái","B","3:25"));
        a.add(new danhsachBH(R.drawable.imgmusic,R.drawable.ic_more_vert_black_24dp,"Yêu 5","C","2:25"));
        a.add(new danhsachBH(R.drawable.imgmusic,R.drawable.ic_more_vert_black_24dp,"Người âm phủ","D","2:54"));
        a.add(new danhsachBH(R.drawable.imgmusic,R.drawable.ic_more_vert_black_24dp,"HaNoi and U","E","3:16"));
        lvMusic.setAdapter(adapterJava);

        edtTenbaihat=findViewById(R.id.edtTenbaihat);
        edtTentg=findViewById(R.id.edtTentg);
        edtThoigian=findViewById(R.id.edtThoigian);
        btnThem=findViewById(R.id.btnThem);
        btnXoa=findViewById(R.id.btnXoa);
        lvMusic.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                a.remove(position);
                adapterJava.notifyDataSetChanged();
                return false;
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.add(new danhsachBH(R.drawable.imgmusic,R.drawable.ic_more_vert_black_24dp,edtTenbaihat.getText().toString(),edtTentg.getText().toString(),edtThoigian.getText().toString()));
                adapterJava.notifyDataSetChanged();
            }
        });
    }
}
