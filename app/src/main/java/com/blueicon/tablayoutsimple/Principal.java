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
        Log.d("CONSOLE","PAPA onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        frameLayoutFragment = (FrameLayout) findViewById(R.id.myFragemnt);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        ahBottomNavigation = (AHBottomNavigation)findViewById(R.id.bottom_navigation);

        final AHBottomNavigationItem item1 = new AHBottomNavigationItem("Menú",R.drawable.menu);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Favoritos",R.drawable.favoritos_item);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Tu orden",R.drawable.item_charola);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Perfil",R.drawable.item_perfil);

        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);
        ahBottomNavigation.addItem(item4);

        //ahBottomNavigation.setDefaultBackgroundColor(R.color.colorAccent);

// Disable the translation inside the CoordinatorLayout
        ahBottomNavigation.setBehaviorTranslationEnabled(false);

// Enable the translation of the FloatingActionButton
       // ahBottomNavigation.manageFloatingActionButtonBehavior(floatingActionButton);

// Change colors
        ahBottomNavigation.setAccentColor(R.color.colorAccent);
        ahBottomNavigation.setInactiveColor(R.color.colorPrimary);

// Force to tint the drawable (useful for font with icon for example)
        ahBottomNavigation.setForceTint(true);

// Display color under navigation bar (API 21+)
// Don't forget these lines in your style-v21
// <item name="android:windowTranslucentNavigation">true</item>
// <item name="android:fitsSystemWindows">true</item>
        ahBottomNavigation.setTranslucentNavigationEnabled(true);

// Manage titles
        ahBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        ahBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        //ahBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        //ahBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

// Use colored navigation with circle reveal effect
        ahBottomNavigation.setColored(false);

// Set current item programmatically
        ahBottomNavigation.setCurrentItem(1);

// Customize notification (title, background, typeface)
        //ahBottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));

// Add or remove notification for each item
        ahBottomNavigation.setNotification("10", 1);
// OR
        /*AHNotification notification = new AHNotification.Builder()
                .setText("1")
                .setBackgroundColor(ContextCompat.getColor(DemoActivity.this, R.color.color_notification_back))
                .setTextColor(ContextCompat.getColor(DemoActivity.this, R.color.color_notification_text))
                .build();
        ahBottomNavigation.setNotification(notification, 1);*/

// Set listeners
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

                        FragmentFavoritos  fragmentFavoritos = new FragmentFavoritos();
                        fragmentTransaction2.replace(R.id.myFragemnt, fragmentFavoritos);
                        fragmentTransaction2.commit();

                        return true;
                    case 2:
                        FragmentManager fm3 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction3 = fm3.beginTransaction();

                        FragmentOrden  fragmentOrden = new FragmentOrden();
                        fragmentTransaction3.replace(R.id.myFragemnt, fragmentOrden);
                        fragmentTransaction3.commit();

                        return true;
                    case 3:

                        FragmentManager fm4 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction4 = fm4.beginTransaction();

                        FragmentPerfil  fragmentPerfil = new FragmentPerfil();
                        fragmentTransaction4.replace(R.id.myFragemnt, fragmentPerfil);
                        fragmentTransaction4.commit();


                        return true;
                }

                return true;
            }
        });
        ahBottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override public void onPositionChange(int y) {
                // Manage the new y position
            }
        });







        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        MainActivity mainActivity = new MainActivity();
        fragmentTransaction.replace(R.id.myFragemnt, mainActivity);
        fragmentTransaction.commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_menu:

                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();

                        MainActivity mainActivity = new MainActivity();
                        fragmentTransaction.replace(R.id.myFragemnt, mainActivity);
                        fragmentTransaction.commit();

                        return true;
                    case R.id.item_favorito:

                        FragmentManager fm2 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fm2.beginTransaction();

                        FragmentFavoritos  fragmentFavoritos = new FragmentFavoritos();
                        fragmentTransaction2.replace(R.id.myFragemnt, fragmentFavoritos);
                        fragmentTransaction2.commit();

                        return true;
                    case R.id.item_charola:
                        FragmentManager fm3 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction3 = fm3.beginTransaction();

                        FragmentOrden  fragmentOrden = new FragmentOrden();
                        fragmentTransaction3.replace(R.id.myFragemnt, fragmentOrden);
                        fragmentTransaction3.commit();

                        return true;
                    case R.id.item_perfil:

                        FragmentManager fm4 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction4 = fm4.beginTransaction();

                        FragmentPerfil  fragmentPerfil = new FragmentPerfil();
                        fragmentTransaction4.replace(R.id.myFragemnt, fragmentPerfil);
                        fragmentTransaction4.commit();


                        return true;
                }
                return false;


            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CONSOLE","PAPA onResume");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CONSOLE","PAPA onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CONSOLE","PAPA onStart");

    }
}
