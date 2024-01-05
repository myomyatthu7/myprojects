package com.example.stone.a002_calculator.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stone.a002_calculator.R;

import java.util.ArrayList;

public class MyCustomDictionaryList extends BaseAdapter {
    Context context;
    ArrayList<String>arrayList;
    public MyCustomDictionaryList(Context context, ArrayList<String>arrayList) {
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lf.inflate(R.layout.custom_dictionary_list,null);
        }
        TextView tvDictionarySearch = convertView.findViewById(R.id.tvDictionarySearch);
        tvDictionarySearch.setText(arrayList.get(position));
        return convertView;
    }
}
