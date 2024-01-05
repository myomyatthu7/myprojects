package com.example.stone.learning.custom_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stone.learning.Common_Words;
import com.example.stone.learning.Custom_Table_Layout;
import com.example.stone.learning.Dictionary;
import com.example.stone.learning.Frg_Host_Com;
import com.example.stone.learning.Host_Fragment;
import com.example.stone.learning.MainActivity;
import com.example.stone.learning.MyTabHost;
import com.example.stone.learning.MyViewFlipper;
import com.example.stone.learning.R;
import com.example.stone.learning.Table_Layout;
import com.example.stone.learning.Video_List;

import java.util.ArrayList;
import java.util.Arrays;

public class Main_List extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView mainListView;
    String []mainAry;
    ArrayList<String>arrayList = new ArrayList<>();
    My_Custom_List myCustomList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list);
        mainListView = findViewById(R.id.lvMain);
        mainAry = getResources().getStringArray(R.array.main_ary);
        arrayList.addAll(Arrays.asList(mainAry));
        myCustomList = new My_Custom_List(getApplicationContext(),arrayList);
        mainListView.setAdapter(myCustomList);
        mainListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Intent intentEngLesson = new Intent(Main_List.this, Video_List.class);
            startActivity(intentEngLesson);
        } else if (position == 1) {
            Intent intentDictionary = new Intent(Main_List.this, Dictionary.class);
            startActivity(intentDictionary);
        } else if (position == 3) {
            Intent intentTapHost = new Intent(Main_List.this, MyTabHost.class);
            startActivity(intentTapHost);
        } else if (position == 4) {
            Intent intentViewFlip = new Intent(Main_List.this, MyViewFlipper.class);
            startActivity(intentViewFlip);
        } else if (position == 5) {
            Intent intentTable = new Intent(Main_List.this, Custom_Table_Layout.class);
            startActivity(intentTable);
        } else if (position == 6) {
            Intent intentCommonWord = new Intent(Main_List.this, Common_Words.class);
            startActivity(intentCommonWord);
        } else if (position == 7) {
            Intent intentCusGrid = new Intent(Main_List.this, Custom_Grid_Layout.class);
            startActivity(intentCusGrid);
        }  else if (position == 8) {
            Intent intentFragment = new Intent(Main_List.this, Host_Fragment.class);
            startActivity(intentFragment);
        } else if (position == 9) {
            Intent intentFrgCom = new Intent(Main_List.this, Frg_Host_Com.class);
            startActivity(intentFrgCom);
        } else if (position == 10) {
            Intent intentMp = new Intent(Main_List.this, MainActivity.class);
            startActivity(intentMp);
        } else if (position == 11) {
            Intent intentNorLs = new Intent(Main_List.this, Normal_List.class);
            startActivity(intentNorLs);
        } else if (position == 12) {
            Intent intentActLs = new Intent(Main_List.this, Activity_List.class);
            startActivity(intentActLs);
        }
    }
}
