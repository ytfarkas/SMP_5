package com.example.smp_5;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class OrderPizza extends AppCompatActivity implements RecyclerClickInterface {

    private ArrayList<PizzaType> pizzaTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_pizza);
        RecyclerView recyclerView = findViewById(R.id.pizzaOptions);
        pizzaTypes = addPizzaList();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new recyclerAdapter(getApplicationContext(), pizzaTypes, this));
    }

    public ArrayList<PizzaType> addPizzaList(){
        pizzaTypes = new ArrayList<>();
        pizzaTypes.add(new PizzaType("Cheese", "Tomato Sauce, Cheese", R.drawable.cheesepizza, null, 8.99 ));
        pizzaTypes.add(new PizzaType("Deluxe", "Tomato Sauce, Sausage, Pepperoni, Green Pepper, Onion, Mushroom", R.drawable.deluxepizza, null, 14.99));
        pizzaTypes.add(new PizzaType("Supreme", "Tomato Sauce, Sausage, Pepperoni, ham, Green Pepper, Onion, Black Olive, Mushroom", R.drawable.supremepizza, null, 15.99));
        pizzaTypes.add(new PizzaType("Meatzza", "Tomato Sauce, Sausage, Pepperoni, Beef, Ham", R.drawable.meatzza, null, 16.99));
        pizzaTypes.add(new PizzaType("Seafood", "Alfredo Sauce, Shrimp, Squid, Crab Meats", R.drawable.seafoodpizza, null, 17.99));
        pizzaTypes.add(new PizzaType("Pepperoni", "Tomato Sauce, Pepperoni", R.drawable.pepperonipizza, null, 10.99));
        pizzaTypes.add(new PizzaType("Beyond", "Tomato Sauce, Beyond Meat, Beyond Bacon", R.drawable.beyondpizza, null, 16.99));
        pizzaTypes.add(new PizzaType("Onion", "Tomato Sauce, Onions", R.drawable.onionpizza, null, 10.99));
        pizzaTypes.add(new PizzaType("Artichoke", "Tomato Sauce, Artichoke", R.drawable.artichokepizza, null, 10.99));
        pizzaTypes.add(new PizzaType("Penne", "Penne Vodka, Cheese", R.drawable.specialtypizza, null, 17.99));

        return pizzaTypes;
    }


    @Override
    public void onClick(int position) {
        Intent intent = new Intent(OrderPizza.this, OrderPizzaSelection.class);

        intent.putExtra("Name", pizzaTypes.get(position).getPizza());
        intent.putExtra("Toppings", pizzaTypes.get(position).getToppings());
        intent.putExtra("Image", pizzaTypes.get(position).getImage());
        intent.putExtra("Price", pizzaTypes.get(position).getPrice());

        startActivity(intent);
    }
}
