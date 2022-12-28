package com.example.chicago_attractions_and_hotels;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;



public class RecyclerAdapterHotels extends RecyclerView.Adapter<RecyclerAdapterHotels.ViewHolder>{

    // Declare variables
    RVClickListener clickListener;
    ArrayList<String> textList = new ArrayList<String>
                (Arrays.asList("Hilton","Omni","Holiday Inn","Hyatt Place","DoubleTree"));
    RecyclerAdapterHotels.ViewHolder viewHolder;
    private int position;

    // Constructor
    public RecyclerAdapterHotels(RVClickListener listener)
    {
        clickListener = listener;

    }

    // Create the view
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context  = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View listView = inflater.inflate(R.layout.recycler_list_view2, parent, false);
        viewHolder = new ViewHolder(listView, clickListener);
        return viewHolder;
    }

//    Bind the data
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.menuItem.setText(textList.get(position));
        holder.menuItem.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = view -> {
        position = viewHolder.getAdapterPosition();
    };

    @Override
    public int getItemCount() {
        return textList.size();
    }

    // View Holder class for the recycler view
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        RVClickListener onClickListener;
        TextView menuItem;

        public ViewHolder(View view, RVClickListener listener)
        {
            super(view);
            onClickListener = listener;
            menuItem = view.findViewById(R.id.textView2);

        }
        @Override
        public void onClick(View v) {
            onClickListener.onClick(v, getLayoutPosition());
            int position = getLayoutPosition();
            Log.i("Position", String.valueOf(position));
        }
    }
}