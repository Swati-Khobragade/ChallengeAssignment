package com.example.calculatorapplication.adapter;
/**
 * @author Swati Khobragade
 */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.calculatorapplication.fragment.BasicCalculatorFragment;
import com.example.calculatorapplication.fragment.ScientificCalculatorFragment;

import java.util.ArrayList;


public class CalculatorPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragmentArraylist;
    private String[] mTitleStringArray;

    /**
     * @param fragmentManager
     * @param fragmentArrayList
     * @param titleArray
     */
    public CalculatorPagerAdapter(FragmentManager fragmentManager, Context context, ArrayList<Fragment> fragmentArrayList, String[] titleArray) {
        super(fragmentManager);
        mFragmentArraylist = fragmentArrayList;
        mTitleStringArray = titleArray;
    }

    @Override
    public int getCount() {
        return mFragmentArraylist.size();
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
                return mTitleStringArray[0];
            case 1:
                return mTitleStringArray[1];
            default:
                return null;
        }
    }

}
