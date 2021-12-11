/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/
package com.example.justjava;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
///this = current object

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
        CheckBox whippedCreamCheckBox=(CheckBox) findViewById(R.id.whipped_Cream_cheak_box);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox=(CheckBox)findViewById(R.id.chocolate_cheak_box);
        boolean hasChocolate=chocolateCheckBox.isChecked();
        EditText nameEditText =(EditText)findViewById(R.id.name_edit_text);
        String UserName=nameEditText.getText().toString();
        Log.v("MainActivity","has Whipped Cream :" +hasWhippedCream);
        displayMessage(createOrderSummary(Price,hasWhippedCream,hasChocolate,UserName));



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

    /**
     * Create summary of the order.
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @param totalPrice of the order
     * @return text summary
     */
    private String createOrderSummary(int totalPrice,boolean addWhippedCream, boolean addChocolate ,String myName) {
       // String Name = "Chetan Singh Negi";

        String priceMessage = "Name: " + myName +"\nAdd Whipped Cream ?"+ addWhippedCream+"\nAdd Chocolate ?"+ addChocolate+"\nQuantity: " + quantity + "\nTotal : $" + totalPrice + "\nThank you!";
//      priceMessage = priceMessage +"\nThank you";
        return priceMessage;
    }
}


