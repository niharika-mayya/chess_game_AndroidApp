package com.example.startscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class settings extends AppCompatActivity {
    private static final int GALLERY_REQUEST_CODE = 1;
    ImageView profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        profile = findViewById(R.id.profile);
        ImageView back=findViewById(R.id.back);
        ImageView changeuname=findViewById(R.id.changeusername);
        ImageView changepswd=findViewById(R.id.changepswd);
        ImageView viewstats=findViewById(R.id.viewstats);
        ImageView logout=findViewById(R.id.logut);
        changeuname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(settings.this,changeusername.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(settings.this);
                startActivity(i, options.toBundle());
            }
        });
        changepswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(settings.this,changepassword.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(settings.this);
                startActivity(i, options.toBundle());
            }
        });
        viewstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(settings.this,viewstats.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(settings.this);
                startActivity(i, options.toBundle());
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(settings.this, login_register_page.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(settings.this);
                startActivity(intent, options.toBundle());
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(settings.this, home_page.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(settings.this);
                startActivity(i, options.toBundle());
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(settings.this, gallery.class);
                startActivityForResult(i, GALLERY_REQUEST_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK) {
            int selectedImageId = data.getIntExtra("id", -1);
            if (selectedImageId != -1) {
                profile.setImageResource(ImageAdapter.mImageIds[selectedImageId]);
            }
        }
    }
}
