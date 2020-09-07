package com.e.gadsleaderboard.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.e.gadsleaderboard.adapters.PagerAdapter;
import com.e.gadsleaderboard.R;
import com.google.android.material.tabs.TabLayout;

public class LeaderBoard extends AppCompatActivity {
    Toolbar toolbar;
    private PagerAdapter adapter;
    TabLayout tabLayout;
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        adapter = new PagerAdapter(getSupportFragmentManager());
        pager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tab);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.submit_menu){
            Intent intent = new Intent(getApplicationContext(), SubmitProject.class);
            startActivity(intent);
        }
        return true;
    }
}
