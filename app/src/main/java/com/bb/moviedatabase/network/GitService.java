package com.bb.moviedatabase.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitService {
        @GET("/movie")
        public <GitResult> Call<List<GitResult>> getMovie(@Path("movierName")String movieName);
}
