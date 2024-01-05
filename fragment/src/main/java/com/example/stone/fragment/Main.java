package com.example.stone.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvMain;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lvMain = findViewById(R.id.lvMain);
        String[] arrayList = getResources().getStringArray(R.array.Fragments);
        lvMain.setAdapter(new ArrayAdapter<>(Main.this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arrayList));
        lvMain.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Intent intentMain = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intentMain);
        } else if (position == 1) {
            Intent intentFrgCom = new Intent(getApplicationContext(),Frg_Com.class);
            startActivity(intentFrgCom);
        } else if (position == 2) {
            Intent intentFrgTr = new Intent(getApplicationContext(),Frg_Tran.class);
            startActivity(intentFrgTr);
        } else if (position == 3) {
            Intent intentFrgList = new Intent(getApplicationContext(),Frg_MN_List.class);
            startActivity(intentFrgList);
        } else if (position == 4) {
            Intent intentFrgDia = new Intent(getApplicationContext(),Frg_Dia_Mn.class);
            startActivity(intentFrgDia);
        } else if (position == 5) {
            Intent i1 = new Intent(getApplicationContext(),Frg_Host1.class);
            startActivity(i1);
        }
    }
}
