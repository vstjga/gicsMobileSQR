package com.proyectodam.gicsmobile;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by vstjga on 22/01/16.
 */
public class LugaresDbAdapter {
    /**
     * Definimos constante con el nombre de la tabla
     */
    public static final String C_TABLA = "Lugares" ;

    /**
     * Definimos constantes con el nombre de las columnas de la tabla
     */
    public static final String C_COLUMNA_ID   = "_id";
    public static final String C_COLUMNA_NOMBRE = "hip_nombre";
    public static final String C_COLUMNA_CATEGORIA = "hip_categoria";

    public static final String C_COLUMNA_DIRECCION = "hip_direccion";
    public static final String C_COLUMNA_CPOSTAL = "hip_cpostal";
    public static final String C_COLUMNA_POBLACION = "hip_poblacion";
    public static final String C_COLUMNA_PAIS = "hip_pais";
    public static final String C_COLUMNA_UBICACION = "hip_ubicacion";
    public static final String C_COLUMNA_PETICION = "hip_peticion";
    public static final String C_COLUMNA_URLIMAGEN = "hip_urlimagen";

    private Context contexto;
    private LugaresDbHelper dbHelper;
    private SQLiteDatabase db;

    /**
     * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
     */
    private String[] columnas = new String[]{ C_COLUMNA_ID, C_COLUMNA_NOMBRE, C_COLUMNA_CATEGORIA, C_COLUMNA_DIRECCION, C_COLUMNA_CPOSTAL, C_COLUMNA_POBLACION, C_COLUMNA_PAIS,C_COLUMNA_UBICACION,C_COLUMNA_PETICION,C_COLUMNA_URLIMAGEN} ;

    public LugaresDbAdapter(Context context)
    {
        this.contexto = context;
    }

    public LugaresDbAdapter abrir() throws SQLException
    {
        dbHelper = new LugaresDbHelper(contexto);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void cerrar()
    {
        dbHelper.close();
    }

    /**
     * Devuelve cursor con todos las columnas de la tabla
     */
    public Cursor getCursor() throws SQLException
    {
        Cursor c = db.query( true, C_TABLA, columnas, null, null, null, null, null, null);

        return c;
    }
}

