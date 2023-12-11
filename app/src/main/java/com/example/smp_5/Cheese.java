package com.example.smp_5;

import java.util.ArrayList;

/**
 * Cheese is an extension of the Pizza class that builds a Cheese pizza.
 * This class also outputs the price as well as the string version of a pizza
 *
 * @author David Rahabi, Judah Farkas
 */
public class Cheese extends Pizza {
    /**
     * Cheese is the constructor for a Cheese pizza
     */
    public Cheese() {
        toppings = new ArrayList<Topping>();
        sauce = Sauce.TOMATO;
        toppings.add(Topping.Cheese);
    }

    /**
     * Price returns the price of the Cheese pizza
     * This overrides the price function in the Pizza class
     *
     * @return price, Double pizza price
     */
    @Override
    public double price() {
        double price = 0;

        if (size.equals(Size.SMALL)) {
            price = 8.99;
        } else if (size.equals(Size.MEDIUM)) {
            price = 10.99;
        } else if (size.equals(Size.LARGE)) {
            price = 12.99;
        }
        if (extraCheese) {
            price += 1.0;
        }
        if (extraSauce) {
            price += 1.0;
        }
        return price;
    }

    /**
     * ToString returns the pizza inputs to a string
     *
     * @return srt, string
     */
    @Override
    public String toString() {

        String str = "[Cheese] Cheese " +
                size.name() + " " + sauce.name() + " ";

        if (extraSauce) {
            str = str + "extra Sauce ";
        }

        if (extraCheese) {
            str = str + "extra cheese ";
        }

        str = str + "$" + (String.format("%,.2f", this.price()));

        return str;
    }
}
