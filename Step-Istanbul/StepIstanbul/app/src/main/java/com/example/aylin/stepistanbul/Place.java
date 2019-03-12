package com.example.aylin.stepistanbul;

/**
 * Created by Aylin on 1.04.2018.
 */

public class Place {
    private String mLocation;
    private String mPlaceName;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public String PlaceName() {
        return mPlaceName;
    }

    public String getLocation() {
        return mLocation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public Place(String Location, String PlaceName, int ImageResourceId) {
        mLocation = Location;
        mPlaceName = PlaceName;
        mImageResourceId = ImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
