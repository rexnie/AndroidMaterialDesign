package com.example.android.androidmaterialdesign;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;

public class TransitionAActivity extends AppCompatActivity implements View.OnClickListener {
    private View mBtnFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_a);
        findViewById(R.id.btn_explode).setOnClickListener(this);
        findViewById(R.id.btn_slide).setOnClickListener(this);
        findViewById(R.id.btn_fade).setOnClickListener(this);
        findViewById(R.id.btn_share).setOnClickListener(this);
        mBtnFab = findViewById(R.id.btn_fab);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_explode:
                newIntentStart(0);
                break;
            case R.id.btn_slide:
                newIntentStart(1);
                break;
            case R.id.btn_fade:
                newIntentStart(2);
                break;
            case R.id.btn_share:
                Intent intent = new Intent(this, TransitionBActivity.class);
                intent.putExtra("flag", 3);

                /* 创建共享元素，ActivityA和ActivityB的transitionName 必须一致*/

                /* 创建单个共享元素 */
                /*startActivity(intent, ActivityOptions
                        .makeSceneTransitionAnimation(this, v, "share")
                        .toBundle()
                );
                */

                /* 创建多个共享元素 */
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,
                        Pair.create(v, "share"),
                        Pair.create(mBtnFab, "fab")).toBundle()
                );
                break;
        }
    }

    private void newIntentStart(int flag) {
        Intent intent = new Intent(this, TransitionBActivity.class);
        intent.putExtra("flag", flag);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
