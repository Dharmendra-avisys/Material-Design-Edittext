package com.avisys.allinone.pagination.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceBuilder {
  // Base URL
  private static final String URL = "https://reqres.in/api/";
  // Create Logger
//  private static HttpLoggingInterceptor logger =
//      new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
  // Create OkHttp Client
//  private static OkHttpClient.Builder okHttp = new OkHttpClient.Builder().addInterceptor(logger);
  // Create Retrofit Builder
  private static Retrofit retrofit = new Retrofit.Builder()
      .baseUrl(URL)
      .addConverterFactory(GsonConverterFactory.create()).build();
//      .client(okHttp.build());
  // Create Retrofit Instance
//  private static Retrofit retrofit = builder.build();
  public static <T> T buildService(Class<T> type) {
    return retrofit.create(type);
  }
}