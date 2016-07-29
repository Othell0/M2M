package com.cs.mm.view.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cs.mm.R;
import com.cs.mm.model.GanHuo;
import com.cs.mm.retrofit.GankRetrofit;
import com.cs.mm.retrofit.GankService;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by exbbefl on 6/14/2016.
 */
public class SplashActivity extends Activity {

    private ImageView image;

    private static final float SCALE_END = 1.13F;

    private static final int ANIMATION_DURATION = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.welcome_layout);

        init();
    }

    private void init() {
        image = (ImageView) findViewById(R.id.welcome_image);

        GankRetrofit.getRetrofit()
                .create(GankService.class)
                .getGanHuo("福利", 1, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GanHuo>() {
                    @Override
                    public void onCompleted() {
                        Log.e("666", "onCompleted");
                        animateImage();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("666", "onError");
                        Glide.with(SplashActivity.this)
                                .load(R.drawable.wall_picture)
                                .into(image);
                        animateImage();
                    }

                    @Override
                    public void onNext(GanHuo ganHuo) {
                        Log.e("666", "onNext");
                        Glide.with(SplashActivity.this)
                                .load(ganHuo.getResults().get(0).getUrl())
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .into(image);
                    }
                });

    }

    private void animateImage() {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(image, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(image, "scaleY", 1f, SCALE_END);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {

                startActivity(new Intent(SplashActivity.this, MainActivity.class));

                SplashActivity.this.finish();

                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }
}