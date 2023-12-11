package com.example.smp_5;

import java.util.ArrayList;

/**
 * Supreme is an extension of the Pizza class that builds a Supreme pizza.
 * This class also outputs the price as well as the string version of a pizza
 *
 * @author David Rahabi, Judah Farkas
 */

public class Supreme extends Pizza {

    /**
     * Supreme is the constructor for a Supreme pizza
     */
    public Supreme() {
        toppings = new ArrayList<Topping>();
        sauce = Sauce.TOMATO;
        toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.ONION);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.HAM);
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.MUSHROOM);
    }

    /**
     * Price returns the price of the Supreme pizza
     * This overrides the price function in the Pizza class
     *
     * @return price, Double pizza price
     */
    @Override
    public double price() {
        double price = 0;
        if (size.equals(Size.SMALL)) {
            price = 15.99;
        } else if (size.equals(Size.MEDIUM)) {
            price = 17.99;
        } else if (size.equals(Size.LARGE)) {
            price = 19.99;
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

        String str = "[Supreme] Black Olive Onion Green Pepper Pepperoni Ham Sausage Mushroom " +
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
