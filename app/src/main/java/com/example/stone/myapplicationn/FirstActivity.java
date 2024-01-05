package com.example.stone.myapplicationn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(v -> {
            Intent i = new Intent(FirstActivity.this,RandomPicker.class);
            startActivity(i);
        });

//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(FirstActivity.this,RandomPicker.class);
//                startActivity(i);
//            }
//        });

    }
}
