package com.example.stone.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class Frg_Dia_Mn extends AppCompatActivity implements View.OnClickListener,Frg_Dialog.clickListener {
//    TextView tvResult;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.frg_dia_mn);
//        Button btnShowDia = findViewById(R.id.btnShowDia);
//        tvResult = findViewById(R.id.tvResult);
//        btnShowDia.setOnClickListener( v -> {
//                Frg_Dialog fd = new Frg_Dialog();
//                FragmentManager fm = getSupportFragmentManager();
//                fd.show(fm,"Dialog");
//        });
//    }
//
//    @Override
//    public void textChange(String msg) {
//        tvResult.setText(msg);
//    }

    Button btnDialog;
    TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frg_dia_mn);
        btnDialog = findViewById(R.id.btnShowDia);
        tvResult = findViewById(R.id.tvResult);
        btnDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        Frg_Dialog fdg = new Frg_Dialog();
        fdg.show(fm,"Dialog");

    }

    @Override
    public void buttonClick(String msg) {
        tvResult.setText(msg);
    }
}
