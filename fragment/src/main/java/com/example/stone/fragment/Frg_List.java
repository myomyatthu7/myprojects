package com.example.stone.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.viewmodel.CreationExtras;

import java.util.Objects;

public class Frg_List extends ListFragment {
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frg_list,container,false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

//    @NonNull
//    @Override
//    public CreationExtras getDefaultViewModelCreationExtras() {
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireActivity(),
//                R.array.Fragments, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
//        setListAdapter(adapter);
//        return super.getDefaultViewModelCreationExtras();
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.list_language, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        setListAdapter(arrayAdapter);
    }
}
