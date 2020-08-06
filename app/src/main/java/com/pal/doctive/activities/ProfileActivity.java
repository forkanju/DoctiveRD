package com.pal.doctive.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.pal.doctive.R;
import com.pal.doctive.adapters.AdapterFragmentP;
import com.pal.doctive.fragments.AllWeekFragment;
import com.pal.doctive.fragments.LastWeekFragment;
import com.pal.doctive.fragments.ThisWeekFragment;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private ArrayList<Fragment> mListFragments;
    private ViewPager mViewPager;
    private ImageView settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        settings = findViewById(R.id.settings);

//         //For Hide Status/Notification Bar background color;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        }

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, WeekActivity.class);
                startActivity(intent);
            }
        });

        mListFragments = new ArrayList<>();
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        ThisWeekFragment mThisWeekFragment = new ThisWeekFragment();
        mListFragments.add(mThisWeekFragment);

        LastWeekFragment mLastWeekFragment = new LastWeekFragment();
        mListFragments.add(mLastWeekFragment);

        AllWeekFragment mAllWeekFragment = new AllWeekFragment();
        mListFragments.add(mAllWeekFragment);

        AdapterFragmentP mViewPagerAdapter = new AdapterFragmentP(getSupportFragmentManager(), 1, mListFragments);
        mViewPager.setAdapter(mViewPagerAdapter);


    }
}