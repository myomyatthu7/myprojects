package com.example.stone.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frg_1 extends Fragment implements View.OnClickListener {
    View v;
    customClickListener clickListener;
    Button btnFrg1;
    TextView tvFrg1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frg_1,container,false);
        btnFrg1 = v.findViewById(R.id.btnFrg1);
        tvFrg1 = v.findViewById(R.id.tvFrg1);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        clickListener = (customClickListener) getActivity();
        btnFrg1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        clickListener.buttonClick("Button One Click");
    }

    public void textChange(String str) {
        tvFrg1.setText(str);
    }
}
interface customClickListener {
    void buttonClick(String str);
}

