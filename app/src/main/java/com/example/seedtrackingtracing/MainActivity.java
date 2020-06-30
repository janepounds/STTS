package com.example.seedtrackingtracing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.seedtrackingtracing.utils.Utils;


public class MainActivity extends AppCompatActivity {

    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    boolean isUserFirstTime;

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, "true"));

        Intent introIntent = new Intent(MainActivity.this, OnBoard.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);

        if (isUserFirstTime)
            startActivity(introIntent);

        CardView profileDetails = (CardView) findViewById(R.id.profile_card_view);
        profileDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToProfile = new Intent(getBaseContext(), ProfileDetails.class);
                startActivity(goToProfile);
            }
        });
        CardView orders=(CardView)findViewById(R.id.orders_card_view);
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showorders();
            }
        });

        CardView quality=(CardView)findViewById(R.id.quality_assurance_card_view);
        quality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qualityassurance();
            }
        });

        CardView reg=(CardView)findViewById(R.id.registration_card_view);
        quality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registration();
            }
        });
    }
    public void showorders(){
        Intent order=new Intent(this,PlaceOrder.class);

        startActivity(order);
    }

    public void qualityassurance(){
        Intent qua=new Intent(this,QualityAssurance.class);

        startActivity(qua);
    }
    public void registration(){
        Intent reg=new Intent(this,QualityAssurance.class);

        startActivity(reg);
    }
}
