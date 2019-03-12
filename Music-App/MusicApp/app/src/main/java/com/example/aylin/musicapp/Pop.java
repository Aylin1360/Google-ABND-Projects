package com.example.aylin.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Pop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Flames","David Guetta",R.drawable.pop));
        songs.add(new Song("In My Blood","Shawn Mendes",R.drawable.pop));
        songs.add(new Song("Friends","Marshmello",R.drawable.pop));
        songs.add(new Song("Over My Head","Echosmith",R.drawable.pop));
        songs.add(new Song("Hım & I","G-Eazy",R.drawable.pop));
        songs.add(new Song("God's Plan","Drake",R.drawable.pop));
        songs.add(new Song("Give 'n' Take","Call Me Loop",R.drawable.pop));
        songs.add(new Song("Mine","Bazzi",R.drawable.pop));
        songs.add(new Song("Sanctify","Years & Years",R.drawable.pop));
        songs.add(new Song("Alright","Cyn",R.drawable.pop));

        SongAdapter itemsAdapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
