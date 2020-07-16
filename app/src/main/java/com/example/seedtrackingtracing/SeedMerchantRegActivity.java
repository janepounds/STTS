package com.example.seedtrackingtracing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seedtrackingtracing.dataobjects.MerchantRegInfo;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SeedMerchantRegActivity extends AppCompatActivity {
    private static final String TAG = SeedMerchantRegActivity.class.getSimpleName();
   private TextView declarationTv,seedMerchantTv;
   private EditText yearsEt, experienceAsEt,productionOtherCropsEt,dateTv, processingOtherCropsEt,marketingOtherCrops2Et,breederSeedEt,basicSeedEt;
   private Spinner productionOfSp,processingOfSp,marketingOfSp,basicNeedsSp,recruitedSp,seedProductionSp,seedMattersSp,basicSeedSp,qualityProgramSp;
   private Button saveBtn, submitBtn, cancelBtn;
    Calendar myCalendar = Calendar.getInstance();
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    private FirebaseFirestore db;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private static final String DIALOG_TITLE = "Please wait ..." ;
    private static final String DIALOG_MESSAGE = "Registering seed merchant.." ;
    final Handler mHandler = new Handler();
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seed_merchant_reg);
        getSupportActionBar().setTitle("Seed Merchant Registration");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));

        declarationTv = findViewById(R.id.declaration_text_view);
        dateTv = findViewById(R.id.date_text_view);

        seedMerchantTv = findViewById(R.id.seed_merchant_tv);
        yearsEt = findViewById(R.id.applicant_years_of_experience_et);
        experienceAsEt = findViewById(R.id.years_of_experience_as_et);
        productionOtherCropsEt = findViewById(R.id.other_crops_et);
        processingOtherCropsEt = findViewById(R.id.other_crops2_et);
        marketingOtherCrops2Et = findViewById(R.id.other_crops3_et);
        breederSeedEt = findViewById(R.id.breeder_seed_et);
        basicSeedEt = findViewById(R.id.basic_seed_et);
        productionOfSp = findViewById(R.id.crop_sp);
        processingOfSp = findViewById(R.id.processing_of_sp);
        marketingOfSp = findViewById(R.id.marketing_of_sp);
        basicNeedsSp = findViewById(R.id.basic_needs_sp);
        recruitedSp = findViewById(R.id.recruited_sp);
        seedProductionSp = findViewById(R.id.seed_production_sp);
        seedMattersSp= findViewById(R.id.seed_matters_sp);
        basicSeedSp = findViewById(R.id.basic_seed_sp);
        qualityProgramSp = findViewById(R.id.quality_sp);
        saveBtn = findViewById(R.id.save_order_btn);
        submitBtn = findViewById(R.id.submit_order_btn);
        cancelBtn = findViewById(R.id.cancel_order_btn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);



        declarationTv.setMovementMethod(new ScrollingMovementMethod());

        db = FirebaseFirestore.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();



        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        dateTv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SeedMerchantRegActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //Buttons onClickListeners
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                merchantreg();
                showprogessDialog();

            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Spinner Adapters

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.crops, android.R.layout.simple_spinner_item);
        productionOfSp.setAdapter(adapter);
        productionOfSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.crops, android.R.layout.simple_spinner_item);
        processingOfSp.setAdapter(adapter2);
        processingOfSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this,R.array.crops, android.R.layout.simple_spinner_item);
        marketingOfSp.setAdapter(adapter3);
        marketingOfSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this,R.array.status, android.R.layout.simple_spinner_item);
        basicSeedSp.setAdapter(adapter4);
        basicSeedSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(this,R.array.status, android.R.layout.simple_spinner_item);
        basicNeedsSp.setAdapter(adapter5);
        basicNeedsSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        ArrayAdapter adapter6 = ArrayAdapter.createFromResource(this,R.array.status, android.R.layout.simple_spinner_item);
        recruitedSp.setAdapter(adapter6);
        recruitedSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        ArrayAdapter adapter7 = ArrayAdapter.createFromResource(this,R.array.status, android.R.layout.simple_spinner_item);
        seedProductionSp.setAdapter(adapter7);
        seedProductionSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        ArrayAdapter adapter8 = ArrayAdapter.createFromResource(this,R.array.status, android.R.layout.simple_spinner_item);
        seedMattersSp.setAdapter(adapter8);
        seedMattersSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        ArrayAdapter adapter9 = ArrayAdapter.createFromResource(this,R.array.status, android.R.layout.simple_spinner_item);
        qualityProgramSp.setAdapter(adapter9);
        qualityProgramSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

        dateTv.setText(sdf.format(myCalendar.getTime()));
    }

    private void merchantreg() {


        Integer years_of_experience =Integer.parseInt(yearsEt.getText().toString().trim());
        String experience_as = experienceAsEt.getText().toString().trim();
        String prodtn_other_crops = productionOtherCropsEt.getText().toString().trim();
        String processing_other_crops = processingOtherCropsEt.getText().toString().trim();
        String markeing_other_crops = marketingOtherCrops2Et.getText().toString().trim();
        String source_breeder_seed = breederSeedEt.getText().toString().trim();
        String source_basic_seed = basicSeedEt.getText().toString().trim();
        String productionOf = productionOfSp.getSelectedItem().toString();
        String prossessingOf =processingOfSp.getSelectedItem().toString();
        String marketingOf =marketingOfSp.getSelectedItem().toString();
        String basic_needs =basicNeedsSp.getSelectedItem().toString();
        String contractual = recruitedSp.getSelectedItem().toString();
        String field_officers = seedProductionSp.getSelectedItem().toString();
        String personnel = seedMattersSp.getSelectedItem().toString();
        String quality_program = qualityProgramSp.getSelectedItem().toString();
        String basicSeed = basicSeedSp.getSelectedItem().toString();
        MerchantRegInfo merchantRegInfo= new MerchantRegInfo("Joseph Kaizzi",years_of_experience,experience_as,productionOf,prodtn_other_crops,prossessingOf,processing_other_crops,marketingOf,markeing_other_crops,basic_needs,contractual,field_officers,personnel,source_breeder_seed,source_basic_seed,basicSeed,quality_program);
//        FirebaseUser user = firebaseAuth.getCurrentUser();
        // db.child(user.getUid()).setValue(profile);
        db.collection("mCBeDnxGmGQKRSU7JGVSR5We25t2").document(
                "seed_merchant_registration")
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
        Toast.makeText(getApplicationContext(), "Seed merchant registered successfully", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void showprogessDialog(){

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle(DIALOG_TITLE);
        dialog.setMessage(DIALOG_MESSAGE);
        dialog.setIndeterminate(true);
        dialog.setCancelable(true);
        dialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5 * 1000); // Here we can place our time consuming task
                    dismissDialog(dialog);
                }catch(Exception e){
                    dismissDialog(dialog);
                }

            }
        }).start();


    }

    public void dismissDialog(final ProgressDialog pd){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                pd.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(SeedMerchantRegActivity.this,MainActivity.class);
        startActivity(intent);
    }
}