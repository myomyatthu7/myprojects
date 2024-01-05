package com.example.stone.myapplicationn;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GoActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvPlay,tvResultHere;
    EditText etMind;
    Button btnGo;
    Button btnGoAfter;
    MediaPlayer mp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);

        tvPlay = findViewById(R.id.tvPlay);
        tvResultHere = findViewById(R.id.tvResultHere);
        etMind = findViewById(R.id.etMind);
        btnGo = findViewById(R.id.btnGo);
        btnGoAfter = findViewById(R.id.btnGoAfter);
        tvPlay.setOnClickListener(this);
        btnGo.setOnClickListener(this);
        btnGoAfter.setOnClickListener(this);
        mp = MediaPlayer.create(GoActivity.this,R.raw.piano);

        Bundle bb = getIntent().getExtras();
        String ss = null;
        if (bb != null) {
            ss = bb.getString("after");
        }
        tvResultHere.setText(ss);
    }

    @Override
    public void onClick(View v) {
        String str = etMind.getText().toString();
        if (v.getId() == R.id.btnGo) {
            if (str.isEmpty()) {
                Toast.makeText(getApplicationContext(),"Enter your Words",Toast.LENGTH_SHORT).show();
            } else {
                Intent i = new Intent(GoActivity.this, GoAfterActivity.class);
                Bundle bd = new Bundle();
                bd.putString("str", str);
                i.putExtras(bd);
                startActivity(i);
            }
        } else if (v.getId()==R.id.btnGoAfter) {
            Intent ii = new Intent(GoActivity.this,GoAfterActivity.class);
            Bundle bnd = new Bundle();
            bnd.putString("str",str);
            ii.putExtras(bnd);
            startActivity(ii);
            //startActivityForResult(ii,0);
            //startActivityIfNeeded(ii,0);
        } else if (v.getId() == R.id.tvPlay) {
            mp.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Pause","On Pause");
        mp.pause();
    }
}
