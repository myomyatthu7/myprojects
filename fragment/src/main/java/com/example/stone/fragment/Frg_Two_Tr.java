package com.example.stone.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.stone.fragment.library.ToastMessage;

public class Frg_Two_Tr extends Fragment {
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onAttach2 !");
        v = inflater.inflate(R.layout.frg_two_tran,container,false);
        return v;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        ToastMessage.toastMsg(context,"Fragment 2: onAttach2 !");
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onCreate !");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onActivityCreated !");
    }

    @Override
    public void onStart() {
        super.onStart();
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onStart !");
    }

    @Override
    public void onResume() {
        super.onResume();
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onResume !");
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onResume !");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onViewCreated !");
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onCreateOptionsMenu !");
    }

    @Override
    public void onPause() {
        super.onPause();
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onPause !");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onSaveInstanceState !");
    }

    @Override
    public void onStop() {
        super.onStop();
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onStop !");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onDestroyView !");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onDestroy !");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        ToastMessage.toastMsg(getActivity(),"Fragment 2: onDetach !");
    }
}
