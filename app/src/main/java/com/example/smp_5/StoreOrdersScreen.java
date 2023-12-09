package com.example.smp_5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StoreOrdersScreen extends AppCompatActivity {

    private StoreOrders storeOrderData;
    private Spinner orderID;
    private ListView ordersListView;
    private TextView subtotal;
    private Button removeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders);
        storeOrderData = new StoreOrders();
        Initialize();
    }
    public void Initialize(){
        orderID.findViewById(R.id.orderIDSpinner);
        ordersListView.findViewById((R.id.storeOrderListView));
        subtotal.findViewById((R.id.storeOrderPrice));
        removeButton.findViewById(R.id.cancelStoreOrderButton);

    }

}
