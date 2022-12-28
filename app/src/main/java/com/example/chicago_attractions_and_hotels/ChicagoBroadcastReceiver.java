package com.example.chicago_attractions_and_hotels;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

// Actions to do on receiving the broadcast from another activity
public class ChicagoBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String extra = intent.getStringExtra("display_required");
        if (extra.equals("attractions")) {
            Toast.makeText(context.getApplicationContext(), "attractions intent",Toast.LENGTH_SHORT).show();
        } else if (extra.equals("hotels")) {
            Toast.makeText(context.getApplicationContext(), "hotels intent",Toast.LENGTH_SHORT).show();
        }

    }
}