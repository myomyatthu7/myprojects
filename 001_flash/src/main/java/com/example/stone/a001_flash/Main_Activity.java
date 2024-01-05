package com.example.stone.a001_flash;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Main_Activity extends Activity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        TextView tv = findViewById(R.id.tv);
        //Typeface tf = Typeface.createFromAsset(getAssets(),"raw.unicode.ttf");
//        Typeface tf = Typeface.createFromAsset(getAssets(),"unicodeFont.ttf");
//        tv.setTypeface(tf)git f;
        tv.setSelected(true);
        mediaPlayer = MediaPlayer.create(this,R.raw.piano1);
        mediaPlayer.start();
        //TextView tvRam = findViewById(R.id.tvRam);

        Thread th = new Thread(() -> {
            try {
                Thread.sleep(5000);
                //Thread.sleep(5000);
                //tvRam.setText(String.valueOf(i));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                //tvRam.setText(String.valueOf(123));
                mediaPlayer.pause();
                Intent i =  new Intent(Main_Activity.this, Next_Activity.class);
                startActivity(i);
                finish();
            }
        });
        th.start();
    }
    @Override
    protected void onStart() {
        super.onStart();
        // BigToast("onStart is Starting!");
        Log.i("stone","onStart is working!I");
        Log.d("stone","onStart is working!D");
        Log.e("stone","onStart is working!E");
        Log.v("stone","onStart is working!V");
        Log.w("stone","onStart is working!W");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // BigToast("onResume is Starting!");
        //  count++;
        Log.i("stone","onResume is working!I");
        Log.d("stone","onResume is working!D");
        Log.e("stone","onResume is working!E");
        Log.v("stone","onResume is working!V");
        Log.w("stone","onResume is working!W");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // BigToast("onPause is Starting!");
        Log.i("stone","onPause is working!I");
        Log.d("stone","onPause is working!D");
        Log.e("stone","onPause is working!E");
        Log.v("stone","onPause is working!V");
        Log.w("stone","onPause is working!W");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // BigToast("onStop is Starting!");
        Log.i("stone","onStop is working!I");
        Log.d("stone","onStop is working!D");
        Log.e("stone","onStop is working!E");
        Log.v("stone","onStop is working!V");
        Log.w("stone","onStop is working!W");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //  BigToast("onRestart is Starting!");
        Log.i("stone","onRestart is working!I");
        Log.d("stone","onRestart is working!D");
        Log.e("stone","onRestart is working!E");
        Log.v("stone","onRestart is working!V");
        Log.w("stone","onRestart is working!W");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //BigToast("onSaveInstanceState is Starting!");
        // outState.putInt("count",count);
        Log.i("stone","onSaveInstanceState is working!I");
        Log.d("stone","onSaveInstanceState is working!D");
        Log.e("stone","onSaveInstanceState is working!E");
        Log.v("stone","onSaveInstanceState is working!V");
        Log.w("stone","onSaveInstanceState is working!W");
    }

    @Override
    public void onStateNotSaved() {
        super.onStateNotSaved();
        // BigToast("onStateNotSaved is Starting!");
        Log.i("stone","onStateNotSaved is working!I");
        Log.d("stone","onStateNotSaved is working!D");
        Log.e("stone","onStateNotSaved is working!E");
        Log.v("stone","onStateNotSaved is working!V");
        Log.w("stone","onStateNotSaved is working!W");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //BigToast("onRestoreInstanceState1 is Starting!");
        // count = savedInstanceState.getInt("count");
        // BigToast(String.valueOf(count));
        Log.i("stone","onRestoreInstanceState is working!I");
        Log.d("stone","onRestoreInstanceState is working!D");
        Log.e("stone","onRestoreInstanceState is working!E");
        Log.v("stone","onRestoreInstanceState is working!V");
        Log.w("stone","onRestoreInstanceState is working!W");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //BigToast("onDestroy is Starting!");
        Log.i("stone","onDestroy is working!I");
        Log.d("stone","onDestroy is working!D");
        Log.e("stone","onDestroy is working!E");
        Log.v("stone","onDestroy is working!V");
        Log.w("stone","onDestroy is working!W");
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        mediaPlayer.start();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        mediaPlayer.pause();
//    }
}
