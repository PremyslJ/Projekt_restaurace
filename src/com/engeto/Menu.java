package com.engeto;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Dish> dishes;

    public Menu() {

        this.dishes = new ArrayList<>();
    }

    public void addToMenu(Dish dish) {

        this.dishes.add(dish);
    }

    public void removeFromMenu(Dish dish) {

        this.dishes.remove(dish);
    }

    public List<Dish> getMenu() {

        return dishes;
    }

    public boolean isDishInMenu(Dish dish) {

        return dishes.contains(dish);
    }
}