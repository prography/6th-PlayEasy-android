package com.prography.playeasy.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitService service = null;

    private RetrofitClient() { }

    public static final String BASE_URL="http://api.theplayeasy.com";

    public static RetrofitService getService() {
        if (service == null) {
            service = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(RetrofitService.class);
        }

        return service;
    }
}
