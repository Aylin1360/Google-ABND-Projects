package com.example.aylin.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2 ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton button = findViewById(R.id.icon_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:41.0926043, 28.9791837"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void increament (View view) {

        if(quantity == 0 ) {
            Toast.makeText(this, "Invalid number of coffee", Toast.LENGTH_SHORT).show();
            return;
        }else {
            quantity = quantity - 1;
            display(quantity);
        }
    }
    //increament ve dicreamentı ters yazdın unutma
    public void decrement(View view) {
        if(quantity == 100) {
            Toast.makeText(this, "Invalid number of coffee", Toast.LENGTH_SHORT).show();
            return;
        }else {
            quantity = quantity + 1;
            display(quantity);
        }
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whippedCreamBox = (CheckBox) findViewById(R.id.check_box_id);
        boolean haswhippedCream = whippedCreamBox.isChecked();

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        CheckBox choclateBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChoclate = choclateBox.isChecked();

        int price = calculatePrice(haswhippedCream , hasChoclate);
        String priceMessage = createOrderSummary(name, price, haswhippedCream, hasChoclate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java app order" + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayMessage(priceMessage);
    }

    private int calculatePrice(boolean addWhippedCream, boolean addChoclate) {
        int basePrice = 5;

        if(addWhippedCream){
            basePrice = basePrice + 1;
        }
        if(addChoclate){
            basePrice = basePrice + 2;
        }
        return quantity * basePrice;
    }

    private String createOrderSummary(String name, int price, boolean whippedCream, boolean choclate){

        if(whippedCream == true){

            return getString(R.string.order_summary_name) + name +
                    "\n" + getString(R.string.Add_whipped_cream) +
                    "\n" + getString(R.string.Quantityy) + quantity  +
                    "\n" + getString(R.string.Total) +
                    price + "\n" + getString(R.string.thank_you) ;
        }else if(choclate == true){

            return getString(R.string.order_summary_name) + name +
                    "\n" + getString(R.string.Add_choclate) +
                    "\n" + getString(R.string.Quantityy) + quantity  +
                    "\n" + getString(R.string.Total) +
                    price + "\n" + getString(R.string.thank_you) ;
        }else if(choclate == true && whippedCream == true ){

            return getString(R.string.order_summary_name) + name +
                    "\n" + getString(R.string.Add_whipped_cream) +
                    "\n" + getString(R.string.Add_choclate) +
                    "\n" + getString(R.string.Quantityy) + quantity  +
                    "\n" + getString(R.string.Total) +
                    price + "\n" + getString(R.string.thank_you) ;
        }else {

            return getString(R.string.order_summary_name) + name +
                    "\n" + getString(R.string.Quantityy) + quantity +
                    "\n" + getString(R.string.Total) +
                    price + "\n" + getString(R.string.thank_you);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
