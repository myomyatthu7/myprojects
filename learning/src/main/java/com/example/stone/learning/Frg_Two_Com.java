package com.example.stone.learning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frg_Two_Com extends Fragment {
    View v;
    TextView tvComTwo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.com_frg_two,container,false);
        tvComTwo = v.findViewById(R.id.tvComTwo);
        return v;
    }
    public void textChange(String msg) {
        tvComTwo.setText(msg);
    }
}
