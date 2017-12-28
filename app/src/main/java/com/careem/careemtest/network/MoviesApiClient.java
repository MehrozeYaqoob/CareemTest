package com.careem.careemtest.network;

import com.careem.careemtest.model.MoviesResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Mehroze on 12/15/2017.
 */
@SuppressWarnings({ "DefaultFileTemplate"})
public interface MoviesApiClient {

    @GET("movie/now_playing")
    Call<MoviesResponse> getNowPlayingMovies(@Query("api_key") String apiKey);

    @GET("discover/movie")
    Call<MoviesResponse> getDateWiseFilteredMovies(@Query("api_key") String apiKey, @Query("primary_release_date.gte") String releaseDate);

}
