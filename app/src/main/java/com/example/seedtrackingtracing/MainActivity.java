package com.example.seedtrackingtracing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.seedtrackingtracing.utils.Utils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

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


        CardView signuptbtn = (CardView) findViewById(R.id.card_view_order);
        signuptbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                seedorders(v);
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
                        loadegs();
                        return true;
                    case R.id.lsb:
                        Toast.makeText(MainActivity.this, "LSB", Toast.LENGTH_SHORT).show();
                        loadoders();
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
        Intent profile = new Intent(this, EditProfileActivity.class);
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

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
