package com.example.smp_5;

import java.util.ArrayList;

/**
 * Penne is an extension of the Pizza class that builds a Penne pizza.
 * This class also outputs the price as well as the string version of a pizza
 *
 * @author David Rahabi, Judah Farkas
 */
public class Penne extends Pizza {
    /**
     * Penne is the constructor for a Penne pizza
     */
    public Penne() {
        toppings = new ArrayList<Topping>();
        sauce = Sauce.PENNE_VODKA;
        toppings.add(Topping.Cheese);
    }

    /**
     * Price returns the price of the Penne pizza
     * This overrides the price function in the Pizza class
     *
     * @return price, Double pizza price
     */
    @Override
    public double price() {
        double price = 0;

        if (size.equals(Size.SMALL)) {
            price = 17.99;
        } else if (size.equals(Size.MEDIUM)) {
            price = 19.99;
        } else if (size.equals(Size.LARGE)) {
            price = 21.99;
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

        String str = "[Penne] Cheese " +
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
