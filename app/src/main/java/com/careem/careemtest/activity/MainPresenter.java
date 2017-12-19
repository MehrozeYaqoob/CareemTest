package com.careem.careemtest.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;

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
 * Created by hp on 12/15/2017.
 */

public class MainPresenter implements MainContract.MainPresenterBehavior {

    private final MoviesApiClient moviesApiClient;

    private int mYear, mMonth, mDay;

    private MoviesResponse movieResponse;
    private MainContract.MainViewBehavior mainViewBehavior;

    @Inject
    public MainPresenter(Context context, MoviesApiClient moviesApiClient) {
        this.moviesApiClient = moviesApiClient;
    }


    @Override
    public void setView(MainContract.MainViewBehavior view) {
        this.mainViewBehavior = view;
    }

    @Override
    public void handleBtnDateFilter(Context context) {

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mainViewBehavior.updateScreen(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }
        }, mYear, mMonth, mDay);

        datePickerDialog.show();
    }

    @Override
    public void fetchMoviesDataByDate(String date) {
        Call<MoviesResponse> call = moviesApiClient.getDateWiseFilteredMovies(Constants.API_KEY,date);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                movieResponse = response.body();
                mainViewBehavior.setAdapter(response.body());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                mainViewBehavior.showErrorMessage(call,t);
            }
        });
    }

    @Override
    public void fetchMoviesDataAsync() {
        Call<MoviesResponse> call = moviesApiClient.getNowPlayingMovies(Constants.API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                movieResponse = response.body();
                mainViewBehavior.setAdapter(response.body());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                mainViewBehavior.showErrorMessage(call,t);
            }
        });
    }

    @Override
    public void handleItemTouchEvent(View v, int position) {
        Movie movie = movieResponse.getResults().get(position);
        mainViewBehavior.showDetailViewOfMovieItem(movie);
    }

}
