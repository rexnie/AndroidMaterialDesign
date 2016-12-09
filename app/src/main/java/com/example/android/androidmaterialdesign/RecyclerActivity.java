package com.example.android.androidmaterialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    private static final String TAG = "RecyclerActivity";

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Spinner mSpinner;
    private List<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mSpinner = (Spinner) findViewById(R.id.spinner);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        //设置显示动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.layout_selection, android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(spinnerAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    //设置为线性布局, view.getText() = "LinearLayoutManager"
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
                } else if (position == 1) {
                    //设置为表格布局  text="GridLayoutManager"
                    mRecyclerView.setLayoutManager(new GridLayoutManager(RecyclerActivity.this, 3));
                } else if (position == 2) {
                    // for Custom layout, text="CustomLayoutHere"
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //增加测试数据
        for (char c = 'A'; c <= 'Z'; c++) {
            mData.add(String.valueOf(c));
        }

        mAdapter = new RecyclerAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RecyclerAdapter.MyOnItemClickListener() {
            @Override
            public void onItemClick(final View view, int position) {
                //设置点击动画
                view.animate().translationZ(15f).setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                view.animate().translationZ(1f).setDuration(500).start();
                            }
                        }).start();
            }
        });
    }

    public void addRecycler(View view) {
        int sz = mData.size();
        if (sz > 0) {
            String str = mData.get(sz - 1);
            char c = str.charAt(0);
            c++;
            mData.add(String.valueOf(c));
        } else {
            mData.add(String.valueOf('A'));
        }
        sz++;
        if (sz > 0) {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void delRecycler(View view) {
        int sz = mData.size();
        if (sz > 0) {
            mData.remove(sz - 1);
            mAdapter.notifyDataSetChanged();
        }
    }
}
