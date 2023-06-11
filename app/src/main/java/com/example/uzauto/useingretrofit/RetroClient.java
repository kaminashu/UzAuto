 /* This is the source code of SmartSchoolTeacher for Android.
 * Copyright Muhammadsoloyev Akbar , 2019-2020.
 */
package com.example.uzauto.useingretrofit;


 import retrofit2.Retrofit;
 import retrofit2.converter.gson.GsonConverterFactory;

 public class RetroClient {

 public static String Ret_URL = "https://uzmd.uz/";

     private static Retrofit getRetrofit() {
         return new Retrofit.Builder()
                 .baseUrl(Ret_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
     }

     public static JSONPlaceHolderApi getApiServise(){
         return getRetrofit().create(JSONPlaceHolderApi.class);
     }
 }

