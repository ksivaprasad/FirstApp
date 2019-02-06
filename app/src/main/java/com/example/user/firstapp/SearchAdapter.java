package com.example.user.firstapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.firstapp.model.Hotels;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private Context context;
    private List<Hotels> hotelsList;
    //private List<Hotels> hotelsListToFilter;


    public SearchAdapter(Context context, List<Hotels> hotelsList) {
        this.context = context;
        this.hotelsList = new ArrayList<>();
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.search_item_layout, null);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder hotelViewHolder, int i) {
        Hotels hotels = hotelsList.get(i);

        hotelViewHolder.title.setText(hotels.getTitle());
        hotelViewHolder.description.setText(hotels.getDescription());

    }

    @Override
    public int getItemCount() {
        return hotelsList.size();
    }



    public void setFilter(List<Hotels> list) {
        hotelsList = new ArrayList<>();
        hotelsList.addAll(list);
        notifyDataSetChanged();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView description;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.id_hotel_name);
            description = itemView.findViewById(R.id.id_food_type);
        }
    }



}
