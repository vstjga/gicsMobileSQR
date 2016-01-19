package com.proyectodam.gicsmobile;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.proyectodam.gicsmobile.R;

public class TipsActivity extends AppCompatActivity {

    public String idLugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        idLugar = getIntent().getStringExtra("idLugar");


    }

    public String getIdlugar () {
        return this.idLugar;

    }
}
