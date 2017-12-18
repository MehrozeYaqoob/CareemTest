package com.careem.careemtest.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.careem.careemtest.model.Movie;
import com.careem.retrofitexample.R;
import com.careem.retrofitexample.databinding.MovieDetailViewBinding;


/**
 * Created by Mehroze on 12/13/2017.
 */

public class MovieDetailActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MovieDetailViewBinding binding = DataBindingUtil.setContentView(this,R.layout.movie_detail_view);
        binding.setMovie((Movie) getIntent().getSerializableExtra("movie"));


    }
}
