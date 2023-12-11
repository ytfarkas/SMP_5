package com.example.smp_5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ViewHolder is the class that uses the viewHolder and puts the data into the recycler view
 *
 * @author David Rahabi, Judah Farkas
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView pizzaImageView;
    TextView pizzaNameView, toppingNameView, priceTV;

    /**
     * ViewHolder sets the data into the view
     * This also sets an onClickListener
     *
     * @param itemView               itemView
     * @param recyclerClickInterface recyclerClickInterface
     */
    public ViewHolder(@NonNull View itemView, RecyclerClickInterface recyclerClickInterface) {
        super(itemView);
        pizzaImageView = itemView.findViewById(R.id.pizzaPhoto);
        pizzaNameView = itemView.findViewById(R.id.pizzaName);
        toppingNameView = itemView.findViewById(R.id.toppingNames);
        priceTV = itemView.findViewById(R.id.priceTextV);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerClickInterface != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        recyclerClickInterface.onClick(position);
                    }
                }
            }
        });

    }
}
