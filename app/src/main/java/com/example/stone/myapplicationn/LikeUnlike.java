package com.example.stone.myapplicationn;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LikeUnlike extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);
        setUi();
    }

    Button btnLike,btnUnlike;
    ImageView ivAndroid,ivLike,ivUnlike;
    TextView tvResult;

    int count = 3000;
    private void setUi() {
        btnLike = (Button) findViewById(R.id.btnLike);
        btnUnlike = (Button) findViewById(R.id.btnUnlike);
        ivAndroid = (ImageView) findViewById(R.id.ivAndroid);
        ivLike = (ImageView) findViewById(R.id.ivLike);
        ivUnlike = (ImageView) findViewById(R.id.ivUnlike);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnLike.setOnClickListener(this);
        btnUnlike.setOnClickListener(this);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnLike ) {
            count++;
            tvResult.setText(count +" : likes this photo");
            ivUnlike.setVisibility(View.INVISIBLE);
            ivLike.setVisibility(View.VISIBLE);
        } else if (v.getId() == R.id.btnUnlike) {
            count--;
            tvResult.setText(count +" : likes this photo");
            ivLike.setVisibility(View.INVISIBLE);
            ivUnlike.setVisibility(View.VISIBLE);
        }
    }
}
