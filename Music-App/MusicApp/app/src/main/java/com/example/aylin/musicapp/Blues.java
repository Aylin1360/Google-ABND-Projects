package com.example.aylin.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Blues extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Crazy Blues","Mamie Smith",R.drawable.blues));
        songs.add(new Song("Ash Tray Blues","Papa Charlie Jackson",R.drawable.blues));
        songs.add(new Song("Devil Got My Woman","Skip James",R.drawable.blues));
        songs.add(new Song("All Around Man","Bo Carter",R.drawable.blues));
        songs.add(new Song("You Was Born To Die","Curley Weaver",R.drawable.blues));
        songs.add(new Song("Cross Road Blues","Robert Johnson",R.drawable.blues));
        songs.add(new Song("Match Box Blues","Blind Lemon",R.drawable.blues));
        songs.add(new Song("Guitar Rag","Sylvester Weaver",R.drawable.blues));
        songs.add(new Song("Runaway Blues","Ma Rainey",R.drawable.blues));
        songs.add(new Song("Baby Please Don't Go","Big Joe Williams",R.drawable.blues));

        SongAdapter itemsAdapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
