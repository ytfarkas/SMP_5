package com.example.smp_5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class MyAlert {
    public static void showAlertDialog(Context contex, String title, String message ){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(contex);
        alertBuilder.setTitle(title);
        alertBuilder.setMessage(message);
        alertBuilder.setCancelable(false);
        alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = alertBuilder.create();
        alert.show();
    }
}
