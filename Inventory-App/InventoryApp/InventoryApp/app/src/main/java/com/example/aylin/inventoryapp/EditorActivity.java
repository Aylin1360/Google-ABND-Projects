package com.example.aylin.inventoryapp;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.aylin.inventoryapp.data.ItemContract.ItemEntry;

public class EditorActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    /**
     * Identifier for the item data loader
     */
    private static final int EXISTING_ITEM_LOADER = 0;

    /**
     * Content URI for the existing item (null if it's a new item)
     */
    private Uri mCurrentItemUri;

    /**
     * EditText field to enter the item's name
     */
    private EditText mNameEditText;

    /**
     * EditText field to enter the suppliers' name
     */
    private EditText mSuplierEditText;

    /**
     * EditText field to enter the suppliers' phone
     */
    private EditText mSuplierPhoneEditText;

    /**
     * EditText field to enter the items's price
     */
    private EditText mPriceEditText;

    /**
     * EditText field to enter the items' quantity
     */
    private EditText mQuantityEditText;
    private int gQuantity;

    private boolean mItemHasChanged = false;

    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mItemHasChanged = true;
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        Intent intent = getIntent();
        mCurrentItemUri = intent.getData();

        if (mCurrentItemUri == null) {
            setTitle(getString(R.string.editor_activity_title_new_item));
            invalidateOptionsMenu();
        } else {
            setTitle(getString(R.string.editor_activity_title_edit_item));
            getLoaderManager().initLoader(EXISTING_ITEM_LOADER, null, this);
        }

        mNameEditText = findViewById(R.id.edit_item_name);
        mSuplierEditText = findViewById(R.id.suplier_name);
        mSuplierPhoneEditText = findViewById(R.id.suplier_phone);
        mPriceEditText = findViewById(R.id.edit_price);
        mQuantityEditText = findViewById(R.id.edit_quantity);

        ImageButton Increase_Button = findViewById(R.id.quantity_increase);
        ImageButton Decrease_Button = findViewById(R.id.quantity_decrease);

        Increase_Button.setOnTouchListener(mTouchListener);
        Decrease_Button.setOnTouchListener(mTouchListener);
        mNameEditText.setOnTouchListener(mTouchListener);
        mSuplierEditText.setOnTouchListener(mTouchListener);
        mSuplierPhoneEditText.setOnTouchListener(mTouchListener);
        mPriceEditText.setOnTouchListener(mTouchListener);
        mQuantityEditText.setOnTouchListener(mTouchListener);

        Increase_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String quantity = mQuantityEditText.getText().toString();
                if (TextUtils.isEmpty(quantity)) {
                    Toast.makeText(EditorActivity.this, "Quantity field cant be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    gQuantity = Integer.parseInt(quantity);
                    mQuantityEditText.setText(String.valueOf(gQuantity + 1));
                }
            }
        });

        Decrease_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = mQuantityEditText.getText().toString();
                if (TextUtils.isEmpty(quantity)) {
                    Toast.makeText(EditorActivity.this, "Quantity field cant be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    gQuantity = Integer.parseInt(quantity);
                    // to validate if quantity is greater than =
                    if ((gQuantity - 1) >= 0) {
                        mQuantityEditText.setText(String.valueOf(gQuantity - 1));
                    } else {
                        Toast.makeText(EditorActivity.this, "Quantity can't be smaller than 0", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        final Button mPhoneCallSupplierButton = findViewById(R.id.call_button);

        mPhoneCallSupplierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = mSuplierPhoneEditText.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);

                }
            }

        });
    }

    private void saveItem() {

        String nameString = mNameEditText.getText().toString().trim();
        String suplierString = mSuplierEditText.getText().toString().trim();
        String priceString = mPriceEditText.getText().toString().trim();
        String quantityString = mQuantityEditText.getText().toString().trim();
        String supplierPhoneNumberString = mSuplierPhoneEditText.getText().toString().trim();

        if (mCurrentItemUri == null &&
                TextUtils.isEmpty(nameString) && TextUtils.isEmpty(suplierString) &&
                TextUtils.isEmpty(priceString) && TextUtils.isEmpty(quantityString) && TextUtils.isEmpty(supplierPhoneNumberString)) {
            Toast.makeText(this, "Please fill the blanks", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues values = new ContentValues();

        if (TextUtils.isEmpty(priceString)) {
            mPriceEditText.setError("Enter the price");
            Toast.makeText(this, "Please fill the price", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(quantityString)) {
            mQuantityEditText.setError("Please fill the quantity");
            Toast.makeText(this, "Please fill the quantity", Toast.LENGTH_SHORT).show();
            return;
        }


        if (TextUtils.isEmpty(nameString)) {
            mNameEditText.setError("Enter the items' name");
            Toast.makeText(this, "Please fill the name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(suplierString)) {
            mSuplierEditText.setError("Enter suppliers' name");
            Toast.makeText(this, "Please fill the suplier name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(supplierPhoneNumberString)) {
            mSuplierPhoneEditText.setError("Enter the supliers number");
            Toast.makeText(this, "Please fill the suplier phone", Toast.LENGTH_SHORT).show();
            return;
        }

        values.put(ItemEntry.COLUMN_ITEM_NAME, nameString);
        values.put(ItemEntry.COLUMN_SUPLIER_NAME, suplierString);
        values.put(ItemEntry.COLUMN_SUPLIER_PHONE, supplierPhoneNumberString);
        values.put(ItemEntry.COLUMN_QUANTITIY, quantityString);
        values.put(ItemEntry.COLUMN_PRICE, priceString);

        if (mCurrentItemUri == null) {

            Uri newUri = getContentResolver().insert(ItemEntry.CONTENT_URI, values);

            if (newUri == null) {
                Toast.makeText(this, getString(R.string.editor_insert_item_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_insert_item_successful),
                        Toast.LENGTH_SHORT).show();
            }

            finish();

        } else {

            int rowsAffected = getContentResolver().update(mCurrentItemUri, values, null, null);

            if (rowsAffected == 0) {
                Toast.makeText(this, getString(R.string.editor_update_item_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_update_item_successful),
                        Toast.LENGTH_SHORT).show();
            }

            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        // If this is a new item, hide the "Delete" menu item.
        if (mCurrentItemUri == null) {
            MenuItem menuItem = menu.findItem(R.id.action_delete);
            menuItem.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                saveItem();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                showDeleteConfirmationDialog();
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                if (!mItemHasChanged) {
                    NavUtils.navigateUpFromSameTask(this);
                    return true;
                }

                DialogInterface.OnClickListener discardButtonClickListener =
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // User clicked "Discard" button, navigate to parent activity.
                                NavUtils.navigateUpFromSameTask(EditorActivity.this);
                            }
                        };

                // Show a dialog that notifies the user they have unsaved changes
                showUnsavedChangesDialog(discardButtonClickListener);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // If the item hasn't changed, continue with handling back button press
        if (!mItemHasChanged) {
            super.onBackPressed();
            return;
        }

        DialogInterface.OnClickListener discardButtonClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // User clicked "Discard" button, close the current activity.
                        finish();
                    }
                };

        // Show dialog that there are unsaved changes
        showUnsavedChangesDialog(discardButtonClickListener);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                ItemEntry._ID,
                ItemEntry.COLUMN_ITEM_NAME,
                ItemEntry.COLUMN_SUPLIER_NAME,
                ItemEntry.COLUMN_SUPLIER_PHONE,
                ItemEntry.COLUMN_PRICE,
                ItemEntry.COLUMN_QUANTITIY};

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                mCurrentItemUri,         // Query the content URI for the current item
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {
            // Find the columns of item attributes that we're interested in
            int nameColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_ITEM_NAME);
            int suplierColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_SUPLIER_NAME);
            int priceColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_QUANTITIY);
            int suplierPhoneIndex = cursor.getColumnIndex(ItemEntry.COLUMN_SUPLIER_PHONE);

            // Extract out the value from the Cursor for the given column index
            String name = cursor.getString(nameColumnIndex);
            String suplier = cursor.getString(suplierColumnIndex);
            int price = cursor.getInt(priceColumnIndex);
            int quantity = cursor.getInt(quantityColumnIndex);
            long suplierPhoneNumber = cursor.getInt(suplierPhoneIndex);

            // Update the views on the screen with the values from the database
            mNameEditText.setText(name);
            mSuplierEditText.setText(suplier);
            mPriceEditText.setText(Integer.toString(price));
            mQuantityEditText.setText(Integer.toString(quantity));
            mSuplierPhoneEditText.setText(Long.toString(suplierPhoneNumber));
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mNameEditText.setText("");
        mSuplierEditText.setText("");
        mPriceEditText.setText("");
        mQuantityEditText.setText("");
        mSuplierPhoneEditText.setText("");
    }

    private void showUnsavedChangesDialog(
            DialogInterface.OnClickListener discardButtonClickListener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.unsaved_changes_dialog_msg);
        builder.setPositiveButton(R.string.discard, discardButtonClickListener);
        builder.setNegativeButton(R.string.keep_editing, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showDeleteConfirmationDialog() {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                deleteItem();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void deleteItem() {
        // Only perform the delete if this is an existing item.
        if (mCurrentItemUri != null) {
            // Call the ContentResolver to delete the item at the given content URI.
            // Pass in null for the selection and selection args because the mCurrentItemUri
            // content URI already identifies the item that we want.
            int rowsDeleted = getContentResolver().delete(mCurrentItemUri, null, null);

            // Show a toast message depending on whether or not the delete was successful.
            if (rowsDeleted == 0) {
                // If no rows were deleted, then there was an error with the delete.
                Toast.makeText(this, getString(R.string.editor_delete_item_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                // Otherwise, the delete was successful and we can display a toast.
                Toast.makeText(this, getString(R.string.editor_delete_item_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }

        finish();
    }
}
