package com.proyectodam.gicsmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyectodam.gicsmobile.json.Category;
import com.proyectodam.gicsmobile.json.Icon;
import com.proyectodam.gicsmobile.json.Venue;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private String idLugar;

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

        TextView ActTitul = (TextView) findViewById(R.id.tvActTitul);
        TextView ActName = (TextView) findViewById(R.id.tvActName);

        TextView DirTitul = (TextView) findViewById(R.id.tvDirTitul);
        TextView DirCalle = (TextView) findViewById(R.id.tvDirCalle);
        TextView DirCpostal = (TextView) findViewById(R.id.tvDirCpostal);
        TextView DirPobla = (TextView) findViewById(R.id.tvDirPobla);
        TextView DirPais = (TextView) findViewById(R.id.tvDirPais);



        String nombreCat = "";

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
            nombreCat  = categoria1.getName();
        }

        Picasso.with(this).load(url_imagen).into(ivPosterImage);

        ActTitul.setText("Categoria");
        ActName.setText("Tipo: " + nombreCat);

        String codigoPostal = lugares.getLocation().getPostalCode();

        if (codigoPostal == null){
            codigoPostal =  "";
        }

        DirTitul.setText("Direccion");
        DirCalle.setText("Calle: " + lugares.getLocation().getAddress());
        DirCpostal.setText("C.Postal: " + codigoPostal);
        DirPobla.setText("Población: " + lugares.getLocation().getCity());
        DirPais.setText("Población: " + lugares.getLocation().getCountry());

        idLugar = lugares.getId();

    }

    public void verComentarios(View view) {

        Intent i = new Intent(this, TipsActivity.class);
        i.putExtra("idLugar", idLugar+"");
        startActivity(i);
    }


}
