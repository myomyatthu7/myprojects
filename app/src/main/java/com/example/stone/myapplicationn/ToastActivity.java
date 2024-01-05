package com.example.stone.myapplicationn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ToastActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        Button btn = (Button) findViewById(R.id.btn);


        // 2
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ToastActivity.this,"Button CLicked",Toast.LENGTH_SHORT).show();
//            }
//        });


        // 3
       // btn.setOnClickListener(new Clicks());

        Button btnOne = (Button) findViewById(R.id.btnOne);
        Button btnTwo = (Button) findViewById(R.id.btnTwo);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
    }

    //@SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnOne) {
            Toast.makeText(getApplicationContext(),"Button One Clicked",Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnTwo) {
            Toast.makeText(getApplicationContext(),"Button Two CLicked",Toast.LENGTH_SHORT).show();
        }
    }


    // 3
//    public class Clicks implements View.OnClickListener {
//
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(ToastActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
//        }
//    }

    // 1
//    public void showToast(View v) {
//        Toast.makeText(ToastActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
//    }

}
