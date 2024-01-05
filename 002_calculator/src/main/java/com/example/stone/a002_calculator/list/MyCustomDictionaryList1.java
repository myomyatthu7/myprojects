package com.example.stone.a002_calculator.list;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stone.a002_calculator.R;

import org.w3c.dom.Text;

public class MyCustomDictionaryList1 extends BaseAdapter {
    Context context;
    String[] ary;
    public MyCustomDictionaryList1(Context context,String[] ary) {
        this.context = context;
        this.ary = ary;
    }
    @Override
    public int getCount() {
        return ary.length;
    }
    @Override
    public Object getItem(int position) {
        return ary[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lf.inflate(R.layout.custom_dictionary_list,null);
        }
        TextView textView = convertView.findViewById(R.id.tvDictionarySearch);
        textView.setText(ary[position]);
        return convertView;
    }
}
