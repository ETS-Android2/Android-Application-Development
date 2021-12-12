/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/
package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
///this = current object

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {
    int quantity = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whippedCreamCheckBox=(CheckBox) findViewById(R.id.whipped_Cream_cheak_box);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox=(CheckBox)findViewById(R.id.chocolate_cheak_box);
        boolean hasChocolate=chocolateCheckBox.isChecked();
        EditText nameEditText =(EditText)findViewById(R.id.name_edit_text);
        String UserName=nameEditText.getText().toString();
        Log.v("MainActivity","has Whipped Cream :" +hasWhippedCream);
        int Price = calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage= createOrderSummary(Price,hasWhippedCream,hasChocolate,UserName);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject) + UserName);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

       // displayMessage(priceMessage);



    }

    /**
     * Calculates the price of the order.
     */
    public int calculatePrice(boolean cream ,boolean Chocolate) {
      //  return (quantity * 5);
        int BasePrice=5;
        if(cream==true)
        {
            BasePrice +=1;
        }

        if (Chocolate)
        {
            BasePrice = (BasePrice + 2) ;
        }


        return quantity*BasePrice;

    }

    public void increment(View view) {

        if (quantity==100)
        {
            Toast.makeText(this, "You can't have More then 100 coffee", Toast.LENGTH_SHORT).show();

            return;
        }
        quantity += 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {


        if (quantity<=1)
        {
            Toast toast = Toast.makeText(MainActivity.this, "You can't have Less then 1 coffee", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
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

    /*private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }*/

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

        String sMessage =getString(R.string.order_summary_name,myName)+
                "\n"+getString(R.string.order_summary_whipped_cream)+ addWhippedCream+
                "\n"+getString(R.string.order_summary_chocolate)+ addChocolate+
                "\n"+getString(R.string.quantity) + quantity +
                "\n"+getString(R.string.order_summary_price,NumberFormat.getCurrencyInstance().format(totalPrice))+
                "\n"+getString(R.string.thank_you);
//      priceMessage = priceMessage +"\nThank you";

        return sMessage;
    }
}


