package com.example.android.androidmaterialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;

public class TransitionBActivity extends AppCompatActivity {
    private static final String TAG = "TransitionBActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        int flag = getIntent().getExtras().getInt("flag");
        switch (flag) {
            case 0:
                // Explode
                // enter: 视图从屏幕两边向中间进入
                // exit : 视图从屏幕中间向两边退出
                getWindow().setEnterTransition(new Explode());
                //getWindow().setExitTransition(new Explode()); //可不要
                break;
            case 1:
                // Slide
                // enter: 视图从屏幕下方向上方进入
                // exit : 视图从屏幕上方向下方退出
                getWindow().setEnterTransition(new Slide());
                break;
            case 2:
                // Fade
                // enter: 视图慢慢显示进入，透明度越来越大
                // exit : 视图慢慢消失退出，透明度越来越小
                getWindow().setEnterTransition(new Fade());
                break;
            case 3:
                break;
        }

        setContentView(R.layout.activity_transition_b);
    }
}
