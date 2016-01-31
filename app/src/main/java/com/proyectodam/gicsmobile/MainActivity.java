package com.proyectodam.gicsmobile;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.proyectodam.gicsmobile.json.Venue;

public class MainActivity extends AppCompatActivity implements MainActivityFragment.OnLugarSelectedListener {
    public static String OBJETO_LUGAR = "OBJETO_LUGAR";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLugarSelected(Venue lugar) {
        boolean tablet = getResources().getBoolean(R.bool.dos_fragments);

        if (tablet) {
            DetailActivityFragment detailFragment = (DetailActivityFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fragmentDetail);
            detailFragment.loadLugarFromActivity(lugar);
        } else {

            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra(OBJETO_LUGAR, lugar);
            startActivity(i);

        }
    }
}