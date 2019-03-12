package com.example.aylin.movieapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MovieAdapter extends ArrayAdapter<Actor> {

    public MovieAdapter(Activity context, ArrayList<Actor> words) {

        super(context, 0, words);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Actor currentWord = getItem(position);

        TextView songTextView = (TextView) listItemView.findViewById(R.id.Name_text_view);
        songTextView.setText((currentWord.getmPopularity()));

        final TextView singerTextView = (TextView) listItemView.findViewById(R.id.popularity_text_view);
        singerTextView.setText(currentWord.getmActor());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(currentWord.getImageResourceId());


        return listItemView;
    }
}
