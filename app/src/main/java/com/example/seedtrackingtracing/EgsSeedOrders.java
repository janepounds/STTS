package com.example.seedtrackingtracing;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EgsSeedOrders extends AppCompatActivity {
    private Spinner cropSp,seedVarietySp,seedClassSp,inventoryStatusSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egsseed_orders);
        getSupportActionBar().setTitle("Seed Orders");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));

        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.select_crop,
                android.R.layout.simple_spinner_item);
        //link the adapter to the spinner
        cropSp =  findViewById(R.id.select_crop_sp);
        cropSp.setAdapter(adapter);
        cropSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long Id) {
                if (i == 0) { // When user clicked on "Choose One" hint and the initial call.
                    ((TextView) view).setTextColor(getResources().getColor(R.color.hint_color));
                    ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                    return;
                }
                i--;  // undo the "Choose One" hint.

                // Your business logic

                // i = 0 map to item0
                // i = 1 map to item1
                // ...

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });


        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.select_crop_variety,
                android.R.layout.simple_spinner_item);
        //link the adapter to the spinner
        seedVarietySp = findViewById(R.id.select_crop_variety_sp);
        seedVarietySp.setAdapter(adapter2);
        seedVarietySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long Id) {
                if (i == 0) { // When user clicked on "Choose One" hint and the initial call.
                    ((TextView) view).setTextColor(getResources().getColor(R.color.hint_color));
                    ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                    return;
                }
                i--;  // undo the "Choose One" hint.

                // Your business logic

                // i = 0 map to item0
                // i = 1 map to item1
                // ...

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                this,
                R.array.select_seed_class,
                android.R.layout.simple_spinner_item);
        //link the adapter to the spinner
        seedClassSp = findViewById(R.id.select_seed_class_sp);
        seedClassSp.setAdapter(adapter3);
        seedClassSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long Id) {
                if (i == 0) { // When user clicked on "Choose One" hint and the initial call.
                    ((TextView) view).setTextColor(getResources().getColor(R.color.hint_color));
                    ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                    return;
                }
                i--;  // undo the "Choose One" hint.

                // Your business logic

                // i = 0 map to item0
                // i = 1 map to item1
                // ...

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(
                this,
                R.array.select_inventory_status,
                android.R.layout.simple_spinner_item);
        //link the adapter to the spinner
        inventoryStatusSp = findViewById(R.id.select_inventory_status_sp);
        inventoryStatusSp.setAdapter(adapter4);
        inventoryStatusSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long Id) {
                if (i == 0) { // When user clicked on "Choose One" hint and the initial call.
                    ((TextView) view).setTextColor(getResources().getColor(R.color.hint_color));
                    ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                    return;
                }
                i--;  // undo the "Choose One" hint.

                // Your business logic

                // i = 0 map to item0
                // i = 1 map to item1
                // ...

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });
    }
}
