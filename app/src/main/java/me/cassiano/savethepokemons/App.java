package me.cassiano.savethepokemons;

/**
 * Created by matheus on 01/12/16.
 */

import android.app.Application;

import me.cassiano.savethepokemons.service.IService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static App sInstance;
    private static IService sService;

    public static App getInstance() {
        return sInstance;
    }

    public static IService getService() {
        return sService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://vettsel.cassiano.me:4567")
                .build();

        sService = retrofit.create(IService.class);
    }


}