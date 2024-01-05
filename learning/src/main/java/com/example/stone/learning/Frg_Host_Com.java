package com.example.stone.learning;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class Frg_Host_Com extends AppCompatActivity implements Frg_One_Com.customButtonClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.com_frg_host);
    }

    @Override
    public void getButtonClick(String msg) {
        FragmentManager frgManager = getSupportFragmentManager();
        Frg_Two_Com frgTwoCom = (Frg_Two_Com) frgManager.findFragmentById(R.id.frgComTwo);
        if (frgTwoCom != null) {
            frgTwoCom.textChange(msg);
        }
    }
}
