package java.stone.allinone;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.Random;

public class Rdm_Pic extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    TextView tvLucky_Num;
    EditText etMax_Num,etAniSec;
    Button btnStart;

    Random random;
    CheckBox cbSkpAni;

    Ctm_PrgDial dialog;
    String max_str;
    String lucky_num;
    String aniSec;
    Boolean skip = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rdm_pic);
        tvLucky_Num = findViewById(R.id.tvLucky_Num);
        etMax_Num = findViewById(R.id.etMax_Num);
        btnStart = findViewById(R.id.btnStart);
        cbSkpAni = findViewById(R.id.cbSkpAni);
        etAniSec = findViewById(R.id.etAniSec);
        btnStart.setOnClickListener(this);
        cbSkpAni.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        random = new Random();
        max_str = etMax_Num.getText().toString();
        aniSec = etAniSec.getText().toString();
        if (v.getId()==R.id.btnStart) {
            if (max_str.isEmpty()|| max_str.contentEquals("0")) {
                ToastMsg.toastMsg(Rdm_Pic.this,"Insert Max Number!");
            } else {
                int max_num = Integer.parseInt(max_str);
                lucky_num = String.valueOf(random.nextInt(max_num)+1);
                if (skip && aniSec.isEmpty()) {
                    ToastMsg.toastMsg(Rdm_Pic.this,"Insert Animation Second");
                } else if (skip) {
                    int sec = Integer.parseInt(aniSec);
                    dialog = new Ctm_PrgDial(Rdm_Pic.this,false,null,
                            "Wait "+aniSec+" Seconds...");
                    dialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                            tvLucky_Num.setText(lucky_num);
                        }
                    },sec* 1000L);
                } else {
                    tvLucky_Num.setText(lucky_num);
                }
            }
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (cbSkpAni.isChecked()) {
            skip = false;
            etAniSec.setVisibility(View.INVISIBLE);
        } else {
            skip = true;
            etAniSec.setVisibility(View.VISIBLE);
        }
    }
}
