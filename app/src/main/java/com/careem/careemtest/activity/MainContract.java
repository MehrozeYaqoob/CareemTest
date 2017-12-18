package com.careem.careemtest.activity;

import android.content.Context;
import android.view.View;

import com.careem.careemtest.model.MoviesResponse;
import com.careem.careemtest.model.Movie;

import retrofit2.Call;

/**
 * Created by hp on 12/15/2017.
 */

public interface MainContract {

    interface MainViewBehavior {
        void setAdapter(MoviesResponse moviesResponse);
        void showErrorMessage(Call<MoviesResponse> call, Throwable t);
        void showDetailViewOfMovieItem(Movie movie);
        void updateScreen(String date);
    }
    interface MainPresenterBehavior {
        void fetchMoviesDataAsync();
        void handleItemTouchEvent(View v, int position);
        void setView(MainContract.MainViewBehavior view);
        void handleBtnDateFilter(Context context);
        void fetchMoviesDataByDate(String date);
    }
}
