package com.example.android.androidmaterialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_palette).setOnClickListener(this);
        findViewById(R.id.btn_elevation).setOnClickListener(this);
        findViewById(R.id.btn_tinting_clipping).setOnClickListener(this);
        findViewById(R.id.btn_recycler_view).setOnClickListener(this);
        findViewById(R.id.btn_card_view).setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_palette:
                startActivity(new Intent(this, PaletteActivity.class));
                break;
            case R.id.btn_elevation:
                startActivity(new Intent(this, ElevationActivity.class));
                break;
            case R.id.btn_tinting_clipping:
                startActivity(new Intent(this, TintingClippingActivity.class));
                break;
            case R.id.btn_recycler_view:
                startActivity(new Intent(this, RecyclerActivity.class));
                break;
            case R.id.btn_card_view:
                startActivity(new Intent(this, CardViewActivity.class));
                break;
        }
    }
}
