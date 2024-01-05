package com.example.stone.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Frg_MN_List extends AppCompatActivity {
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.frg_mn_list);
        FragmentManager fm = getSupportFragmentManager();
        Frg_List flt = new Frg_List();
        FragmentTransaction ftr = fm.beginTransaction();
        ftr.add(R.id.lMain,flt);
        ftr.commit();
    }
}
