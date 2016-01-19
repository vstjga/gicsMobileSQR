package com.proyectodam.gicsmobile;

/**
 * Created by vstjga on 19/01/16.
 */
import android.util.Log;
import android.widget.ArrayAdapter;


import com.proyectodam.gicsmobile.json.Comentarios;
import com.proyectodam.gicsmobile.json.Item_;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;


public class APIClientTips {


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

    public APIClientTips() {
        super();
    }




    public void getLugares(final ArrayAdapter<Item_> adapter, String clave, String v) {
        Log.d(clave, "DEBUGJGA");
        Call<Comentarios> call = servei.getLugaresSQR(clave, v);
        call.enqueue(new Callback<Comentarios>() {

                         @Override
                         public void onResponse(Response<Comentarios> response, Retrofit retrofit) {
                             if (response.isSuccess()) {
                                 Comentarios misComentarios = response.body();

                                 adapter.clear();
                                 for (Item_ prod : misComentarios.getResponse().getTips().getItems()) {
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


        @GET("/v2/venues/40a55d80f964a52020f31ee3/tips")
        Call<Comentarios> getLugaresSQR(@Query("oauth_token") String clave,@Query("v") String v);



    }
}




