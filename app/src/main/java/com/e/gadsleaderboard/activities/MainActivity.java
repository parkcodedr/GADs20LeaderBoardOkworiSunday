package com.e.gadsleaderboard.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.e.gadsleaderboard.R;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(getApplicationContext(),LeaderBoard.class);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },4000);

    }
}
