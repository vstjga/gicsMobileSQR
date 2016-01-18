package com.proyectodam.gicsmobile;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proyectodam.gicsmobile.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TipsActivityFragment extends Fragment {

    public TipsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tips, container, false);
    }
}
