package com.careem.careemtest.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.careem.retrofitexample.R;
import com.careem.retrofitexample.databinding.MovieItemBinding;
import com.careem.careemtest.model.MoviesResponse;


/**
 * Created by hp on 12/18/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.DataBindingViewHolder> {

    private MoviesResponse moviesList;
    public  class DataBindingViewHolder extends RecyclerView.ViewHolder
    {
        MovieItemBinding binding;

        public DataBindingViewHolder(MovieItemBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public  MovieAdapter(MoviesResponse moviesList)
    {
        this.moviesList = moviesList;
    }

    @Override
    public DataBindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MovieItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.movie_item,parent,false);
        return new DataBindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(DataBindingViewHolder holder, int position) {
        holder.binding.setMovie(moviesList.getResults().get(position));
    }

    @Override
    public int getItemCount() {
        return moviesList.getResults().size();
    }
}
