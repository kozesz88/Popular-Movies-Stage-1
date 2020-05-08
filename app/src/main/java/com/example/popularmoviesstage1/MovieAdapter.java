package com.example.popularmoviesstage1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<Movie> {
    private final String LOG_TAG = MovieAdapter.class.getName();
    private Context mContext;

    public MovieAdapter(Context context, List<Movie> movie) {
        super(context, 0, movie);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.details, parent, false);
        }
        Movie currentMovie = getItem(position);
        ImageView imageView = (ImageView) gridItemView.findViewById(R.id.imageView);
        String movieImageLink = currentMovie.getImage();
        String imagePosterLink = "http://image.tmdb.org/t/p/w500/";
        imagePosterLink = imagePosterLink + movieImageLink;
        Log.e(LOG_TAG, "Context" + mContext);
        // textView.setText(imagePosterLink);
        Picasso.get().load(imagePosterLink).into(imageView);
        return gridItemView;
    }
}
