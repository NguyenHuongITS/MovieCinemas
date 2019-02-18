package com.example.nguyenhuongit.moviecinemas.Data;

public class ComingSoon {

    public ComingSoon(int image_cs, String text_cs) {
        this.image_cs = image_cs;
        this.text_cs = text_cs;
    }

    public int getImage_cs() {
        return image_cs;
    }

    public void setImage_cs(int image_cs) {
        this.image_cs = image_cs;
    }

    public String getText_cs() {
        return text_cs;
    }

    public void setText_cs(String text_cs) {
        this.text_cs = text_cs;
    }

    public int image_cs;
    public String text_cs;
}
