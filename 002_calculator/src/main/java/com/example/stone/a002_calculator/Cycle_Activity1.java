package com.example.stone.a002_calculator;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Cycle_Activity1 extends AppCompatActivity implements Animation.AnimationListener {

    boolean play = false;
    //TextView tv;
    //int size = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cycle_turn);
        Button btnRotate = findViewById(R.id.btnRotate);
        Button btnRotateLine = findViewById(R.id.btnRotateLine);
        Button btnTap = findViewById(R.id.btnTap);
        //tv = findViewById(R.id.tv);
        Animation btnAnim;
        Animation btnAnimLine;
        SoundPool sp;

        int tap;
        int cancel;
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.cycle_rotate);
        btnAnimLine = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.line_rotate);
        sp = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        tap = sp.load(Cycle_Activity1.this,R.raw.tap,1);
        cancel = sp.load(Cycle_Activity1.this,R.raw.cancel,1);
        btnAnim.setAnimationListener(this);
        btnAnimLine.setAnimationListener(this);
        btnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //size += 10;
                //tv.setTextSize(size);
                play = !play;
                if (play) {
                    sp.play(tap,1,1,0,0,1);

                    btnRotate.startAnimation(btnAnim);
                    btnRotateLine.startAnimation(btnAnimLine);
                } else {
                    sp.play(cancel,1,1,0,0,1);
                    btnRotate.clearAnimation();
                    btnRotateLine.clearAnimation();
                }
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
