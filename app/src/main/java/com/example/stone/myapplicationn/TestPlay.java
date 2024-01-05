package com.example.stone.myapplicationn;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Random;

public class TestPlay extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    TextView tvResult;
    EditText etInput;
    Button btnCmd;
    ToggleButton tgb;

    Random ran = new Random();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_play);
        setUi();
    }
    public void setUi() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        etInput = (EditText) findViewById(R.id.etInput);
        btnCmd = (Button) findViewById(R.id.btnCmd);
        tgb = (ToggleButton) findViewById(R.id.tgb);
        btnCmd.setOnClickListener(this);
        //tgb.setOnClickListener(this);
        tgb.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCmd) {
            String inputText = etInput.getText().toString();
            tvResult.setText(inputText);
            if (inputText.equalsIgnoreCase("left")) {
                tvResult.setGravity(Gravity.START);
            } else if (inputText.equalsIgnoreCase("right")) {
                tvResult.setGravity(Gravity.END);
            } else if (inputText.equalsIgnoreCase("center")) {
                tvResult.setGravity(Gravity.CENTER);
            } else if (inputText.isEmpty()){
                tvResult.setGravity(Gravity.CENTER_HORIZONTAL);
                String noData = "No Data";
                tvResult.setText(noData);
            } else {
                tvResult.setGravity(Gravity.CENTER_HORIZONTAL);
            }
            tvResult.setTextSize(ran.nextInt(70));
            tvResult.setTextColor(Color.rgb(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
            int gravity = ran.nextInt(4);
            if (gravity == 0) {
                tvResult.setGravity(Gravity.CENTER_HORIZONTAL);
            } else if (gravity == 1 ) {
                tvResult.setGravity(Gravity.END);
            } else if (gravity == 2 ) {
                tvResult.setGravity(Gravity.START);
            } else {
                tvResult.setGravity(Gravity.CENTER);
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked)
            etInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
         else etInput.setInputType(InputType.TYPE_CLASS_TEXT);

    }
}
