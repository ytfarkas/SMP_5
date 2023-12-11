package com.example.smp_5;

import java.util.ArrayList;

/**
 * Store Orders handles the store orders placed. it can add, remove, and cancel orders according to order number
 *
 * @author David Rahabi, Judah Farkas
 */

public class StoreOrders {
    private ArrayList<Order> storeOrderList;
    private static int nextOrderNumber;

    /**
     * StoreOrder makes a new StoreOrder Arraylist and adds the next order number
     */

    public StoreOrders() {
        storeOrderList = new ArrayList<Order>();
        nextOrderNumber = 1;
    }

    /**
     * addOrder adds the order into storeOrder and updates the next order number
     *
     * @param order order
     */

    public void addOrder(Order order) {
        storeOrderList.add(order);
        nextOrderNumber++;
    }

    /**
     * cancelOrder cancels the order according to the ID selected
     *
     * @param id ID
     */
    public void cancelOrder(int id) {
        for (Order order : storeOrderList) {
            if (order.getID() == id) {
                storeOrderList.remove(order);
                return;
            }
        }
    }

    /**
     * getCurrentOrderNumber gets the current order number selected
     *
     * @return nextOrderNumber
     */
    public int getCurrentOrderNumber() {
        return nextOrderNumber;
    }

    /**
     * getStoreOrderList returns the storeOrders arraylist
     *
     * @return storeOrderList
     */
    public ArrayList<Order> getStoreOrderList() {
        return storeOrderList;
    }
}
