package com.example.stone.learning;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Videos_Play extends AppCompatActivity {

    VideoView vView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.videos_play);
        vView = findViewById(R.id.vView);
        vView.requestFocus();
        Bundle bnd = getIntent().getExtras();
        String path = bnd != null ? bnd.getString("eng_lesson") : null;
        controller(path);
        vView.start();
    }

    private void controller(String path) {
        vView.setVideoPath(path);
        MediaController controller = new MediaController(Videos_Play.this);
        vView.setMediaController(controller);
        controller.setAnchorView(vView);
    }
}
