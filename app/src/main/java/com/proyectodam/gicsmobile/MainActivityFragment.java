package com.proyectodam.gicsmobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.proyectodam.gicsmobile.json.Venue;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

 //   private ArrayList<String> items;
 //    private ArrayAdapter<String> adapter;

    private ArrayList<Venue> items;
    private VenueAdapter adapter;
    public static String OBJETO_LUGAR = "OBJETO_LUGAR";

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ListView lvVenues = (ListView) rootView.findViewById(R.id.lvVenues);
        items = new ArrayList<Venue>();
        adapter = new VenueAdapter(
                getContext(),
                R.layout.lvvvenues_row,
                items
        );
        lvVenues.setAdapter(adapter);

        lvVenues.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getContext(), DetailActivity.class);
                i.putExtra(OBJETO_LUGAR, adapter.getItem(position));
                startActivity(i);
            }
        });


        return rootView;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_lugares_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void refresh() {
        APIClient apiClient = new APIClient();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        String clave          = preferences.getString("clave", "KIG3YM0N0TFADPJIR4K4GSZNSSFEPWK1IBDS10NVUIUNDOVR");
        String ll             = preferences.getString("ubicacion", "41.387920,2.169919");
        String v              = preferences.getString("fecha", "20160101");

        Log.d(clave, "preferencias --> clave");
        Log.d(ll, "preferencias --> ubicacion");
        Log.d(v, "preferencias --> fecha");


        apiClient.getLugares(adapter, clave, ll, v);


    }

}