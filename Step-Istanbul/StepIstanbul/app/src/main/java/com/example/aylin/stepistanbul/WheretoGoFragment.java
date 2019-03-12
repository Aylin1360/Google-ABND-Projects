package com.example.aylin.stepistanbul;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class WheretoGoFragment extends Fragment {

    public WheretoGoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.W1), getString(R.string.w1), R.drawable.taksim));
        places.add(new Place(getString(R.string.W2), getString(R.string.w2), R.drawable.sapphire));
        places.add(new Place(getString(R.string.W3), getString(R.string.w3), R.drawable.galata));
        places.add(new Place(getString(R.string.W4), getString(R.string.w4), R.drawable.bosphorus));
        places.add(new Place(getString(R.string.W5), getString(R.string.w5), R.drawable.k_z_kulesi_gece));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.brownish);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);


        return rootView;
    }

}