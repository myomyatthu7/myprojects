package java.stone.allinone.project2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.stone.allinone.R;
import java.util.ArrayList;

public class CustomNoteAdapter extends RecyclerView.Adapter<CustomNoteAdapter.ViewHolder> {
    Context context;
    ArrayList<String>id,title,des,dateTime;
    Animation list_anim;

    public CustomNoteAdapter(Context context, ArrayList<String>id,
                             ArrayList<String>title,ArrayList<String>des,ArrayList<String>dateTime) {
        this.context = context;
        this.id = id;
        this.title = title;
        this.des = des;
        this.dateTime = dateTime;
    }
    @NonNull
    @Override
    public CustomNoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.ctm_note_ls,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomNoteAdapter.ViewHolder holder, int position) {
        holder.tvId.setText(String.valueOf(id.get(position)));
        holder.tvTitle.setText(String.valueOf(title.get(position)));
        holder.tvDes.setText(String.valueOf(des.get(position)));
        holder.tvDateTime.setText(String.valueOf(dateTime.get(position)));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Update_Note.class);
                intent.putExtra("id",String.valueOf(id.get(holder.getAdapterPosition())));
                intent.putExtra("title",String.valueOf(title.get(holder.getAdapterPosition())));
                intent.putExtra("des",String.valueOf(des.get(holder.getAdapterPosition())));
                intent.putExtra("dateTime",String.valueOf(dateTime.get(holder.getAdapterPosition())));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId,tvTitle,tvDes,tvDateTime;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDes = itemView.findViewById(R.id.tvDes);
            tvDateTime = itemView.findViewById(R.id.tvDateTime);
            cardView = itemView.findViewById(R.id.cardView);
            list_anim = AnimationUtils.loadAnimation(context,R.anim.list_anim);
            cardView.setAnimation(list_anim);
        }
    }
}
