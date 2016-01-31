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
    private static String name = "SQRGICSDB" ;
    private static SQLiteDatabase.CursorFactory factory = null;
    Context context;

    public LugaresDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;

    }

    public LugaresDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    public LugaresDbHelper(Context context) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL( "DROP TABLE IF EXISTS Lugares");

        db.execSQL( "CREATE TABLE Lugares(" +
                " id          TEXT PRIMARY KEY," +
                " nombre      TEXT," +
                " categoria   TEXT," +
                " direccion   TEXT," +
                " cpostal     TEXT," +
                " poblacion   TEXT," +
                " pais        TEXT," +
                " ubicacion   TEXT," +
                " distancia   TEXT," +
                " urlimagen   TEXT)" );

       APIClient apiClient = new APIClient();

 
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
