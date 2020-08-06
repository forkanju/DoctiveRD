package com.pal.doctive.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pal.doctive.R;

public class SurveyCompletedActivity extends AppCompatActivity {

    private static int SPLASH_TIMEOUT = 2500;
    TextView allSets;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_completed);

        allSets = findViewById(R.id.all_set);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SurveyCompletedActivity.this, CoachReadyActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIMEOUT);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splashanimation);
        allSets.startAnimation(animation);

    }
}