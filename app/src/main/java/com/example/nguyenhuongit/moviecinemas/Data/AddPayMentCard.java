package com.example.nguyenhuongit.moviecinemas.Data;

import android.widget.ImageView;
import android.widget.TextView;

public class AddPayMentCard {
    int imageView_add;

    public AddPayMentCard(int imageView_add, String textView_add) {
        this.imageView_add = imageView_add;
        this.textView_add = textView_add;
    }

    public int getImageView_add() {
        return imageView_add;
    }

    public void setImageView_add(int imageView_add) {
        this.imageView_add = imageView_add;
    }

    public String getTextView_add() {
        return textView_add;
    }

    public void setTextView_add(String textView_add) {
        this.textView_add = textView_add;
    }

    String textView_add;
}
