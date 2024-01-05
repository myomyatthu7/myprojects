package com.example.stone.fragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class Frg_Com extends AppCompatActivity implements Frg_One_C.customButtonClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void buttonClick(String msg) {
        FragmentManager fm = getSupportFragmentManager();
        Frg_Two_C frgTwoC = (Frg_Two_C) fm.findFragmentById(R.id.frgTwo);
        frgTwoC.textChange(msg);
    }
}
