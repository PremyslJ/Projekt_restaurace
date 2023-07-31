import com.engeto.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RestaurantManager restaurantManager = new RestaurantManager();
        CookBook cookBook = new CookBook();
        Menu menu = new Menu();


        // Přidání receptů do cookBook
        List<String> images1 = Arrays.asList("kuřecí-rizek-01", "kuřecí-rizek-02");
        Dish dish1 = new Dish("Kuřecí řízek obalovaný 150 g", 120.0, 20, images1, Category.MAINDISH);


        List<String> images2 = Arrays.asList("hranolky-01", "hranolky-02");
        Dish dish2 = new Dish("Hranolky 150 g", 60.0, 10, images2, Category.ANNEX);

        List<String> images3 = Arrays.asList("pstruh-01");
        Dish dish3 = new Dish("Pstruh na víně 200 g", 180.0, 30, images3, Category.MAINDISH);


        List<String> images4 = Arrays.asList("játra s rýží-01");
        Dish dish4 = new Dish("Játra s rýží 250g", 130.0, 26, images4, Category.MAINDISH);

        List<String> images5 = Arrays.asList("Pivo KOzel 12");
        Dish dish5 = new Dish("Pivo Kozel 0,5  12°", 38.0, 26, images5, Category.DRINK);

        cookBook.addRecipe(dish1);
        cookBook.addRecipe(dish2);
        cookBook.addRecipe(dish3);
        cookBook.addRecipe(dish4);
        cookBook.addRecipe(dish5);


        // Získání aktuálního menu

        // Přidání receptů do aktuálního menu
        restaurantManager.addToMenu(dish1);
        restaurantManager.addToMenu(dish3);
        restaurantManager.addToMenu(dish4);
        restaurantManager.addToMenu(dish5);


        // Vytvoření objednávek


        Dish[] items1 = {dish1, dish3,dish5};
        Order order1 = new Order(15, Arrays.asList(items1), 3, "15:25", null, null);

        Dish[] items2 = {dish3};
        Order order2 = new Order(2, Arrays.asList(items2), 2, "17:12", null, "Hosté byli spokojeni.");

        Dish[] items3 = {dish1, dish3};
        Order order3 = new Order(15, Arrays.asList(items3), 4, "15:29", "16:10", null);

        Dish[] items4 = {dish1, dish3};
        Order order4 = new Order(15, Arrays.asList(items4), 3, "18:30", "18:45", null);

        Dish[] items5 = {dish1, dish3, dish1, dish1, dish3,dish5,dish5,dish5,dish5};
        Order order5 = new Order(15, Arrays.asList(items5), 3, "18:30", "18:45", null);

        restaurantManager.addOrder(order1);
        restaurantManager.addOrder(order2);
        restaurantManager.addOrder(order3);
        restaurantManager.addOrder(order4);
        restaurantManager.addOrder(order5);


        // Proveď uzavření objednávky
        try {
            restaurantManager.completeOrder(1); // Uzavře objednávku s ID 1
        } catch (RestaurantException e) {
            throw new RuntimeException(e);
        }

        // Získání statistik
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("Počet nedokončených objednávek: " + restaurantManager.getIncompleteOrdersCount());
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");


        List<Order> sortedOrdersByCreationTime = restaurantManager.sortOrdersByCreationTime();
        //     Vypsání seřazených objednávek
        System.out.println("Seřazené objednávky podle času zadání:");
        for (Order order : sortedOrdersByCreationTime) {
            System.out.println(order);
        }


        List<Order> sortedOrders = restaurantManager.sortOrdersByWaiter();
        System.out.println("Seřazené objednávky podle číšníka: " + sortedOrders);

        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");

        List<Order> ordersInTime = restaurantManager.getOrdersByTime("15:00", "16:00");
        System.out.println("Objednávky v časovém období 15:00 - 16:00: " + ordersInTime);
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");

        Map<Integer, Double> priceByWaiter = restaurantManager.getOrderPriceByWaiter();
        System.out.println("Celková cena objednávek podle číšníka: " + priceByWaiter);
        System.out.println("-----------------------------------------------");


//        for (Order order : restaurantManager.getOrders()) {
//            System.out.println("Objednávka ID: " + order.getOrderId());
//            System.out.println("Jídla: " + order.getItems());
//            System.out.println("Čas objednání: " + order.getOrderedTime());
//            System.out.println("Čas dokončení: " + order.getFulfillmentTime());
//            System.out.println("Stav: " + (order.isCompleted() ? "Dokončená" : "Nedokončená"));
//            System.out.println("-----------------------------------------------");
//        }

        //System.out.println(sortedOrders);


        //restaurantManager.addToMenu((Dish) menu.getMenu());


//        // Výpis informací o jídlech v cookBook
//        List<Dish> recipes = cookBook.getRecipes();
//
//        System.out.println("Recepty v cookBook:");
//        for (Dish recipe : recipes) {
//            System.out.println("Název: " + recipe.getTitle());
//            System.out.println("Cena: " + recipe.getPrice() + " Kč");
//            System.out.println("Doba přípravy: " + recipe.getPreparationTime() + " minut");
//            System.out.println("Kategorie: " + recipe.getCategory());
//            System.out.println("URL fotografií:");
//            for (String image : recipe.getImages()) {
//                System.out.println(image);
//            }
//            System.out.println("------------------------");
//        }


    }
}
