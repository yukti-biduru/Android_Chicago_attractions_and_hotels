package com.example.chicago_attractions_and_hotels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

public class ChicagoAttractions extends AppCompatActivity {

    // Declare parameters
    private int itemSelected = 0;
    private final AttractionsMenu attractionsMenuFragment = new AttractionsMenu();
    private final AttractionsData attractionsDataFragment = new AttractionsData();
    private MenuViewModel model;
    private int currentIndex = -1;

    public ArrayList<String> URLList = new ArrayList<String>
            (Arrays.asList("https://www.uic.edu/","URL2","URL3","URL4","URL5"));

    // Initialize the fragments and map them to the static layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicago_attractions);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, attractionsMenuFragment);
        fragmentTransaction.replace(R.id.fragmentContainerView2, attractionsDataFragment);
        model = new ViewModelProvider(this).get(MenuViewModel.class);
        model.getSelectedItem().observe(this, item -> {

            if (item < 0 || item >= URLList.size())
                return;
            currentIndex = item;

        });
    }

    // Options menu creation
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    // Actions defined on options menu item selection
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