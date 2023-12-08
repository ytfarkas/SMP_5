package com.example.smp_5;

import android.database.Observable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class BuildYourOwn extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView toppingsList;
    private Button addToCartButton;
    private CheckBox extraSauce;
    private CheckBox extraCheese;
    private TextView price;
    private Spinner size;
    private Spinner sauce;
    private ArrayList<String> pizzaSizeOption;
    private ArrayList<String> pizzaSauceOption;

    ObservableArrayList<String> list = new ObservableArrayList<>();
    String[] toppings = {"Onion", "Mushrooms", "Artichoke", "Green Olives", "Black Olives", "Sausage", "Crab Meat",
            "Beyond Beef", "Tomato", "Squid"};
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_your_own);
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

        PopulateToppingList();

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

    public void PopulateToppingList(){
        toppingsList.setChoiceMode(toppingsList.CHOICE_MODE_MULTIPLE);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, list);
        Collections.addAll(list, toppings);
        toppingsList.setAdapter(adapter);
        ArrayList<String> selectedTopping = new ArrayList<>();
        toppingsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toppingsList.setItemChecked(position, toppingsList.isItemChecked(position));
                if (toppingsList.isItemChecked(position)){
                    selectedTopping.add(list.get(position));
                } else{
                    selectedTopping.remove(list.get(position));
                }
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
