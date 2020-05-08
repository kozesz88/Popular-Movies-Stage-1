package com.example.popularmoviesstage1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class MovieLoader extends AsyncTaskLoader<List<Movie>> {
    String mUrl;

    public MovieLoader(Context context, String url) {
        super(context);
        mUrl = url;
        forceLoad();
    }

    @Override
    public List<Movie> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<Movie> movies = JSONUtils.fetchMovieData(mUrl);
        return movies;
    }
}
