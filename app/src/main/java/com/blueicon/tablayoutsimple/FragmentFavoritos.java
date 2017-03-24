package com.blueicon.tablayoutsimple;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by developer on 22/03/17.
 */

public class FragmentFavoritos extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("CONSOLE","favoritos :::::::::: onCreateView");

        View rootView =  inflater.inflate(R.layout.fragment_favoritos,container,false);
        return  rootView;

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("CONSOLE"," favoritos :::::::::: onResume");

    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("CONSOLE"," favoritos :::::::::: onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("CONSOLE","favoritos :::::::::: onStart");

    }
}
