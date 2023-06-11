package com.example.uzauto.useingretrofit;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface JSONPlaceHolderApi {
//zapros berib javob kutadi
    @GET("/shaxsiy/uzautokh/shw.php")
    Call<List<ModelJson>> getUzAutHodim();

    @GET("/shaxsiy/uzautokh/shw_trening.php")
    Call<List<ModelJson>> getTrening();

    @GET("/shaxsiy/uzautokh/update.php")
    Call<List<ModelJson>> getUpdate(@Query("android_id") String android_id, @Query("tabel_raqam") String tabel_raqam);
    //Call<List<ModelJson>> getTest(@Query("android_id") String android_id, @Query("status") String status, @Query("hisob") int hisob);
}
