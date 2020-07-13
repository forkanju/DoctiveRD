package com.pal.doctive.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.pal.doctive.R;

public class MainActivity extends AppCompatActivity {

    //splash timeout
    private static int SPLASH_TIMEOUT = 2500;
    TextView wcText, fitText;
    ImageView gymIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wcText = (TextView) findViewById(R.id.text_wc);
        fitText = (TextView) findViewById(R.id.text_fitness);
        gymIcon = (ImageView) findViewById(R.id.icon_gym);

        // For Hide Status/Notification Bar background color;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        //Splash screen ..

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIMEOUT);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splashanimation);
        wcText.startAnimation(animation);
        fitText.startAnimation(animation);
        gymIcon.startAnimation(animation);


    }


}
