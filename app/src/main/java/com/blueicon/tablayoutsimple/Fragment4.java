package com.blueicon.tablayoutsimple;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by developer on 22/04/17.
 */

public class Fragment4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("CONSOLE","ITEM 4 :::::::::: onCreateView");

        View rootView =  inflater.inflate(R.layout.fragment_4,container,false);
        return  rootView;

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("CONSOLE","ITEM 4 :::::::::: onResume");

    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("CONSOLE","ITEM 4 :::::::::: onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("CONSOLE","ITEM 4 :::::::::: onStart");

    }
}
