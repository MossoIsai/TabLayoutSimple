package com.blueicon.tablayoutsimple;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

/**
 * Created by developer on 22/03/17.
 */

public class Principal extends AppCompatActivity {
    private FrameLayout frameLayoutFragment;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("CONSOLE","PAPA onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        frameLayoutFragment = (FrameLayout) findViewById(R.id.myFragemnt);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);


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
