package com.proyectodam.gicsmobile;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import com.proyectodam.gicsmobile.json.Category;
import com.proyectodam.gicsmobile.json.Icon;
import com.proyectodam.gicsmobile.json.Lugares;
import com.proyectodam.gicsmobile.json.Venue;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

import com.squareup.okhttp.ResponseBody;

import java.util.ArrayList;


public class APIClient {


    final String BASE_URL = "https://api.foursquare.com";
    final String clavefinal = "KIG3YM0N0TFADPJIR4K4GSZNSSFEPWK1IBDS10NVUIUNDOVR";
    final String llfinal = "41.387920,2.169919";  // poblenou
    final String vfinal = "20160101";
    boolean offline = false;
    DAOLugaresDB db = new DAOLugaresDB();

  //  https://api.foursquare.com/v2/venues/search?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&v=20130815&ll=40.7463956,-73.9852992"

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ApiGicsInterfase servei = retrofit.create(ApiGicsInterfase.class);

    public APIClient() {
        super();
    }




  //  public void getLugares(final Context context, final ArrayAdapter<Venue> adapter, String clave, String ll, String v) {
      public void getLugares(final Context context) {



        Call<Lugares> call = servei.getLugaresSQR(clavefinal, llfinal, vfinal);
        call.enqueue(new Callback<Lugares>() {

                         @Override
                         public void onResponse(Response<Lugares> response, Retrofit retrofit) {
                             if (response.isSuccess()) {
                                 Lugares MisLugares = response.body();

                             //    adapter.clear();
                                 db.borrarLugares (context);
                                 for (Venue prod : MisLugares.getResponse().getVenues()) {
                             //     adapter.add(prod);

                                     String categoria = "";

                                     String id = prod.getId();
                                     String nombre = prod.getName();

                                     ArrayList<Category> categorias = (ArrayList<Category>) prod.getCategories();
                                     Integer numcat = categorias.size();


                                     String urlimagen = "https://ss3.4sqi.net/img/categories_v2/food/pizza_bg_88.png"; // imagen omision

                                     if (numcat > 0) {
                                         Category categoria1 = categorias.get(0);
                                         categoria = categoria1.getName();
                                         Icon icono = categoria1.getIcon();
                                         urlimagen = icono.getPrefix() + "bg_88" + icono.getSuffix(); // error autorizacion en url-api
                                     }

                                     String direccion = prod.getLocation().getAddress();
                                     String cpostal = prod.getLocation().getPostalCode();
                                     String poblacion = prod.getLocation().getCity();
                                     String pais = prod.getLocation().getCountry();
                                     String ubicacion = prod.getLocation().getLat() + "," + prod.getLocation().getLng();
                                     String distancia = prod.getLocation().getDistance().toString();
                                     Log.d(distancia, "CARGANDO DB");
                                     db.altaLugar (context, id, nombre, categoria, direccion,cpostal,poblacion,pais,ubicacion,distancia,urlimagen);

                                 }
                          } else {
                                 CharSequence text = "DATOS OFFLINE";
                                 int duration = Toast.LENGTH_LONG;

                                 Toast toast = Toast.makeText(context, text, duration);
                                 toast.show();

                             }
                         }

                         @Override
                         public void onFailure(Throwable t) {
                             CharSequence text = "DATOS OFFLINE";
                             int duration = Toast.LENGTH_LONG;

                             Toast toast = Toast.makeText(context, text, duration);
                             toast.show();

                         }

                     }
        );
    }

    public void recuperarDB(){

    }


    interface ApiGicsInterfase {

       @GET("/v2/venues/search")
       Call<Lugares> getLugaresSQR(@Query("oauth_token") String clave,@Query("ll") String ll,@Query("v") String v);



    }
}



// http://gics.260mb.net/gics/Venues/GetVenuesPorNombre?apikey=6969

// http://localhost/gics/Venues/GetVenuesPorPrecio?apikey=6969