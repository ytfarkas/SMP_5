package com.example.smp_5;

import java.util.ArrayList;

/**
 * OrderData is the class that houses our singleton data. it has the current otder, store order, and order data
 *
 * @author David Rahabi, Judah Farkas
 */

final class OrderData {
    private static OrderData orderData;
    private static Order currentOrder;
    private static StoreOrders storeOrders;

    /**
     * OrderData is the constructor for our order data class
     */
    private OrderData() {
        storeOrders = new StoreOrders();
        currentOrder = new Order(storeOrders.getCurrentOrderNumber(), new ArrayList<Pizza>());
    }

    /**
     * getOrderData is the getter method for orderData
     *
     * @return orderData
     */
    public static synchronized OrderData getOrderData() {
        if (orderData == null) {
            orderData = new OrderData();
        }
        return orderData;
    }

    /**
     * getCurrentOrder is the getter method for currentOrder
     *
     * @return currentOrder
     */
    public Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * getStoreOrders is the getter method for storeOrders
     *
     * @return storeOrders
     */
    public StoreOrders getStoreOrders() {
        return storeOrders;
    }

    public void addToStoreOrders() {

        storeOrders.addOrder(currentOrder);
        currentOrder = new Order(storeOrders.getCurrentOrderNumber(), new ArrayList<Pizza>());
    }

    /**
     * addToCurrentOrder adds the pizza to currentOrder
     *
     * @param pizza pizza
     */
    public void addToCurrentOrder(Pizza pizza) {
        currentOrder.addToOrder(pizza);
    }

    /**
     * cancelOrder cancels the storeOrder
     *
     * @param id id
     */
    public void cancelOrder(int id) {
        storeOrders.cancelOrder(id);
    }

    /**
     * removePizza removes the pizza selected from currentOrder
     *
     * @param index index
     */
    public void removePizza(int index) {
        currentOrder.removePizza(index);
    }

}
