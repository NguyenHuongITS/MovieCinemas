package com.example.nguyenhuongit.moviecinemas.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguyenhuongit.moviecinemas.Data.PaymentCard;
import com.example.nguyenhuongit.moviecinemas.R;

import java.util.ArrayList;
import java.util.List;

public class PaymentCardAdapter extends RecyclerView.Adapter<PaymentCardAdapter.MyViewHolder> {

    List<PaymentCard> paymentCardList = new ArrayList<>();
    Context context;
    LayoutInflater layoutInflater;
    int layout;

    public PaymentCardAdapter(Context context, int layout, List<PaymentCard> paymentCardList){
        this.context = context;
        this.layout = layout;
        this.paymentCardList = paymentCardList;
        layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_payment_card, parent, false);
        return new PaymentCardAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PaymentCard paymentCard = paymentCardList.get(position);
        holder.idCard.setText(paymentCard.getIdCard());
        holder.nameCard.setText(paymentCard.getNameCard());
        holder.dateCard.setText(paymentCard.getDateCard());
    }

    @Override
    public int getItemCount() {
        return paymentCardList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView idCard,nameCard, dateCard;
        public MyViewHolder(View itemView) {
            super(itemView);
            idCard = itemView.findViewById(R.id.txt_idCard);
            nameCard = itemView.findViewById(R.id.txt_nameCard);
            dateCard = itemView.findViewById(R.id.txt_dateCard);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Your Payment Card", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}
