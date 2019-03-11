package com.example.onlineshoppingcart.mainview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.onlineshoppingcart.R;
import com.example.onlineshoppingcart.signin.SignInActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor preferencesEditor;
    private String sharedPrefFile = "com.example.onlineshoppingcart";

    String user_id, fname, lname, email, mobile, api_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sharedPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        preferencesEditor = sharedPreferences.edit();

        if (getIntent().hasExtra("appapikey")) {
            this.user_id = getIntent().getExtras().getString("id");
            this.fname = getIntent().getExtras().getString("firstname");
            this.lname = getIntent().getExtras().getString("lastname");
            this.email = getIntent().getExtras().getString("email");
            this.mobile = getIntent().getExtras().getString("mobile");
            this.api_key = getIntent().getExtras().getString("appapikey");

            preferencesEditor.putString("user_id", user_id);
            preferencesEditor.putString("fname", fname);
            preferencesEditor.putString("lname", lname);
            preferencesEditor.putString("email", email);
            preferencesEditor.putString("mobile", mobile);
            preferencesEditor.putString("api_key", api_key);

            preferencesEditor.apply();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.signIn) {
            Intent intent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.home) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.shoppingCart) {

        } else if (id == R.id.payment) {
            Intent intent = new Intent(MainActivity.this, PaymentActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        preferencesEditor.clear();
        preferencesEditor.apply();
    }
}
