package com.example.aylin.movieapp;

import java.util.Comparator;

/**
 * Created by Aylin on 2.04.2018.
 */

public class Actor implements Comparator<Actor> {
    private String mActor;
    private double mPopularity;
    private int mImageResourceId;


    public Actor(String mActor, double mPopularity, int imageResourceId){
        this.mActor = mActor;
        this.mPopularity = mPopularity;
        mImageResourceId = imageResourceId;
    }

    public String getmPopularity() {
        String pop = Double.toString(mPopularity);
        return pop; }


    public String getmActor() { return mActor; }

    public int getImageResourceId() { return mImageResourceId; }

    @Override
    public int compare(Actor o1, Actor o2) {
        return o1.getmPopularity().compareTo(o2.getmPopularity());
    }

    @Override
    public String toString() {
        return mActor;
    }
}



