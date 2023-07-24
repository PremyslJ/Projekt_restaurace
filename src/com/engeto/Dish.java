package com.engeto;

import java.util.List;
public class Dish{

    private static int idCounter = 1;
    private int  id = idCounter++;

    private String title;
    private Double price;
    private int preparationTime;

    private String mainImage;
    private List<String> images;

    public Dish() {
        this.title = title;
        this.price = price;
        this.preparationTime = preparationTime;
        this.mainImage = mainImage;
        this.images = images;
    }

    public Dish(String title, Double price, int preparationTime, String mainImage) {
        this.title = title;
        this.price = price;
        this.preparationTime = preparationTime;
        this.mainImage = mainImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return    '\n'+
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", preparationTime=" + preparationTime +
                ", mainImage='" + mainImage + '\'' +
                ", images=" + images +'\n'
                ;
    }
}