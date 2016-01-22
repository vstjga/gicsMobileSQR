package com.proyectodam.gicsmobile;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by vstjga on 22/01/16.
 */
public class LugaresDbHelper extends SQLiteOpenHelper {
    private static int version = 1;
    private static String name = "LugaresDb" ;
    private static SQLiteDatabase.CursorFactory factory = null;

    public LugaresDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    public LugaresDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    public LugaresDbHelper(Context context) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(this.getClass().toString(), "Creando base de datos");

        db.execSQL( "CREATE TABLE Lugares(" +
                " _id             TEXT PRIMARY KEY," +
                " hip_nombre      TEXT NOT NULL, " +
                " hip_categoria   TEXT, " +
                " hip_direccion   TEXT," +
                " hip_cpostal     TEXT," +
                " hip_poblacion   TEXT," +
                " hip_pais        TEXT," +
                " hip_ubicacion   TEXT," +
                " hip_peticion    TEXT," +
                " hip_urlimagen   TEXT)" );



        Log.i(this.getClass().toString(), "Tabla Lugares creada");

    /*
    * Insertamos datos de pruebas
    */
        db.execSQL("INSERT INTO Lugares(_id, hip_nombre,hip_categoria,hip_direccion,hip_cpostal,hip_poblacion,hip_pais,hip_ubicacion,hip_peticion,hip_urlimagen) VALUES(1,'nombre1','categoria1','direccion1','cpostal1','cpostal1','poblacion1','pais1','ubicacion1','peticion1','urlimagen1')");

        db.execSQL("INSERT INTO Lugares(_id, hip_nombre,hip_categoria,hip_direccion,hip_cpostal,hip_poblacion,hip_pais,hip_ubicacion,hip_peticion,hip_urlimagen) VALUES(2,'nombre2','categoria2','direccion2','cpostal2','cpostal2','poblacion2','pais2','ubicacion2','peticion2','urlimagen2')");

        db.execSQL("INSERT INTO Lugares(_id, hip_nombre,hip_categoria,hip_direccion,hip_cpostal,hip_poblacion,hip_pais,hip_ubicacion,hip_peticion,hip_urlimagen) VALUES(3,'nombre3','categoria3','direccion3','cpostal3','cpostal3','poblacion3','pais3','ubicacion3','peticion3','urlimagen3')");

        Log.i(this.getClass().toString(), "Datos de pruebas Lugares insertados");

        Log.i(this.getClass().toString(), "Base de datos creada");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}