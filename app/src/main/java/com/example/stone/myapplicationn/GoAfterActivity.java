package com.example.stone.myapplicationn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GoAfterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvGoAfterResult;
    TextView tvRadioResult;
    RadioGroup rg;
    RadioButton rgJava,rgKt,rgCPlus;
    Button btnGoAfterFinish;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goafter);

         tvGoAfterResult = (TextView) findViewById(R.id.tvGoAfterResult);
         tvRadioResult = (TextView) findViewById(R.id.tvRadioResult);
         rg = (RadioGroup) findViewById(R.id.rg);


        rgJava = (RadioButton) findViewById(R.id.rgJava);
        rgKt = (RadioButton) findViewById(R.id.rgKt);
        rgCPlus = (RadioButton) findViewById(R.id.rgCPlus);

        //Intent i = new Intent(GoAfterActivity.this,GoActivity.class);
        Bundle bd = getIntent().getExtras();
        String str = null;
        if (bd != null) {
            str = bd.getString("str");
        }
        tvGoAfterResult.setText(str);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rgJava) {
                    tvRadioResult.setText("You choose Java");
                } else if (checkedId == R.id.rgKt) {
                    tvRadioResult.setText("You choose Kotlin");
                } else if (checkedId == R.id.rgCPlus) {
                    tvRadioResult.setText("You choose C++");
                }
            }
        });

        btnGoAfterFinish = findViewById(R.id.btnGoAfterFinish);
        btnGoAfterFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String choose = tvRadioResult.getText().toString();
        if (v.getId()==R.id.btnGoAfterFinish) {
            Intent in = new Intent();
            Bundle bn = new Bundle();
            bn.putString("after",choose);
            in.putExtras(bn);
            startActivity(in);
            //finish();
        }
    }
}
