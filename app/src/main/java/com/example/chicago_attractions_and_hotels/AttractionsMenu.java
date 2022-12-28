package com.example.chicago_attractions_and_hotels;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AttractionsMenu extends Fragment {

    // Declare parameters
    private RecyclerView recycler_list_view;
    private RVClickListener listener;
    private int _position;
    private MenuViewModel model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the layout to create the fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_attractions_menu, container, false);
    }

    // Create the recycler view of the fragment to display the data
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler_list_view = getActivity().findViewById(R.id.recycler_list_view);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(listener);
        recycler_list_view.setHasFixedSize(false);
        recycler_list_view.setAdapter(recyclerAdapter);
        recycler_list_view.setLayoutManager(new LinearLayoutManager(getContext()));
        model = new ViewModelProvider(requireActivity()).get(MenuViewModel.class);
        _position = recyclerAdapter.getPosition();
        listener = (listenerView, position) -> {
        model.selectItem(_position);
        };



    }


}