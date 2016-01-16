package com.proyectodam.gicsmobile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
        ListView lvPelis = (ListView) rootView.findViewById(R.id.lvPelis);
        items = new ArrayList<Venue>();
        adapter = new VenueAdapter(
                getContext(),
                R.layout.lvvvenues_row,
                items
        );
        lvPelis.setAdapter(adapter);

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


         String clave       = preferences.getString("clave","a");

         String ll          = preferences.getString("tipus_consulta", "valoradas");;
         String v          = "20160101";


         apiClient.getLugares(adapter, clave, ll, v);


    }

}