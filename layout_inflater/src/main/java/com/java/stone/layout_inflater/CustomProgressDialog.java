package com.java.stone.layout_inflater;

import android.app.Dialog;
import android.content.Context;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

public class CustomProgressDialog extends Dialog {

    protected CustomProgressDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        WindowManager.LayoutParams params = Objects.requireNonNull(getWindow()).getAttributes();
        params.gravity = Gravity.CENTER_HORIZONTAL;
        getWindow().setAttributes(params);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.from(context).inflate(R.layout.cut_pro_dia,null);
        setContentView(v);
    }
}
