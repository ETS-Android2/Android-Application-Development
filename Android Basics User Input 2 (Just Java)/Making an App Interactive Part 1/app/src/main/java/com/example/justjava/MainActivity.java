/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/
package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int Price = calculatePrice();
        displayMessage(createOrderSummary(Price));


    }

    /**
     * Calculates the price of the order.
     */
    public int calculatePrice() {
        return (quantity * 5);

    }

    public void increment(View view) {

        quantity += 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {

        quantity -= 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private String createOrderSummary(int totalPrice) {
        String Name = "Chetan Singh Negi";

        String priceMessage = "Name: " + Name + "\nQuantity: " + quantity + "\nTotal : $" + totalPrice + "\nThank you!";
//      priceMessage = priceMessage +"\nThank you";
        return priceMessage;
    }
}


