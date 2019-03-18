package com.example.calculatorapplication.adapter;
/**
 * @author Swati Khobragade
 */

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.calculatorapplication.fragment.BasicCalculatorFragment;
import com.example.calculatorapplication.fragment.ScientificCalculatorFragment;


public class CalculatorPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;

    /**
     * @param fragmentManager
     */
    public CalculatorPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                fragment = BasicCalculatorFragment.newInstance();
                break;
            case 1: // Fragment # 0 - This will show FirstFragment different title
                fragment = ScientificCalculatorFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Basic";
            case 1:
                return "Scientific";
            default:
                return null;
        }
    }
}
