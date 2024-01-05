package com.example.stone.a002_calculator;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.TestOnly;

import java.util.Locale;

public class RelativeLayout_InJava extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rout;
    private TextView tvTitle,tvUser,tvPw;
    private EditText etUser,etPw;
    private Button btnLog;
    TextToSpeech tts;
    private RelativeLayout.LayoutParams tvTitleDimen,tvUserDimen,etUserDimen,tvPwDimen,etPwDimen,btnLogDimen;
    private int tvTitleId = 1,tvUserId = 2,tvPwId = 3,etUserId=4,etPwId=5,btnLogId = 6;
    private int mp = RelativeLayout.LayoutParams.MATCH_PARENT,wc = RelativeLayout.LayoutParams.WRAP_CONTENT;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpUi();
        rout.addView(tvTitle,tvTitleDimen);
        rout.addView(tvUser,tvUserDimen);
        rout.addView(etUser,etUserDimen);
        rout.addView(tvPw,tvPwDimen);
        rout.addView(etPw,etPwDimen);
        rout.addView(btnLog,btnLogDimen);
        tts = new TextToSpeech(this,new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
            }
        });
        //btnLog.setOnClickListener(this);
        tvUser.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        //String s = etUser.getText().toString();
        String s = tvUser.getText().toString();
        String[] e = s.split(":");
        String t = e[0];
        tts.speak(t,TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    protected void onPause() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }

    private void setUpUi() {
        rout = new RelativeLayout(RelativeLayout_InJava.this);
        RelativeLayout.LayoutParams rOutDimen = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        rout.setLayoutParams(rOutDimen);
        setContentView(rout);
        createTitleUi();
        createTvUser();
        createEtUser();
        createTvPw();
        createEtPw();
        createBtnLog();
    }

    private void createBtnLog() {
        btnLog = new Button(this);
        btnLogDimen = new RelativeLayout.LayoutParams(wc,wc);
        btnLogDimen.addRule(RelativeLayout.BELOW,etPwId);
        btnLogDimen.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        btnLog.setLayoutParams(btnLogDimen);
        btnLog.setText("Log");
        btnLog.setId(btnLogId);
    }

    private void createEtPw() {
        etPw = new EditText(this);
        etPwDimen = new RelativeLayout.LayoutParams(wc,wc);
        etPw.setId(etPwId);
        //ViewGroup.MarginLayoutParams dd = new RelativeLayout.MarginLayoutParams(etPwDimen);
        //etPwDimen.setMarginEnd(30);
        etPwDimen.addRule(RelativeLayout.BELOW,etUserId);
        etPwDimen.addRule(RelativeLayout.RIGHT_OF,tvPwId);
        etPwDimen.addRule(RelativeLayout.ALIGN_BASELINE,tvPwId);
        etPwDimen.addRule(RelativeLayout.ALIGN_PARENT_END);
        etPw.setLayoutParams(etPwDimen);
    }

    private void createTvPw() {
        tvPw = new TextView(this);
        tvPwDimen = new RelativeLayout.LayoutParams(wc,wc);
        tvPw.setId(tvPwId);
        tvPwDimen.addRule(RelativeLayout.BELOW,tvUserId);
        tvPwDimen.addRule(RelativeLayout.ALIGN_LEFT,tvUserId);
        tvPw.setText("Password : ");
        //tvPwDimen.addRule(RelativeLayout.);
        tvPw.setLayoutParams(tvPwDimen);
        tvPw.setTextSize(20);
    }

    private void createEtUser() {
        etUser = new EditText(this);
        etUserDimen = new RelativeLayout.LayoutParams(wc,wc);
        etUser.setId(etUserId);
        etUserDimen.addRule(RelativeLayout.BELOW,tvTitleId);
        etUserDimen.addRule(RelativeLayout.RIGHT_OF,tvUserId);
        etUserDimen.addRule(RelativeLayout.ALIGN_PARENT_END);
        etUserDimen.addRule(RelativeLayout.ALIGN_BASELINE,tvUserId);
        etUser.setLayoutParams(etUserDimen);
    }
    private void createTitleUi() {
        tvTitle = new TextView(RelativeLayout_InJava.this);
         tvTitleDimen = new RelativeLayout.LayoutParams(wc, wc);
         tvTitle.setId(tvTitleId);
        tvTitle.setLayoutParams(tvTitleDimen);
        tvTitle.setText("Please Fill Your Identify!");
        tvTitleDimen.setMargins(20,30,0,20);
        tvTitle.setBackgroundColor(Color.GREEN);
    }
    private void createTvUser() {
        tvUser = new TextView(RelativeLayout_InJava.this);
        tvUserDimen = new RelativeLayout.LayoutParams(wc,wc);
        tvUser.setId(tvUserId);
        tvUserDimen.addRule(RelativeLayout.BELOW,1);
        tvUser.setLayoutParams(tvUserDimen);
        tvUser.setText("Username : စကားပြောမလား");
        tvUser.setTextSize(20);
        tvUser.setTextColor(Color.BLUE);
        tvUser.setShadowLayer(5,10,10,Color.BLACK);
    }


}
