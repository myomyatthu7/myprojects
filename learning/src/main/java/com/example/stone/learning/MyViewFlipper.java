package com.example.stone.learning;

import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyViewFlipper extends AppCompatActivity implements View.OnClickListener {
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_flipper);
        viewFlipper = findViewById(R.id.vf);
//        viewFlipper.setFlipInterval(2000);
//        viewFlipper.startFlipping();
        viewFlipper.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        viewFlipper.showNext();
    }
}
