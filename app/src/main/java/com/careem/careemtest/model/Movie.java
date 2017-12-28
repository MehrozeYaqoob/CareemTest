package com.careem.careemtest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mehroze on 12/13/2017.
 */

@SuppressWarnings({ "DefaultFileTemplate"})
public class Movie implements Serializable{
    @SerializedName("poster_path")
    private  String posterPath;
    @SerializedName("adult")
    private  boolean adult;
    @SerializedName("overview")
    private  String overview;
    @SerializedName("release_date")
    private  String releaseDate;
    @SerializedName("genre_ids")
    private List<Integer> genreIds = new ArrayList<>();
    @SerializedName("id")
    private Integer id;
    @SerializedName("original_title")
    private  String originalTitle;
    @SerializedName("original_language")
    private  String originalLanguage;
    @SerializedName("title")
    private  String title;
    @SerializedName("backdrop_path")
    private  String backdropPath;
    @SerializedName("popularity")
    private  Double popularity;
    @SerializedName("vote_count")
    private  Integer voteCount;
    @SerializedName("video")
    private  Boolean video;
    @SerializedName("vote_average")
    private  Double voteAverage;

    public Movie(String posterPath, boolean adult, String overview, String releaseDate, List<Integer> genreIds, Integer id,
                 String originalTitle, String originalLanguage, String title, String backdropPath, Double popularity,
                 Integer voteCount, Boolean video, Double voteAverage) {
        this.posterPath = posterPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.genreIds = genreIds;
        this.id = id;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.title = title;
        this.backdropPath = backdropPath;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.video = video;
        this.voteAverage = voteAverage;
    }



    public String getOverview() {
        return overview;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVoteCount() {
        return voteCount.toString();
    }

}
