package com.example.seedtrackingtracing;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.seedtrackingtracing.utils.FontManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME = 5000;


    RelativeLayout edubg;

    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

            if (firebaseUser == null) {
                Intent intent = new Intent(SplashActivity.this, LandingPage.class);
                startActivity(intent);
                finish();
            }
            if (firebaseUser != null) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        //firebase instance
        firebaseAuth = FirebaseAuth.getInstance();
        //        Transparent Status Bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_splash);
        edubg = (RelativeLayout) findViewById(R.id.edubg);


        edubg.setVisibility(View.INVISIBLE);





        edubg();

        new BackgroundTask().execute();
    }

    public void edubg() {


        YoYo.with(Techniques.FadeIn)
                .duration(1000)
                .interpolate(new AccelerateDecelerateInterpolator())
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                        edubg.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {



                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .playOn(edubg);

    }







    private class BackgroundTask extends AsyncTask {
        // Intent intent;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // firebaseAuth.addAuthStateListener(authStateListener);
            //  intent = new Intent(Splash.this, MainActivity.class);
        }

        @Override
        protected Object doInBackground(Object[] params) {

            /*  Use this method to load background
             * data that your app needs. */

            try {
                Thread.sleep(SPLASH_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
//            Pass your loaded data here using Intent

//            intent.putExtra("data_key", "");
            // startActivity(intent);
            // finish();
            firebaseAuth.addAuthStateListener(authStateListener);
        }
    }
}
