package com.example.stone.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frg_Two_C extends Fragment {
    TextView tvFrgTwo;
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frg_two,container,false);
        tvFrgTwo = v.findViewById(R.id.tvFrgTwo);
        return v;
    }
    public void textChange(String msg) {
        tvFrgTwo.setText(msg);
    }
}
