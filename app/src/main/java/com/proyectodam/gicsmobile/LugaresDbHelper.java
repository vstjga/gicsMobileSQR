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
        Log.i(this.getClass().toString(), "Creando base de datos");
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


        Log.i(this.getClass().toString(), "Tabla Lugares creada");

    /*
    * Insertamos datos de pruebas
    */
    //    db.execSQL("INSERT INTO Lugares(_id, nombre,categoria,direccion,cpostal,poblacion,pais,ubicacion,distancia,urlimagen) VALUES('1','nombre1','categoria1','direccion1','cpostal1','poblacion1','pais1','ubicacion1','100','urlimagen1')");

    //    db.execSQL("INSERT INTO Lugares(_id, nombre,categoria,direccion,cpostal,poblacion,pais,ubicacion,distancia,urlimagen) VALUES('2','nombre2','categoria2','direccion2','cpostal2','poblacion2','pais2','ubicacion2','200','urlimagen2')");

    //    db.execSQL("INSERT INTO Lugares(_id, nombre,categoria,direccion,cpostal,poblacion,pais,ubicacion,distancia,urlimagen) VALUES('3','nombre3','categoria3','direccion3','cpostal3','poblacion3','pais3','ubicacion3','300','urlimagen3')");

        Log.i(this.getClass().toString(), "Datos de pruebas Lugares insertados");

        Log.i(this.getClass().toString(), "Base de datos creada");
//        apiClient.getLugares(getContext(), adapter, clave, ll, v);

          APIClient apiClient = new APIClient();

          apiClient.getLugares(context);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
