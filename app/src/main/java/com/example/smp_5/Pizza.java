package com.example.smp_5;

import java.util.ArrayList;

/**
 * The Pizza Class is an abstract class that handles all the different pizza types
 * it has the Toppings, Size, Sauce, extraCheese, and extraSauce available to be edited by different pizza instances
 * This also has the price function that is a polymorphism fo the other pizza classes
 *
 * @author Judah Farkas, David Rahabi
 */

public abstract class Pizza {
    protected ArrayList<Topping> toppings; //Topping is a enum class
    protected Size size; //Size is a enum class
    protected Sauce sauce; //Sauce is a enum class
    protected boolean extraSauce;
    protected boolean extraCheese;
    public abstract double price(); //polymorphism


}