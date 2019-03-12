package com.example.aylin.stepistanbul;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelsFragment extends Fragment {

    public HotelsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.H1), getString(R.string.h1), R.drawable.hilton));
        places.add(new Place(getString(R.string.H2), getString(R.string.h2), R.drawable.marmara));
        places.add(new Place(getString(R.string.H3), getString(R.string.h3), R.drawable.inter));
        places.add(new Place(getString(R.string.H4), getString(R.string.h4), R.drawable.fourseasons));
        places.add(new Place(getString(R.string.H5), getString(R.string.h5), R.drawable.c_ragan));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.brownish);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}