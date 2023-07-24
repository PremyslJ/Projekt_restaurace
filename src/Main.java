import com.engeto.CookBook;
import com.engeto.Dish;

import com.engeto.RestaurantManager;
import com.engeto.Waiter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RestaurantManager restaurantManager = new RestaurantManager();
        CookBook cookBook = new CookBook();

        // Vytvoření číšníků
        Waiter waiter1 = new Waiter(1);
        Waiter waiter2 = new Waiter(2);

        // Přidání číšníků do restaurace
        List<Dish>dishList =new ArrayList<>();
        // Vytvoření a přidání jídel do kuchařky (cookbook)
        cookBook.add( new Dish("Kuřecí řízek obalovaný", 150.0, 30, "kuraci_rizek"));
        cookBook.add(new Dish("Hranolky", 70.0, 15, "hranolky"));
        cookBook.add(new Dish("Pstruh na víně", 220.0, 40, "pstruh_vine"));

        System.out.println(cookBook.getDishList());

    }
}