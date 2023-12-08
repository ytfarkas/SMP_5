package com.example.smp_5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class OrderPizzaSelection extends AppCompatActivity {
    private Spinner pizzaSize;
    private TextView pizzaName;
    private TextView toppingsDesc;
    private ImageView imageSelection;
    private CheckBox extraSauce;
    private CheckBox extraCheese;
    private TextView priceTV;
    private Double price;
    ArrayList<String> pizzaSizeOptions;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_pizza_selection);

        String pizza = getIntent().getStringExtra("Name");
        String toppings = getIntent().getStringExtra("Toppings");
        int image = getIntent().getIntExtra("Image", 0);
        price = getIntent().getDoubleExtra("Price", 0);
        initialize(pizza, toppings, image, price);
    }

    public void initialize(String pizza, String toppings, int image, Double price){
        pizzaSize = findViewById(R.id.pizzaSize);
        pizzaName = findViewById(R.id.pizzaNameSelection);
        toppingsDesc = findViewById(R.id.toppingOrderSelection);
        imageSelection = findViewById(R.id.orderPizzaSelectionImage);
        extraSauce = findViewById(R.id.extraSauceCheckbox);
        extraCheese = findViewById(R.id.extraCheeseCheckbox);
        priceTV = findViewById(R.id.priceTextView);

        pizzaName.setText(pizza);
        toppingsDesc.setText(toppings);
        imageSelection.setImageResource(image);

        initializeSpinner(pizzaSize);
        spinnerListener();
        checkboxListener(extraSauce, extraCheese);

        updatePrice(price, pizzaSize.getSelectedItem().toString(), extraSauce.isChecked(), extraCheese.isChecked());




    }
    public void initializeSpinner(Spinner pizzaSize){
        pizzaSizeOptions = pizzaSizeOptions();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pizzaSizeOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pizzaSize.setAdapter(adapter);

    }
    public ArrayList<String> pizzaSizeOptions(){
        pizzaSizeOptions = new ArrayList<>();
        pizzaSizeOptions.add("Small");
        pizzaSizeOptions.add("Medium");
        pizzaSizeOptions.add("Large");
        return pizzaSizeOptions;

    }
    public void spinnerListener(){
        pizzaSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedSize = pizzaSize.getItemAtPosition(position).toString();
                updatePrice(price, selectedSize, extraSauce.isChecked(), extraCheese.isChecked());

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
    public void checkboxListener(CheckBox extraSauce, CheckBox extraCheese){
     extraSauce.setOnCheckedChangeListener((buttonView, isChecked) -> {
         updatePrice(price, pizzaSize.getSelectedItem().toString(), isChecked, extraCheese.isChecked());
     });
     extraCheese.setOnCheckedChangeListener((buttonView, isChecked) -> {
         updatePrice(price, pizzaSize.getSelectedItem().toString(), extraSauce.isChecked(), isChecked);
     });
 }
    public void updatePrice(Double price, String size, boolean extraSauce, boolean extraCheese){
        double pizzaPrice = 0.00;
        if (size.equals("Small")){
            pizzaPrice = price;
        } else if(size.equals("Medium")){
            pizzaPrice = price + 2.00;
        } else if (size.equals("Large")){
            pizzaPrice = price + 4.00;
        }
        if (extraSauce){
            pizzaPrice = pizzaPrice+ 1.00;
        }
        if (extraCheese){
            pizzaPrice = pizzaPrice + 1.00;
        }
        priceTV.setText(String.valueOf(String.format("%.2f", pizzaPrice)));
    }
}
