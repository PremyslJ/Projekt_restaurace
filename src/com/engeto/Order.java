package com.engeto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int tableNumber;
    private Date orderedTime;
    private Date fulfilmentTime;
    private Waiter waiter;
    private List<Dish> items;
    private int chefStatus;

    public Order(int tableNumber, Date orderedTime, Date fulfilmentTime, Waiter waiter) {
        this.tableNumber = tableNumber;
        this.orderedTime = orderedTime;
        this.fulfilmentTime = fulfilmentTime;
        this.waiter = waiter;
        this.items = new ArrayList<>();
        this.chefStatus = 0; // Výchozí stav objednávky - vystavena
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public Date getOrderedTime() {
        return orderedTime;
    }

    public Date getFulfilmentTime() {
        return fulfilmentTime;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public List<Dish> getItems() {
        return items;
    }

    public int getChefStatus() {
        return chefStatus;
    }

    public void setChefStatus(int chefStatus) {
        this.chefStatus = chefStatus;
    }

    public void addItem(Dish dish) {
        items.add(dish);
    }

    public void removeItem(Dish dish) {
        items.remove(dish);
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Dish dish : items) {
            total += dish.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "tableNumber=" + tableNumber +
                ", orderedTime=" + orderedTime +
                ", fulfilmentTime=" + fulfilmentTime +
                ", waiter=" + waiter +
                ", items=" + items +
                ", chefStatus=" + chefStatus +
                '}';
    }
}
