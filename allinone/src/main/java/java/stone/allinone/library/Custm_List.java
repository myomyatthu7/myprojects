package java.stone.allinone.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.stone.allinone.R;
import java.util.ArrayList;

public class Custm_List extends BaseAdapter  {
    Context context;
    ArrayList<String>firstAry;
    ArrayList<String >secAry;
    public Custm_List(Context context, ArrayList<String>firstAry) {
        this.context = context;
        this.firstAry = firstAry;
    }
    public Custm_List(Context context, ArrayList<String>firstAry,ArrayList<String>secAry)  {
        this.context = context;
        this.firstAry = firstAry;
        this.secAry = secAry;
    }
    @Override
    public int getCount() {
        return firstAry.size();
    }

    @Override
    public Object getItem(int position) {
        return firstAry.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.ctm_ls_view,parent,false);
        }
        TextView tvWord = convertView.findViewById(R.id.tvWord);
        TextView tvPho = convertView.findViewById(R.id.tvPho);
        tvWord.setText(firstAry.get(position));
        tvPho.setText(secAry.get(position));
        return convertView;
    }
}
