package com.example.smp_5;

import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StoreOrdersScreen extends AppCompatActivity {

    private ArrayAdapter<String> pizzaListAdapter;

    private OrderData storeOrderData;
    private Spinner orderID;
    private ListView ordersListView;
    private TextView subtotal;
    private Button removeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders);
        storeOrderData = OrderData.getOrderData();
        Initialize();
    }
    public void Initialize(){
        orderID = findViewById(R.id.orderIDSpinner);
        ordersListView = findViewById((R.id.storeOrderListView));
        subtotal = findViewById((R.id.storeOrderPrice));
        removeButton= findViewById(R.id.cancelStoreOrderButton);

        PopulateSpinner();
        InitializeSpinnerListener();
        RemoveButtonListener();
    }

    public void PopulateSpinner(){
        ArrayList<Order> orderList = storeOrderData.getStoreOrders().getStoreOrderList();
        ArrayList<Integer> ID = new ArrayList<>();
        for(Order order: orderList){
            ID.add(order.getID());
        }
        if(ID.isEmpty()){
            removeButton.setAlpha(0.5f);
            removeButton.setEnabled(false);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ID);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orderID.setAdapter(adapter);
    }

    public void InitializeSpinnerListener(){
        orderID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int orderNum = (int) orderID.getSelectedItem();
                ArrayList<Order> orderList = storeOrderData.getStoreOrders().getStoreOrderList();
                ArrayList<String> pizzaString = new ArrayList<String>();
                for (Order order: orderList){
                    if(order.getID() == orderNum){
                        subtotal.setText(String.format("%,.2f", order.getTotalPrice()));
                        for(Pizza pizza : order.getOrderList()){
                            pizzaString.add(pizza.toString());
                        }
                    }
                }
                pizzaListAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, pizzaString);
                ordersListView.setAdapter(pizzaListAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void RemoveButtonListener(){
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeOrderData.cancelOrder((int) orderID.getSelectedItem());
                pizzaListAdapter.clear();
                subtotal.setText("");
                PopulateSpinner();
                Toast.makeText(getApplicationContext(), "Pizza Removed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
