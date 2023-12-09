package com.example.smp_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {


    private OrderData orderData;
    private Button orderPizza;
    private Button buildYourOwn;

    private Button currentorder;

    private Button storeorders;


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


    private void BuildYourOwnListener() {
        buildYourOwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, BuildYourOwnScreen.class);
                startActivity(intent);
            }
        });
    }

    private void OrderPizzaListener() {
        orderPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, OrderPizza.class);
                startActivity(intent);

            }
        });
    }

    private void currentOrderListener() {
        currentorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, CurrentOrderScreen.class);
                startActivity(intent);

            }
        });
    }

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