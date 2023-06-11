package com.example.uzauto.useingretrofit;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface JSONPlaceHolderApi {
//zapros berib javob kutadi
    @GET("/shaxsiy/uzautokh/shw.php")
    Call<List<ModelJson>> getUzAutHodim();

    @GET("/shaxsiy/uzautokh/shw_trening.php")
    Call<List<ModelJson>> getTrening();
    //Call<List<ModelJson>> getTest(@Query("android_id") String android_id, @Query("status") String status, @Query("hisob") int hisob);
}
