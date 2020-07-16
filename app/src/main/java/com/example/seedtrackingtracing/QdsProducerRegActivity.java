package com.example.seedtrackingtracing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

import com.example.seedtrackingtracing.dataobjects.QdsReg;
import com.example.seedtrackingtracing.dataobjects.SeedGrowerReg;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class QdsProducerRegActivity extends AppCompatActivity {
    private static final String TAG = SeedGrowerRegistrationActivity.class.getSimpleName();
    private TextView seedProducerTv;
    private EditText dateEt,farmLocationEt,yearsOfExperienceEt,growersNumberEt,fallowsEt;
    private Spinner adequateIsolationSp,farmOperationsSp,certifiedSeedSp;
    private Button saveBtn, submitBtn, cancelBtn;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    private FirebaseFirestore db;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    Calendar myCalendar = Calendar.getInstance();
    private static final String DIALOG_TITLE = "Please wait ..." ;
    private static final String DIALOG_MESSAGE = "Registering qds producer.." ;
    final Handler mHandler = new Handler();
    private ProgressBar progressBar;

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
        db = FirebaseFirestore.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);



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

        dateEt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(QdsProducerRegActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //Button onClickListeners
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    qdsreg();
                    showprogessDialog();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

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
    private void updateLabel() {
        String myFormat = "dd/mm/yyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

        dateEt.setText(sdf.format(myCalendar.getTime()));
    }

    private void qdsreg() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyy");
        String location = farmLocationEt.getText().toString().trim();
        Integer years_of_experience =Integer.parseInt(yearsOfExperienceEt.getText().toString().trim());
        Integer grower_number = Integer.parseInt(growersNumberEt.getText().toString().trim());
        String cropping_history =fallowsEt.getText().toString().trim();
        String adequate_isolation= adequateIsolationSp.getSelectedItem().toString();
        String certified_seed_awareness =certifiedSeedSp.getSelectedItem().toString();
        Date application_date = format.parse(dateEt.getText().toString().trim());

        QdsReg qdsReg= new QdsReg("Joseph Kaizzi",location,years_of_experience,grower_number,cropping_history,adequate_isolation,certified_seed_awareness,application_date);
//        FirebaseUser user = firebaseAuth.getCurrentUser();
        // db.child(user.getUid()).setValue(profile);
        db.collection("mCBeDnxGmGQKRSU7JGVSR5We25t2").document(
                "qds_registration")
                .set(qdsReg)
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
        Toast.makeText(getApplicationContext(), "Qds producer registered successfully", Toast.LENGTH_LONG).show();
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

        Intent intent = new Intent(QdsProducerRegActivity.this,MainActivity.class);
        startActivity(intent);
    }
}