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
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.example.calculatorapplication.R;
import com.example.calculatorapplication.fragment.BasicCalculatorFragment;
import com.example.calculatorapplication.fragment.ScientificCalculatorFragment;


public class CalculatorPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;
    private Context mContext;
    Drawable myDrawable;

    /**
     * @param fragmentManager
     */
    public CalculatorPagerAdapter(FragmentManager fragmentManager,Context context) {
        super(fragmentManager);
        mContext=context;
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

    /*@Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        SpannableStringBuilder sb;
        ImageSpan span;
        switch (position) {
            case 0:
                myDrawable = mContext.getResources().getDrawable(R.drawable.scientific_calculator);
                sb = new SpannableStringBuilder("  Page1"); // space added before text for convenience

                myDrawable.setBounds(0, 0, myDrawable.getIntrinsicWidth(), myDrawable.getIntrinsicHeight());
                span = new ImageSpan(myDrawable, ImageSpan.ALIGN_BASELINE);
                sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                return sb;
            case 1:
                return "Scientific";
            default:
                return null;
        }
    }*/
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
