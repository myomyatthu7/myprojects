package com.example.stone.fragment.library;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ToastMessage {
    public static void toastMsg(Context context,String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
