package java.stone.allinone;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Main extends Activity {

    // later use soundPool ,,,
    MediaPlayer mp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
        TextView tvAds = findViewById(R.id.tvAds);
        tvAds.setSelected(true);
        mp = MediaPlayer.create(Main.this,R.raw.piano);
        mp.start();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    mp.stop();
                    Intent iMainList = new Intent(Main.this,MainLsV.class);
                    startActivity(iMainList);
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }
}
