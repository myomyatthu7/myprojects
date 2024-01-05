package com.example.stone.a002_calculator.list;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stone.a002_calculator.R;
import com.example.stone.a002_calculator.mylibrary.BigToastMsg;

import java.util.ArrayList;

public class MyListView1 extends AppCompatActivity {

    ListView listView;
    String [] ary;

    TypedArray aryIcon;
    ArrayList<ItemGenerator>itemGenerator;
    MyCustomList1 myCustomList1;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.lvLanguage);
        ary = getResources().getStringArray(R.array.list_language);
        aryIcon = getResources().obtainTypedArray(R.array.icon_list);
        itemGenerator = new ArrayList<>();
        itemGenerator.add(new ItemGenerator(ary[0],aryIcon.getResourceId(0,-1)));
        itemGenerator.add(new ItemGenerator(ary[1],aryIcon.getResourceId(1,-1),true,"5"));
        itemGenerator.add(new ItemGenerator(ary[2],aryIcon.getResourceId(2,-1),true,"10"));
        itemGenerator.add(new ItemGenerator(ary[3],aryIcon.getResourceId(3,-1)));
        itemGenerator.add(new ItemGenerator(ary[4],aryIcon.getResourceId(4,-1)));
        itemGenerator.add(new ItemGenerator(ary[5],aryIcon.getResourceId(5,-1),true,"35"));
        itemGenerator.add(new ItemGenerator(ary[6],aryIcon.getResourceId(6,-1)));
        itemGenerator.add(new ItemGenerator(ary[7],aryIcon.getResourceId(7,-1),true,"45"));
        itemGenerator.add(new ItemGenerator(ary[8],aryIcon.getResourceId(8,-1)));
        itemGenerator.add(new ItemGenerator(ary[9],aryIcon.getResourceId(9,-1),true,"24"));
        itemGenerator.add(new ItemGenerator(ary[10],aryIcon.getResourceId(10,-1),true,"17"));
        itemGenerator.add(new ItemGenerator(ary[11],aryIcon.getResourceId(11,-1),true,"11"));
        itemGenerator.add(new ItemGenerator(ary[12],aryIcon.getResourceId(12,-1)));
        itemGenerator.add(new ItemGenerator(ary[13],aryIcon.getResourceId(13,-1)));
        itemGenerator.add(new ItemGenerator(ary[14],aryIcon.getResourceId(14,-1)));
        itemGenerator.add(new ItemGenerator(ary[15],aryIcon.getResourceId(15,-1),true,"2"));
        itemGenerator.add(new ItemGenerator(ary[16],aryIcon.getResourceId(16,-1)));
        itemGenerator.add(new ItemGenerator(ary[17],aryIcon.getResourceId(17,-1),true,"7"));
        itemGenerator.add(new ItemGenerator(ary[18],aryIcon.getResourceId(18,-1),true,"99+"));

        myCustomList1 = new MyCustomList1(MyListView1.this,itemGenerator);
        listView.setAdapter(myCustomList1);
        listView.setOnItemClickListener(new ListViewListener());
    }

    private class ListViewListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            BigToastMsg.bigToastMsg(getApplicationContext(),String.valueOf(position));
        }
    }
}
