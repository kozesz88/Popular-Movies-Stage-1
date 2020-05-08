package com.example.popularmoviesstage1;

public class Movie {

    private String mOriginal_title;
    private String mImage;
    private String mRelease_date;
    private String mSynopsis;
    private String mUser_rating;

    public Movie(String original_title, String image, String release_date, String synopsis, String user_rating) {
        mOriginal_title = original_title;
        mImage = image;
        mRelease_date = release_date;
        mSynopsis = synopsis;
        mUser_rating = user_rating;
    }

    public String getImage() {
        return mImage;
    }

    public String getOriginal_title() {
        return mOriginal_title;
    }

    public String getRelease_date() {
        return mRelease_date;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public String getUser_rating() {
        return mUser_rating;
    }

}

