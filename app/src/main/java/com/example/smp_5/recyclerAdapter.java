package com.example.smp_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * recyclerAdaoter is the adapter for the recyler view to function correctly
 */

public class recyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final RecyclerClickInterface recyclerClickInterface;
    Context contex;
    ArrayList<PizzaType> pizzaType;

    /**
     * recyclerAdapter is the constructor for recycler adapter
     *
     * @param context                context
     * @param pizzaType              pizzaType
     * @param recyclerClickInterface recyclerClickInterface
     */

    public recyclerAdapter(Context context, ArrayList<PizzaType> pizzaType, RecyclerClickInterface recyclerClickInterface) {
        this.contex = context;
        this.pizzaType = pizzaType;
        this.recyclerClickInterface = recyclerClickInterface;
    }

    /**
     * onCreateViewHolder switches to the view-holder when pizzaType option is clicked
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return ViewHolder
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(contex).inflate(R.layout.pizza_type, parent, false), recyclerClickInterface);
    }

    /**
     * onBindViewHolder binds the view-holder with the pizzaType options
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.pizzaNameView.setText(pizzaType.get(position).getPizza());
        holder.toppingNameView.setText(pizzaType.get(position).getToppings());
        holder.pizzaImageView.setImageResource(pizzaType.get(position).getImage());
        holder.priceTV.setText(pizzaType.get(position).getPrice().toString());

    }

    /**
     * getItemCount gets the size of the pizzaTypeArray
     *
     * @return pizzaType size
     */
    @Override
    public int getItemCount() {
        return pizzaType.size();
    }
}
