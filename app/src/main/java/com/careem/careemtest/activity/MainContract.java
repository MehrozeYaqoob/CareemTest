package com.careem.careemtest.activity;

import android.content.Context;

import com.careem.careemtest.model.MoviesResponse;
import com.careem.careemtest.model.Movie;

/**
 * Created by Mehroze on 12/15/2017.
 */

@SuppressWarnings("ALL")
interface MainContract {

    interface MainViewBehavior {
        void setAdapter(MoviesResponse moviesResponse);
        void showErrorMessage();
        void showDetailViewOfMovieItem(Movie movie);
        void updateScreen(String date);
    }
    interface MainPresenterBehavior {
        void fetchMoviesDataAsync();
        void handleItemTouchEvent(int position);
        void attachView(MainContract.MainViewBehavior view);
        void handleBtnDateFilter(Context context);
        void fetchMoviesDataByDate(String date);
    }
}
