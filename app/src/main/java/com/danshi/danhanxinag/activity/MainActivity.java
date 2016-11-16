package com.danshi.danhanxinag.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.danshi.danhanxinag.base.BaseActivity;
import com.danshi.danhanxinag.danshiapp.R;
import com.danshi.danhanxinag.fragment.MeizhiFragment;
import com.danshi.danhanxinag.fragment.NewsFragment;
import com.danshi.danhanxinag.fragment.StoryFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    private NewsFragment mNewsFragment;
    private MeizhiFragment mMeizhiFragment;
    private StoryFragment mStoryFragment;
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
      /*设置toolbar上的触发NavigationView的按钮*/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_camera:
                Snackbar.make(getCurrentFocus(), "开发中...", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.nav_gallery:
                showNewsFragment();
                break;
            case R.id.nav_slideshow:
                showMeizhiFragment();
                break;
            case R.id.nav_manage:
                showStoryFragment();
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showStoryFragment() {
        if (mStoryFragment == null) {
            mStoryFragment = new StoryFragment();
        }
        showContentFragment(mStoryFragment, R.id.fragment_container);
    }

    private void showMeizhiFragment() {
        if (mMeizhiFragment == null) {
            mMeizhiFragment = new MeizhiFragment();
        }
        showContentFragment(mMeizhiFragment, R.id.fragment_container);
    }

    private void showNewsFragment() {
        if (mNewsFragment == null) {
            mNewsFragment = new NewsFragment();
        }
        showContentFragment(mNewsFragment, R.id.fragment_container);
    }
}