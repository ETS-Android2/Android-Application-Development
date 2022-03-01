package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeListItem> {

    public EarthquakeAdapter(@NonNull Context context, @NonNull ArrayList<EarthquakeListItem> earthquakeListItems) {
        super(context, 0, earthquakeListItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View ListItemView=convertView;
        if (ListItemView==null)
        {
            ListItemView=LayoutInflater.from(getContext()).inflate(R.layout.ethquake_list_item,parent,false);
        }
        EarthquakeListItem CurrentEarthquakeListItem =getItem(position);
        TextView magnitudeTextView = (TextView) ListItemView.findViewById(R.id.magnitude);
        TextView locationTextView = (TextView) ListItemView.findViewById(R.id.location);
        TextView dateTextView = (TextView) ListItemView.findViewById(R.id.date);
        magnitudeTextView.setText( CurrentEarthquakeListItem.getMagnitude());
        locationTextView.setText(CurrentEarthquakeListItem.getLocation());
        dateTextView.setText(CurrentEarthquakeListItem.getDate());
        return ListItemView;

    }

}
