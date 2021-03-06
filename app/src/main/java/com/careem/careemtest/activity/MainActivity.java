package com.careem.careemtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.careem.careemtest.adapter.ClickListener;
import com.careem.careemtest.adapter.MovieAdapter;
import com.careem.careemtest.adapter.RecyclerTouchListener;
import com.careem.careemtest.app.CareemApplication;
import com.careem.careemtest.model.Movie;
import com.careem.careemtest.model.MoviesResponse;
import com.careem.careemtest.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.MainViewBehavior {

    @Inject
    MainPresenter presenter;

    private RecyclerView recyclerView;
    private Button dateFilterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializing dagger
        ((CareemApplication)getApplication()).getAppComponent().inject(MainActivity.this);

        // setting presenter view
        presenter.attachView(this);

        // recycler view
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        // Using our Presenter Rendering logic
        presenter.fetchMoviesDataAsync();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(MainActivity.this, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                presenter.handleItemTouchEvent(position);
            }
        }));


        dateFilterBtn = findViewById(R.id.btn_date_filter);
        dateFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.handleBtnDateFilter(MainActivity.this);
            }
        });
    }

    /**
     *  Overridden methods from MainContract.MainViewBehavior
     *  setAdapter , show error message , show detail view of item
     */
    @Override
    public void setAdapter(MoviesResponse moviesResponse) {
        recyclerView.setAdapter(new MovieAdapter(moviesResponse));
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(MainActivity.this,"Error Occurred",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDetailViewOfMovieItem(Movie movie) {
        // first parameter is the context, second is the class of the activity to launch
        Intent i = new Intent(MainActivity.this, MovieDetailActivity.class);
        i.putExtra(MovieDetailActivity.KEY_MOVIE,movie);
        startActivity(i);
    }

    @Override
    public void updateScreen(String date) {
        dateFilterBtn.setText(date);
        presenter.fetchMoviesDataByDate(date);
    }
}
