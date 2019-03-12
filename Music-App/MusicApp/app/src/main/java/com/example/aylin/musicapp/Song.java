package com.example.aylin.musicapp;

/**
 * Created by Aylin on 2.04.2018.
 */

public class Song {
    private String mArtist;
    private String mSong;
    private int mImageResourceId;


    public Song(String mArtist, String mSong, int imageResourceId){
        this.mArtist = mArtist;
        this.mSong = mSong;
        mImageResourceId = imageResourceId;
    }


    public String getmSong() {

        return mSong;
    }

    public String getmArtist() {

        return mArtist;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}

