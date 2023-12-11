package com.example.smp_5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * MyAlert is the class that can set an alert on screen when passed
 *
 * @author David Rahabi, Judah Farkas
 */

public class MyAlert {

    /**
     * showAlertDialog shows the alert on screen with the inputted text and message
     */
    public static void showAlertDialog(Context contex, String title, String message) {
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
