package com.example.seedtrackingtracing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FourthScreen extends Fragment {
    public static FourthScreen newInstance() {
        FourthScreen fragment = new FourthScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fourthscreen, container, false);


        return rootView;
    }

}
