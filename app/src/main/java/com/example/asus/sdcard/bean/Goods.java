package com.example.asus.sdcard.bean;

/**
 * Created by Asus on 2016/4/24.
 */
public class Goods {
    private int image;

    public Goods(String name) {
        this.name = name;
    }

    private String name;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Goods(int image, String name, int price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }
}
