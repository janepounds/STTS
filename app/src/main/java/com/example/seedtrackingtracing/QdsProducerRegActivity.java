package com.example.seedtrackingtracing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class QdsProducerRegActivity extends AppCompatActivity {
    private TextView seedProducerTv;
    private EditText dateEt,farmLocationEt,yearsOfExperienceEt,growersNumberEt,fallowsEt;
    private Spinner adequateIsolationSp,farmOperationsSp,certifiedSeedSp;
    private Button saveBtn, submitBtn, cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qds_producer_reg);

        seedProducerTv = findViewById(R.id.seed_producer_tv);
        dateEt = findViewById(R.id.date_text_view_producer);
        farmLocationEt = findViewById(R.id.location_of_farm_et);
        yearsOfExperienceEt = findViewById(R.id.years_of_experience_as_grower_et_producer);
        growersNumberEt = findViewById(R.id.growers_number_et);
        fallowsEt = findViewById(R.id.fallows_et);
        adequateIsolationSp = findViewById(R.id.adequate_isolation_spinner);
        farmOperationsSp = findViewById(R.id.farm_operations_spinner);
        certifiedSeedSp = findViewById(R.id.certified_seed_spinner);
        saveBtn = findViewById(R.id.save_button_producer);
        submitBtn = findViewById(R.id.submit_button_producer);
        cancelBtn = findViewById(R.id.cancel_btn_producer);


        //Button onClickListeners
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

        //Spinner Adapters

        ArrayAdapter arrayAdapter =  ArrayAdapter.createFromResource(this, R.array.status,android.R.layout.simple_spinner_item);

        adequateIsolationSp.setAdapter(arrayAdapter);
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

        farmOperationsSp.setAdapter(arrayAdapter);
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

        certifiedSeedSp.setAdapter(arrayAdapter);
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

    }
}