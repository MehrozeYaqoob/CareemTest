package com.careem.careemtest.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.DatePicker;

import com.careem.careemtest.app.CareemApplication;
import com.careem.careemtest.model.MoviesResponse;
import com.careem.careemtest.app.Constants;
import com.careem.careemtest.model.Movie;
import com.careem.careemtest.network.MoviesApiClient;


import java.util.Calendar;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mehroze on 12/15/2017.
 */

@SuppressWarnings("ALL")
public class MainPresenter implements MainContract.MainPresenterBehavior {

    @Inject
    MoviesApiClient moviesApiClient;

    private MoviesResponse movieResponse;
    private MainContract.MainViewBehavior mainViewBehavior;

    public MainPresenter(Context context) {
        ((CareemApplication)context).getAppComponent().inject(this);

    }

    @Override
    public void attachView(MainContract.MainViewBehavior view) {
        this.mainViewBehavior = view;
    }

    @Override
    public void handleBtnDateFilter(Context context) {

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mainViewBehavior.updateScreen(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    @Override
    public void fetchMoviesDataByDate(String date) {
        Call<MoviesResponse> call = moviesApiClient.getDateWiseFilteredMovies(Constants.API_KEY,date);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call, @NonNull Response<MoviesResponse> response) {
                movieResponse = response.body();
                mainViewBehavior.setAdapter(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<MoviesResponse> call, @NonNull Throwable t) {
                mainViewBehavior.showErrorMessage();
            }
        });
    }

    @Override
    public void fetchMoviesDataAsync() {
        Call<MoviesResponse> call = moviesApiClient.getNowPlayingMovies(Constants.API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call, @NonNull Response<MoviesResponse> response) {
                movieResponse = response.body();
                mainViewBehavior.setAdapter(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<MoviesResponse> call, @NonNull Throwable t) {
                mainViewBehavior.showErrorMessage();
            }
        });
    }

    @Override
    public void handleItemTouchEvent(int position) {
        Movie movie = movieResponse.getResults().get(position);
        mainViewBehavior.showDetailViewOfMovieItem(movie);
    }

}
