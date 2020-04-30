package com.example.seedtrackingtracing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FirstScreen extends Fragment {
    public static FirstScreen newInstance() {
        FirstScreen fragment = new FirstScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.firstscreen, container, false);

        return rootView;
    }
}
