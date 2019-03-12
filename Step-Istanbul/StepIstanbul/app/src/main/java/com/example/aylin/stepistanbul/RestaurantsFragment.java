package com.example.aylin.stepistanbul;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.R1), getString(R.string.r1), R.drawable.sortie_club));
        places.add(new Place(getString(R.string.R2), getString(R.string.r2), R.drawable.fahham));
        places.add(new Place(getString(R.string.R3), getString(R.string.r3), R.drawable.rocknrolla));
        places.add(new Place(getString(R.string.R4), getString(R.string.r4), R.drawable.walters));
        places.add(new Place(getString(R.string.R5), getString(R.string.r5), R.drawable.mendels));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.brownish);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);


        return rootView;
    }

}