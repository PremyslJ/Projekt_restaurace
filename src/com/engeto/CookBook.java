package com.engeto;

import java.util.ArrayList;
import java.util.List;

public class CookBook{


    private List<Dish> dishList = new ArrayList<>();

    public void add(Dish dish){

        dishList.add(dish);
    }

    public List<Dish> getDishList(){
        return dishList;}

    @Override
    public String toString() {
        return "CookBook{" +
                "dishList=" + dishList +
                '}';
    }
}


