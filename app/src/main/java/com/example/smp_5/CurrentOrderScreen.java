package com.example.smp_5;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * CurrentOrderScreen is the activity screen that takes in your current order and displays the price
 * It allows the removal of pizzas and the sending of the data to Store Orders
 *
 * @author David Rahabi, Judah Farkas
 */
public class CurrentOrderScreen extends AppCompatActivity {

    private int checkedPosition = -1;
    private OrderData orderData;
    private Button placeOrder;
    private Button removePizza;
    private TextView total;
    private TextView subtotal;
    private TextView Tax;
    private ListView pizzas;

    /**
     * OnCreate is the function that runs when the activity is created
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_order);
        orderData = OrderData.getOrderData();
        Initialize();
    }

    /**
     * Initialize initializes all functions required for the CurrentOrderScreen code to be functional
     */
    public void Initialize() {

        placeOrder = findViewById(R.id.placeOrderButton);
        removePizza = findViewById(R.id.removePizzaButton);
        total = findViewById(R.id.orderTotal);
        subtotal = findViewById(R.id.orderSubTotal);
        Tax = findViewById(R.id.salesTax);
        pizzas = findViewById(R.id.pizzaList);
        PlaceOrderButtonListener();
        RemovePizzaButtonListener();
        setOrderText();
        setPrices();
        removePizza.setEnabled(false);
        removePizza.setAlpha(0.5f);

    }

    /**
     * setOrderText sets the orders into text so it can be displayed onto ListView
     */
    private void setOrderText() {
        if (pizzas.getChildCount() != 0) {
            pizzas.removeAllViewsInLayout();
        }
        if (!orderData.getCurrentOrder().getOrderList().isEmpty()) {
            ArrayList<Pizza> pizzalist = orderData.getCurrentOrder().getOrderList();
            ArrayList<String> pizzaStrings = new ArrayList<String>();
            for (Pizza pizza : pizzalist) {
                pizzaStrings.add(pizza.toString());
            }
            ArrayAdapter<String> pizzaListAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_single_choice,
                    pizzaStrings
            );
            pizzas.setAdapter(pizzaListAdapter);
            pizzas.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            pizzas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> Parent, View view, int position, long id) {
                    if (checkedPosition == position) {
                        checkedPosition = -1;
                        pizzas.setItemChecked(position, false);
                        removePizza.setAlpha(0.5f);
                        removePizza.setEnabled(false);
                    } else {
                        pizzas.setItemChecked(position, true);
                        removePizza.setAlpha(1.0f);
                        removePizza.setEnabled(true);
                        checkedPosition = position;
                    }
                }
            });
        } else {
            placeOrder.setAlpha(0.5f);
            placeOrder.setEnabled(false);
        }
    }

    /**
     * setPrices sets the prices according to the order
     */
    private void setPrices() {
        if (orderData.getCurrentOrder().getOrderList().isEmpty()) {
            subtotal.setText("0.00");
            total.setText("0.00");
            Tax.setText("0.00");
        } else {
            subtotal.setText(String.format("%,.2f", orderData.getCurrentOrder().getSubtotal()));
            total.setText(String.format("%,.2f", orderData.getCurrentOrder().getTotalPrice()));
            Tax.setText(String.format("%,.2f", orderData.getCurrentOrder().getTotalPrice() - orderData.getCurrentOrder().getSubtotal()));
        }
    }

    /**
     * RemovePizzaButtonListener is the code for the Remove Pizza Button when selected
     * Its purpose is to remove the selected pizza from the order
     */
    private void RemovePizzaButtonListener() {
        removePizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderData.removePizza(pizzas.getCheckedItemPosition());
                removePizza.setEnabled(false);
                removePizza.setAlpha(0.5f);
                setOrderText();
                setPrices();
                Toast.makeText(getApplicationContext(), "Pizza Removed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * PlaceOrderButtonListener is the code for when Place Order button is pressed
     * This method sends the pizza information to the StoreOrder Screen
     */
    private void PlaceOrderButtonListener() {
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderData.addToStoreOrders();
                setOrderText();
                setPrices();
                Toast.makeText(getApplicationContext(), "Order Placed!", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
