package com.example.stone.learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stone.learning.custom_list.My_Custom_Dictionary_List;
import com.example.stone.learning.custom_list.My_Custom_Lesson_List;
import com.example.stone.learning.custom_list.My_Custom_List;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Video_List extends AppCompatActivity {
    ListView listView;
    String [] ary;
    My_Custom_Lesson_List my_custom_lesson_list;
    ArrayList<String>engLessonAry;

    int []aryEngLesson = {R.raw.one, R.raw.two, R.raw.three, R.raw.four, R.raw.five
            , R.raw.six, R.raw.seven, R.raw.eight, R.raw.nine, R.raw.ten
            , R.raw.eleven, R.raw.twelve, R.raw.thirteen, R.raw.fourteen, R.raw.fifteen,
            R.raw.sixteen, R.raw.seventeen, R.raw.eighteen, R.raw.nineteen, R.raw.twelve};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_list);
        engLessonAry = new ArrayList<>();
        listView = findViewById(R.id.lvLesson);
        ary = getResources().getStringArray(R.array.eng_video);
        engLessonAry.addAll(Arrays.asList(ary));
        //myCustomList = new My_Custom_List(Video_List.this,ary);
        my_custom_lesson_list = new My_Custom_Lesson_List(Video_List.this,engLessonAry);
        listView.setAdapter(my_custom_lesson_list);
        listView.setOnItemClickListener(new ItemClick());
    }

    public void Uri(String filePath) {
        Intent intent = new Intent(Video_List.this, Videos_Play.class);
        Bundle bn = new Bundle();
        bn.putString("eng_lesson",filePath);
        intent.putExtras(bn);
        startActivity(intent);
    }

    private class ItemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(Video_List.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            String filePath = "android.resource://com.example.stone.learning/"+aryEngLesson[position];
            Uri(filePath);
        }
    }
}
