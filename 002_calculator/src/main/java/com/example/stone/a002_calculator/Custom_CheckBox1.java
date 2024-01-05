package com.example.stone.a002_calculator;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stone.a002_calculator.mylibrary.BigToastMsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Custom_CheckBox1 extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private CheckBox cbSnare,cbIron,cbEmperor,cbAudio;
    private ToggleButton tgDiscount;
    private TextView tvTotalPrice,tvDis;
    private EditText etDisKey;

    private Button btnTotal,btnDis;
    private int price = 0;
    private int disPrice = 0;

    private final StringBuilder sb = new StringBuilder();
    private String[][] twoAry;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox_toggle);
        cbSnare = findViewById(R.id.cbSnare);
        cbIron = findViewById(R.id.cbIron);
        cbEmperor = findViewById(R.id.cbEmperor);
        cbAudio = findViewById(R.id.cbAudio);
        tgDiscount = findViewById(R.id.tgDiscount);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        btnTotal = findViewById(R.id.btnTotal);
        btnDis = findViewById(R.id.btnDis);
        etDisKey = findViewById(R.id.etDisKey);
        tvDis = findViewById(R.id.tvDiscount);
        twoDimen();
        btnTotal.setOnClickListener(this);
        btnDis.setOnClickListener(this);
        tgDiscount.setOnCheckedChangeListener(this);
    }
    private void twoDimen() {
        fileReading();
        String [] ary = sb.toString().split("\n");
        twoAry = new String[ary.length][];
        int rowCount = 0;
        for (String row : ary) {
            twoAry[rowCount++] = row.split("=");
        }
        cbSnare.setText(twoAry[0][0].trim());
        cbEmperor.setText(twoAry[1][0].trim());
        cbIron.setText(twoAry[2][0].trim());
        cbAudio.setText(twoAry[3][0].trim());
    }
    private void fileReading() {
        AssetManager as = getAssets();
        try {
            InputStream ip = as.open("price.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(ip));
            String line;
            while ((line =br.readLine()) != null) {
                sb.append(line+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onClick(View v) {
        price = 0;
        addingCheckItem(cbSnare);
        addingCheckItem(cbEmperor);
        addingCheckItem(cbIron);
        addingCheckItem(cbAudio);
        tvTotalPrice.setText(String.valueOf(changed(tgDiscount)));
        if (v.getId() == R.id.btnDis) {
            String key = etDisKey.getText().toString();
            if (key.contentEquals("12345")) {
                etDisKey.setVisibility(View.INVISIBLE);
                btnDis.setVisibility(View.INVISIBLE);
                tvDis.setVisibility(View.VISIBLE);
                tgDiscount.setVisibility(View.VISIBLE);
            } else if (key.isEmpty()) {
                BigToastMsg.bigToastMsg(getApplicationContext(),"Insert Key!");
            } else {
                BigToastMsg.bigToastMsg(getApplicationContext(),"Wrong Key!");
            }
        }
    }

    private void addingCheckItem(CheckBox cb) {
        if (cb.isChecked())  {
            if (cb==cbSnare) {
                price += Integer.parseInt(twoAry[0][1].trim());
            } else  if (cb==cbEmperor) {
                price += Integer.parseInt(twoAry[1][1].trim());
            } else  if (cb==cbIron) {
                price += Integer.parseInt(twoAry[2][1].trim());
            } else  if (cb==cbAudio) {
                price += Integer.parseInt(twoAry[3][1].trim());
            }
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        changed(tgDiscount);
    }

    private int changed(ToggleButton tgDiscount) {
        if (tgDiscount.isChecked()) {
            disPrice = (int) (price - (price*0.2));
        } else {
            disPrice = price;
        }
        return disPrice;
    }
}
