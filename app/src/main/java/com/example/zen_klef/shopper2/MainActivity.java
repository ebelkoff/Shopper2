package com.example.zen_klef.shopper2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    DBHandler dbHandler;
    ShoppingLists shoppingListsAdapter;
    ListView shopperListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        dbHandler = new DBHandler(this, null);


        shopperListView = (ListView) this.findViewById(R.id.shopperlistView);

        shoppingListsAdapter = new ShoppingLists(this, dbHandler.getShoppinglists(), 0);


        shopperListView.setAdapter(shoppingListsAdapter);
    }


    public void openCreateList (View view){
    intent = new Intent(this, CreateList.class);
    startActivity(intent);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.action_home:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_action_create_list:
                intent = new Intent(this, CreateList.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


}

}
