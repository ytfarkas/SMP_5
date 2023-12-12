package com.example.smp_5;

import java.util.ArrayList;

/**
 * Beyond is an extension of the Pizza class that builds a Beyond pizza.
 * This class also outputs the price as well as the string version of a pizza
 *
 * @author David Rahabi, Judah Farkas
 */
public class Beyond extends Pizza {
    /**
     * Beyond is the constructor for a Beyond pizza
     */
    public Beyond() {
        toppings = new ArrayList<Topping>();
        sauce = Sauce.TOMATO;
        toppings.add(Topping.BEYOND_BEEF);
        toppings.add(Topping.BEYOND_BACON);
    }

    /**
     * Price returns the price of the Beyond pizza
     * This overrides the price function in the Pizza class
     *
     * @return price, Double pizza price
     */
    @Override
    public double price() {
        double price = 0;

        if (size.equals(Size.SMALL)) {
            price = 16.99;
        } else if (size.equals(Size.MEDIUM)) {
            price = 18.99;
        } else if (size.equals(Size.LARGE)) {
            price = 20.99;
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

        String str = "[Beyond] Beyond Beef, Beyond Bacon " +
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
