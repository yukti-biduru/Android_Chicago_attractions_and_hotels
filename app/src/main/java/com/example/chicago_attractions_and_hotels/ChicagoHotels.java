package com.example.chicago_attractions_and_hotels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ChicagoHotels extends AppCompatActivity {

    // Declare parameters
   private final HotelsMenu hotelsMenuFragment = new HotelsMenu();
    private final HotelsData hotelsDataFragment = new HotelsData();

    // Initialize and map fragments
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicago_hotels);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView3, hotelsMenuFragment);
        fragmentTransaction.replace(R.id.fragmentContainerView4, hotelsDataFragment);
    }

    // Options menu creation
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    // Options menu selection actions
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