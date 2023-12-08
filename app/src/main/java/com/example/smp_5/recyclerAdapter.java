package com.example.smp_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final RecyclerClickInterface recyclerClickInterface;
    Context contex;
    ArrayList<PizzaType> pizzaType;

    public recyclerAdapter(Context context, ArrayList<PizzaType> pizzaType, RecyclerClickInterface recyclerClickInterface) {
        this.contex = context;
        this.pizzaType = pizzaType;
        this.recyclerClickInterface = recyclerClickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(contex).inflate(R.layout.pizza_type, parent, false), recyclerClickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.pizzaNameView.setText(pizzaType.get(position).getPizza());
        holder.toppingNameView.setText(pizzaType.get(position).getToppings());
        holder.pizzaImageView.setImageResource(pizzaType.get(position).getImage());
        holder.priceTV.setText(pizzaType.get(position).getPrice().toString());

    }

    @Override
    public int getItemCount() {
        return pizzaType.size();
    }
}
