package com.example.seedtrackingtracing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ThirdScreen extends Fragment {

    public static ThirdScreen newInstance() {
        ThirdScreen fragment = new ThirdScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.thirdscreen, container, false);

        return rootView;
    }


}
