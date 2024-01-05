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

public class Frg_2 extends Fragment implements View.OnClickListener {
    View v;
    TextView tvFrg2;
    Button btnFrg2;
    customClickListener clickListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frg_2,container,false);
        tvFrg2 = v.findViewById(R.id.tvFrg2);
        btnFrg2 = v.findViewById(R.id.btnFrg2);
        return v;
    }
    public void textChange(String str) {
        tvFrg2.setText(str);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        clickListener = (customClickListener) getActivity();
        btnFrg2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        clickListener.buttonClick("Button Two Click");
    }
}
