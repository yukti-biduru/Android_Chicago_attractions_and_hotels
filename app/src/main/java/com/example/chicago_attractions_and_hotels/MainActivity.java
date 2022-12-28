package com.example.chicago_attractions_and_hotels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    // Declare variables
    private BroadcastReceiver chicagoBroadcastReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    // filter broadcasts
    protected void onResume()
    {
        super.onResume();
        intentFilter = new IntentFilter(Intent.ACTION_VIEW);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        chicagoBroadcastReceiver = new ChicagoBroadcastReceiver();
        registerReceiver(chicagoBroadcastReceiver,intentFilter);
    }

    protected void onPause()
    {
        super.onPause();
        unregisterReceiver(chicagoBroadcastReceiver);
    }

    // Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId()) {
            case R.id.attractions:
                startActivity(new Intent(this, ChicagoAttractions.class));
                return true;
            case R.id.hotels:
                startActivity(new Intent(this, ChicagoHotels.class));
                return true;
        }
            return false;
    }
}


