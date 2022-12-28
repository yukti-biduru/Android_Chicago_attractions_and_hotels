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

import java.util.ArrayList;
import java.util.Arrays;

public class HotelsData extends Fragment {

    // Declare parameters
    private WebView hotelsWebView;
    private MenuViewModel model;
    private int currentIndex = -1;
    public ArrayList<String> URLList = new ArrayList<String>
            (Arrays.asList("https://www.hilton.com/en/hotels/chichhh-hilton-chicago/",
                    "https://www.omnihotels.com/hotels/chicago",
                    "https://www.ihg.com/holidayinn/hotels/us/en/chicago/chiwh/hoteldetail",
                    "https://www.hyatt.com/en-US/hotel/illinois/hyatt-place-chicago-downtown-the-loop/chizp",
                    "https://www.hilton.com/en/hotels/chimmdt-doubletree-chicago-magnificent-mile/"));
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the layout of the fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hotels_data, container, false);
    }

    // Map the url associated with the clicked value
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hotelsWebView = getActivity().findViewById(R.id.hotelsWebView);

        model = new ViewModelProvider(requireActivity()).get(MenuViewModel.class);
        model.getSelectedItem().observe(getViewLifecycleOwner(), item -> {

            if (item < 0 || item >= URLList.size())
                return;
            currentIndex = item;
            hotelsWebView.loadUrl(this.URLList.get(currentIndex));
        });
    }
}