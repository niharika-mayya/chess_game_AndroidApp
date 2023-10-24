package com.example.startscreen;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
public class loadpage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadpage);
        ImageView imageView = findViewById(R.id.image_view_1);
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        imageView.startAnimation(rotateAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.clearAnimation();
                Intent intent = new Intent(loadpage.this, login_register_page.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(loadpage.this);
                startActivity(intent, options.toBundle());
            }
        }, 5000);
    }
}