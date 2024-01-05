package java.stone.allinone.project1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.stone.allinone.R;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<DataClass> dataList;
    Context context;
    List<DataClass> searchList;

    public void setSearchList(List<DataClass>searchList) {
        this.dataList = searchList;
        notifyDataSetChanged();
    }

    public MyAdapter(List<DataClass> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
       return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
//        holder.recImage.setImageResource(dataList.get(holder.getAdapterPosition()).getDataImage());
//        holder.recTitle.setText(dataList.get(holder.getAdapterPosition()).getDataTitle());
//        holder.recDesc.setText(dataList.get(holder.getAdapterPosition()).getDataDesc());
//        holder.recLang.setText(dataList.get(holder.getAdapterPosition()).getDataLang());
        holder.recImage.setImageResource(dataList.get(position).getDataImage());
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recDesc.setText(dataList.get(position).getDataDesc());
        holder.recLang.setText(dataList.get(position).getDataLang());
        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,DetailActivity.class);
                i.putExtra("Image",dataList.get(holder.getAdapterPosition()).getDataImage());
                i.putExtra("Title",dataList.get(holder.getAdapterPosition()).getDataTitle());
                i.putExtra("Desc",dataList.get(holder.getAdapterPosition()).getDataDesc());
                i.putExtra("Lang",dataList.get(holder.getAdapterPosition()).getDataLang());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView recImage;
        TextView recTitle,recDesc,recLang;
        CardView recCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recImage = itemView.findViewById(R.id.recImage);
            recTitle = itemView.findViewById(R.id.recTitle);
            recDesc = itemView.findViewById(R.id.recDesc);
            recLang = itemView.findViewById(R.id.recLang);
            recCard = itemView.findViewById(R.id.recCard);
        }
    }

//    private Context context;
//    private List<DataClass> dataList;
//
//    public void setSearchList(List<DataClass> dataSearchList){
//        this.dataList = dataSearchList;
//        notifyDataSetChanged();
//    }
//
//    public MyAdapter(Context context, List<DataClass> dataList){
//        this.context = context;
//        this.dataList = dataList;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//
//        holder.recImage.setImageResource(dataList.get(position).getDataImage());
//        holder.recTitle.setText(dataList.get(position).getDataTitle());
//        holder.recDesc.setText(dataList.get(position).getDataDesc());
//        holder.recLang.setText(dataList.get(position).getDataLang());
//
//        holder.recCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, DetailActivity.class);
//                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
//                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
//                intent.putExtra("Desc", dataList.get(holder.getAdapterPosition()).getDataDesc());
//                context.startActivity(intent);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataList.size();
//    }
//}
//
//class MyViewHolder extends RecyclerView.ViewHolder{
//
//    ImageView recImage;
//    TextView recTitle, recDesc, recLang;
//    CardView recCard;
//
//    public MyViewHolder(@NonNull View itemView) {
//        super(itemView);
//
//        recImage = itemView.findViewById(R.id.recImage);
//        recTitle = itemView.findViewById(R.id.recTitle);
//        recDesc = itemView.findViewById(R.id.recDesc);
//        recLang = itemView.findViewById(R.id.recLang);
//        recCard = itemView.findViewById(R.id.recCard);
//    }


}
