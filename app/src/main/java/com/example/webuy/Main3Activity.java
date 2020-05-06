package com.example.webuy;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;


import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class Main3Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@Nullable MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.dashboard:
                    Intent intent = new Intent(getApplicationContext(),DashbordActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigationMyCourses:
                    fragment = new DealFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                    break;
                case R.id.navigationHome:
                    fragment = new MagazinFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                    break;
                case  R.id.navigationSearch:
                    //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                    break;
                case  R.id.navigationMenu:
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.openDrawer(GravityCompat.START);
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(new DarkModePrefManager(this).isNightMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        setContentView(R.layout.activity_main3);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        bottomNavigationView.setSelectedItemId(R.id.navigationHome);

        FloatingActionButton fab = findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddDeal.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.dark_mode) {
            //code for setting dark mode
            //true for dark mode, false for day mode, currently toggling on each click
            DarkModePrefManager darkModePrefManager = new DarkModePrefManager(this);
            darkModePrefManager.setDarkMode(!darkModePrefManager.isNightMode());
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            recreate();
        } else if (id == R.id.edit_profile) {
            Intent intent = new Intent(getApplicationContext(),Main4Activity.class);
            startActivity(intent);


        } else if (id == R.id.change_password) {
            Intent intent = new Intent(getApplicationContext(),Main5Activity.class);
            startActivity(intent);


        } else if (id == R.id.notification) {

        } else if (id == R.id.feedback) {
            Intent intent = new Intent(getApplicationContext(),CrispSDKActivity.class);
            startActivity(intent);

        } else if (id == R.id.logout) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
