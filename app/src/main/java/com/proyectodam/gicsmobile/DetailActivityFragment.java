package com.proyectodam.gicsmobile;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.squareup.picasso.Picasso;


import com.proyectodam.gicsmobile.json.*;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    TextView Name;
    TextView Address;
    TextView Distance;
    ImageView ivPosterImage;

    TextView ActTitul;
    TextView ActName;

    TextView DirTitul;
    TextView DirCalle;
    TextView DirCpostal;
    TextView DirPobla;
    TextView DirPais;
    Venue lugares;
    View fragmentoDetalle;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.fragmentoDetalle = inflater.inflate(R.layout.fragment_detail, container, false);

        Name = (TextView) fragmentoDetalle.findViewById(R.id.tvName);
        Address = (TextView) fragmentoDetalle.findViewById(R.id.tvAddress);
        Distance = (TextView) fragmentoDetalle.findViewById(R.id.tvDistance);
        ivPosterImage = (ImageView) fragmentoDetalle.findViewById(R.id.ivPosterImage);

        ActTitul = (TextView) fragmentoDetalle.findViewById(R.id.tvActTitul);
        ActName = (TextView) fragmentoDetalle.findViewById(R.id.tvActName);

        DirTitul = (TextView) fragmentoDetalle.findViewById(R.id.tvDirTitul);
        DirCalle = (TextView) fragmentoDetalle.findViewById(R.id.tvDirCalle);
        DirCpostal = (TextView) fragmentoDetalle.findViewById(R.id.tvDirCpostal);
        DirPobla = (TextView) fragmentoDetalle.findViewById(R.id.tvDirPobla);
        DirPais = (TextView) fragmentoDetalle.findViewById(R.id.tvDirPais);


        Bundle b = getActivity().getIntent().getExtras();

        try {
            this.lugares = b.getParcelable(MainActivityFragment.OBJETO_LUGAR);
            fragmentoDetalle.setVisibility(View.VISIBLE);
            loadLugar(fragmentoDetalle,this.lugares);
        } catch (NullPointerException ex) {
            this.lugares = null;
            fragmentoDetalle.setVisibility(View.INVISIBLE);

        }


        final Button button = (Button) fragmentoDetalle.findViewById(R.id.botonComentarios);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent i = new Intent(getContext(), TipsActivity.class);
                i.putExtra("idLugar", lugares.getId()+"");
                startActivity(i);
            }
        });

        return fragmentoDetalle;


    }
    private void loadLugar(View view, Venue lugares) {

        Name.setText(lugares.getName());
        Address.setText(lugares.getLocation().getAddress());
        Distance.setText(lugares.getLocation().getDistance().toString() + " metros");

        String nombreCat = "";
        ArrayList<Category> categorias = (ArrayList<Category>) lugares.getCategories();
        Integer numcat = categorias.size();
        String  numcats = numcat.toString();

        String url_imagen = "https://ss3.4sqi.net/img/categories_v2/food/pizza_bg_88.png";

        if (numcat > 0) {
            Category categoria1 = categorias.get(0);
            Icon icono = categoria1.getIcon();
//            url_imagen = icono.getPrefix() + "bg_88" + icono.getSuffix();
            url_imagen = icono.getPrefix(); //

            nombreCat  = categoria1.getName();
        }

        Picasso.with(getContext()).load(url_imagen).into(ivPosterImage);

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

    }

    public void loadLugarFromActivity(Venue lugar) {
        this.lugares = lugar;
        View view = getView();
        fragmentoDetalle.setVisibility(View.INVISIBLE);
        if (lugar != null) {
            loadLugar(view, lugar);
            fragmentoDetalle.setVisibility(View.VISIBLE);
        }
    }



}
