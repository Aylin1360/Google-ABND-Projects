package com.example.aylin.stepistanbul;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aylin on 1.04.2018.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    //Resource ID for background color
    private int mBackgroundResourceId;

    public PlaceAdapter(Activity context, ArrayList<Place> places, int historicalResourceId) {
        super(context, 0, places);
        mBackgroundResourceId = historicalResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        Place currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView placeName = (TextView) listItemView.findViewById(R.id.place_text_view);

        // set text on the name TextView
        placeName.setText(currentPlace.PlaceName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);

        // set text on the number TextView
        locationTextView.setText(currentPlace.getLocation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);

        // set the image to iconView
        if (currentPlace.hasImage()) {
            iconView.setImageResource(currentPlace.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that resource ID maps to
        int color = ContextCompat.getColor(getContext(), mBackgroundResourceId);
        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
