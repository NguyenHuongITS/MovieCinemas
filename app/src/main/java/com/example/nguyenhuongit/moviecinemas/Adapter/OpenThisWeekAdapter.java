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

import com.example.nguyenhuongit.moviecinemas.Data.OpenThisWeek;
import com.example.nguyenhuongit.moviecinemas.R;
import com.example.nguyenhuongit.moviecinemas.View.Activity.DetailsMoviesActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class OpenThisWeekAdapter extends RecyclerView.Adapter<OpenThisWeekAdapter.MyViewHolder> {

    List<OpenThisWeek> openThisWeekList = new ArrayList<>();
    Context context;
    LayoutInflater layoutInflater;
    int layout;
    //khai báo intent
    int image_id_movies;
    String title_movies;

    public OpenThisWeekAdapter(Context context,int layout, List<OpenThisWeek> openThisWeekList){
        this.context = context;
        this.layout = layout;
        this.openThisWeekList = openThisWeekList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_movies_shows, parent,false);
        return new OpenThisWeekAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OpenThisWeek openThisWeek =openThisWeekList.get(position);
        holder.textView_otw.setText(openThisWeek.getText_otw());
        Picasso.with(context).load(openThisWeek.getImage_otw()).into(holder.imageView_otw);
    }

    @Override
    public int getItemCount() {
        return openThisWeekList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView_otw;
        public TextView textView_otw;

        public MyViewHolder(View itemView) {
            super(itemView);
            //ánh xạ
            imageView_otw = itemView.findViewById(R.id.image_movies_shows);
            textView_otw = itemView.findViewById(R.id.txt_movies_shows);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //gửi dữ liệu qua activity khác
                    image_id_movies = openThisWeekList.get(getAdapterPosition()).image_otw;
                    title_movies = openThisWeekList.get(getAdapterPosition()).text_otw;
                    Intent intent = new Intent(context,DetailsMoviesActivity.class);
                    intent.putExtra("image_movies",image_id_movies);
                    intent.putExtra("title_movies",title_movies);
                    context.startActivity(intent);

                    //Toast.makeText(context, "This item your choose", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
