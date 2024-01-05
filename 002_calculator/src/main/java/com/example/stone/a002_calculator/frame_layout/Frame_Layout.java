package com.example.stone.a002_calculator.frame_layout;

import android.media.TimedText;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stone.a002_calculator.R;
import com.example.stone.a002_calculator.mylibrary.Frame_Layout_Lib;

import java.sql.Time;

public class Frame_Layout extends AppCompatActivity implements View.OnClickListener {

    Button btnOneFrame,btnTwoFrame,btnThreeFrame,btnStart,btnStop;
    LinearLayout linearOne,linearTwo,linearThree;

    TextView tvCurrentDate,tvCurrentTime,tvResult;
    Frame_Layout_Lib fll;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        btnOneFrame = findViewById(R.id.btnOneFrame);
        btnTwoFrame = findViewById(R.id.btnTwoFrame);
        btnThreeFrame = findViewById(R.id.btnThreeFrame);
        linearOne = findViewById(R.id.linearOne);
        linearTwo = findViewById(R.id.linearTwo);
        linearThree = findViewById(R.id.linearThree);
        tvCurrentDate = findViewById(R.id.tvCurrentDate);
        tvCurrentTime = findViewById(R.id.tvCurrentTime);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        tvResult = findViewById(R.id.tvResult);

        btnOneFrame.setOnClickListener(this);
        btnTwoFrame.setOnClickListener(this);
        btnThreeFrame.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        fll = new Frame_Layout_Lib(Frame_Layout.this);
        currentDate_Time();
    }

    Long start;
    Long stop;

    @Override
    public void onClick(View v) {
        fll.playPool();

        //fll.plays();
        if (v.getId() == R.id.btnOneFrame) {
            linearOne.setVisibility(View.VISIBLE);
            linearTwo.setVisibility(View.INVISIBLE);
            linearThree.setVisibility(View.INVISIBLE);
        } else if (v.getId() == R.id.btnTwoFrame) {
            linearOne.setVisibility(View.INVISIBLE);
            linearTwo.setVisibility(View.VISIBLE);
            linearThree.setVisibility(View.INVISIBLE);
            currentDate_Time();
        } else if (v.getId() == R.id.btnThreeFrame) {
            linearOne.setVisibility(View.INVISIBLE);
            linearTwo.setVisibility(View.INVISIBLE);
            linearThree.setVisibility(View.VISIBLE);
        } else if (v.getId() == R.id.btnStart) {
            start = 0L;
            start = System.currentTimeMillis();
        } else if (v.getId() == R.id.btnStop) {
            stop = System.currentTimeMillis();
            long result = stop - start;

            long sec = (result /1000);   // 7500 -> 7sec 77500 -> 77sec
            double min = (double) sec / 60;
            String s = String.valueOf(min);
            String e = s.substring(0,s.indexOf("."));
            String r = s.substring(s.indexOf("."));
            String timer = "Result is : " +e+" / "+r+ " minutes"+sec+" Seconds,"+result+" milliseconds";
            tvResult.setText(timer);
        }
    }
    private void currentDate_Time() {
        String currentDateTime = fll.getCurrentDateTime();
        String currentDate = currentDateTime.substring(0,currentDateTime.indexOf(" "));
        String currentTime = currentDateTime.substring(currentDateTime.indexOf(" ")+1);
        String date = "Date is : "+currentDate;
        String time = "Time is : "+currentTime;
        tvCurrentDate.setText(date);
        tvCurrentTime.setText(time);
    }
}
