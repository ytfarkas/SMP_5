package com.example.smp_5;

import android.app.AlertDialog;
import android.content.Context;
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

public class BuildYourOwnScreen extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView toppingsList;
    private Button addToCartButton;
    private CheckBox extraSauce;
    private CheckBox extraCheese;
    private TextView price;
    private Spinner size;
    private Spinner sauce;
    private ArrayList<String> pizzaSizeOption;
    private ArrayList<String> pizzaSauceOption;
    private Context context;
    private ArrayList<String> selectedTopping;
    ObservableArrayList<String> list = new ObservableArrayList<>();
    String[] toppings = {"Onion", "Mushrooms", "Artichoke", "Green Olives", "Black Olives", "Sausage", "Crab Meat",
            "Beyond Beef", "Tomato", "Squid"};
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_your_own);
        context = this;
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
        updatePrice();
        InitializeSpinnerListener();
        InitializeCheckboxListener();
        InitializeButtonListener();

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
    public void InitializeSpinnerListener(){
        size.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updatePrice();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void InitializeCheckboxListener(){
        extraSauce.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            updatePrice();
        }
        ));
        extraCheese.setOnCheckedChangeListener((buttonView, isChecked) -> {
            updatePrice();
        });
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
        selectedTopping = new ArrayList<>();
        toppingsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (toppingsList.isItemChecked(position)) {
                    if (selectedTopping.size() < 7) {
                        toppingsList.setItemChecked(position, true);
                        selectedTopping.add(list.get(position));
                    } else {
                        toppingsList.setItemChecked(position, false);
                        MyAlert.showAlertDialog(context, "Too Many Toppings", "Toppings Cannot Exceed 7");
                    }
                }
                else {
                    toppingsList.setItemChecked(position, false);
                    selectedTopping.remove(list.get(position));
                }
                updatePrice();

            }
        });
    }
    public void InitializeButtonListener(){

    }
    public void updatePrice() {
        double updatePrice = 0.00;
        if (size.getSelectedItem().toString().equals("Small")) {
            updatePrice = 8.99;
        } else if (size.getSelectedItem().toString().equals("Medium")) {
            updatePrice = 10.99;
        } else if (size.getSelectedItem().toString().equals("Large")){
            updatePrice = 12.99;
        }
        if (extraCheese.isChecked()){
            updatePrice += 1.00;
        }
        if (extraSauce.isChecked()){
            updatePrice +=1.00;
        }
        if (selectedTopping.size() > 3){
            updatePrice += (selectedTopping.size() - 3) * 1.49;
        }
        price.setText(String.valueOf(String.format(String.format("%.2f", updatePrice))));

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
