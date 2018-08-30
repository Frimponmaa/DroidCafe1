package com.eunicefrimponmaa.droidcafepart1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
                displayMap();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_order:
                displayToast(getString(R.string.action_order_message));
                return true;

            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                return  true;
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                return true;

            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;

             default:
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    //displays a toast message for the food order and starts order activity
    public void showFoodOrder(String message){

        displayToast(message);
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }

    //shows a message that the donut image was clicked
    public void showDonutOrder(View view){
        showFoodOrder(getString(R.string.donut_order_message));
    }

    //shows a message when the ice cream sandwich image is clicked
    public void showIceCreamOrder(View view){
        showFoodOrder(getString(R.string.ice_cream_order_message));
    }

    //shows a message that the froyo image was clicked
    public  void showFroyoOrder(View view){
        showFoodOrder(getString(R.string.froyo_order_message));
    }

    public void displayMap(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        //Using the coordinates for Google headquaters
        String data =  getString(R.string.google_mtv_coord_zoom12);
        intent.setData(Uri.parse(data));
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

}
