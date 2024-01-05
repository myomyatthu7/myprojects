package com.example.stone.a002_calculator.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stone.a002_calculator.R;

import java.util.zip.Inflater;

public class MyCustomList extends BaseAdapter {
    private Context context;
    private String [] ary;
    private int [] image = {R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,
                R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,
                R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,
                R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java};
    public MyCustomList(Context context,String []ary) {
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

            LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lf.inflate(R.layout.activity_custom_list,null);
            ImageView iv = convertView.findViewById(R.id.ivJava);
            TextView tv = convertView.findViewById(R.id.tvJava);
            iv.setImageResource(image[position]);
            tv.setText(ary[position]);
        return convertView;
    }

//    private Context context;
//    private String []ary;
//
//    private int [] image = {R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,
//            R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,
//            R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,
//            R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java};
//    public MyCustomList(Context context,String []ary) {
//        this.context = context;
//        this.ary = ary;
//    }
//    @Override
//    public int getCount() {
//        return ary.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return ary[position];
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            LayoutInflater iF = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = iF.inflate(R.layout.activity_custom_list,null);
//        }
//        ImageView iv = convertView.findViewById(R.id.ivJava);
//        TextView tv = convertView.findViewById(R.id.tvJava);
//        tv.setText(ary[position]);
//        iv.setImageResource(image[position]);
//        return convertView;
//    }

}
