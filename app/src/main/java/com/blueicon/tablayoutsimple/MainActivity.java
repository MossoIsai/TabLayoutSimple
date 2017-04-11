package com.blueicon.tablayoutsimple;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.*;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("CONSOLE","Main :::::::::: onCreateView");

        View rootView =  inflater.inflate(R.layout.activity_main,container,false);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tablayout_menu);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager_menu);

        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        CostumerFragment2 adapter = new CostumerFragment2(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
       // viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


            }
        });
        return rootView;
    }

    public class CostumerFragment extends FragmentPagerAdapter{

        public CostumerFragment(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    FragmentManager fm2 =  getActivity().getSupportFragmentManager();
                    FragmentTransaction ft2 = fm2.beginTransaction();
                    Fragment2 two = new Fragment2();
                    ft2.replace(R.id.viewPager_menu,two);
                    ft2.commit();
                    return two;

                case 1:
                FragmentManager fm =  getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment1 one = new Fragment1();
                ft.replace(R.id.viewPager_menu,one);
                ft.commit();
                return one;

            }
            return null;
        }
        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public int getItemPosition(Object object) {
            return android.support.v4.view.PagerAdapter.POSITION_NONE;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            viewPager.removeView((View)object);
        }

    }


    public class CostumerFragment2 extends FragmentStatePagerAdapter{

        public CostumerFragment2(FragmentManager fm) {
            super(fm);

        }
        @Override
        public Fragment getItem(int index) {

            switch (index) {
                case 0:

                    return new Fragment1();

                case 1:

                    return new Fragment2();

            }
            return null;


        }

        @Override
        public int getCount() {
            return 2;
        }

    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d("CONSOLE","Main :::::::::: onResume");


    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("CONSOLE","Main :::::::::: onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("CONSOLE","Main :::::::::: onStart");

    }
}
