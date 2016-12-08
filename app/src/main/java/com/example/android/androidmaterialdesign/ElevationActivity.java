package com.example.android.androidmaterialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ElevationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elevation);

        TextView textView = (TextView) findViewById(R.id.tv_translation_z);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getTranslationZ() == 0) {
                    v.setTranslationZ(20*getResources().getDisplayMetrics().density);
                } else {
                    v.setTranslationZ(0);
                }
            }
        });
    }
}
