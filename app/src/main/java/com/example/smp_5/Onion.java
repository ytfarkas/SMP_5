package com.example.smp_5;

import java.util.ArrayList;

/**
 * Onion is an extension of the Pizza class that builds a Onion pizza.
 * This class also outputs the price as well as the string version of a pizza
 *
 * @author David Rahabi, Judah Farkas
 */
public class Onion extends Pizza {
    /**
     * Onion is the constructor for a Onion pizza
     */
    public Onion() {
        toppings = new ArrayList<Topping>();
        sauce = Sauce.TOMATO;
        toppings.add(Topping.ONION);
    }

    /**
     * Price returns the price of the Onion pizza
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

        String str = "[Onion] Onion " +
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
