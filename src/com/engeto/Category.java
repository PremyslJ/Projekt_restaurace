package com.engeto;

public enum Category {
    STARTED("předkrm"),
    MAINDISH("hlavní jídlo") ,
    DESSERT("dezert"),

    DRINK("pití"),

    ANNEX("příloha");

    private String description;

    Category(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
