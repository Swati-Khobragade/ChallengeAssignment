package com.example.calculatorapplication.activity;
/**
 * @author Swati.Khobragade
 */

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.calculatorapplication.R;
import com.example.calculatorapplication.adapter.CalculatorPagerAdapter;
import com.example.calculatorapplication.fragment.BasicCalculatorFragment;
import com.example.calculatorapplication.fragment.ScientificCalculatorFragment;

public class CalculatorActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private ViewPager viewPager;
    private CalculatorPagerAdapter mCalculatorPagerAdapter;
    private DrawerLayout drawer;
    private Button mbuttonRed;
    private Button mbuttonGreen;
    private Button mbuttonCyan;
    private BasicCalculatorFragment basicCalculatorFragment;
    private ScientificCalculatorFragment scientificCalculatorFragment;
    private TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.basic_calculator_tab,
            R.drawable.scientific_calculator_tab,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setAdapter();
        setPageTransformer();
        registerListeners();
        setupTabIcons();
    }

    /**
     * Set Tab Icons
     */
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        mbuttonRed.setOnClickListener(this);
        mbuttonGreen.setOnClickListener(this);
        mbuttonCyan.setOnClickListener(this);
    }

    /**
     * Initialize the Views
     */
    private void initViews() {
        viewPager = findViewById(R.id.viewPagerCalculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mbuttonRed = findViewById(R.id.buttonRed);
        mbuttonGreen = findViewById(R.id.buttonGreen);
        mbuttonCyan = findViewById(R.id.buttonCyan);
        tabLayout = findViewById(R.id.tabLayout);
        Log.d("tabLayout-", tabLayout + "");
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * Set Adapter to ViewPager
     */
    private void setAdapter() {
        mCalculatorPagerAdapter = new CalculatorPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(mCalculatorPagerAdapter);
    }

    /**
     * Set PageTransformer ti ViewPager
     */
    private void setPageTransformer() {
        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View view, float position) {
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                view.setScaleX(normalizedposition / 2 + 0.5f);
                view.setScaleY(normalizedposition / 2 + 0.5f);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_basic) {
            viewPager.setCurrentItem(0);
        } else if (id == R.id.nav_scientific) {
            viewPager.setCurrentItem(1);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonRed:
                setFrameColor("#ff3232");
                break;
            case R.id.buttonGreen:
                setFrameColor("#329932");
                break;
            case R.id.buttonCyan:
                setFrameColor("#00e5e5");
                break;
        }
    }

    /**
     * Set Color to outer Frame
     *
     * @param color
     */
    private void setFrameColor(String color) {
        Log.d("color", color + "");
        basicCalculatorFragment = (BasicCalculatorFragment) getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.viewPagerCalculator + ":" + 0);
        Bundle bundle = new Bundle();
        bundle.putString("selectedColor", color);
        basicCalculatorFragment.putArguments(bundle);

        scientificCalculatorFragment = (ScientificCalculatorFragment) getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.viewPagerCalculator + ":" + 1);
        Bundle bundle1 = new Bundle();
        bundle1.putString("selectedColor", color);
        scientificCalculatorFragment.putArguments(bundle1);

        drawer.closeDrawer(GravityCompat.START);
    }
}
