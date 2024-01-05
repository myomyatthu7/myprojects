package com.example.stone.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stone.fragment.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOne,btnTwo;
    TextView tvOne,tvTwo;
    //View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne = findViewById(R.id.btnFrgOne);
        btnTwo = findViewById(R.id.btnFrgTwo);
        tvOne = findViewById(R.id.tvFrgOne);
        tvTwo = findViewById(R.id.tvFrgTwo);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button btnV = (Button) v;
        //Toast.makeText(this, btnV.getText().toString(), Toast.LENGTH_SHORT).show();
        if (btnV.getText().toString().contentEquals(btnOne.getText())) {
            String e = "Button One Clicked";
            tvTwo.setText(e);
        } else if (v.getId() == R.id.btnFrgTwo) {
            tvOne.setText("Button Two Clicked");
        }
    }
}