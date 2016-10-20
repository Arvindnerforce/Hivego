package com.chat.laptop.hivego.dashboard.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chat.laptop.hivego.R;
import com.chat.laptop.hivego.salon.NearestSalonFragment;
import com.seatgeek.placesautocomplete.OnPlaceSelectedListener;
import com.seatgeek.placesautocomplete.PlacesAutocompleteTextView;
import com.seatgeek.placesautocomplete.model.Place;


public class SearchCityFragment extends Fragment
{


    PlacesAutocompleteTextView placesAutocomplete;
    Button search_button;
    TextView toolbar_title_txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_city, container, false);

        search_button = (Button) view.findViewById(R.id.search_button);

        placesAutocomplete = (PlacesAutocompleteTextView) view.findViewById(R.id.places_autocomplete);

        setuptoolbar(view);

        placesAutocomplete.setOnPlaceSelectedListener(
                new OnPlaceSelectedListener()
                {
                    @Override
                    public void onPlaceSelected(final Place place)
                    {
                        // do something awesome with the selected place
                    }
                }
        );

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                NearestSalonFragment nearestSalonActivity = new NearestSalonFragment();
                android.support.v4.app.FragmentTransaction search_fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                search_fragmentTransaction.replace(R.id.frame, nearestSalonActivity);
                search_fragmentTransaction.addToBackStack(null);
                search_fragmentTransaction.commit();
            }
        });

        return view;
    }


    private void setuptoolbar(View view)
    {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        toolbar_title_txt = (TextView) getActivity().findViewById(R.id.title_txt);

        toolbar_title_txt.setText("SEARCH IN YOUR CITY");

    }

}
