package com.prography.playeasy.lib;

import com.prography.playeasy.lib.auth.RetrofitLoginApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientGenerator {
    private static RetrofitLoginApi service = null;
    private static final String BASE_URL="http://api.theplayeasy.com";

    private RetrofitClientGenerator() { }

    public static RetrofitLoginApi getClient() {
        if (service == null) {
            service = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(RetrofitLoginApi.class);
        }

        return service;
    }
}
