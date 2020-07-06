package com.example.seedtrackingtracing;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class EgsSeedOrders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egsseed_orders);
        getSupportActionBar().setTitle("Seed Orders");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));
    }
}
