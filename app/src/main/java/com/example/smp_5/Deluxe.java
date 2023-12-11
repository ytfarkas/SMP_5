package com.example.smp_5;

import java.util.ArrayList;

/**
 * BuildYourOwn is an extension of the Pizza class that builds a Deluxe pizza.
 * This class also outputs the price as well as the string version of a pizza
 *
 * @author David Rahabi, Judah Farkas
 */
public class Deluxe extends Pizza {

    /**
     * This is the constructor for the Deluxe pizza
     * This adds the toppings along with the sauce
     */
    public Deluxe() {
        toppings = new ArrayList<Topping>();
        sauce = Sauce.TOMATO;
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.MUSHROOM);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.ONION);

    }

    /**
     * Price returns the price of the custom pizza
     * This overrides the price function in the Pizza class
     *
     * @return price, Double pizza price
     */
    @Override
    public double price() {
        double price = 0;

        if (size.equals(Size.SMALL)) {
            price = 14.99;
        } else if (size.equals(Size.MEDIUM)) {
            price = 16.99;
        } else if (size.equals(Size.LARGE)) {
            price = 18.99;
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

        String str = "[Deluxe] Sausage Mushroom Green Pepper Pepperoni Onion " +
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
