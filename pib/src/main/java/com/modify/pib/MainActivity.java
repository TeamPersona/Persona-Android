package com.modify.pib;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.modify.pib.fragment.NamedFragment;
import com.modify.pib.fragment.VoDetailFragment;
import com.modify.pib.fragment.VoListFragment;
import com.modify.pib.listener.VoItemListener;
import com.modify.pib.model.ValueOpportunity;
import com.modify.pib.network.SessionsManager;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, VoItemListener, FragmentManager.OnBackStackChangedListener {

    private static final long DRAWER_CLOSE_DELAY_MS = 100;
    private static final String NAV_ITEM_ID = "navItemId";
    private final VoListFragment mVoListFragment = new VoListFragment();
    private final Handler mDrawerActionHandler = new Handler();
    private SessionsManager sessionsManager;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mNavItemId;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionsManager = new SessionsManager(getApplicationContext());

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // load saved navigation state if present
        if (null == savedInstanceState) {
            mNavItemId = R.id.drawer_vo_featured;
        } else {
            mNavItemId = savedInstanceState.getInt(NAV_ITEM_ID);
        }

        // set up the fragment titles
        mVoListFragment.setTitle(R.string.title_vo_featured);

        // listen for navigation events
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().addOnBackStackChangedListener(this);

        // select the correct nav menu item
        navigationView.getMenu().findItem(mNavItemId).setChecked(true);

        // set up the hamburger icon to open and close the drawer
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        navigate(mNavItemId);
    }

    /**
     * Performs the actual navigation logic, updating the main content fragment.
     */
    private void navigate(final int itemId) {
        FragmentManager fm = getSupportFragmentManager();
        /*
         * FIXME: This is used to clear the back stack when another navigation item is clicked
         * Since other fragments are not implemented whenever another navigation item is clicked
         * it navigates to the VoListFragment
         * This behaviour will resolve itself after all other fragments are implemented and routed
         */
        fm.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        switch (itemId) {
            case R.id.drawer_vo_featured:
                fm.beginTransaction()
                        .replace(R.id.frame, mVoListFragment)
                        .commit();
                getSupportActionBar().setTitle(mVoListFragment.getTitle());
                break;
            case R.id.drawer_sign_out:
                signOut();
                break;
            default:
                // ignore
                break;
        }
    }

    private void signOut() {
        sessionsManager.setLoggedIn(false);
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Handles clicks on the navigation menu.
     */
    @Override
    public boolean onNavigationItemSelected(final MenuItem menuItem) {
        // update highlighted item in the navigation menu
        menuItem.setChecked(true);
        mNavItemId = menuItem.getItemId();

        // allow some time after closing the drawer before performing real navigation
        // so the user can see what is happening
        mDrawerLayout.closeDrawer(GravityCompat.START);
        mDrawerActionHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigate(menuItem.getItemId());
            }
        }, DRAWER_CLOSE_DELAY_MS);
        return true;
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.support.v7.appcompat.R.id.home) {
            return mDrawerToggle.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NAV_ITEM_ID, mNavItemId);
    }

    @Override
    public void onVoItemClicked(ValueOpportunity data) {
        VoDetailFragment detailFragment = (VoDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_vo_detail);

        if (detailFragment != null) {
            // TODO: Side-by-side fragment (tablets only)
            detailFragment.updateDetailsView(data);
        } else {
            detailFragment = new VoDetailFragment();
            Bundle args = new Bundle();
            args.putSerializable(VoDetailFragment.VO_DATA, data);
            detailFragment.setArguments(args);

            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.frame, detailFragment)
                    .commit();
        }
    }

    @Override
    public void onBackStackChanged() {
        NamedFragment fragment = (NamedFragment) getSupportFragmentManager().findFragmentById(R.id.frame);
        getSupportActionBar().setTitle(fragment.getTitle());
    }
}