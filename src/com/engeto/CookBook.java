package com.engeto;

import java.util.ArrayList;
import java.util.List;

public class CookBook {
    private List<Dish> recipes;

    public CookBook() {
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(Dish dish) {
        this.recipes.add(dish);
    }

    public void removeRecipe(Dish dish) {
        this.recipes.remove(dish);
    }

    public List<Dish> getRecipes() {
        return recipes;
    }

    @Override
    public String toString() {
        return "CookBook{" +
                "recipes=" + recipes +
                '}';
    }
}