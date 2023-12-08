package com.example.smp_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private Button orderPizza;
    private Button buildYourOwn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        orderPizza = findViewById(R.id.orderButton);
        OrderPizzaListener();
        buildYourOwn = findViewById((R.id.buildYourOwnButton));
        BuildYourOwnListener();

    }

    private void BuildYourOwnListener() {
        buildYourOwn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, BuildYourOwn.class);
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
}