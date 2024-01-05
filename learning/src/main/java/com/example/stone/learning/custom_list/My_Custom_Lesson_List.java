package com.example.stone.learning.custom_list;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stone.learning.R;

import java.util.ArrayList;

public class My_Custom_Lesson_List extends BaseAdapter {
    private Context context;
    private ArrayList<String> arrayList;

    public My_Custom_Lesson_List(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lf.inflate(R.layout.video_lesson, null);
        }
        TextView tvMain = convertView.findViewById(R.id.tvLesson);
        tvMain.setText(arrayList.get(position));
        return convertView;
    }

}
