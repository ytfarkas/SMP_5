package com.example.smp_5;

public class PizzaType {
    private String pizzaType;
    private String toppings;
    private String size;
    private int image;
    private double price;

    public PizzaType(String pizzaType, String toppings, int image, String size, Double price){
        this.pizzaType = pizzaType;
        this.toppings = toppings;
        this.image = image;
        this.size = size;
        this.price = price;
    }

    public String getPizza(){
        return pizzaType;
    }

    public String getToppings(){
        return toppings;
    }
    public int getImage(){
        return image;
    }

    public String getSize(){ return size;}
    public Double getPrice(){ return price;}



    public void setPizzaType(String pizzaType){
        this.pizzaType = pizzaType;
    }
    public void setToppings(String toppings){
        this.toppings = toppings;
    }
    public void setImage(int image){
        this.image = image;
    }
    public void setSize (String size){ this.size = size; }
    public void setPrice(Double price){ this.price = price;}
}
