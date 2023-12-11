package com.example.smp_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * MainMenu is the main menu activity or app, it has 4 buttons, Order Pizza, Build Your Own, Current Order, and Store Order
 * This houses all listeners when the button os pressed. it also has our OrderData Singleton Class
 *
 * @author David Rahabi, Judah Farkas
 */

public class MainMenu extends AppCompatActivity {


    private OrderData orderData;
    private Button orderPizza;
    private Button buildYourOwn;

    private Button currentorder;

    private Button storeorders;


    /**
     * onCreate initializes all needed code on create of the activity
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        orderPizza = findViewById(R.id.orderButton);
        OrderPizzaListener();
        buildYourOwn = findViewById((R.id.buildYourOwnButton));
        BuildYourOwnListener();

        currentorder = findViewById(R.id.currentOrderButton);
        currentOrderListener();

        storeorders = findViewById(R.id.storeOrderButton);
        storeOrdersListener();

        orderData = OrderData.getOrderData();
    }


    /**
     * BuildYourOwnListener is the button listener for the BuildYourOwn button
     * it takes you to the build your own activity screen
     */
    private void BuildYourOwnListener() {
        buildYourOwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, BuildYourOwnScreen.class);
                startActivity(intent);
            }
        });
    }

    /**
     * OrderPizzaListener is the button listener for the OrderPizza button
     * it takes you to the order pizza activity screen
     */
    private void OrderPizzaListener() {
        orderPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, OrderPizza.class);
                startActivity(intent);

            }
        });
    }

    /**
     * currentOrderListener is the button listener for the currentOrder button
     * it takes you to the current order activity screen
     */
    private void currentOrderListener() {
        currentorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, CurrentOrderScreen.class);
                startActivity(intent);

            }
        });
    }

    /**
     * storeOrdersListener is the button listener for the storeOrders button
     * it takes you to the store orders activity screen
     */
    private void storeOrdersListener() {
        storeorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, StoreOrdersScreen.class);
                startActivity(intent);

            }
        });
    }
}