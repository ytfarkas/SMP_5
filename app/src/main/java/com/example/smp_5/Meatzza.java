package com.example.smp_5;

import java.util.ArrayList;

/**
 * Meatzza is an extension of the Pizza class that builds a Meatzza pizza.
 * This class also outputs the price as well as the string version of a pizza
 *
 * @author David Rahabi, Judah Farkas
 */
public class Meatzza extends Pizza {
    /**
     * Meatzza is the constructor for a Meatzza pizza
     */
    public Meatzza() {
        toppings = new ArrayList<Topping>();
        sauce = Sauce.TOMATO;
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.HAM);
        toppings.add(Topping.BEEF);
        toppings.add(Topping.SAUSAGE);
    }

    /**
     * Price returns the price of the Meataxe pizza
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

        String str = "[Meatzza] Pepperoni Beef Ham Sausage " +
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
