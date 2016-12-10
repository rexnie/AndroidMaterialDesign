package com.example.android.androidmaterialdesign;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

public class CircularRevealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_reveal);

        final View oval = findViewById(R.id.iv_oval);
        oval.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animator a = ViewAnimationUtils.createCircularReveal(oval,
                        oval.getWidth() / 2,
                        oval.getHeight() / 2,
                        oval.getWidth(),
                        0);
                a.setInterpolator(new AccelerateDecelerateInterpolator());
                a.setDuration(2000);
                a.start();
            }
        });

        final View rect = findViewById(R.id.iv_rect);
        rect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Animator a = ViewAnimationUtils.createCircularReveal(rect,
                        0, 0, 0, (float) Math.hypot(rect.getWidth(), rect.getHeight()));
                a.setInterpolator(new AccelerateDecelerateInterpolator());
                a.setDuration(2000);
                a.start();
            }
        });
    }
}
