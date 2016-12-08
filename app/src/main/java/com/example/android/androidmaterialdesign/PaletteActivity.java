package com.example.android.androidmaterialdesign;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class PaletteActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "PaletteActivity";
    private int mPictureIndex; // 2 pictures switch
    private int mColorIndex; // 3 colors switch
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        mImageView = (ImageView) findViewById(R.id.iv_palette);
        mImageView.setOnClickListener(this);
        mImageView.setImageResource(R.drawable.green_boy);
        mPictureIndex = 0;
        mColorIndex = -1; // when click it start from -1
    }

    public void onClick(View v) {
        mColorIndex++;
        if (mColorIndex == 3) {
            mColorIndex = 0;
            if (mPictureIndex == 0) {
                mPictureIndex = 1;
            } else {
                mPictureIndex = 0;
            }
        }

        setPalette(mPictureIndex, mColorIndex);
    }

    /**
     * Palette获取颜色
     */
    private void setPalette(int pictureIndex, final int colorIndex) {
        int resId = R.drawable.green_boy;
        if (pictureIndex == 1) {
            resId = R.drawable.blue_sky;
        }
        final String logString = "setPalette: resId=" + resId + ",colorIndex=" + colorIndex;
        Log.d(TAG, logString);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
        mImageView.setImageBitmap(bitmap);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrant = null;
                //通过Palette来获取对应的色调
                switch (colorIndex) {
                    case 0:
                        vibrant = palette.getVibrantSwatch();
                        break;
                    case 1:
                        vibrant = palette.getDarkVibrantSwatch();
                        break;
                    case 2:
                        vibrant = palette.getLightVibrantSwatch();
                        break;
                    /* XX muted swatch maybe null */
                    case 3:
                        vibrant = palette.getMutedSwatch();
                        break;
                    case 4:
                        vibrant = palette.getDarkMutedSwatch();
                        break;
                    case 5:
                        vibrant = palette.getLightMutedSwatch();
                        break;
                    default:
                        Log.e(TAG, "onGenerated: unknown id");
                        break;
                }

                if (vibrant != null) {
                    //设置标题栏颜色
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(vibrant.getRgb()));
                    Window window = getWindow();
                    // 设置状态栏颜色
                    window.setStatusBarColor(vibrant.getRgb());
                    Toast.makeText(getApplicationContext(), logString, Toast.LENGTH_SHORT).show();
                } else {
                    Log.d(TAG, "onGenerated: vibrant is null");
                    Toast.makeText(getApplicationContext(), "vibrant is null", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}
