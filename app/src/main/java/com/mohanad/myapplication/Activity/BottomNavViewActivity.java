package com.mohanad.myapplication.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mohanad.myapplication.Fragment.ChatFragment;
import com.mohanad.myapplication.Fragment.HomeFragment;
import com.mohanad.myapplication.Fragment.StatusFragment;
import com.mohanad.myapplication.R;

public class BottomNavViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav_view);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home_tab){
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();
                item.setChecked(true);
            }
            else if(item.getItemId() == R.id.chat_tab){
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new ChatFragment()).commit();
                item.setChecked(true);
            }
            else if(item.getItemId() == R.id.status_tab){
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,new StatusFragment()).commit();
                item.setChecked(true);
            }
            return true;
        });
    }
}