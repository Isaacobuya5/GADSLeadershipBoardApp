package com.example.gadsleadershipboardapp.services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    private static  final  String URL = "https://gadsapi.herokuapp.com/";


    // Building and registering the interceptor
    // 1. create the logger
    private static HttpLoggingInterceptor logger = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    // 2. Create OkHttpClient
    // and register interceptor
    private static OkHttpClient.Builder okHttp = new OkHttpClient.Builder()
            .addInterceptor(logger);

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            // 3. tell Retrofit to use our custom okHttp client that use the logging interceptor
            .client(okHttp.build());

    private static Retrofit retroFit = builder.build();

    public static  <S> S buildService(Class<S> serviceType) {
        return retroFit.create(serviceType);
    }
}
