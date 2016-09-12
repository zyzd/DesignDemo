package com.zyzd.designdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton mFabBtb;
    private CoordinatorLayout mRootLayout;
    private Toolbar mToolBar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private NavigationView mNavigationView;
//    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();

    }

    private void initInstances() {
        mToolBar = (Toolbar) findViewById(R.id.toobar);
        setSupportActionBar(mToolBar);
//        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
//        mTabLayout.addTab(mTabLayout.newTab().setText("tab_1"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("tab_2"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("tab_3"));
        mRootLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);
        mFabBtb = (FloatingActionButton) findViewById(R.id.fabBtn);
        mFabBtb.setOnClickListener(this);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        mCollapsingToolbarLayout.setTitle(getResources().getString(R.string.app_name));
        mNavigationView = (NavigationView) findViewById(R.id.navigation);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId){
                    case R.id.navItem1:
                        Toast.makeText(MainActivity.this, "navItem1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navItem2:
                        Toast.makeText(MainActivity.this, "navItem2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navItem3:
                        Toast.makeText(MainActivity.this, "navItem3", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navItem4:
                        Toast.makeText(MainActivity.this, "navItem4", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fabBtn:
                Snackbar.make(mRootLayout,"Hello,I am Snacker!",Snackbar.LENGTH_SHORT)
                    .setAction("点击内容", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                           Toast.makeText(MainActivity.this, "hello!", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                
                break;
        }
    }
}
