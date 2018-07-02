package com.example.aylin.inventoryapp;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

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
    public void bindView(View view, Context context, Cursor cursor) {

        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView summaryTextView = (TextView) view.findViewById(R.id.summary);

        // Find the columns of pet attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_ITEM_NAME);
        int suplierColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_SUPLIER_NAME);

        // Read the pet attributes from the Cursor for the current pet
        String itemName = cursor.getString(nameColumnIndex);
        String suplierName = cursor.getString(suplierColumnIndex);

        // If the pet breed is empty string or null, then use some default text
        // that says "Unknown breed", so the TextView isn't blank.
        if (TextUtils.isEmpty(suplierName)) {
            suplierName = context.getString(R.string.unknown_suplier);
        }

        // Update the TextViews with the attributes for the current pet
        nameTextView.setText(itemName);
        summaryTextView.setText(suplierName);
    }
}
