package com.example.stone.learning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frg_One_Com extends Fragment implements View.OnClickListener {
    View v;
    TextView  tvComOne;
    Button btnComOne;
    customButtonClickListener buttonClickListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.com_frg_one,container,false);
        btnComOne = v.findViewById(R.id.btnComOne);
        btnComOne.setOnClickListener(this);
        btnComOne.setOnClickListener(this);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        buttonClickListener = (customButtonClickListener) getActivity();
    }

    @Override
    public void onClick(View v) {
        buttonClickListener.getButtonClick("Button One Clicked");
    }

    interface customButtonClickListener {
        void getButtonClick(String msg);
    }
}
