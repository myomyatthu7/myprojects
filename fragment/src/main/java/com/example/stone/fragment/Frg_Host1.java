package com.example.stone.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


public class Frg_Host1 extends AppCompatActivity implements customClickListener {
    Button btnFrg1,btnFrg2;
    TextView tvFrg1,tvFrg2;
    int count1 = 0;
    int count2 = 0;
    View v;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frg_host1);
//        btnFrg1 = findViewById(R.id.btnFrg1);
//        btnFrg2 = findViewById(R.id.btnFrg2);
//        tvFrg1 = findViewById(R.id.tvFrg1);
//        tvFrg2 = findViewById(R.id.tvFrg2);
//        btnFrg1.setOnClickListener(this);
//        btnFrg2.setOnClickListener(this);
    }
    @Override
    public void buttonClick(String str) {
        FragmentManager fm = getSupportFragmentManager();
        Frg_2 f2 = (Frg_2) fm.findFragmentById(R.id.frg_2);
        if (f2 != null) {
            f2.textChange(str);
        }
        Frg_1 f1 = (Frg_1) fm.findFragmentById(R.id.frg_1);
        if (f1 != null) {
            f1.textChange(str);
        }
    }
}
