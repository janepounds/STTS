package com.example.seedtrackingtracing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seedtrackingtracing.dataobjects.MerchantRegInfo;
import com.example.seedtrackingtracing.dataobjects.SeedGrowerReg;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class SeedGrowerRegistrationActivity extends AppCompatActivity {
    private static final String TAG = SeedGrowerRegistrationActivity.class.getSimpleName();
    private TextView seedGrowerTv,dateTv;
    private EditText yearsAsGrowerEt,hectaresEt,seedSourceEt,growerNumberEt,lastCropsEt;
    private Spinner cropSp, cropVarietySp,adequateIsolationSp,farmOperationsSp,certifiedSeedSp;
    private Button saveBtn,submitBtn, cancelBtn;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    private FirebaseFirestore db;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
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

        db = FirebaseFirestore.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
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
                seedgrowerreg();

            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void seedgrowerreg() {

        Integer years_of_experience =Integer.parseInt(yearsAsGrowerEt.getText().toString().trim());
        String crop = cropSp.getSelectedItem().toString();
        String crop_variety = cropVarietySp.getSelectedItem().toString();
        Integer no_of_hectares =Integer.parseInt(hectaresEt.getText().toString().trim()) ;
        String source_of_seed = seedSourceEt.getText().toString().trim();
        Integer grower_number = Integer.parseInt(growerNumberEt.getText().toString().trim());
        String last_crop_of_season = lastCropsEt.getText().toString().trim();
        String adequate_isolation= adequateIsolationSp.getSelectedItem().toString();
        String adequate_labour =farmOperationsSp.getSelectedItem().toString();
        String certified_seed_awareness =certifiedSeedSp.getSelectedItem().toString();

        SeedGrowerReg merchantRegInfo= new SeedGrowerReg("Joseph Kaizzi",years_of_experience,crop,crop_variety, no_of_hectares,source_of_seed,grower_number,last_crop_of_season,adequate_isolation,adequate_labour,certified_seed_awareness);
//        FirebaseUser user = firebaseAuth.getCurrentUser();
        // db.child(user.getUid()).setValue(profile);
        db.collection("mCBeDnxGmGQKRSU7JGVSR5We25t2").document(
                "seed_grower_registration")
                .set(merchantRegInfo)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
        Toast.makeText(getApplicationContext(), "Seed grower registered successfully", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}