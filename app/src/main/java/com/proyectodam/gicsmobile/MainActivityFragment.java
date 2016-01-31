package com.proyectodam.gicsmobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
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
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    private ArrayList<Venue> items;
    private VenueAdapter adapter;
    public static String OBJETO_LUGAR = "OBJETO_LUGAR";
    private OnLugarSelectedListener listener;



    private Cursor cursor;

    DAOLugaresDB dao= new DAOLugaresDB();


    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LugaresDbHelper dbHelper = new LugaresDbHelper(getContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();

    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnLugarSelectedListener) context;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        ListView lvVenues = (ListView) rootView.findViewById(R.id.lvTips);

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

                boolean tablet = getResources().getBoolean(R.bool.dos_fragments);
                Venue lugar = adapter.getItem(position);
                listener.onLugarSelected(lugar);

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
        apiClient.getLugares(getContext());

        dao.mostrarLugares(getContext(), adapter);

    }

    // Container Activity must implement this interface

    public interface OnLugarSelectedListener {
        void onLugarSelected(Venue lugar);
    }


}