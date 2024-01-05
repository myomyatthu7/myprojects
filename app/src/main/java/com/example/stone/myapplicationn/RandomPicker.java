package com.example.stone.myapplicationn;

import static java.lang.Thread.sleep;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RandomPicker extends AppCompatActivity implements View.OnClickListener {

    TextView tvLuckyNum;
    EditText etMaxInput;

    Button btnStart,btnFinish;
    //ImageView iv;

    Random random = new Random();
    //int i = 0;

    //int max;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_picker);
        setUi();
    }

    private void setUi() {
        tvLuckyNum = (TextView) findViewById(R.id.tvLuckyNum);
        etMaxInput = (EditText) findViewById(R.id.etMaxInput);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnFinish = (Button) findViewById(R.id.btnFinish);
        //iv = findViewById(R.id.iv);
        btnStart.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        String maxNum = etMaxInput.getText().toString();
        if (v.getId() == R.id.btnFinish) {
            Intent i = new Intent(RandomPicker.this, FirstActivity.class);
            //startActivity(i);
            finish();
        } else if (maxNum.isEmpty()) {
            tvLuckyNum.setText("Null");
        } else if ( v.getId() == R.id.btnStart) {
//            while (i < 5) {
//                Log.d("hello",String.valueOf(i));
//                if (i%2 ==1) {
//                    iv.setVisibility(View.VISIBLE);
//                }
//                try {
//                    i++;
//                    Thread.sleep(2000);
//                    //iv.setVisibility(View.INVISIBLE);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }

                int max = Integer.parseInt(maxNum)+1;
                int luck = random.nextInt(max);
                tvLuckyNum.setText(String.valueOf(luck));

        }
    }
}
