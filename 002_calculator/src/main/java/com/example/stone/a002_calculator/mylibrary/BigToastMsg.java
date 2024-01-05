package com.example.stone.a002_calculator.mylibrary;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BigToastMsg {
    public static void bigToastMsg(Context context,String Msg) {
        Toast bigToast = Toast.makeText(context,Msg,Toast.LENGTH_SHORT);
//        LinearLayout rout = (LinearLayout) bigToast.getView();
//        TextView tvToast = (TextView) rout.getChildAt(0);
//        tvToast.setTextSize(25);
//        tvToast.setGravity(Gravity.CENTER);
        bigToast.show();
    }
}
