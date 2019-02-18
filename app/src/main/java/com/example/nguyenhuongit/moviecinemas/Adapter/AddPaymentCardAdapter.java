package com.example.nguyenhuongit.moviecinemas.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguyenhuongit.moviecinemas.Data.AddPayMentCard;
import com.example.nguyenhuongit.moviecinemas.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AddPaymentCardAdapter extends RecyclerView.Adapter<AddPaymentCardAdapter.MyViewHolder> {
    List<AddPayMentCard> addPayMentCardList;
    Context context;
    LayoutInflater layoutInflater;
    int layout;

    public AddPaymentCardAdapter(Context context, int layout, List<AddPayMentCard> addPayMentCardList){
        this.context = context;
        this.layout = layout;
        this.addPayMentCardList = addPayMentCardList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_add_payment_card, parent, false);
        return new AddPaymentCardAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AddPayMentCard addPayMentCard =addPayMentCardList.get(position);
        holder.textView_add.setText(addPayMentCard.getTextView_add());
        Picasso.with(context).load(addPayMentCard.getImageView_add()).into(holder.imageView_add);
    }

    @Override
    public int getItemCount() {
        return addPayMentCardList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView_add;
        public TextView textView_add;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView_add = itemView.findViewById(R.id.image_add_card);
            textView_add = itemView.findViewById(R.id.txt_add_titleCard);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Add Payment Card", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
