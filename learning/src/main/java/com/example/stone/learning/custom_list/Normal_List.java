package com.example.stone.learning.custom_list;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.stone.learning.R;

import java.lang.reflect.Array;

public class Normal_List extends Activity {
    String[] ary = {"Java","Kotlin","FireBase","Sql","Github"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nor_ls);
        ListView lv = findViewById(R.id.lvNor);
        ArrayAdapter<String>arrayAdapter = new ArrayAdapter<>(getApplication(),
                android.R.layout.simple_list_item_1,ary);
        lv.setAdapter(arrayAdapter);
    }
}
