package com.example.user.firstapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import com.example.user.firstapp.model.Hotels;

import java.util.ArrayList;
import java.util.List;

public class LandingActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Menu menu;

    /*RecyclerView recyclerView;
    SearchAdapter searchAdapter;

    List<Hotels> hotelsList;*/

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            ActionBar actionBar = getSupportActionBar();
            Fragment selected = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //actionBar.show();
                    menu.getItem(0).setVisible(false);
                    selected = new Fragment1();
                    break;
                case R.id.navigation_search:
                    menu.getItem(0).setVisible(true);
                    //actionBar.hide();
                    selected = new Fragment2();
                    break;
                case R.id.navigation_dashboard:
                    menu.getItem(0).setVisible(false);
                   // actionBar.show();
                    selected = new Fragment2();
                    break;
                case R.id.navigation_notifications:
                    menu.getItem(0).setVisible(false);
                    //actionBar.show();
                    selected = new Fragment3();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selected).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment1()).commit();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        /*hotelsList = new ArrayList<>();
        recyclerView = this.findViewById(R.id.id_recycler_view_search);

        hotelsList.add(new Hotels(
                "Hotel Name 1  grt gre re ter re tre tret er tre tertertrtre ter Hotel Name 1  grt gre re ter re tre tret er tre tertertrtre ter Hotel Name 1  grt gre re ter re tre tret er tre tertertrtre ter",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Hotel Name 2",
                "Description",
                "10 - 15 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Hotel Name 3",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Hotel Name 4",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchAdapter = new SearchAdapter(this, hotelsList);
        recyclerView.setAdapter(searchAdapter);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        this.menu = menu;
        menu.getItem(0).setVisible(false);
        /*MenuItem menuItem = this.menu.findItem(R.id.id_search_menu);
        SearchView searchView = (SearchView) menuItem.getActionView();
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
        });*/

        return true;
    }


}
