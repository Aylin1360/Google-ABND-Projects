package com.example.aylin.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Actors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);


        final ArrayList<Actor> actors = new ArrayList<>();

        actors.add(new Actor("Jack Nicholson", 1.9, R.drawable.jacknicholson));
        actors.add(new Actor("Marlon Brando", 2.3, R.drawable.marlonbrando));
        actors.add(new Actor("Robert De Niro", 3.8, R.drawable.robertdeniro));
        actors.add(new Actor("Al Pacino", 4.3, R.drawable.alpacino));
        actors.add(new Actor("Danel Day-Lewis", 5.9, R.drawable.danielday));
        actors.add(new Actor("Dustin Hoffman", 6.1, R.drawable.dustinhoffman));
        actors.add(new Actor("Tom Hanks", 7, R.drawable.tomhanks));
        actors.add(new Actor("Anthony Hopkins", 8.8, R.drawable.anthonyhopkins));
        actors.add(new Actor("Paul Newman", 9.3, R.drawable.paulnewman));
        actors.add(new Actor("Ralph Fiennes", 6.4, R.drawable.ralphfiennes));
        actors.add(new Actor("Brad Pitt", 8.7, R.drawable.bradpitt));
        actors.add(new Actor("Bruce Willis", 9.3, R.drawable.bruce));
        actors.add(new Actor("Johnny Depp", 7.5, R.drawable.johnny));
        actors.add(new Actor("Morgan Freeman", 8.1, R.drawable.morgan));
        actors.add(new Actor("Paul Test1", 9.3, R.drawable.paulnewman));
        actors.add(new Actor("Paul Test2", 9.3, R.drawable.paulnewman));

        Collections.sort(actors, new Comparator<Actor>() {
            public int compare(Actor self, Actor other) {
                return self.getmPopularity().compareTo(other.getmPopularity());
            }
        });

        Collections.reverse(actors);

        final MovieAdapter itemsAdapter = new MovieAdapter(this, actors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        final Button searchButton = (Button) findViewById(R.id.search);
        final EditText theFilter = (EditText) findViewById(R.id.editt);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = 0;
                for (Actor string : actors) {
                    if(string.toString().toLowerCase().contains(theFilter.getText().toString().toLowerCase())){
                        count++;
                    }
                }
                theFilter.setText(count + " " + "results found");
            }
        });

    }
}
