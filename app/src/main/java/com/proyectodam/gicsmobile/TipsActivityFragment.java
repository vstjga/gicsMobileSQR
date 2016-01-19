package com.proyectodam.gicsmobile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.proyectodam.gicsmobile.json.Item_;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class TipsActivityFragment extends Fragment {

    private ArrayList<Item_> items;
    private TipsAdapter adapter;
    public static String OBJETO_LUGAR = "OBJETO_LUGAR";
    public TipsActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tips, container, false);
        ListView lvTips = (ListView) rootView.findViewById(R.id.lvTips);
        items = new ArrayList<Item_>();
        adapter = new TipsAdapter(
                getContext(),
                R.layout.lvvtips_row,
                items
        );
        lvTips.setAdapter(adapter);


        return rootView;

    }


    private void refresh() {
        APIClientTips apiClientTips = new APIClientTips();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        String clave          = preferences.getString("clave", "KIG3YM0N0TFADPJIR4K4GSZNSSFEPWK1IBDS10NVUIUNDOVR");
        String ll             = preferences.getString("ubicacion", "41.387920,2.169919");
        String v              = preferences.getString("fecha", "20160101");

        Log.d(clave, "preferencias --> clave");
        Log.d(ll, "preferencias --> ubicacion");
        Log.d(v, "preferencias --> fecha");


        apiClientTips.getLugares(adapter, clave, v);


    }
}
