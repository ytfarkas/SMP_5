package com.example.smp_5;

import java.util.ArrayList;

/**
 * BuildYourOwn is an extension of the Pizza class that builds a custom pizza.
 * This class also outputs the price as well as the string version of a pizza
 *
 * @Author David Rahabi, Judah Farkas
 */
public class BuildYourOwn extends Pizza {

    /**
     * BuildYourOwn is the constructor for a custom pizza
     */
    public BuildYourOwn() {
        toppings = new ArrayList<Topping>();
    }

    /**
     * Price returns the price of the custom pizza
     * This overrides the price function in the Pizza class
     *
     * @return price, Double price
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
        for (int i = 0; i < toppings.size(); i++) {
            if (i > 2) {
                price += 1.49; // first 3 toppings free, add 1.49 for every extra topping
            }
        }
        return Math.round(price * 100.0) / 100.0;
    }

    /**
     * ToString returns the pizza inputs to a string
     *
     * @return srt, string
     */
    @Override
    public String toString() {

        String tpngs = "";
        for (Topping t : toppings) {
            if (t.name().contains("_")) {
                tpngs = tpngs + t.name().replace("_", " ") + " ";
            } else {
                tpngs = tpngs + t.name() + " ";
            }
        }

        String sc = sauce.name();
        if (sc.contains("_")) {
            sc = sc.replace("_", " ");
        }


        String str = "[BuildYourOwn] " + tpngs +
                size.name() + " " + sc + " ";

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