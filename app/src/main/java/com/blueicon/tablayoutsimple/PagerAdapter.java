package com.blueicon.tablayoutsimple;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numberTabs;

    public PagerAdapter(FragmentManager fm, int numberTabs) {
        super(fm);
        this.numberTabs = numberTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Log.d("CONSOLE", ":::: 0");
                Fragment1 tab1 = new Fragment1();
                return tab1;
            case 1:
                Log.d("CONSOLE", ":::: 1");

                Fragment2 tab2 = new Fragment2();

                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberTabs;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }


}
