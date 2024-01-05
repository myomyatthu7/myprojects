package com.example.stone.a001_flash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.InterfaceAddress;

public class Video_Play_List_Activity extends AppCompatActivity implements View.OnClickListener {
    Button btnChitThu,btnLatSar,btnMaSoneTaw,btnMgMyat,btnMoneKhine;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play_list_activity);
        btnLatSar = findViewById(R.id.btnlatsar);
        btnChitThu = findViewById(R.id.btnChitThu);
        btnMaSoneTaw = findViewById(R.id.btnMaSoneTaw);
        btnMgMyat = findViewById(R.id.btnMgMyat);
        btnMoneKhine = findViewById(R.id.btnMoneKhine);
        btnLatSar.setOnClickListener(this);
        btnChitThu.setOnClickListener(this);
        btnMaSoneTaw.setOnClickListener(this);
        btnMgMyat.setOnClickListener(this);
        btnMoneKhine.setOnClickListener(this);

//        na = new Next_Activity();
//        int ix = na.getInt();
//        Toast.makeText(Video_Play_List_Activity.this,"here : "+ix, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnChitThu) {
            pushKey(R.raw.chitthu);
        } else if (v.getId() == R.id.btnlatsar) {
            pushKey(R.raw.latsar);
        } else if (v.getId() == R.id.btnMaSoneTaw) {
            pushKey(R.raw.masonetaw);
        } else if (v.getId() == R.id.btnMgMyat) {
            pushKey(R.raw.mgmyat);
        } else if (v.getId() == R.id.btnMoneKhine) {
            pushKey(R.raw.piano1);
        }
    }

    private void pushKey(int uri) {
        Intent i = new Intent(Video_Play_List_Activity.this,Video_Play_Activity.class);
        Bundle b = new Bundle();
        //b.putByte(str,s);
        b.putInt("str",uri);
        i.putExtras(b);
        startActivity(i);
    }

//    private void pushKey(String str,byte byt) {
//        Intent i = new Intent(Video_Play_List_Activity.this,Video_Play_Activity.class);
//        Bundle b = new Bundle();
//        b.putByte(str,byt);
//        i.putExtras(b);
//        startActivity(i);
//    }
}
