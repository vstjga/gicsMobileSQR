package com.proyectodam.gicsmobile;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by vstjga on 22/01/16.
 */
public class LugaresCursorAdapter extends CursorAdapter {

    private LugaresDbAdapter dbAdapter = null ;

    public LugaresCursorAdapter(Context context, Cursor c)
    {
        super(context, c);
        dbAdapter = new LugaresDbAdapter(context);
        try {
            dbAdapter.abrir();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv = (TextView) view ;

        tv.setText(cursor.getString(cursor.getColumnIndex(LugaresDbAdapter.C_COLUMNA_NOMBRE)));

    }
}

