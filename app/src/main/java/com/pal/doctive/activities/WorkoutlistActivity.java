package com.pal.doctive.activities;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.pal.doctive.R;

public class WorkoutlistActivity extends AppCompatActivity {
    private View workout1Layout;
    private Button startWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutlist);
        //  getSupportActionBar().hide();
        // For Hide Status/Notification Bar background color;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        workout1Layout = findViewById(R.id.workout1_layout);
        startWorkout = findViewById(R.id.start_workout);
        workout1Layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutlistActivity.this, WorkoutdetailsActivity.class);
                startActivity(intent);
            }
        });

        startWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutlistActivity.this, WorkoutrunningActivity.class);
                startActivity(intent);
            }
        });

    }
}