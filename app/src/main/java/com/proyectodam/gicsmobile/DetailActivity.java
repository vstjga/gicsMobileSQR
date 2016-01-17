package com.proyectodam.gicsmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyectodam.gicsmobile.json.Category;
import com.proyectodam.gicsmobile.json.Icon;
import com.proyectodam.gicsmobile.json.Venue;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle b = getIntent().getExtras();
        Venue lugares = b.getParcelable(MainActivityFragment.OBJETO_LUGAR);
        TextView Name = (TextView) findViewById(R.id.tvName);
        TextView Address = (TextView) findViewById(R.id.tvAddress);
        TextView Distance = (TextView) findViewById(R.id.tvDistance);
        ImageView ivPosterImage = (ImageView) findViewById(R.id.ivPosterImage);

        Name.setText(lugares.getName());
        Address.setText(lugares.getLocation().getAddress());
        Distance.setText(lugares.getLocation().getDistance().toString() + " metros");

        ArrayList<Category> categorias = (ArrayList<Category>) lugares.getCategories();
        Integer numcat = categorias.size();
        String  numcats = numcat.toString();

        String url_imagen = "https://ss3.4sqi.net/img/categories_v2/food/pizza_bg_88.png"; // imagen omision

        if (numcat > 0) {
            Category categoria1 = categorias.get(0);
            Icon icono = categoria1.getIcon();
            url_imagen = icono.getPrefix() + "bg_88" + icono.getSuffix(); // error autorizacion en url-api
        }

        Picasso.with(this).load(url_imagen).into(ivPosterImage);
    }

}
