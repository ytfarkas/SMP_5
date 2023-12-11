package com.example.smp_5;

/**
 * PizzaMaker is the only method that makes new instances of pizza
 * This class takes in a String input, creates, and returns a new pizza that is able to be added to an order
 *
 * @author David Rahabi, Judah Farkas
 */

public class PizzaMaker {

    /**
     * createPizza takes a string input ans creates a new instance of pizza
     *
     * @param pizzaType pizza string
     * @return pizza
     */
    public static Pizza createPizza(String pizzaType) {
        Pizza pizza;
        if (pizzaType.equals("Meatzza")) {
            pizza = new Meatzza();
        } else if (pizzaType.equals("Pepperoni")) {
            pizza = new Pepperoni();
        } else if (pizzaType.equals("Seafood")) {
            pizza = new Seafood();
        } else if (pizzaType.equals("Supreme")) {
            pizza = new Supreme();
        } else if (pizzaType.equals("Deluxe")) {
            pizza = new Deluxe();
        } else if (pizzaType.equals("Cheese")) {
            pizza = new Cheese();
        } else if (pizzaType.equals("Beyond")) {
            pizza = new Beyond();
        } else if (pizzaType.equals("Onion")) {
            pizza = new Onion();
        } else if (pizzaType.equals("Artichoke")) {
            pizza = new Artichoke();
        } else if (pizzaType.equals("Penne")) {
            pizza = new Penne();
        } else {  //build your own
            pizza = new BuildYourOwn();
        }
        return pizza;
        //not sure if there needs to be a case for if the string is incorrect
    }
}


