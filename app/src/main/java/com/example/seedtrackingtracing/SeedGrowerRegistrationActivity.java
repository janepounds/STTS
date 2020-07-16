package com.example.seedtrackingtracing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }
}