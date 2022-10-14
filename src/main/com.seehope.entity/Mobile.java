package com.seehope.entity;

/**
 * @PACKAGE_NAME: com.seehope.entity
 * @Author XSH
 * @Date 2022-09-19 19:27
 * @Version 1.0.0
 * @Description：
 **/
public class Mobile {
   private int id;
   private String brand;
   private String type;
   private double price;
   private String imageUrl;

    public Mobile(int id, String brand, String type, double price, String imageUrl) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Mobile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
