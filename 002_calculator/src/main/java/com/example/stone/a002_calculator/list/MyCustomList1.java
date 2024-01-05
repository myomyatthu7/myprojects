package com.example.stone.a002_calculator.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.stone.a002_calculator.R;

import java.util.ArrayList;

public class MyCustomList1 extends BaseAdapter {
    Context context;
    //String  []ary;

    ArrayList<ItemGenerator>itemGenerator;
//
//    private int [] image = {R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,
//            R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,
//            R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,R.drawable.java,
//            R.drawable.java,R.drawable.java,R.drawable.java};
    public MyCustomList1(Context context, ArrayList<ItemGenerator>itemGenerator) {
        this.context = context;
        //this.ary = ary;
        this.itemGenerator = itemGenerator;
    }
    @Override
    public int getCount() {
        return itemGenerator.size();
    }

    @Override
    public Object getItem(int position) {
        return itemGenerator.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.activity_custom_list,null);
        }
        TextView tv = convertView.findViewById(R.id.tvJava);
        TextView tvIconCount = convertView.findViewById(R.id.tvIconCount);
        ImageView imageView = convertView.findViewById(R.id.ivJava);
        tv.setText(itemGenerator.get(position).getLanguage());
        imageView.setImageResource(itemGenerator.get(position).getIcon());
        if (itemGenerator.get(position).isNoti()) {
            tvIconCount.setText(itemGenerator.get(position).getpCount());
        } else if (!itemGenerator.get(position).isNoti()) {
            tvIconCount.setVisibility(View.GONE);
        }

        return convertView;
    }
}
