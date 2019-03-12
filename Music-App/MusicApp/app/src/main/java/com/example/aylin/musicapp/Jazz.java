package com.example.aylin.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Jazz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Straight, No Chaser","Thelonious Monk",R.drawable.jazz));
        songs.add(new Song("Tenor Madness","Sony Rollings",R.drawable.jazz));
        songs.add(new Song("Blue Monk","Ray Bryant Trio",R.drawable.jazz));
        songs.add(new Song("Billie's Bounce","Wes Montgomery",R.drawable.jazz));
        songs.add(new Song("All Of Me","Big Bang Jazz",R.drawable.jazz));
        songs.add(new Song("The Girl From Ipanema","Amy Winehouse",R.drawable.jazz));
        songs.add(new Song("Wave","Antonio Carlos Jobim",R.drawable.jazz));
        songs.add(new Song("Caravan","Chet Atkins",R.drawable.jazz));
        songs.add(new Song("Fly Me To The Moon","Frank Sinatra",R.drawable.jazz));
        songs.add(new Song("All Blues","Miles Davis",R.drawable.jazz));

        SongAdapter itemsAdapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
