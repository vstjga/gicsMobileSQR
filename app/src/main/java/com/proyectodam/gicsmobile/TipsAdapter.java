package com.proyectodam.gicsmobile;

/**
 * Created by vstjga on 19/01/16.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.proyectodam.gicsmobile.json.*;
import com.squareup.picasso.Picasso;


public class TipsAdapter extends ArrayAdapter<Item_> {

    public TipsAdapter(Context context, int resource, List<Item_> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Item_ myitem = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lvvtips_row, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvTexto = (TextView) convertView.findViewById(R.id.tvTexto);

    ImageView ivPosterImage = (ImageView) convertView.findViewById(R.id.ivPosterImage);

        tvName.setText(myitem.getUser().getFirstName());
        tvTexto.setText(myitem.getText());




        String url_imagen = "https://ss3.4sqi.net/img/categories_v2/food/pizza_bg_88.png"; // imagen omision

        url_imagen = myitem.getPhotourl();

     //  Picasso.with(getContext()).load(url_imagen).into(ivPosterImage);

        return convertView;

    }

}
