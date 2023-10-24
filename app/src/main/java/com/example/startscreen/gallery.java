package com.example.startscreen;

import androidx.appcompat.app.AppCompatActivity;
import com.example.startscreen.ImageAdapter;
import android.os.Bundle;
import android.widget.GridView;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

public class gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        GridView gridView = findViewById(R.id.gridview);


        int[] imageIds = {
                R.drawable.pawn_white,R.drawable.pawn_black
        };

        ImageAdapter adapter = new ImageAdapter(this, imageIds);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(gallery.this, settings.class);
                i.putExtra("id", position);
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}