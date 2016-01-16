package com.proyectodam.gicsmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.proyectodam.gicsmobile.json.*;

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

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvCriticsScore = (TextView) convertView.findViewById(R.id.tvCriticsScore);
        TextView tvDate = (TextView) convertView.findViewById(R.id.tvDate);
        ImageView ivPosterImage = (ImageView) convertView.findViewById(R.id.ivPosterImage);

        tvTitle.setText(Venue.getName());
        tvCriticsScore.setText(Venue.getId());

        tvDate.setText(Venue.getLocation() + " $");


  //      String poster = Venue.getImagen();
 //      String url_img = "http://image.tmdb.org/t/p/w300/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg";
 //       http://gics.260mb.net/gics/img/640px-Arroz_a_banda.jpg

 //       String url_img = "http://gics.260mb.net/gics/" + poster;
 //       Picasso.with(getContext()).load("http://gics.260mb.net/gics/img/640px-Arroz_a_banda.jpg").into(ivPosterImage);

        return convertView;
    }

}
