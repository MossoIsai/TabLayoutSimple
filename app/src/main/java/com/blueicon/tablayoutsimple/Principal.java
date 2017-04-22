package com.blueicon.tablayoutsimple;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

/**
 * Created by developer on 22/03/17.
 */

public class Principal extends AppCompatActivity {
    private FrameLayout frameLayoutFragment;
    private BottomNavigationView bottomNavigationView;
    private AHBottomNavigation ahBottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("CONSOLE", "PAPA onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        frameLayoutFragment = (FrameLayout) findViewById(R.id.myFragemnt);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        ahBottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        final AHBottomNavigationItem item1 = new AHBottomNavigationItem("Menú", R.drawable.menu);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Favoritos", R.drawable.favoritos_item);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Tu orden", R.drawable.item_charola);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Perfil", R.drawable.item_perfil);

        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);
        ahBottomNavigation.addItem(item4);
        ahBottomNavigation.setBehaviorTranslationEnabled(false);
        ahBottomNavigation.setAccentColor(R.color.colorAccent);
        ahBottomNavigation.setInactiveColor(R.color.colorPrimary);

        ahBottomNavigation.setForceTint(true);
        ahBottomNavigation.setTranslucentNavigationEnabled(true);

        ahBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        ahBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        ahBottomNavigation.setColored(false);

        ahBottomNavigation.setCurrentItem(1);

        ahBottomNavigation.setNotification("10", 1);
        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // Do something cool here...
                switch (position) {
                    case 0:
                        //item1.setColor(getResources().getColor(R.color.colorAccent));
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();

                        MainActivity mainActivity = new MainActivity();
                        fragmentTransaction.replace(R.id.myFragemnt, mainActivity);
                        fragmentTransaction.commit();

                        return true;
                    case 1:

                        FragmentManager fm2 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fm2.beginTransaction();

                        FragmentFavoritos fragmentFavoritos = new FragmentFavoritos();
                        fragmentTransaction2.replace(R.id.myFragemnt, fragmentFavoritos);
                        fragmentTransaction2.commit();

                        return true;
                    case 2:
                        FragmentManager fm3 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction3 = fm3.beginTransaction();

                        FragmentOrden fragmentOrden = new FragmentOrden();
                        fragmentTransaction3.replace(R.id.myFragemnt, fragmentOrden);
                        fragmentTransaction3.commit();

                        return true;
                    case 3:

                        FragmentManager fm4 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction4 = fm4.beginTransaction();

                        FragmentPerfil fragmentPerfil = new FragmentPerfil();
                        fragmentTransaction4.replace(R.id.myFragemnt, fragmentPerfil);
                        fragmentTransaction4.commit();


                        return true;
                }

                return true;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CONSOLE", "PAPA onResume");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CONSOLE", "PAPA onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CONSOLE", "PAPA onStart");

    }
}
