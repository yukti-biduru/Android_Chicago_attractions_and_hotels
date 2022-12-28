package com.example.chicago_attractions_and_hotels;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class AttractionsData extends Fragment {

    // Declare  parameters
    private WebView attractionsWebView;
    private MenuViewModel model;
    private int currentIndex = -1;
    public ArrayList<String> URLList = new ArrayList<String>
            (Arrays.asList(
                    "https://www.lpzoo.org/",
                    "https://navypier.org/",
                    "https://www.msichicago.org/",
                    "https://www.artic.edu/",
                    "https://www.thetilt.com/"));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    // Constructor for the fragment
    public AttractionsData()
    {

    }

    // Parameterized constructor for the fragment
    public AttractionsData(int position)
    {
        attractionsWebView.loadUrl(this.URLList.get(position));
    }

    // Inflate the layout to create the fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attractions_data, container, false);
    }

    // Load the WebView in the fragment
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attractionsWebView = getActivity().findViewById(R.id.attractionsWebView);
        model = new ViewModelProvider(requireActivity()).get(MenuViewModel.class);
        model.getSelectedItem().observe(getViewLifecycleOwner(), item -> {

            if (item < 0 || item >= URLList.size())
                return;
            currentIndex = item;
            attractionsWebView.loadUrl(this.URLList.get(currentIndex));
        });

    }
}