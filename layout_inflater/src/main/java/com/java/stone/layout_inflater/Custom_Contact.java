package com.java.stone.layout_inflater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ViewUtils;

public class Custom_Contact extends ArrayAdapter<String> {


    String []name;
    String []num;
    Context context;
    public Custom_Contact(@NonNull Context context,String[]name,String[]num) {
        super(context,R.layout.ctm_contact_lst,R.id.tvName,name);
        this.name = name;
        this.num = num;
        this.context = context;
    }
    public static class ViewHolder{
        TextView tvName,tvNum;
        ViewHolder(View view) {
            tvName = view.findViewById(R.id.tvName);
            tvNum = view.findViewById(R.id.tvNum);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ViewHolder vHolder;
        if (v==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.ctm_contact_lst, parent, false);
            vHolder = new ViewHolder(v);
            v.setTag(vHolder);
        } else {
            vHolder = (ViewHolder) v.getTag();
        }
//        TextView tvName = v.findViewById(R.id.tvName);
//        TextView tvNum = v.findViewById(R.id.tvNum);
        vHolder.tvName.setText(name[position]);
        vHolder.tvNum.setText(num[position]);
        return v;
    }
}
