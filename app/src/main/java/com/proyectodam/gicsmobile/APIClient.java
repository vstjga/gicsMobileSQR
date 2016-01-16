package com.proyectodam.gicsmobile;

import android.util.Log;
import android.widget.ArrayAdapter;


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



public class APIClient {


    final String BASE_URL = "https://api.foursquare.com";
    final String clavefinal = "KIG3YM0N0TFADPJIR4K4GSZNSSFEPWK1IBDS10NVUIUNDOVR";
    final String llfinal = "41.387920,2.169919";  // poblenou
    final String vfinal = "20160101";

  //  https://api.foursquare.com/v2/venues/search?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&v=20130815&ll=40.7463956,-73.9852992"

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ApiGicsInterfase servei = retrofit.create(ApiGicsInterfase.class);

    public APIClient() {
        super();
    }




    public void getLugares(final ArrayAdapter<Venue> adapter, String clave, String ll, String v) {
        Log.d(clave, "DEBUGJGA");
        Call<Lugares> call = servei.getLugaresSQR(clave, ll, v);
        call.enqueue(new Callback<Lugares>() {

                         @Override
                         public void onResponse(Response<Lugares> response, Retrofit retrofit) {
                             if (response.isSuccess()) {
                                 Lugares MisLugares = response.body();

                                 adapter.clear();
                                 for (Venue prod : MisLugares.getResponse().getVenues()) {
                                     adapter.add(prod);

                                 }
                             } else {

                                 adapter.clear();
                             }
                         }
                         @Override
                         public void onFailure(Throwable t) {
                         }
                     }
        );
    }

    interface ApiGicsInterfase {

       @GET("/v2/venues/search")
       Call<Lugares> getLugaresSQR(@Query("oauth_token") String clave,@Query("ll") String ll,@Query("v") String v);



    }
}



// http://gics.260mb.net/gics/Venues/GetVenuesPorNombre?apikey=6969

// http://localhost/gics/Venues/GetVenuesPorPrecio?apikey=6969