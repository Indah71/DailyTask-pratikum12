package com.example.latihan_praktikum_7.network;

import com.example.latihan_praktikum_7.entity.Doa;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api")
    Call<List<Doa>> getDoaList();
}
