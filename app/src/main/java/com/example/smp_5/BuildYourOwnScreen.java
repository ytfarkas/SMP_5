package com.example.smp_5;

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

public class BuildYourOwnScreen extends AppCompatActivity {

    private OrderData orderData;
    private ListView toppingsList;
    private Button addToCartButton;
    private CheckBox extraSauce;
    private CheckBox extraCheese;
    private TextView price;
    private Spinner size;
    private Spinner sauce;
    private ArrayList<String> pizzaSizeOption;
    private ArrayList<String> pizzaSauceOption;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_your_own);
        orderData = OrderData.getOrderData();
        Initialize();
    }
    public void Initialize(){
        toppingsList = findViewById(R.id.toppingListView);
        addToCartButton = findViewById(R.id.bYOAddToCartButton);
        extraCheese = findViewById(R.id.bYOExtraCheeseCheckbox);
        extraSauce = findViewById((R.id.bYOExtraSauceCheckbox));
        price = findViewById(R.id.bYOPriceTextView);
        size = findViewById(R.id.bYOSizeSpinner);
        sauce = findViewById(R.id.bYOSauceSpinner);

        InitializeSpinners();
        PopulateSpinner();
        AddToCartButtonListener();
    }
    public void InitializeSpinners(){
        pizzaSauceOption = new ArrayList<>();
        pizzaSizeOption = new ArrayList<>();
        pizzaSauceOption.add("Tomato");
        pizzaSauceOption.add("Alfredo");
        pizzaSauceOption.add("Penne Vodka");
        pizzaSizeOption.add("Small");
        pizzaSizeOption.add("Medium");
        pizzaSizeOption.add("Large");

    }
    public void PopulateSpinner(){
        ArrayAdapter<String> sizeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pizzaSizeOption);
        ArrayAdapter<String> sauceAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pizzaSauceOption);
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sauceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        size.setAdapter(sizeAdapter);
        sauce.setAdapter(sauceAdapter);
    }

    public void AddToCartButtonListener(){
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pizza pizza =  PizzaMaker.createPizza("");
                pizza.size = Size.valueOf(size.getSelectedItem().toString().toUpperCase());
                pizza.extraCheese = extraCheese.isSelected();
                pizza.extraSauce = extraSauce.isSelected();
                orderData.addToCurrentOrder(pizza);
                Toast.makeText(getApplicationContext(), "Added To Cart", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
