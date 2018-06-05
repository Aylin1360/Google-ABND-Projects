package com.example.aylin.inventoryapp.data;

import android.provider.BaseColumns;

public final class ItemContract {

    private ItemContract(){}

    public static final class ItemEntry implements BaseColumns {

        public final static String TABLE_NAME = "items";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_ITEM_NAME = "name";
        public final static String COLUMN_SUPLIER_NAME = "suplier";
        public final static String COLUMN_PRICE = "price";
        public final static String COLUMN_SUPLIER_PHONE = "phone";
        public final static String COLUMN_QUANTITIY = "quantity";

    }
}
