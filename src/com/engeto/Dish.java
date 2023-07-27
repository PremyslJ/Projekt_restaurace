package com.engeto;

import java.util.List;

public class Dish {
    private String title;
    private double price;
    private int preparationTime;
    private List<String> images;
    private String category;

    public Dish(String title, double price, int preparationTime, List<String> images, String category) {
        this.title = title;
        this.price = price;
        this.preparationTime = preparationTime;
        this.images = images;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public List<String> getImages() {
        return images;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return title + " - " + price + " Kč, Kategorie: " + category;
    }
}
