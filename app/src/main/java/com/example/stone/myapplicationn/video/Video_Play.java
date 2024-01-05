package com.example.stone.myapplicationn.video;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stone.myapplicationn.R;

public class Video_Play extends AppCompatActivity {

    private VideoView vv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play_video);
        vv = findViewById(R.id.vPlay);
        Bundle bundle = getIntent().getExtras();
        String filePath = bundle.getString("engVideo");
        mediaController(filePath);
        vv.start();
    }

    private void mediaController(String filePath) {
        vv.setVideoPath(filePath);
        MediaController controller = new MediaController(Video_Play.this);
        controller.setAnchorView(vv);
        vv.setMediaController(controller);
    }
}
