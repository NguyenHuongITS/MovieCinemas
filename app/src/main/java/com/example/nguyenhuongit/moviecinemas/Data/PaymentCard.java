package com.example.nguyenhuongit.moviecinemas.Data;

public class PaymentCard {
    String idCard;
    String nameCard;

    public PaymentCard(String idCard, String nameCard, String dateCard) {
        this.idCard = idCard;
        this.nameCard = nameCard;
        this.dateCard = dateCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public String getDateCard() {
        return dateCard;
    }

    public void setDateCard(String dateCard) {
        this.dateCard = dateCard;
    }

    String dateCard;
}
