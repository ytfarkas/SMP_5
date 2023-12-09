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

public class CurrentOrderScreen extends AppCompatActivity {


    private OrderData orderData;
    private Button placeOrder;
    private Button removePizza;
    private TextView total;
    private TextView subtotal;
    private ListView pizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_order);
        orderData = OrderData.getOrderData();
        Initialize();
    }

    public void Initialize(){

        placeOrder = findViewById(R.id.placeOrderButton);
        removePizza = findViewById(R.id.removePizzaButton);
        total = findViewById(R.id.orderTotal);
        subtotal = findViewById(R.id.orderSubTotal);
        pizzas=findViewById(R.id.pizzaList);
        pizzas.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        PlaceOrderButtonListener();
        RemovePizzaButtonListener();
        setOrderText();
        setPrices();
    }

    private void setOrderText(){
        if(pizzas.getChildCount()!=0) {
            pizzas.removeAllViewsInLayout();
        }
        if(!orderData.getCurrentOrder().getOrderList().isEmpty()){
            ArrayList<Pizza> pizzalist = orderData.getCurrentOrder().getOrderList();
            ArrayList<String> pizzaStrings = new ArrayList<String>();

            for(Pizza pizza: pizzalist){
                pizzaStrings.add(pizza.toString());
            }
            ArrayAdapter<String> pizzaListAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_single_choice,
                    pizzaStrings
            );
            pizzas.setAdapter(pizzaListAdapter);
            pizzas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> Parent, View view, int position, long id) {
                    if(pizzas.isItemChecked(position)){
                        pizzas.setItemChecked(position,true);
                    }
                    else{
                        pizzas.setItemChecked(position, false);
                    }
                }
            });

        }
    }

    private void setPrices(){
        if(orderData.getCurrentOrder().getOrderList().isEmpty()){
            subtotal.setText("0.00");
            total.setText("0.00");
        }
        else{
            subtotal.setText(String.format("%,.2f",orderData.getCurrentOrder().getSubtotal()));
            total.setText(String.format("%,.2f", orderData.getCurrentOrder().getTotalPrice()));
        }
    }

    private void RemovePizzaButtonListener(){
        removePizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderData.removePizza(pizzas.getCheckedItemPosition());
                setOrderText();
                setPrices();
                Toast.makeText(getApplicationContext(), "Pizza Removed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void PlaceOrderButtonListener(){
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
