package com.example.user.firstapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.firstapp.model.Hotels;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {


    RecyclerView recyclerView;
    SearchAdapter searchAdapter;

    List<Hotels> hotelsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        hotelsList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.id_recycler_view_search);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        hotelsList.add(new Hotels(
                "Hotel ",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "fgfghfg Name 2",
                "Description",
                "10 - 15 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "gfhfg Name 3",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "gfhfrrr Name 4",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        searchAdapter = new SearchAdapter(getContext(), hotelsList);
        recyclerView.setAdapter(searchAdapter);

        /*SearchView searchView = (SearchView) view.findViewById(R.id.id_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                s = s.toLowerCase();
                List<Hotels> filteredList = new ArrayList<>();
                for ( Hotels hotels: hotelsList ) {
                    if ( (hotels.getTitle().toLowerCase()).contains(s) ) {
                        filteredList.add(hotels);
                    }
                }
                searchAdapter.setFilter(filteredList);
                return true;
            }
        });*/
        final TextView textViewRecent = view.findViewById(R.id.id_recent);
        EditText editText = view.findViewById(R.id.id_editText_search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchText = s.toString();
                List<Hotels> filteredList = new ArrayList<>();
                if (searchText != null && !searchText.equals("")){
                    textViewRecent.setVisibility(View.INVISIBLE);
                    for ( Hotels hotels: hotelsList ) {
                        if ( (hotels.getTitle().toLowerCase()).contains(searchText) ) {
                            filteredList.add(hotels);
                        }
                    }
                }
                else {
                    textViewRecent.setVisibility(View.VISIBLE);
                }
                searchAdapter.setFilter(filteredList);
            }
        });

        return view;
    }



    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
        //this.menu = menu;
        menu.getItem(0).setVisible(false);
        MenuItem menuItem = menu.findItem(R.id.id_search_menu);
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                List<Hotels> filteredList = new ArrayList<>();
                for ( Hotels hotels: hotelsList ) {
                    if ( (hotels.getTitle().toLowerCase()).contains(newText) ) {
                        filteredList.add(hotels);
                    }
                }
                searchAdapter.setFilter(filteredList);
                return true;
            }
        });

    }*/

}
