package com.example.seedtrackingtracing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.seedtrackingtracing.utils.Utils;

import me.relex.circleindicator.CircleIndicator;

public class OnBoard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        getSupportActionBar().hide();

        ViewPager defaultViewpager = (ViewPager) findViewById(R.id.viewpager_default);
        CircleIndicator defaultIndicator = (CircleIndicator) findViewById(R.id.indicator_default);
        PagerAdapter defaultPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        defaultViewpager.setAdapter(defaultPagerAdapter);
        defaultIndicator.setViewPager(defaultViewpager);

        Button goToMain = (Button) findViewById(R.id.get_started);
        goToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  update 1st time pref
                Utils.saveSharedSetting(OnBoard.this, MainActivity.PREF_USER_FIRST_TIME, "false");
                finish();
            }
        });
    }

    public class PagerAdapter extends FragmentPagerAdapter {

        Fragment f;
        private int pagerCount = 4;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            final Fragment result;
            switch (position) {
                case 0:
                    // First Fragment of First Tab
                    result = new FirstScreen();
                    break;
                case 1:
                    // First Fragment of Second Tab
                    result = new SecondScreen();
                    break;
                case 2:
                    // First Fragment of Third Tab
                    result = new ThirdScreen();
                    break;

                case 3:
                    // First Fragment of Third Tab
                    result = new FourthScreen();
                    break;
                default:
                    result = null;
                    break;
            }

            return result;
        }

        @Override
        public int getCount() {
            return pagerCount;
        }
    }
}
