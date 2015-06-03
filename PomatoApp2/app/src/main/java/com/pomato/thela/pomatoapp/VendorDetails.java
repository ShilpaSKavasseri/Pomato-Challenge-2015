package com.pomato.thela.pomatoapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class VendorDetails extends Activity {
    ListView VendorDetails;
    SimpleAdapter adapter;
    TextView tv;
    Button bOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_details);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("Thela Name") + " Shopping Cart";
        tv = (TextView)findViewById(R.id.textview);
        tv.setText(message);
        bOrder = (Button)findViewById(R.id.buttonOrder);

        VendorDetails  = (ListView) findViewById(R.id.listView2);
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Vegetable","Potato");
        map.put("cost", " Rs 15/Kg");
        mylist.add(map);

        map = new HashMap<String, String>();
        map.put("Vegetable","Carrot");
        map.put("cost", " Rs 30/Kg");
        mylist.add(map);

        map = new HashMap<String, String>();
        map.put("Vegetable","Onion");
        map.put("cost", " Rs 25/Kg");
        mylist.add(map);

        map = new HashMap<String, String>();
        map.put("Vegetable","Brinjal");
        map.put("cost", " Rs 15/Kg");
        mylist.add(map);

        map = new HashMap<String, String>();
        map.put("Vegetable","Tomato");
        map.put("cost", " Rs 15/Kg");
        mylist.add(map);

        map = new HashMap<String, String>();
        map.put("Vegetable","Lemon");
        map.put("cost", " Rs 50/Kg");
        mylist.add(map);

        map = new HashMap<String, String>();
        map.put("Vegetable","Pumpkin");
        map.put("cost", " Rs 15/Kg");
        mylist.add(map);

        map = new HashMap<String, String>();
        map.put("Vegetable","Watermelon");
        map.put("cost", " Rs 40/Kg");
        mylist.add(map);

        map = new HashMap<String, String>();
        map.put("Vegetable","Apple");
        map.put("cost", " Rs 60/Kg");
        mylist.add(map);

        map = new HashMap<String, String>();
        map.put("Vegetable","Orange");
        map.put("cost", " Rs 20/Kg");
        mylist.add(map);

// ...
        adapter = new SimpleAdapter(this, mylist, R.layout.vendor_details,
                new String[] {"Vegetable", "cost"}, new int[] {R.id.veg, R.id.cost});
        VendorDetails.setAdapter(adapter);

        bOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:8281412190"));
                startActivity(callIntent);
               
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vendor_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
