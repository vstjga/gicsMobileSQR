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

        Category categoria1 = categorias.get(0);

//       for(int x=0;x<numcat;x++) {
 //           Log.d(categorias.get(x).getName(),"categorias");
 //       }

         Icon icono = categoria1.getIcon();
         String url_imagen = icono.getPrefix() + icono.getSuffix(); // error autorizacion en url-api
         Log.d(url_imagen, "imagen");

         url_imagen = "http://image.tmdb.org/t/p/w130/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg"; // imagen pruebas


       Picasso.with(getContext()).load(url_imagen).into(ivPosterImage);


//       respuesta en la llamada
 //       <Error>
 //       <Code>AccessDenied</Code>
 //       <Message>Access Denied</Message>
 //       <RequestId>EC3AF51A1CF10264</RequestId>
 //       <HostId>
 //               tLpkYU4/DamMqX27X02v0BJk16Uvw0fv72eezUYFpc7zWVX1MXupbeIPHdJfNQtp/Pj95xwL3Nc=
 //       </HostId>
 //       </Error>

        return convertView;
    }

}
