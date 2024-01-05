package com.example.stone.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frg_One_C extends Fragment implements View.OnClickListener {
    View v;
    customButtonClickListener customButtonClickListener;
    Button btnFrgOne;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frg_one,container,false);
        btnFrgOne = v.findViewById(R.id.btnFrgOne);
        btnFrgOne.setOnClickListener(this);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        customButtonClickListener = (Frg_One_C.customButtonClickListener) getActivity();
    }

    @Override
    public void onClick(View v) {
        customButtonClickListener.buttonClick("Button One Clicked");
    }

    interface customButtonClickListener {
        void buttonClick(String msg);
    }
}
