package com.prography.playeasy.lib;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientGenerator {
    private static Retrofit service = null;
    private static final String BASE_URL="http://api.theplayeasy.com";

    private RetrofitClientGenerator() { }

    public static <T> T getClient(Class<T> apiInterfaceClass) {
        if (service == null) {
            service = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return apiInterfaceClass.cast(service.create(apiInterfaceClass));
    }
}
