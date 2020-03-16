package com.bb.moviedatabase.network;

import java.util.List;

import butterknife.internal.Constants;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitRetroFitInstance {
    private static final Object BASE_URL = "https://api.themoviedb.org";
    private GitService gitService;

        public GitRetroFitInstance() {
            gitService = createService(createRetrofit());
        }
        private Retrofit createRetrofit(){

            return new Retrofit.Builder()
                    .baseUrl((String) GitRetroFitInstance.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        private GitService createService(Retrofit retrofit) {
            return retrofit.create(GitService.class);
        }

        public <GitResult> Call<List<GitResult>> getMovie(String movieName){
            return gitService.getMovie(movieName);
        }
}
