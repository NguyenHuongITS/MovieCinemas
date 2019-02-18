package com.example.nguyenhuongit.moviecinemas.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguyenhuongit.moviecinemas.Data.ComingSoon;
import com.example.nguyenhuongit.moviecinemas.R;
import com.example.nguyenhuongit.moviecinemas.View.Activity.DetailsMoviesActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ComingSoonAdapter extends RecyclerView.Adapter<ComingSoonAdapter.MyViewHolder> {

    Context context;
    int layout;
    LayoutInflater layoutInflater;
    List<ComingSoon> comingSoonList = new ArrayList<>();

    //khai báo intent
    int image_id_movies;
    String title_movies;


    public ComingSoonAdapter(Context context, int layout, List<ComingSoon> comingSoonList){
        this.context = context;
        this.layout = layout;
        this.comingSoonList = comingSoonList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_movies_shows, parent, false);
        return new ComingSoonAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ComingSoon comingSoon = comingSoonList.get(position);
        holder.textView_cs.setText(comingSoon.getText_cs());
        Picasso.with(context).load(comingSoon.getImage_cs()).into(holder.imageView_cs);
    }

    @Override
    public int getItemCount() {
        return comingSoonList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView_cs;
        public TextView textView_cs;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView_cs = itemView.findViewById(R.id.image_movies_shows);
            textView_cs = itemView.findViewById(R.id.txt_movies_shows);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //gửi dữ liệu qua activity khác
                    image_id_movies = comingSoonList.get(getAdapterPosition()).image_cs;
                    title_movies = comingSoonList.get(getAdapterPosition()).text_cs;
                    Intent intent = new Intent(context,DetailsMoviesActivity.class);
                    intent.putExtra("image_movies",image_id_movies);
                    intent.putExtra("title_movies",title_movies);
                    context.startActivity(intent);

                    //Toast.makeText(context, "This item your choose!!!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
