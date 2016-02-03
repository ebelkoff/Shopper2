package com.example.zen_klef.shopper2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Zen_Klef on 2/2/16.
 */
public class ShoppingLists extends CursorAdapter {

    public ShoppingLists(Context context, Cursor cursor, int flags){
        super(context, cursor, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.li_shopping_list, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ((TextView) view.findViewById(R.id.textViewName)).
                setText(cursor.getString(cursor.getColumnIndex("list_name")));
        ((TextView) view.findViewById(R.id.textViewStore)).
                setText(cursor.getString(cursor.getColumnIndex("list_store")));
        ((TextView) view.findViewById(R.id.textViewDate)).
                setText(cursor.getString(cursor.getColumnIndex("list_date")));

    }
}
