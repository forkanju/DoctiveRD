package com.pal.doctive.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.pal.doctive.R;
import com.pal.doctive.adapters.AdapterFragmentQ;
import com.pal.doctive.fragments.AgeFragment;
import com.pal.doctive.fragments.DiabetesFragment;
import com.pal.doctive.fragments.GenderFragment;
import com.pal.doctive.fragments.GoalFragment;
import com.pal.doctive.fragments.HeartdiseasFragment;
import com.pal.doctive.fragments.HeightFragment;
import com.pal.doctive.fragments.MailFragment;
import com.pal.doctive.fragments.WeightFragment;
import com.pal.doctive.models.Answers;

import java.util.ArrayList;

public class SurveyActivity extends AppCompatActivity {

    private ArrayList<Fragment> mListFragments;
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

//           // For Hide Status/Notification Bar background color;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLIPOP) {
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        }



        mListFragments = new ArrayList<>();
        mViewPager = (ViewPager) findViewById(R.id.pager);


        GenderFragment genderFragment = new GenderFragment();
        mListFragments.add(genderFragment);

        GoalFragment goalFragment = new GoalFragment();
        mListFragments.add(goalFragment);

        AgeFragment ageFragment = new AgeFragment();
        mListFragments.add(ageFragment);

        HeightFragment heightFragment = new HeightFragment();
        mListFragments.add(heightFragment);

        WeightFragment weightFragment = new WeightFragment();
        mListFragments.add(weightFragment);

        DiabetesFragment diabetesFragment = new DiabetesFragment();
        mListFragments.add(diabetesFragment);

        HeartdiseasFragment heartdiseasFragment = new HeartdiseasFragment();
        mListFragments.add(heartdiseasFragment);

        MailFragment mailFragment = new MailFragment();
        mListFragments.add(mailFragment);

        AdapterFragmentQ mViewPagerAdapter = new AdapterFragmentQ(getSupportFragmentManager(), 1, mListFragments);
        mViewPager.setAdapter(mViewPagerAdapter);



    }

    public void go_to_next() {
        mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
    }

    public void go_to_back() {
        mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
    }


    public void event_survey_completed(Answers instance) {

        Log.e("TAG", "FINISH " + instance.get_json_object());
        //Toast.makeText(getApplicationContext(), "Survey completed!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(SurveyActivity.this, WeekActivity.class);
        startActivity(intent);
       // finish();
    }


}
