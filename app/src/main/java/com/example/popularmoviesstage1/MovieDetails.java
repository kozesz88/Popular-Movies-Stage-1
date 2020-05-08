package com.example.popularmoviesstage1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {
    public static final String EXTRA_POSITION = "extra_position";
    private TextView mOriginal_title;
    private ImageView mImage;
    private TextView mRelease_date;
    private TextView mSynopsis;
    private TextView mUser_rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        setTitle("Movie Details");


        mOriginal_title = (TextView) findViewById(R.id.original_title);
        mRelease_date = (TextView) findViewById(R.id.release_date);
        mSynopsis = (TextView) findViewById(R.id.synopsis);
        mUser_rating = (TextView) findViewById(R.id.user_rate);
        mImage = (ImageView) findViewById(R.id.image);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String title = bundle.getString("movieTitle");
            String releaseDate = bundle.getString("movieReleaseDate");
            String image = bundle.getString("moviePoster");
            String synopsis = bundle.getString("plotSynopsis");
            String userRating = bundle.getString("stringVoteAverage");

            String imagePosterLink = "http://image.tmdb.org/t/p/w500/" + image;

            mOriginal_title.setText(title);
            mSynopsis.setText(synopsis);
            mUser_rating.setText(userRating);
            mRelease_date.setText(releaseDate);
            Picasso.get().load(imagePosterLink).into(mImage);
        }
    }
}
