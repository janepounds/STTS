package com.example.seedtrackingtracing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SeedGrowerRegistrationActivity extends AppCompatActivity {

    private TextView seedGrowerTv,dateTv;
    private EditText yearsAsGrowerEt,hectaresEt,seedSourceEt,growerNumberEt,lastCropsEt;
    private Spinner cropSp, cropVarietySp,adequateIsolationSp,farmOperationsSp,certifiedSeedSp;
    private Button saveBtn,submitBtn, cancelBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seed_grower_registration);
        getSupportActionBar().setTitle("Seed Grower Registration");

        seedGrowerTv = findViewById(R.id.seed_grower_tv);
        dateTv = findViewById(R.id.date_text_view);
        yearsAsGrowerEt = findViewById(R.id.years_of_experience_as_grower_et);
        hectaresEt = findViewById(R.id.hectares_et);
        seedSourceEt = findViewById(R.id.seed_source_et);
        growerNumberEt = findViewById(R.id.grower_number_et);
        lastCropsEt = findViewById(R.id.last_crops_et);
        cropSp = findViewById(R.id.crop_spinner);
        cropVarietySp = findViewById(R.id.crop_variety_sp);
        adequateIsolationSp = findViewById(R.id.adequate_isolation_sp);
        farmOperationsSp = findViewById(R.id.farm_operations_sp);
        certifiedSeedSp = findViewById(R.id.certified_seed_sp);
        saveBtn = findViewById(R.id.save_button);
        submitBtn = findViewById(R.id.submit_button);
        cancelBtn = findViewById(R.id.cancel_btn);


        //Spinner adapters
        ArrayAdapter arrayAdapter =  ArrayAdapter.createFromResource(this, R.array.select_crop,android.R.layout.simple_spinner_item);
        cropSp.setAdapter(arrayAdapter);
        cropSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long Id) {
                if (i == 0) { // When user clicked on "Choose One" hint and the initial call.
                    ((TextView) view).setTextColor(getResources().getColor(R.color.hint_color));
                    ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
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

        ArrayAdapter arrayAdapter1 =  ArrayAdapter.createFromResource(this, R.array.select_crop_variety,android.R.layout.simple_spinner_item);
        cropVarietySp.setAdapter(arrayAdapter1);
        cropVarietySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long Id) {
                if (i == 0) { // When user clicked on "Choose One" hint and the initial call.
                    ((TextView) view).setTextColor(getResources().getColor(R.color.hint_color));
                    ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
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

        ArrayAdapter arrayAdapter2 =  ArrayAdapter.createFromResource(this, R.array.status,android.R.layout.simple_spinner_item);
        adequateIsolationSp.setAdapter(arrayAdapter2);
        adequateIsolationSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long Id) {
                if (i == 0) { // When user clicked on "Choose One" hint and the initial call.
                    ((TextView) view).setTextColor(getResources().getColor(R.color.hint_color));
                    ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
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

        ArrayAdapter arrayAdapter3 =  ArrayAdapter.createFromResource(this, R.array.status,android.R.layout.simple_spinner_item);
        farmOperationsSp.setAdapter(arrayAdapter3);
        farmOperationsSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long Id) {
                if (i == 0) { // When user clicked on "Choose One" hint and the initial call.
                    ((TextView) view).setTextColor(getResources().getColor(R.color.hint_color));
                    ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
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

        ArrayAdapter arrayAdapter4 =  ArrayAdapter.createFromResource(this, R.array.status,android.R.layout.simple_spinner_item);
        certifiedSeedSp.setAdapter(arrayAdapter4);
        certifiedSeedSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long Id) {
                if (i == 0) { // When user clicked on "Choose One" hint and the initial call.
                    ((TextView) view).setTextColor(getResources().getColor(R.color.hint_color));
                    ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
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

        //Button onClickListener
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}