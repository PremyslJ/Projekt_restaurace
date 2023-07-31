package com.engeto;

import java.util.*;

public class RestaurantManager  {

    private List<Order> orders;
    private Map<Integer, Double> orderPriceByWaiter;
    private List<Dish> menu;
    public RestaurantManager() {
        this.orders = new ArrayList<>();
        this.orderPriceByWaiter = new HashMap<>();
        this.menu = new ArrayList<>(); // Inicializace seznamu
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    // Metoda pro přidání nové objednávky do systému
    public void addOrder(Order order) {
        if (menu.containsAll(order.getItems())) {
            this.orders.add(order);
            int waiterId = order.getWaiterId();
            double orderPrice = calculateOrderPrice(order);
            orderPriceByWaiter.put(waiterId, orderPriceByWaiter.getOrDefault(waiterId, 0.0) + orderPrice);
        } else {
            System.out.println("-----------------------------------------------");
            System.out.println("Objednávka obsahuje jídla, která nejsou v menu.");
            System.out.println("-----------------------------------------------");
        }
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

    // Metoda pro seřazení objednávek podle času zadání
    public List<Order> sortOrdersByCreationTime() {
        List<Order> sortedOrders = new ArrayList<>(orders);
        sortedOrders.sort(Comparator.comparing(Order::getOrderedTime));
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
            int itemCount = getItemCount(order.getItems(), dish);
            totalPrice += dish.getPrice() * itemCount;
        }
        return totalPrice;
    }

    private int getItemCount(List<Dish> items, Dish targetDish) {
        int count = 0;
        for (Dish dish : items) {
            if (dish.equals(targetDish)) {
                count++;
            }
        }
        return count;
    }


    //

    // Metoda pro přidání jídla do nabídky (menu)
    public void addToMenu(Dish dish) {
        this.menu.add(dish);
   }


    // Metoda pro odebrání jídla z nabídky (menu)
    public void removeFromMenu(Dish dish) {
        this.menu.remove(dish);
    }

//    public void completeOrder(int orderId) {
//        for (Order order : orders) {
//            if (order.getOrderId() == orderId) {
//                order.setCompleted(true);
//                break;
//            }
//        }
//    }
public void completeOrder(int orderId) throws RestaurantException {
    Order orderToComplete = findOrderById(orderId);
    if (orderToComplete == null) {
        throw new RestaurantException("Objednávka s ID " + orderId + " neexistuje.");
    }

    orderToComplete.setCompleted(true);
}

    private Order findOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }


}