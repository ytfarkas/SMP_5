package com.example.smp_5;

import java.util.ArrayList;

final class OrderData {
    private static OrderData orderData;
    private static Order currentOrder;
    private static StoreOrders storeOrders;

    private OrderData(){
        storeOrders = new StoreOrders();
        currentOrder = new Order(storeOrders.getCurrentOrderNumber(), new ArrayList<Pizza>());
    }

    public static synchronized OrderData getOrderData(){
        if (orderData == null){
            orderData = new OrderData();
        }
        else{
            System.out.println("OrderData already exists");
        }
        return orderData;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public StoreOrders getStoreOrders() {
        return storeOrders;
    }
    public void addToStoreOrders(){

        storeOrders.addOrder(currentOrder);
        currentOrder = new Order(storeOrders.getCurrentOrderNumber(), new ArrayList<Pizza>());
    }
    public void addToCurrentOrder(Pizza pizza){
        currentOrder.addToOrder(pizza);
    }

    public void cancelOrder(int id){
        storeOrders.cancelOrder(id);
    }
    public void removePizza(int index){
        currentOrder.removePizza(index);
    }

    public void printOrder(){
        for(Pizza order : currentOrder.getOrderList()){
            System.out.println(order.toString());

        }
    }
}
