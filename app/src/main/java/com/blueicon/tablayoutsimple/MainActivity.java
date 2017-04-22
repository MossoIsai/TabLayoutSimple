package com.blueicon.tablayoutsimple;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;;
import android.support.v4.app.FragmentStatePagerAdapter;
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
        CostumerFragment2 adapter = new CostumerFragment2(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        return  rootView;
    }

    public class CostumerFragment2 extends FragmentStatePagerAdapter {

        public void loadData() {

        }

            // your cod

        public CostumerFragment2(FragmentManager fm) {
            super(fm);

        }
        @Override
        public Fragment getItem(int index) {
            System.out.println("CONSOLE 1 POSICION A ELIMINAR: "+(index));

            switch (index){
               case 0:
                   return  new Fragment1();
               case 1:
                   return  new Fragment2();
               case 2:
                   return  new Fragment3();
               case 3:
                   return  new Fragment4();
               case 4:
                   return  new Fragment5();
           }
           return null;
        }
        @Override
        public int getCount() {
            return 5;
        }
        //Borrame todo lo que no esete visible
        @Override
        public int getItemPosition(Object object) {
            return  POSITION_NONE;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            System.out.println("CONSOLE 2 POSITION DISTRUIDA: " +position);
        }
        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {

        }

    }

}
