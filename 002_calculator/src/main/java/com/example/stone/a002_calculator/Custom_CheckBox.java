package com.example.stone.a002_calculator;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
import java.io.StreamTokenizer;

public class Custom_CheckBox extends AppCompatActivity implements View.OnClickListener {
    private CheckBox cbSnare,cbIron,cbEmperor,cbAudio;
    private ToggleButton tgDiscount;
    private TextView tvTotalPrice,tvDis;
    private EditText etDisKey;

    private Button btnTotal,btnDis;
    private int price = 0;
    private double disPrice = 0;

    private final StringBuilder sb = new StringBuilder();
    private String[][] twoAry;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_checkbox_toggle);

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
    }

    private void twoDimen() {
        fileReading();
        String []ary = sb.toString().split("\n");
        twoAry = new String[ary.length][];
        int rowCount = 0;
        for (String row : ary) {
            twoAry[rowCount++] = row.split("=");
        }
        cbSnare.setText(twoAry[0][0]);
        cbIron.setText(twoAry[1][0]);
        cbEmperor.setText(twoAry[2][0]);
        cbAudio.setText(twoAry[3][0]);
    }
    private void fileReading() {
        AssetManager asm = getAssets();
        try {
            InputStream is = asm.open("price.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine())!= null) {
                sb.append(line).append("\n");
               // sb.append(line+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void onClick(View v) {
        price = 0;
        addingCheckedItems(cbSnare);
        addingCheckedItems(cbIron);
        addingCheckedItems(cbEmperor);
        addingCheckedItems(cbAudio);
        BigToastMsg.bigToastMsg(this,String.valueOf(price));
    }
    private void addingCheckedItems(CheckBox cb) {
        if (cb.isChecked()) {
            if (cb == cbSnare) {
                price += Integer.parseInt(twoAry[0][1].trim());
            } else if (cb == cbIron) {
                price += Integer.parseInt(twoAry[1][1].trim());
            } else if (cb == cbEmperor) {
                price += Integer.parseInt(twoAry[2][1].trim());
            } else if (cb == cbAudio) {
                price += Integer.parseInt(twoAry[3][1].trim());
            }
        }
    }
}
