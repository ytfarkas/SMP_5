package com.example.smp_5;

import java.util.ArrayList;

/**
 * Seafood is an extension of the Pizza class that builds a Seafood pizza.
 * This class also outputs the price as well as the string version of a pizza
 *
 * @author David Rahabi, Judah Farkas
 */

public class Seafood extends Pizza {
    /**
     * Seafood is the constructor for a Seafood pizza
     */
    public Seafood() {
        toppings = new ArrayList<Topping>();
        sauce = Sauce.ALFREDO;
        toppings.add(Topping.SHRIMP);
        toppings.add(Topping.SQUID);
        toppings.add(Topping.CRAB_MEAT);
    }

    /**
     * Price returns the price of the Seafood pizza
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

        String sea = "[Seafood] Shrimp Squid Crab Meats " +
                size.name() + " " + sauce.name() + " ";
        ;

        if (extraSauce) {
            sea = sea + "extra Sauce ";
        }

        if (extraCheese) {
            sea = sea + "extra cheese ";
        }

        sea = sea + (String.format("%,.2f", this.price()));

        return sea;
    }
}
