package com.engeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantManager {
    private List<Order> orders;
    private Map<Integer, Double> orderPriceByWaiter;
    private List<Dish> menu; // Nově přidaný atribut pro uložení nabídky (seznamu jídel)

    public RestaurantManager() {
        this.orders = new ArrayList<>();
        this.orderPriceByWaiter = new HashMap<>();
        this.menu = new ArrayList<>(); // Inicializace seznamu nabídky
    }

    // Metoda pro přidání nové objednávky do systému
    public void addOrder(Order order) {
        this.orders.add(order);
        int waiterId = order.getWaiterId();
        double orderPrice = calculateOrderPrice(order);
        // Aktualizace celkové ceny objednávek pro daného číšníka
        orderPriceByWaiter.put(waiterId, orderPriceByWaiter.getOrDefault(waiterId, 0.0) + orderPrice);
    }

    // Metoda pro získání počtu nevyřízených objednávek
    public int getIncompleteOrdersCount() {
        int incompleteCount = 0;
        for (Order order : orders) {
            if (order.getFulfillmentTime() == null) {
                incompleteCount++;
            }
        }
        return incompleteCount;
    }

    // Metoda pro seřazení objednávek podle číšníka
    public List<Order> sortOrdersByWaiter() {
        List<Order> sortedOrders = new ArrayList<>(orders);
        sortedOrders.sort((order1, order2) -> Integer.compare(order1.getWaiterId(), order2.getWaiterId()));
        return sortedOrders;
    }

    // Metoda pro získání seznamu objednávek, které byly zadány v určitém časovém období
    public List<Order> getOrdersByTime(String startTime, String endTime) {
        List<Order> ordersInTime = new ArrayList<>();
        for (Order order : orders) {
            if (order.getOrderedTime().compareTo(startTime) >= 0 && order.getOrderedTime().compareTo(endTime) <= 0) {
                ordersInTime.add(order);
            }
        }
        return ordersInTime;
    }

    // Metoda pro získání celkové ceny objednávek pro jednotlivé číšníky
    public Map<Integer, Double> getOrderPriceByWaiter() {
        return orderPriceByWaiter;
    }

    // Pomocná metoda pro výpočet celkové ceny objednávky
    private double calculateOrderPrice(Order order) {
        double totalPrice = 0;
        for (Dish dish : order.getItems()) {
            totalPrice += dish.getPrice();
        }
        return totalPrice;
    }

    // Metody pro práci s menu (seznamem jídel)

    // Metoda pro přidání jídla do nabídky (menu)
    public void addToMenu(Dish dish) {
        this.menu.add(dish);
    }

    // Metoda pro odebrání jídla z nabídky (menu)
    public void removeFromMenu(Dish dish) {
        this.menu.remove(dish);
    }
}