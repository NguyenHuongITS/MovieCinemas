package com.example.nguyenhuongit.moviecinemas.Data;

public class OpenThisWeek {
    public int image_otw;

    public OpenThisWeek(int image_otw, String text_otw) {
        this.image_otw = image_otw;
        this.text_otw = text_otw;
    }

    public int getImage_otw() {
        return image_otw;
    }

    public void setImage_otw(int image_otw) {
        this.image_otw = image_otw;
    }

    public String getText_otw() {
        return text_otw;
    }

    public void setText_otw(String text_otw) {
        this.text_otw = text_otw;
    }

    public String text_otw;
}
