package com.example.smp_5;

/**
 * PizzaType is the class that sets the pizzaType for the recylerView
 *
 * @author David Rahabi, Judah Farkas
 */
public class PizzaType {
    private String pizzaType;
    private String toppings;
    private String size;
    private int image;
    private double price;

    /**
     * PizzaType is the constructor for pizzaType
     *
     * @param pizzaType pizzaType
     * @param toppings  toppings
     * @param image     image
     * @param size      size
     * @param price     price
     */
    public PizzaType(String pizzaType, String toppings, int image, String size, Double price) {
        this.pizzaType = pizzaType;
        this.toppings = toppings;
        this.image = image;
        this.size = size;
        this.price = price;
    }

    /**
     * getPizza is the getter method for pizza
     *
     * @return pizzaType
     */
    public String getPizza() {
        return pizzaType;
    }

    /**
     * getToppings is the getter method for toppings
     *
     * @return toppings
     */
    public String getToppings() {
        return toppings;
    }

    /**
     * getImage is the getter method for image
     *
     * @return image
     */
    public int getImage() {
        return image;
    }

    /**
     * getSize is the getter method for size
     *
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     * getPrice is the getter method for price
     *
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * setPizzaType is the setter method for setting the pizza type
     *
     * @param pizzaType pizzaType
     */
    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    /**
     * setToppings is the setter method for toppings
     *
     * @param toppings toppings
     */
    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    /**
     * setImage is the setter method for setting the immage
     *
     * @param image image
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * setSize is the setter method for size
     *
     * @param size size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * setPrice is the setter method for setting the price
     *
     * @param price price
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}
