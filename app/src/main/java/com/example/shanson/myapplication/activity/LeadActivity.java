package com.example.shanson.myapplication.activity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.shanson.myapplication.R;
import com.example.shanson.myapplication.base.BaseActivity;

public class LeadActivity extends BaseActivity {
    private ImageView lead_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        lead_image = (ImageView) findViewById(R.id.image_lead);
        Animation animation = new AlphaAnimation(0.1f, 1.0f);
        animation.setDuration(3000);
        lead_image.setAnimation(animation);
        lead_image.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                startActivity(LoginActivity.class);

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                skip();
            }


            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
    private void skip() {
         startActivity(MainActivity.class);
         finish();
    }
}
