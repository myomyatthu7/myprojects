package stone.dhamma.channel.dhammachannel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private final List<MyData> dataList;
    private final Context context;
//    public void setSearchList(List<MyData>searchList) {
//        this.dataList = searchList;
//        notifyDataSetChanged();
//    }

    protected MyAdapter(List<MyData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_dhamma,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
       // holder.imageView.setImageResource(dataList.get(position).getImage());
        holder.tvTitle.setText(dataList.get(position).getTitle());
       // holder.tvDesc.setText(dataList.get(position).getDec());
        holder.tvTitle.setOnClickListener(v -> {
            Intent i = new Intent(context,Detail.class);
            i.putExtra("Title",dataList.get(holder.getAdapterPosition()).getTitle());
           // i.putExtra("Image",dataList.get(holder.getAdapterPosition()).getImage());
            i.putExtra("Desc",dataList.get(holder.getAdapterPosition()).getDec());
            i.putExtra("Uri",dataList.get(holder.getAdapterPosition()).getUri());
            i.putExtra("Translate",dataList.get(holder.getAdapterPosition()).getTranslate());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final Button tvTitle;
      //  ImageView imageView;
     //   CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        //    imageView = itemView.findViewById(R.id.image);
        //    cardView = itemView.findViewById(R.id.cardView);
        //    tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }
}
