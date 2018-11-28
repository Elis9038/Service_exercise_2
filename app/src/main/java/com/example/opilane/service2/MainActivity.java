package com.example.opilane.service2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        int color = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        LinearLayout rl = findViewById(R.id.ln);
        rl.setBackgroundColor(color);
    }

    public void onStart(View view) {
        Intent intent = new Intent(this, TheService.class);
        startService(intent);
    }

    public void onStop(View view) {
        Intent intent = new Intent(this, TheService.class);
        stopService(intent);
    }
}

