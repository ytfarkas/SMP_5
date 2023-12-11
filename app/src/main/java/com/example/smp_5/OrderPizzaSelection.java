package com.example.smp_5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class OrderPizzaSelection extends AppCompatActivity {

    private OrderData orderData;
    private Spinner pizzaSize;
    private TextView pizzaName;
    private TextView toppingsDesc;
    private ImageView imageSelection;
    private CheckBox xtraSauce;
    private CheckBox xtraCheese;
    private TextView priceTV;
    private Double price;
    private Button addToCart;
    ArrayList<String> pizzaSizeOptions;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_pizza_selection);

        orderData = OrderData.getOrderData();

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
        xtraSauce = findViewById(R.id.extraSauceCheckbox);
        xtraCheese = findViewById(R.id.extraCheeseCheckbox);
        priceTV = findViewById(R.id.priceTextView);
        addToCart = findViewById(R.id.addToCart);

        pizzaName.setText(pizza);
        toppingsDesc.setText(toppings);
        imageSelection.setImageResource(image);

        initializeSpinner(pizzaSize);
        spinnerListener();
        checkboxListener(xtraSauce, xtraCheese);
        AddToCartButtonListener();

        updatePrice(price, pizzaSize.getSelectedItem().toString(), xtraSauce.isChecked(), xtraCheese.isChecked());




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
                updatePrice(price, selectedSize, xtraSauce.isChecked(), xtraCheese.isChecked());

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
    public void checkboxListener(CheckBox xtraSauce, CheckBox xtraCheese){
     xtraSauce.setOnCheckedChangeListener((buttonView, isChecked) -> {
         updatePrice(price, pizzaSize.getSelectedItem().toString(), isChecked, xtraCheese.isChecked());
     });
     xtraCheese.setOnCheckedChangeListener((buttonView, isChecked) -> {
         updatePrice(price, pizzaSize.getSelectedItem().toString(), xtraSauce.isChecked(), isChecked);
     });
 }
 public void AddToCartButtonListener(){
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pizza pizza =  PizzaMaker.createPizza(pizzaName.getText().toString());
                pizza.size = Size.valueOf(pizzaSize.getSelectedItem().toString().toUpperCase());
                pizza.extraCheese = xtraCheese.isChecked();
                pizza.extraSauce = xtraSauce.isChecked();
                orderData.addToCurrentOrder(pizza);
                Toast.makeText(getApplicationContext(), "Added To Cart", Toast.LENGTH_SHORT).show();
            }
        });
 }
    public void updatePrice(Double price, String size, boolean xtraSauce, boolean xtraCheese){
        double pizzaPrice = 0.00;
        if (size.equals("Small")){
            pizzaPrice = price;
        } else if(size.equals("Medium")){
            pizzaPrice = price + 2.00;
        } else if (size.equals("Large")){
            pizzaPrice = price + 4.00;
        }
        if (xtraSauce){
            pizzaPrice = pizzaPrice+ 1.00;
        }
        if (xtraCheese){
            pizzaPrice = pizzaPrice + 1.00;
        }
        priceTV.setText(String.valueOf(String.format("%.2f", pizzaPrice)));
    }
}
