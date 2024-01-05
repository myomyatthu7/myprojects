package com.example.stone.a001_flash;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.service.chooser.ChooserAction;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Next_Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    RadioGroup rGroup;
    RadioButton rPhoneCall,rSendEmail,rPlayVideo,rSendDrawPic,rSendMemoryPic;

    TextView tvResult;
    Button btnNext;

    int num;

    int check = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);

        rGroup = findViewById(R.id.rGroup);
        rPhoneCall = findViewById(R.id.rPhoneCall);
        rSendEmail = findViewById(R.id.rSendEmail);
        rPlayVideo = findViewById(R.id.rPlayVideo);
        rSendDrawPic = findViewById(R.id.rSendDrawPic);
        rSendMemoryPic = findViewById(R.id.rSendMemoryPic);
        tvResult = findViewById(R.id.tvResult);
        btnNext = findViewById(R.id.btnNext);

        rGroup.setOnCheckedChangeListener(this);
        btnNext.setOnClickListener(this);
    }

    public int getInt() {
        return num;
    }

    public void setInt(int num) {
        this.num = num;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNext) {
            if (check == R.id.rPhoneCall) {
                Intent iPhoneCall = new Intent(Next_Activity.this,PhoneCall_Activity.class);
                startActivity(iPhoneCall);
            } else if (check  == R.id.rSendEmail) {
                Intent iSendEmail = new Intent(Next_Activity.this,Send_Email_Activity.class);
                startActivity(iSendEmail);
                //Toast.makeText(Next_Activity.this,rSendEmail.getText(),Toast.LENGTH_SHORT).show();
            } else if (check == R.id.rPlayVideo) {
                //num = num++;
                Intent iPlayVideo = new Intent(Next_Activity.this,Video_Play_List_Activity.class);
                startActivity(iPlayVideo);
                //Toast.makeText(Next_Activity.this,rPlayVideo.getText(),Toast.LENGTH_SHORT).show();
            } else if (check == R.id.rSendDrawPic) {
               sentDrawPic();
            } else if (check == R.id.rSendMemoryPic) {
                sentMemoryPic();
            } else {
                Toast.makeText(Next_Activity.this,"Uncheck!",Toast.LENGTH_SHORT).show();
            }
            setInt(2);
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        check = checkedId;
        if (checkedId == R.id.rPhoneCall) {
            tvResult.setText(rPhoneCall.getText().toString());
            tvResult.setTextColor(Color.rgb(46,204,113));
        } else if (checkedId == R.id.rPlayVideo) {
            tvResult.setText(rPlayVideo.getText().toString());
            tvResult.setTextColor(Color.rgb(142,68,173));
        } else if (checkedId == R.id.rSendEmail) {
            tvResult.setText(rSendEmail.getText().toString());
            tvResult.setTextColor(Color.rgb(241,196,15));
        } else if (checkedId == R.id.rSendDrawPic) {
            tvResult.setText(rSendDrawPic.getText().toString());
            tvResult.setTextColor(Color.rgb(231,76,60));
        } else if (checkedId == R.id.rSendMemoryPic) {
            tvResult.setText(rSendMemoryPic.getText().toString());
            tvResult.setTextColor(Color.rgb(52,152,219));
        }
    }

    private void sentDrawPic() {
        Intent iSentDrawPic = new Intent(Intent.ACTION_SEND);
        Uri uri = Uri.parse("android.resource://com.example.stone.a001_flash/drawable"+R.drawable.image1);
        iSentDrawPic.setType("image/*");
        iSentDrawPic.putExtra(Intent.ACTION_SEND,uri);
        iSentDrawPic.putExtra(Intent.EXTRA_TEXT,"Hello IC Sent");
        Intent chooser = Intent.createChooser(iSentDrawPic,"Choose App for send");
        startActivity(chooser);
        //iSentDrawPic.createChooser(iSentDrawPic,"Hello");
        //startActivity(iSentDrawPic);
    }

    private void sentMemoryPic() {

//        File f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
//        String [] ary = f.list();
//        Uri uri;
//        ArrayList <Uri> arrayList = new ArrayList<>();
//        for (String pic : ary) {
//            uri = Uri.parse("file:"+ary.toString()+pic);
//            arrayList.add(uri);
//        }
//        Intent i = new Intent(Intent.ACTION_SEND);
//        i.setType("image/*");
//        i.putExtra(Intent.EXTRA_STREAM,arrayList);
//        i.putExtra(Intent.EXTRA_TEXT,"hello");
//        Intent cho = Intent.createChooser(i,"Chosse");
//        startActivity(cho);


        File f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        String []ary = f.list();
        Uri uri;
        ArrayList <Uri> arrayList = new ArrayList<>();
        for (String pic: ary) {
            uri = Uri.parse("file:"+ary.toString()+pic);
            arrayList.add(uri);
        }
        Intent iSentMemoryPic = new Intent(Intent.ACTION_SEND_MULTIPLE);
        iSentMemoryPic.putExtra(Intent.EXTRA_STREAM,arrayList);
        iSentMemoryPic.setType("image/*");
        Intent iChooser = Intent.createChooser(iSentMemoryPic,"Choose for send!");
        startActivity(iChooser);
    }

//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        if (checkedId == R.id.rPhoneCall) {
//            Intent iPhoneCall = new Intent(Next_Activity.this,PhoneCall_Activity.class);
//            startActivity(iPhoneCall);
//            //tvResult.setText();
//        } else if (checkedId == R.id.rSendDrawPic) {
//            Intent iSendDrawPic = new Intent(Intent.ACTION_SEND);
//            Uri uri = Uri.parse("android:resource://MyApplicationn/001_flash/src/main/res/drawable"
//                    +R.drawable.ic_launcher_background);
//            iSendDrawPic.putExtra(Intent.ACTION_SEND,uri);
//            iSendDrawPic.putExtra(Intent.EXTRA_TEXT,"Hello World");
//            iSendDrawPic.setType("image/*");
//            Intent chooser = Intent.createChooser(iSendDrawPic,"Choose App!");
//            startActivity(chooser);
//        }
//    }
}
