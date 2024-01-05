package com.example.stone.learning.custom_list;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.stone.learning.R;

public class Activity_List extends ListActivity {
    String[] ary = {"Java","Kotlin","FireBase","Sql","Github"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_ls);
        getListView();

        ArrayAdapter<String >arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,ary);
        setListAdapter(arrayAdapter);
    }
}
