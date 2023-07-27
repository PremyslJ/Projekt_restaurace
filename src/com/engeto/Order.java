package com.engeto;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int tableNumber;
    private String orderedTime;
    private String fulfillmentTime;
    private int waiterId; // ID číšníka, který objednávku vytvořil
    private List<Dish> items;

    public Order(int tableNumber, String orderedTime, int waiterId) {
        this.tableNumber = tableNumber;
        this.orderedTime = orderedTime;
        this.waiterId = waiterId;
        this.items = new ArrayList<>();
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(String orderedTime) {
        this.orderedTime = orderedTime;
    }

    public String getFulfillmentTime() {
        return fulfillmentTime;
    }

    public void setFulfillmentTime(String fulfillmentTime) {
        this.fulfillmentTime = fulfillmentTime;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }

    public List<Dish> getItems() {
        return items;
    }

    public void addItem(Dish dish, int waiterId) {
        if (this.waiterId == waiterId) {
            items.add(dish);
        } else {
            System.out.println("Nemáte oprávnění upravovat tuto objednávku.");
        }
    }

    public void removeItem(Dish dish, int waiterId) {
        if (this.waiterId == waiterId) {
            items.remove(dish);
        } else {
            System.out.println("Nemáte oprávnění upravovat tuto objednávku.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Table Number: ").append(tableNumber).append("\n");
        sb.append("Ordered Time: ").append(orderedTime).append("\n");
        sb.append("Fulfillment Time: ").append(fulfillmentTime).append("\n");
        sb.append("Waiter ID: ").append(waiterId).append("\n");
        sb.append("Items:\n");
        for (Dish dish : items) {
            sb.append("- ").append(dish.getTitle()).append(", Price: ").append(dish.getPrice()).append(" Kč\n");
        }
        return sb.toString();
    }
}