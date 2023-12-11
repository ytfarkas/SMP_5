package com.example.smp_5;

import java.util.ArrayList;

/**
 * Pepperoni is an extension of the Pizza class that builds a Pepperoni pizza.
 * This class also outputs the price as well as the string version of a pizza
 *
 * @author David Rahabi, Judah Farkas
 */
public class Pepperoni extends Pizza {
    /**
     * Pepperoni is the constructor for a Pepperoni pizza
     */
    public Pepperoni() {
        toppings = new ArrayList<Topping>();
        sauce = Sauce.TOMATO;
        toppings.add(Topping.PEPPERONI);
    }

    /**
     * Price returns the price of the Pepperoni pizza
     * This overrides the price function in the Pizza class
     *
     * @return price, Double pizza price
     */
    @Override
    public double price() {
        double price = 0;

        if (size.equals(Size.SMALL)) {
            price = 10.99;
        } else if (size.equals(Size.MEDIUM)) {
            price = 12.99;
        } else if (size.equals(Size.LARGE)) {
            price = 14.99;
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

        String str = "[Pepperoni] Pepperoni " +
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
