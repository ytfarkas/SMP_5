package com.example.smp_5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Order class main purpose is to create the orders for the Order stage
 * it gets the order and holds them in an arrayList along with the order ID
 *
 * @author David Rahabi, Judah Farkas
 */

public class Order {
    private int id;
    private ArrayList<Pizza> orderList;

    /**
     * Order is the constructor for the order class
     *
     * @param id        ID
     * @param orderList ArrayList orderlist
     */
    public Order(int id, ArrayList<Pizza> orderList) {
        this.id = id;
        this.orderList = orderList;
    }

    /**
     * getID is the getter method for the ID
     *
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * getOrderList is the getter method for the order list
     *
     * @return orderList
     */
    public ArrayList<Pizza> getOrderList() {
        return orderList;
    }

    /**
     * removePizza removes the pizza from the order
     *
     * @param index Pizza index
     */
    public void removePizza(int index) {
        orderList.remove(index);
    }

    /**
     * addToOrder adds the pizza to the order
     *
     * @param pizza pizza
     */
    public void addToOrder(Pizza pizza) {
        orderList.add(pizza);
    }

    /**
     * getTotalPrice gets the total price including sales tax of the pizza order
     *
     * @return total
     */
    public double getTotalPrice() {
        double total = 0;

        for (Pizza pizza : this.orderList) {
            total += pizza.price();
        }
        total += total * 0.06625;
        return total;
    }

    /**
     * getSubtotal gets the subtotal of the order
     *
     * @return total subtotal
     */
    public double getSubtotal() {
        double total = 0;

        for (Pizza pizza : this.orderList) {
            total += pizza.price();
        }
        return total;
    }


}
