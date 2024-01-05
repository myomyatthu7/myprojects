package com.example.stone.a002_calculator.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stone.a002_calculator.Cycle_Activity;
import com.example.stone.a002_calculator.R;
import com.example.stone.a002_calculator.mylibrary.BigToastMsg;

import java.util.List;

public class MyListView extends AppCompatActivity {

    private ListView listView;
    private String [] ary;

    MyCustomList mcl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
//        listView = findViewById(R.id.lvLanguage);
//        ary = getResources().getStringArray(R.array.list);
//        listView.setAdapter(new ArrayAdapter<String>(MyListView.this, android.R.layout.simple_list_item_1,ary));
//        listView.setOnItemClickListener(new Stone());

//        listView = findViewById(R.id.lvLanguage);
//        ary = getResources().getStringArray(R.array.list);
//        mcl = new MyCustomList(MyListView.this,ary);
//        listView.setAdapter(mcl);


        listView = findViewById(R.id.lvLanguage);
        ary = getResources().getStringArray(R.array.list_language);
        mcl = new MyCustomList(MyListView.this,ary);
        listView.setAdapter(mcl);
        listView.setOnItemClickListener(new Stone());
        // own
        //listView.setAdapter(new ArrayAdapter<String>(MyListView.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,ary));
    }

    private class Stone implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (ary[position].contentEquals("Java")) {
                Intent iJava = new Intent(MyListView.this,Cycle_Activity.class);
                startActivity(iJava);
            }
        }
    }

//    private class Stone implements AdapterView.OnItemClickListener {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            BigToastMsg.bigToastMsg(getApplicationContext(),String.valueOf(id));
//            if (ary[position].contentEquals("Java")) {
//                Intent iBall = new Intent(MyListView.this,Cycle_Activity.class);
//                startActivity(iBall);
//            }
//        }
//    }
}
