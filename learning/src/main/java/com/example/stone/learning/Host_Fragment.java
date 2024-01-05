package com.example.stone.learning;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Host_Fragment extends AppCompatActivity implements View.OnClickListener {
    Button btnOneFrg,btnTwoFrg;
    TextView tvOne,tvTwo;
    private int count=0;
    private int counts=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_fragment);
        btnOneFrg = (Button) findViewById(R.id.btnOneFrg);
        btnTwoFrg = (Button) findViewById(R.id.btnTwoFrg);
        tvOne = findViewById(R.id.tvOne);
        tvTwo = findViewById(R.id.tvTwo);
        btnOneFrg.setOnClickListener(this);
        btnTwoFrg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        //Toast.makeText(this, btn.getText().toString(), Toast.LENGTH_SHORT).show();
        if (btn.getText().toString().contentEquals("Fragment One")) {
            count++;
            tvTwo.setText("You Button One clicked me"+count+" times");
        } else  if (btn.getText().toString().contentEquals("Fragment Two")) {
            counts++;
            tvOne.setText("You Button Two clicked me"+counts+" times");
        }
    }
}
