package com.example.stone.a001_flash;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Video_Play_Activity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play_activity);

        //Toast.makeText(Video_Play_Activity.this,filePath,Toast.LENGTH_SHORT).show();

        //Button btnPlay = findViewById(R.id.btnPlay);
        videoView = findViewById(R.id.videoView);
        videoView.requestFocus();
        Bundle bn = getIntent().getExtras();
        //byte path = bn.getByte("str");
//        int path = 0;
//        if (bn != null) {
//            path = bn.getInt("str");
//        }
//        byte latPath = bn.getByte("lat");
//        byte maPath = bn.getByte("ma");
//        byte mgPath = bn.getByte("mg");
//        byte monePath = bn.getByte("mone");
        String filePath = null;
        if (bn != null) {
            filePath = "android.resource://com.example.stone.a001_flash/"+bn.getInt("str");
        }
        uri(filePath);
        videoView.start();




        //String filePath = "android.resource://com.example.stone.a001_flash/"+R.raw.chitthu;
        //uri(filePath);

//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ss = !ss;
//                if (ss) {
//                    videoView.start();
//                    btnPlay.setText("Pause");
//                } else {
//                    videoView.pause();
//                    btnPlay.setText("Play");
//                }
//            }
//        });
    }

    private void uri(String filePath) {
        //Uri uri = Uri.parse(filePath);
        videoView.setVideoPath(filePath);
        MediaController mc = new MediaController(Video_Play_Activity.this);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);
    }

//    public void uri(String filePath) {
//        Uri uri =Uri.parse(filePath);
//        videoView.setVideoURI(uri);
//        MediaController controller = new MediaController(Video_Play_Activity.this);
//        controller.setAnchorView(videoView);
//        videoView.setMediaController(controller);
//    }
}
