package com.example.stone.learning.custom_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stone.learning.R;

import java.util.ArrayList;

public class My_Custom_Dictionary_List extends BaseAdapter {
    Context context;
    ArrayList<String>wordsAryList;
    ArrayList<String>phoneticAryList;
    public My_Custom_Dictionary_List(Context context, ArrayList<String>wordsAryList,ArrayList<String>phoneticAryList) {
        this.context = context;
        this.wordsAryList = wordsAryList;
        this.phoneticAryList = phoneticAryList;
    }
    @Override
    public int getCount() {
        return wordsAryList.size();
    }

    @Override
    public Object getItem(int position) {
        return wordsAryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lf.inflate(R.layout.dictionary_textview, null);
        }
        TextView tvDic = convertView.findViewById(R.id.tvDic);
        TextView tvMya = convertView.findViewById(R.id.tvMya);
        tvDic.setText(wordsAryList.get(position));
        tvMya.setText(phoneticAryList.get(position));
        return convertView;
    }
}