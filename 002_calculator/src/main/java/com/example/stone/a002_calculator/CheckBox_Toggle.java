package com.example.stone.a002_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.stone.a002_calculator.mylibrary.BigToastMsg;
import java.util.Objects;

public class CheckBox_Toggle extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private CheckBox cbSnare,cbIron,cbEmperor,cbAudio;
    private ToggleButton tgDiscount;
    private TextView tvTotalPrice,tvDis;
    private EditText etDisKey;

    private Button btnTotal,btnDis;
    private int price = 0;
    private double disPrice = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox_toggle);
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.activity_custom_actionbar);

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

        tgDiscount.setOnCheckedChangeListener(this);
        //tgDiscount.set
        btnTotal.setOnClickListener(this);
        btnDis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        price = 0;
        addingCheckedItem(cbSnare);
        addingCheckedItem(cbIron);
        addingCheckedItem(cbEmperor);
        addingCheckedItem(cbAudio);
        if(v.getId()==R.id.btnDis) {
            String key = etDisKey.getText().toString();
            if (key.isEmpty()) {
                BigToastMsg.bigToastMsg(getApplicationContext(),"No Key");
            } else if (key.contentEquals("12345")) {
                btnDis.setVisibility(View.INVISIBLE);
                etDisKey.setVisibility(View.INVISIBLE);
                tgDiscount.setVisibility(View.VISIBLE);
                tvDis.setVisibility(View.VISIBLE);
            } else {
                BigToastMsg.bigToastMsg(getApplicationContext(),"Wrong Key");
            }
        } else if (v.getId() == R.id.btnTotal) {
            tvTotalPrice.setText(String.valueOf(checked(tgDiscount)));
        }
    }

    private void addingCheckedItem(CheckBox cb) {
        if (cb.isChecked()) {
            String []cbArray = cb.getText().toString().split(" ");
            price += Integer.parseInt(cbArray[cbArray.length-1]);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
       checked(tgDiscount);
    }

    public double checked(ToggleButton tg) {
        if (tg.isChecked()) {
            disPrice = price - (price*0.2);
        } else {
            disPrice = price;
        }
        return disPrice;
    }


//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.btnTotal) {
//            price = 0;
//            addingCheckedItems(cbSnare);
//            addingCheckedItems(cbIron);
//            addingCheckedItems(cbEmperor);
//            addingCheckedItems(cbAudio);
//            tvTotalPrice.setText(String.valueOf(checked(tgDiscount)));
//        } else if (v.getId() == R.id.btnDis) {
//            String checkKey = etDisKey.getText().toString();
//            if (checkKey.isEmpty()) {
//                BigToastMsg.bigToastMsg(this,"Key!!");
//                //BigToastMsg.bigToastMsg(this,sf.toString());
//            } else if (checkKey.contentEquals("12345")){
//                BigToastMsg.bigToastMsg(this,"Success");
//                tvDis.setVisibility(View.VISIBLE);
//                btnDis.setVisibility(View.INVISIBLE);
//                tgDiscount.setVisibility(View.VISIBLE);
//                etDisKey.setVisibility(View.INVISIBLE);
//            } else {
//                BigToastMsg.bigToastMsg(this,"Wrong Key");
//            }
//        }

//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        price = 0;
//        addingCheckedItems(cbSnare);
//        addingCheckedItems(cbIron);
//        addingCheckedItems(cbEmperor);
//        addingCheckedItems(cbAudio);
//        String totalPrice = String.valueOf(price);
//        tvTotalPrice.setText(totalPrice);
//    }


//    private void addingCheckedItems(CheckBox cb) {
//        if (cb.isChecked()) {
//            String []itemsAry = cb.getText().toString().split(" ");
//            price += Integer.parseInt(itemsAry[itemsAry.length-1]);
//        }
//    }

//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        checked(tgDiscount);
//    }
//    private double checked(ToggleButton tg) {
//        if (tg.isChecked()) {
//            disPrice =  price - (price * 0.2);
//        } else {
//            disPrice = price;
//        }
//        return disPrice;
//    }
}
