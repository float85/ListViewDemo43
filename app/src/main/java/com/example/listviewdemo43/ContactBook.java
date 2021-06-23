package com.example.listviewdemo43;

public class ContactBook {
    String name;
    String address;
    String numberPhone;
    boolean blImgView;


    public ContactBook(String name, String address, String numberPhone, boolean blImgView) {
        this.name = name;
        this.address = address;
        this.numberPhone = numberPhone;
        this.blImgView = blImgView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public boolean isBlImgView() {
        return blImgView;
    }

    public void setBlImgView(boolean blImgView) {
        this.blImgView = blImgView;
    }
}
