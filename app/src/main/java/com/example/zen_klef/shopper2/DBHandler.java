package com.example.zen_klef.shopper2;

/**
 * Created by Zen_Klef on 1/28/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Zen_Klef on 1/28/16.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shopper.db";

    public static final String TABLE_SHOPPING_LIST = "shoppinglist";
    public static final String COLUMN_LIST_ID = "_id";
    public static final String COLUMN_LIST_NAME = "list_name";
    public static final String COLUMN_LIST_STORE = "list_store";
    public static final String COLUMN_LIST_DATE = "list_date";

    public DBHandler (Context context, SQLiteDatabase.CursorFactory factory){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String query = "CREATE TABLE " + TABLE_SHOPPING_LIST + "(" +
                COLUMN_LIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_LIST_NAME + " TEXT," +
                COLUMN_LIST_STORE + " TEXT," +
                COLUMN_LIST_DATE + " TEXT" +
                ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOPPING_LIST);
        onCreate(db);
    }

    public void addShoppingList(String name, String store, String date){

        ContentValues values = new ContentValues();

        values.put(COLUMN_LIST_NAME, name);
        values.put(COLUMN_LIST_STORE, store);
        values.put(COLUMN_LIST_DATE, date);

        SQLiteDatabase db = getWritableDatabase();

        db.insert(TABLE_SHOPPING_LIST, null, values);

        db.close();
    }


    public Cursor getShoppinglists() {


    SQLiteDatabase db = getWritableDatabase();

    return db.rawQuery("SELECT * FROM " + TABLE_SHOPPING_LIST, null);

    }
}
