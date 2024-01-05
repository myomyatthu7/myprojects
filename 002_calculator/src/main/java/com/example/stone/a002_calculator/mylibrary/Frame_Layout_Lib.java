package com.example.stone.a002_calculator.mylibrary;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.example.stone.a002_calculator.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Frame_Layout_Lib {
    private SoundPool sp;
    private int clip;
    private Context context;
    public Frame_Layout_Lib(Context context) {
        sp = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        clip = sp.load(context,R.raw.tap,1);
    }
    public void playPool() {
        sp.play(clip,1,1,0,0,1);
    }

    public String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
        return sdf.format(Calendar.getInstance().getTime());
    }


//    public void playSoundPool(Context context) {
//        this.context = context;
//        sp = new SoundPool(5,AudioManager.STREAM_MUSIC,0);
//        clip = sp.load(context,R.raw.tap,1);
//        //plays();
//    }
//    public void plays() {
//        BigToastMsg.bigToastMsg(context,"Play");
//        sp.play(clip,1,1,0,0,1);
//    }
}
