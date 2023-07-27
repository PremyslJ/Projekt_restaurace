import com.engeto.CookBook;
import com.engeto.Dish;
import com.engeto.Menu;
import com.engeto.RestaurantManager;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RestaurantManager restaurantManager = new RestaurantManager();
        CookBook cookBook = new CookBook();
        Menu menu = new Menu();
        // Přidání receptů do cookBook
        List<String> images1 = Arrays.asList("kuřecí-rizek-01.png", "kuřecí-rizek-02.png");
        Dish dish1 = new Dish("Kuřecí řízek obalovaný 150 g", 120.0, 20, images1, "Hlavní jídla");

        List<String> images2 = Arrays.asList("hranolky-01.png", "hranolky-02.png");
        Dish dish2 = new Dish("Hranolky 150 g", 60.0, 10, images2, "Přílohy");

        List<String> images3 = Arrays.asList("pstruh-01.png");
        Dish dish3 = new Dish("Pstruh na víně 200 g", 180.0, 30, images3, "Hlavní jídla");

        cookBook.addRecipe(dish1);
        cookBook.addRecipe(dish2);
        cookBook.addRecipe(dish3);


        // Přidání receptů do aktuálního menu
        menu.addToMenu(dish1);
        menu.addToMenu(dish3);



        //restaurantManager.addToMenu((Dish) menu.getMenu());

        System.out.println(menu.getMenu());

//        // Výpis informací o jídlech v cookBook
        List<Dish> recipes = cookBook.getRecipes();
        System.out.println("Recepty v cookBook:");
        for (Dish recipe : recipes) {
            System.out.println("Název: " + recipe.getTitle());
            System.out.println("Cena: " + recipe.getPrice() + " Kč");
            System.out.println("Doba přípravy: " + recipe.getPreparationTime() + " minut");
            System.out.println("Kategorie: " + recipe.getCategory());
            System.out.println("URL fotografií:");
            for (String image : recipe.getImages()) {
                System.out.println(image);
            }
            System.out.println("------------------------");
        }


    }
}