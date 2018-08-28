package com.example.android.a201808_12_spinner;

public class Coffee {
    private String title;
    private int price;
    private int img_resource_id;

    // Constructor
    public Coffee(String title, int price, int img_resource_id) {
        this.title = title;
        this.price = price;
        this.img_resource_id = img_resource_id;
    }

    // getter setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getImg_resource_id() {
        return img_resource_id;
    }

    public void setImg_resource_id(int img_resource_id) {
        this.img_resource_id = img_resource_id;
    }

    @Override
    public String toString(){
        return "Coffee{" +
                "title='" + title + "\'" +
                ", price=" + price +
                ", img_resource_id=" + img_resource_id +
                "}";

    }

}
