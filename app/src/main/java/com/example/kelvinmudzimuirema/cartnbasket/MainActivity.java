package com.example.kelvinmudzimuirema.cartnbasket;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    public Button startbn;


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    public NavigationView navigation;

    public void init(){
        startbn=(Button)findViewById(R.id.startbn);
        startbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this, GoogleSignIn.class);
                startActivity(toy);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigation = (NavigationView)findViewById(R.id.left_drawer);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id =item.getItemId();
                switch (id){
                    case R.id.nav_account:
                       Intent i = new Intent(MainActivity.this, GoogleSignIn.class);
                        startActivity(i);
                        break;
                    case R.id.nav_category:
                        Intent c = new Intent(MainActivity.this, ProductList.class);
                        startActivity(c);
                        break;
                    case R.id.nav_cart:
                        Intent p = new Intent(MainActivity.this, ShoppingCartActivity.class);
                        startActivity(p);
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id= item.getItemId();
        if (mToggle.onOptionsItemSelected(item)){
       }

        return super.onOptionsItemSelected(item);
    }

}
