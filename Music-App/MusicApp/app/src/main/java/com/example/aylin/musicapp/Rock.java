package com.example.aylin.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Rock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Sober Up","AJR",R.drawable.rock));
        songs.add(new Song("Run For Cover","The Killers",R.drawable.rock));
        songs.add(new Song("Hometown","Cleopatrick",R.drawable.rock));
        songs.add(new Song("Hole In Your Heart","Royal Blood",R.drawable.rock));
        songs.add(new Song("White Flag","Bishop Briggs",R.drawable.rock));
        songs.add(new Song("The Day I Die","Island",R.drawable.rock));
        songs.add(new Song("Dangerous Night","Thirty Seconds To Mars",R.drawable.rock));
        songs.add(new Song("Turn","The Wombats",R.drawable.rock));
        songs.add(new Song("Sit Next To Me","Foster The People",R.drawable.rock));
        songs.add(new Song("Broken","lovelytheband",R.drawable.rock));

        SongAdapter itemsAdapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}
