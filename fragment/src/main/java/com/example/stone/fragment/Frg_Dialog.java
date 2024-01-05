package com.example.stone.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.stone.fragment.library.ToastMessage;

public class Frg_Dialog extends DialogFragment implements View.OnClickListener {
//    View v;
//    Button btnYes,btnNo;
//    buttonClickListener bcl;
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        v = inflater.inflate(R.layout.frg_dialog,container);
//        setCancelable(false);
//        getDialog().setTitle("Hellooooo");
//        if (getShowsDialog()) {
//            Toast.makeText(getActivity(), "Showing Dialog", Toast.LENGTH_SHORT).show();
//        }
//        btnYes = v.findViewById(R.id.btnYes);
//        btnNo = v.findViewById(R.id.btnNo);
//        return v;
//    }
//
//    @Override
//    public void onAttach(@NonNull Activity activity) {
//        super.onAttach(activity);
//        bcl = (buttonClickListener) activity;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        btnYes.setOnClickListener(this);
//        btnNo.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        if (v.getId() == R.id.btnYes) {
//            bcl.textChange("You clicked YES!");
//            dismiss();
//        } else if (v.getId() == R.id.btnNo) {
//            bcl.textChange("You clicked No!");
//            dismiss();
//        }
//    }
//    public interface buttonClickListener {
//        void textChange(String msg);
//    }


    View v;
    Button btnYes,btnNo;
    clickListener clickListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frg_dialog,container);
        btnYes = v.findViewById(R.id.btnYes);
        btnNo = v.findViewById(R.id.btnNo);
//        if (getShowsDialog()) {
//            ToastMessage.toastMsg(getContext(),String.valueOf(getDialog()));
//        }
        getDialog().setTitle("Are you developer?");
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        getDialog().addContentView(v,params);
        getDialog().setCancelable(false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        clickListener = (Frg_Dialog.clickListener) getContext();
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnYes) {
            clickListener.buttonClick("Button Clicked YES");

        } else if (v.getId() == R.id.btnNo){
            clickListener.buttonClick("Button Clicked No");
        }
        dismiss();
    }

    interface clickListener {
        void buttonClick(String msg);
    }
}
