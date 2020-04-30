package com.example.seedtrackingtracing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class SecondScreen extends Fragment {
    public static SecondScreen newInstance() {
        SecondScreen fragment = new SecondScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.secondscreen, container, false);

        return rootView;
    }
}
