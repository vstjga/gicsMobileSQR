package com.proyectodam.gicsmobile;

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

import com.proyectodam.gicsmobile.json.*;
import com.squareup.picasso.Picasso;

/**
 * Created by usuario1 on 8/11/15.
 */
public class VenueAdapter extends ArrayAdapter<Venue> {

    public VenueAdapter(Context context, int resource, List<Venue> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       Venue Venue = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lvvvenues_row, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvAddress = (TextView) convertView.findViewById(R.id.tvAddress);
        TextView tvDistance = (TextView) convertView.findViewById(R.id.tvDistance);
        ImageView ivPosterImage = (ImageView) convertView.findViewById(R.id.ivPosterImage);

        tvName.setText(Venue.getName());
        tvAddress.setText(Venue.getLocation().getAddress());
        tvDistance.setText(Venue.getLocation().getDistance().toString() + " metros");

        ArrayList <Category> categorias = (ArrayList<Category>) Venue.getCategories();
        Integer numcat = categorias.size();
        String  numcats = numcat.toString();

        String url_imagen = "https://ss3.4sqi.net/img/categories_v2/food/pizza_bg_88.png"; // imagen omision

        if (numcat > 0) {
            Category categoria1 = categorias.get(0);
            Icon icono = categoria1.getIcon();
            url_imagen = icono.getPrefix() + "bg_88" + icono.getSuffix(); // error autorizacion en url-api
        }

        Picasso.with(getContext()).load(url_imagen).into(ivPosterImage);

    return convertView;

    }

}
