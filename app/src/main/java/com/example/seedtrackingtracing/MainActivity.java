package com.example.seedtrackingtracing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.seedtrackingtracing.utils.Utils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    LinearLayout seedOrder,registration;
    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    boolean isUserFirstTime;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       getSupportActionBar().setTitle("Welcome, Joseph");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));



        seedOrder =  findViewById(R.id.layout_seed_order);
        registration = findViewById(R.id.layout_registration);
        seedOrder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                seedorders(v);
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

        registrations(v);
            }
        });
    }
    private void seedorders(View v) {

        PopupMenu popup = new PopupMenu(this, v);
        // Inflate the menu from xml
        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());

        // Setup menu item selection
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.egs:
                        Toast.makeText(MainActivity.this, "EGS", Toast.LENGTH_SHORT).show();

                        return true;
                    case R.id.lsb:
                        Toast.makeText(MainActivity.this, "LSB", Toast.LENGTH_SHORT).show();

                        return true;
                    default:
                        return false;
                }
            }
        });
        // Handle dismissal with: popup.setOnDismissListener(...);
        // Show the menu
        popup.show();
    }
    private void registrations(View v) {

        PopupMenu popup = new PopupMenu(this, v);
        // Inflate the menu from xml
        popup.getMenuInflater().inflate(R.menu.popup2, popup.getMenu());

        // Setup menu item selection
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.sr4:
                        Toast.makeText(MainActivity.this, "Form SR4", Toast.LENGTH_SHORT).show();
                        loadsr4();
                        return true;
                    case R.id.sr6:
                        Toast.makeText(MainActivity.this, "Form SR6", Toast.LENGTH_SHORT).show();

                        return true;
                    case R.id.qds:
                        Toast.makeText(MainActivity.this, "Form QDS R1", Toast.LENGTH_SHORT).show();

                        return true;
                    default:
                        return false;
                }
            }
        });
        // Handle dismissal with: popup.setOnDismissListener(...);
        // Show the menu
        popup.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                getProfile();
                return true;
            case R.id.action_settings:
                goToSettings();
                return true;
            case R.id.action_about:
                // Settings option clicked.
                about();
                return true;
            case R.id.action_help:
                // Settings option clicked.
                help();
                return true;
            case R.id.log_out:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void getProfile(){
        Intent profile = new Intent(this, ProfileDetails.class);
        startActivity(profile);
        finish();

    }
    public void goToSettings(){

    }
    public void about(){

    }
    public void logout(){
        Intent logout=new Intent(this,LandingPage.class);
        startActivity(logout);
        finish();
    }
    public void help(){


    }

    public void loadoders() {
        Intent signup = new Intent(this,SeedOrders.class);
        startActivity(signup);
        finish();
    }

    public void loadegs() {
        Intent signup = new Intent(this,EgsSeedOrders.class);
        startActivity(signup);
        finish();
    }
    public void loadsr4() {
        Intent signup = new Intent(this,SeedMerchantRegActivity.class);
        startActivity(signup);
        finish();
    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to logout?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                        startActivity(intent);
                    }
                }).create().show();
    }
}
