package com.engeto;

import java.util.List;

public class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private int tableNumber;
    private final List<Dish> items;
    private int waiterId;
    private String orderedTime;
    private String fulfillmentTime;
    private final String note;
    private boolean completed;

    public Order(int tableNumber, List<Dish> items, int waiterId, String orderedTime, String fulfillmentTime, String note) {
        this.orderId = nextOrderId++;
        this.tableNumber = tableNumber;
        this.items = items;
        this.waiterId = waiterId;
        this.orderedTime = orderedTime;
        this.fulfillmentTime = fulfillmentTime;
        this.note = note;
        this.completed = false;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
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

//    @Override
//    public String toString() {
//        return
//                "tableNumber=" + tableNumber +"\n"+
//                ", items=" + items +"\n"+
//                ", waiterId=" + waiterId +"\n"+
//                ", orderedTime='" + orderedTime + '\'' +"\n"+
//                ", fulfillmentTime='" + fulfillmentTime + '\'' +"\n"+
//                ", note='" + note + '\'' +"\n"+
//                '}';
//    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Table Number: ").append(tableNumber).append("\n");
        sb.append("Ordered Time: ").append(orderedTime).append("\n");
        sb.append("Fulfillment Time: ").append(fulfillmentTime).append("\n");
        sb.append("Waiter ID: ").append(waiterId).append("\n");
        sb.append("Poznámka: ").append(note).append("\n");
        sb.append("Items:\n");
        for (Dish dish : items) {
            sb.append("- ").append(dish.getTitle()).append(", Price: ").append(dish.getPrice()).append(" Kč\n");
        }
        return sb.toString();
    }
}