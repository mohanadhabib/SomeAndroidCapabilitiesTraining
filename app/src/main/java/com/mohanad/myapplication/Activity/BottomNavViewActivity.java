package com.mohanad.myapplication.Activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.mohanad.myapplication.Fragment.ChatFragment;
import com.mohanad.myapplication.Fragment.HomeFragment;
import com.mohanad.myapplication.Fragment.StatusFragment;
import com.mohanad.myapplication.R;

public class BottomNavViewActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav_view);
        layout = findViewById(R.id.constraint);
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.a){
            Snackbar.make(layout,item.getTitle(),Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.posts_text_color)).setTextColor(getColor(R.color.comment_card_color)).show();
        }
        else if(item.getItemId() == R.id.b){
            Snackbar.make(layout,item.getTitle(),Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.posts_text_color)).setTextColor(getColor(R.color.comment_card_color)).show();
        }
        else if (item.getItemId() == R.id.c) {
            Snackbar.make(layout,item.getTitle(),Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.posts_text_color)).setTextColor(getColor(R.color.comment_card_color)).show();
        }
        else if(item.getItemId() == R.id.d){
            Snackbar.make(layout,item.getTitle(),Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.posts_text_color)).setTextColor(getColor(R.color.comment_card_color)).show();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tool_bar_menu,menu);
        return true;
    }
}