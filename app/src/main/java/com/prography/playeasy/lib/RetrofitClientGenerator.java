package com.prography.playeasy.lib;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientGenerator {
    private static Object service = null;
    private static final String BASE_URL="http://api.theplayeasy.com";

    private RetrofitClientGenerator() { }

    public static <T> T getClient(Class<T> apiInterfaceClass) {
        if (service == null) {
            service = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(apiInterfaceClass);
        }

        return apiInterfaceClass.cast(service);
    }
}
