package com.example.nguyenhuongit.moviecinemas.View.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguyenhuongit.moviecinemas.Adapter.AddPaymentCardAdapter;
import com.example.nguyenhuongit.moviecinemas.Adapter.PaymentCardAdapter;
import com.example.nguyenhuongit.moviecinemas.Data.AddPayMentCard;
import com.example.nguyenhuongit.moviecinemas.Data.PaymentCard;
import com.example.nguyenhuongit.moviecinemas.R;

import java.util.ArrayList;
import java.util.List;

public class DetailsMoviesActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView txt_title_banner, txt_details_cinemas, txt_details_date, txt_details_seats, txt_back_home;
    public ImageView image_title_banner;
    public TextView button_confirm;

    //payment card
    RecyclerView recyclerView_payment;
    PaymentCardAdapter paymentCardAdapter;
    List<PaymentCard> paymentCardList = new ArrayList<>();

    //add payment card
    RecyclerView recyclerView_add_payment;
    AddPaymentCardAdapter addPaymentCardAdapter ;
    List<AddPayMentCard> addPayMentCardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movies);
        //hide action bar
        HideActionbar();
        //Ánh xạ
        Mapping();
        //Lấy dữ liệu intent
        DataGetIntent();
        //event click
        ControlClickEvent();
        //Payment card
        DataPaymentCard();
        //add payment card
        DataAddPaymentCard();
    }

    private void Mapping() {
        image_title_banner = findViewById(R.id.image_details_avatar);
        txt_title_banner = findViewById(R.id.txt_details_banner);
        button_confirm = findViewById(R.id.btn_confirm_pay);
        txt_details_cinemas = findViewById(R.id.txt_cinemas_details);
        txt_details_date = findViewById(R.id.txt_date_details);
        txt_details_seats = findViewById(R.id.txt_seats_details);
        txt_back_home = findViewById(R.id.txt_back_home);
        recyclerView_payment = findViewById(R.id.recycleview_payment_card);
        recyclerView_add_payment = findViewById(R.id.recycleview_add_payment_card);
    }

    private void DataGetIntent() {
        Intent intent = getIntent();
        int id_movies =  intent.getIntExtra("image_movies",0);
        String title_movies = intent.getStringExtra("title_movies");
        image_title_banner.setImageResource(id_movies);
        txt_title_banner.setText(title_movies);
    }

    private void HideActionbar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void ControlClickEvent() {
        button_confirm.setOnClickListener(this);
        txt_details_cinemas.setOnClickListener(this);
        txt_details_date.setOnClickListener(this);
        txt_details_seats.setOnClickListener(this);
        txt_back_home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm_pay:
                Toast.makeText(this, "This item confirm your choose", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_cinemas_details:
                Toast.makeText(this, "This item cinemas your choose", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_date_details:
                Toast.makeText(this, "This item date your choose", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_seats_details:
                Toast.makeText(this, "This item seats your choose", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_back_home:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void DataPaymentCard() {
        //DATA
        PaymentCard paymentCard = new PaymentCard("XXXX XXXX XXXX XXXX","CUSTOMER","12/22");
        paymentCardList.add(paymentCard);

        //SET RECYCLEVIEW
        paymentCardAdapter = new PaymentCardAdapter(getApplicationContext(),R.layout.item_payment_card,paymentCardList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_payment.setLayoutManager(linearLayoutManager);
        recyclerView_payment.setItemAnimator(new DefaultItemAnimator());
        recyclerView_payment.setAdapter(paymentCardAdapter);
        paymentCardAdapter.notifyDataSetChanged();
    }

    private void DataAddPaymentCard() {
        //DATA
        AddPayMentCard addPayMentCard = new AddPayMentCard(R.drawable.icon_add_payment_card,"Add a Payment Card");
        addPayMentCardList.add(addPayMentCard);

        //SET RECYCLEVIEW
        addPaymentCardAdapter = new AddPaymentCardAdapter(getApplicationContext(),R.layout.item_add_payment_card,addPayMentCardList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_add_payment.setLayoutManager(linearLayoutManager);
        recyclerView_add_payment.setItemAnimator(new DefaultItemAnimator());
        recyclerView_add_payment.setAdapter(addPaymentCardAdapter);
        addPaymentCardAdapter.notifyDataSetChanged();


    }
}
