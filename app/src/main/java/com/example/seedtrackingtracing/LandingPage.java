package com.example.seedtrackingtracing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.seedtrackingtracing.utils.Utils;

import me.relex.circleindicator.CircleIndicator;

public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);
        getSupportActionBar().hide();


        Button signuptbtn = (Button) findViewById(R.id.signupbtn);
        signuptbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                loadsignup();
            }
        });
    }
    public void loadsignup() {
        Intent signup = new Intent(this,SignInActivity.class);
        startActivity(signup);
        finish();
    }
}
