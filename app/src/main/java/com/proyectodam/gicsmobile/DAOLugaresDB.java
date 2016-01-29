package com.proyectodam.gicsmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;


import com.proyectodam.gicsmobile.json.*;

import java.util.ArrayList;
/**
 * Created by vstjga on 23/01/16.
 *
 */

public class DAOLugaresDB {

    /**
     * Constructor clase DAOLugaresDB
     */
    DAOLugaresDB(){}


    public void altaLugar (Context context, String id, String nombre, String categoria, String direccion, String cpostal, String poblacion,String pais,
    String ubicacion, String distancia, String urlimagen){

        LugaresDbHelper admin = new LugaresDbHelper(context,"SQRGICSDB",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();


        ContentValues registre = new ContentValues();
        registre.put("id",id);
        registre.put("nombre",nombre);
        registre.put("categoria",categoria);
        registre.put("direccion",direccion);
        registre.put("cpostal",cpostal);
        registre.put("poblacion",poblacion);
        registre.put("pais",pais);
        registre.put("ubicacion",ubicacion);
        registre.put("distancia",distancia);
        registre.put("urlimagen",urlimagen);

        db.insert("Lugares", null, registre);
        String a ="";
        Log.d(a, "registro insertado");
        db.close();
        Log.d(a, "INSERTANDO DB");
    }

    /**
     *
     */
    public  void borrarLugares(Context context) {
        LugaresDbHelper admin = new LugaresDbHelper(context, "SQRGICSDB", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        db.execSQL( "delete from Lugares");

    }

    /**
     *
     */
    public  void mostrarLugares(Context context,final ArrayAdapter<Venue> adapter) {

        LugaresDbHelper admin = new LugaresDbHelper(context, "SQRGICSDB", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();



        final Cursor c = db.rawQuery("select * from Lugares", null);
        String id = "";
        String nombre = "";
        String categoria = "";
        String direccion = "";
        String cpostal = "";
        String poblacion = "";
        String pais = "";
        String ubicacion = "";
        String distancia = "";
        String urlimagen = "";

        if (c.moveToFirst())
        {
            do {
                id=c.getString(0);
                nombre=c.getString(1);
                categoria=c.getString(2);
                direccion=c.getString(3);
                cpostal=c.getString(4);
                poblacion=c.getString(5);
                pais=c.getString(6);
                ubicacion=c.getString(7);    // falta desglosar en latitud y longitud no la uso
                distancia=c.getString(8);    // esta en db como string hay que transformar
                                            //
                urlimagen=c.getString(9);    // esta desglosado utilizo per prefix

                Log.d(id, "ID id");
                Log.d(nombre, "ID nombre");
                Log.d(categoria, "ID categoria");
                Log.d(direccion, "ID direccion");
                Log.d(cpostal, "ID cpostal ");
                Log.d(poblacion, "ID poblacion");
                Log.d(pais, "ID pais");
                Log.d(ubicacion, "ID ubicacion");
                Log.d(distancia, "ID distancia");
                Log.d(urlimagen, "ID imagen");








                Venue    prod = new Venue();
                Location loca = new Location();
                Category cate = new Category();
                Icon ico = new Icon();

                prod.setId(id);
                prod.setName(nombre);

                loca.setAddress(direccion);
                loca.setPostalCode(cpostal);
                loca.setCity(poblacion);
                loca.setCountry(pais);
                loca.setPostalCode(cpostal);

                Integer numdistancia;
                try
                {
                    numdistancia = Integer.parseInt(distancia);

                }
                catch(NumberFormatException nfe)
                {
                    numdistancia = 0;
                }


                loca.setDistance(numdistancia);

                ico.setPrefix(urlimagen);

                cate.setName(categoria);
                cate.setIcon(ico);


                prod.setLocation(loca);



                ArrayList<Category> categories = new ArrayList<Category>();
                categories.add(cate);

                prod.setCategories(categories);


                adapter.add(prod);

                Log.d(nombre, "LEIDO DE DB");

            } while (c.moveToNext());
        }
        db.close();

    return;
    }
}
