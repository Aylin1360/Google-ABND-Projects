package com.example.aylin.stepistanbul;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoricalFragment extends Fragment {

    public HistoricalFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.HP1), getString(R.string.hp1), R.drawable.sultanahmet));
        places.add(new Place(getString(R.string.HP2), getString(R.string.hp2), R.drawable.ayasofya));
        places.add(new Place(getString(R.string.HP3), getString(R.string.hp3), R.drawable.topkap_));
        places.add(new Place(getString(R.string.HP4), getString(R.string.hp4), R.drawable.yerebatan_sarn_c_));
        places.add(new Place(getString(R.string.HP5), getString(R.string.hp5), R.drawable._stiklal_caddesi__stanbul));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.brownish);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }

}