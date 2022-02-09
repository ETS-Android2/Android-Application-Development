package com.example.android.quakereport;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class EthquakeAdapter extends ArrayAdapter {
    ArrayList<EthquakeListItem> items;
    public EthquakeAdapter(Context context, int layout, ArrayList<EthquakeListItem> items)
    {
        super(context,layout);
        items=items;
    }
}
