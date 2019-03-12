package com.example.aylin.musicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> words) {

        super(context, 0, words);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentWord = getItem(position);

        TextView songTextView = (TextView) listItemView.findViewById(R.id.Song_text_view);
        songTextView.setText(currentWord.getmSong());

        TextView singerTextView = (TextView) listItemView.findViewById(R.id.Singer_text_view);
        singerTextView.setText(currentWord.getmArtist());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(currentWord.getImageResourceId());

        return listItemView;
    }
}
