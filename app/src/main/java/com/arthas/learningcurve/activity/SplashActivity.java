package com.arthas.learningcurve.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.arthas.learningcurve.R;
import com.bumptech.glide.Glide;


import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tcz on 16/4/12.
 */
public class SplashActivity extends BaseActivity {

    @Bind(R.id.iv_splash)
    ImageView mBackgroundIv;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

//        mBackgroundIv.setBackground(getResources().getDrawable(R.drawable.splash_bg));
//        Animation animation = new AlphaAnimation(0.2f,1.0f);
//        animation.setDuration(3000);
//        mBackgroundIv.startAnimation(animation);
        Glide.with(this)
                .load("http://img0.imgtn.bdimg.com/it/u=269362335,3946859697&fm=21&gp=0.jpg")
                .asGif()
                .error(R.drawable.splash_bg)
                .into(mBackgroundIv);
        mHandler = new Handler();
        mHandler.postDelayed(() -> {
            startActivity(MainActivity.class);
            finish();
        }, 3000);

    }
}
