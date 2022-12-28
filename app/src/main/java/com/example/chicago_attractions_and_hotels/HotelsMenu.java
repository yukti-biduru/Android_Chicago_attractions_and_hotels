package com.example.chicago_attractions_and_hotels;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HotelsMenu extends Fragment {

    private RecyclerView recycler_list_view;
    private RVClickListener listener;
    private int _position;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotels_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listener = (listenerView, position) -> {
            _position = position;
            Log.i("execution","listener getting executed");
        };
        recycler_list_view = getActivity().findViewById(R.id.recycler_list_view2);
        RecyclerAdapterHotels recyclerAdapterHotels = new RecyclerAdapterHotels(listener);
        recycler_list_view.setHasFixedSize(false);
        recycler_list_view.setAdapter(recyclerAdapterHotels);
        recycler_list_view.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}