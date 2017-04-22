package com.blueicon.tablayoutsimple;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;;
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
        Log.d("CONSOLE", "Main :::::::::: onCreateView");

        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tablayout_menu);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager_menu);

        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 5"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                System.out.println("POSICION: "+tab.getPosition());
                inflateFragmenSelectec(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //CostumerFragment2 adapter = new CostumerFragment2(getActivity().getSupportFragmentManager());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                // Here position is the selected page-position
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return rootView;
    }

    public Fragment inflateFragmenSelectec(int position){
        switch (position){
            case 0:
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                fragmentTransaction.add(R.id.viewPager_menu, fragment1);
                fragmentTransaction.replace(R.id.viewPager_menu, fragment1);
                fragmentTransaction.commit();
                return  new Fragment1();

            case 1:
                FragmentManager fragmentManager2 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                fragmentTransaction2.add(R.id.viewPager_menu, fragment2);
                fragmentTransaction2.replace(R.id.viewPager_menu, fragment2);
                fragmentTransaction2.commit();
                return new  Fragment2();

            case 2: return  new Fragment3();
            case 3: return  new Fragment4();
            case 4: return  new Fragment5();
        }
        return  null;
    }


    public class CostumerFragment2 extends FragmentStatePagerAdapter {

        public CostumerFragment2(FragmentManager fm) {
            super(fm);

        }
        @Override
        public Fragment getItem(int index) {
            System.out.println("POSICION: " + index);

            switch (index) {
                case 0:

                    return new Fragment1();

                case 1:

                    return new Fragment2();
                case 2:

                    return new Fragment3();
                case 3:

                    return new Fragment4();
                case 4:

                    return new Fragment5();


            }
            return null;


        }

        @Override
        public int getCount() {
            return 5;
        }


    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("CONSOLE", "Main :::::::::: onResume");


    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("CONSOLE", "Main :::::::::: onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("CONSOLE", "Main :::::::::: onStart");

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
