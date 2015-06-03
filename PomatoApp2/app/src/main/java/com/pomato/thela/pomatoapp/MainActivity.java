package com.pomato.thela.pomatoapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {
    ListView VendorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VendorList  = (ListView) findViewById(R.id.listView);
        String[] values = new String[] { "KD & CO",
                "Farm Fresh",
                "The Thela Store",
                "Bharath Vegetable Store",
                "Organo Store",
                "Veggie Mart",
                "PKC Fruits",
                "Kerala Fresh"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        VendorList.setAdapter(adapter);

        // ListView Item Click Listener
        VendorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) VendorList.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                          "Thela Name : " + itemValue, Toast.LENGTH_LONG)
                        .show();
               Intent intent = new Intent(getApplicationContext(),VendorDetails.class);
                intent.putExtra("Thela Name",itemValue);
                startActivity(intent);


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
