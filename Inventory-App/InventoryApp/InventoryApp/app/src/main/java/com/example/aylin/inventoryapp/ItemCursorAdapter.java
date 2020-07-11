package com.example.aylin.inventoryapp;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aylin.inventoryapp.data.ItemContract.ItemEntry;

public class ItemCursorAdapter extends CursorAdapter{

    public ItemCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {

        TextView nameTextView = view.findViewById(R.id.name);
        TextView priceTextView = view.findViewById(R.id.price);
        TextView quantityClothesTextView = view.findViewById(R.id.quantity);
        Button sellButton = view.findViewById(R.id.sell_button);

        int nameColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_ITEM_NAME);
        int priceColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_PRICE);
        int quantityColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_QUANTITIY);

        String itemName = cursor.getString(nameColumnIndex);
        String price = "Price: " + cursor.getString(priceColumnIndex) + " $";
        String quantity = "Quantity available: " + cursor.getString(quantityColumnIndex);

        if (TextUtils.isEmpty(price)) {
            price = context.getString(R.string.unknown_suplier);
        }

        String currentQuantityString = cursor.getString(quantityColumnIndex);
        final int currentQuantity = Integer.valueOf(currentQuantityString);
        // Get the rows from the table with the ID
        final int productId = cursor.getInt(cursor.getColumnIndex(ItemEntry._ID));

        //setting up the decrement on the sell button
        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setting up an if else statement to what will be done when the current quantity is > 0
                if (currentQuantity > 0) {
                    int newQuantity = currentQuantity - 1;

                    //Getting the URI with the append of the ID for the row
                    Uri quantityUri = ContentUris.withAppendedId(ItemEntry.CONTENT_URI, productId);

                    //Getting the current Value for quantity and updating them with the new value -1
                    ContentValues values = new ContentValues();
                    values.put(ItemEntry.COLUMN_QUANTITIY, newQuantity);
                    context.getContentResolver().update(quantityUri, values, null, null);
                }

                else {
                    Toast.makeText(context, "This product is out of stock", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Update the TextViews with the attributes for the current item
        nameTextView.setText(itemName);
        priceTextView.setText(price);
        quantityClothesTextView.setText(quantity);
    }
}
