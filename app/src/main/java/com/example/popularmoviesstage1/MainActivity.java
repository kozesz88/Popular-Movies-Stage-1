package com.example.popularmoviesstage1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements android.app.LoaderManager.LoaderCallbacks<List<Movie>> {

    public static final String MOVIES_POPULAR = "https://api.themoviedb.org/3/movie/popular?api_key=";
    public static final String MOVIES_TOP_RATED = "https://api.themoviedb.org/3/movie/top_rated?api_key=";
    private static final String LOG_TAG = MainActivity.class.getName();
    public static String MOVIES_URL_LINK_FINAL = MOVIES_POPULAR;
    /**
     * Adapter for the list of news
     */
    private MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Picasso.get().setLoggingEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView movieGridView = (GridView) findViewById(R.id.movies_gridview);
        mAdapter = new MovieAdapter(this, new ArrayList<Movie>());
        movieGridView.setAdapter(mAdapter);
        movieGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Movie currentMovie = mAdapter.getItem(position);
                String title = currentMovie.getOriginal_title();
                String releaseDate = currentMovie.getRelease_date();
                String image = currentMovie.getImage();
                String synopsis = currentMovie.getSynopsis();
                String userRating = currentMovie.getUser_rating();
                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                Bundle bundle = new Bundle();
                bundle.putString("movieTitle", title);
                bundle.putString("movieReleaseDate", releaseDate);
                bundle.putString("moviePoster", image);
                bundle.putString("plotSynopsis", synopsis);
                bundle.putString("stringVoteAverage", userRating);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        getLoaderManager().initLoader(0, null, this);
    }


    @Override
    public android.content.Loader<List<Movie>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new MovieLoader(this, MOVIES_URL_LINK_FINAL);
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<Movie>> loader, List<Movie> data) {
        mAdapter = new MovieAdapter(this, data);
        GridView movieGridView = (GridView) findViewById(R.id.movies_gridview);
        movieGridView.setAdapter(mAdapter);
    }

    @Override
    public void onLoaderReset(android.content.Loader<List<Movie>> loader) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.top_rated:
                MOVIES_URL_LINK_FINAL = MOVIES_TOP_RATED;
                getLoaderManager().restartLoader(0, null, this);
                return true;
            case R.id.most_popular:
                MOVIES_URL_LINK_FINAL = MOVIES_POPULAR;
                getLoaderManager().restartLoader(0, null, this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


