/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {
    /** URL for earthquake data from the USGS dataset */

    private static final String SAMPLE_JSON_RESPONSE = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";


   // public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a list of earthquake magnitude,locations,Date.
       /* ArrayList<EarthquakeListItem> earthquakes =QueryUtils.extractEarthquakes();*/
        EarthquakeAsyncTask task= new EarthquakeAsyncTask();
        task.execute(SAMPLE_JSON_RESPONSE);


    }
    private class EarthquakeAsyncTask extends AsyncTask<String,Void, ArrayList<EarthquakeListItem>>
    {

        @Override
        protected ArrayList<EarthquakeListItem> doInBackground(String... urls) {
            ArrayList<EarthquakeListItem> result =QueryUtils.fetchEarthquakeData(urls[0]);

            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<EarthquakeListItem> result) {
            if (result == null)
            {
                return;
            }
            updateUi(result);

        }
    }

    private void updateUi (ArrayList<EarthquakeListItem> earthqakes)
    {
        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        final EarthquakeAdapter adapter=new EarthquakeAdapter(this,earthqakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        // Create a new adapter that takes the list of earthquakes as input
       /* final EarthquakeAdapter adapter2 = new EarthquakeAdapter(this, earthqakes);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter2);*/
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                EarthquakeListItem currentEarthquake = adapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
                /*EarthquakeAsyncTask task =new EarthquakeAsyncTask();
                task.execute(QueryUtils.SAMPLE_JSON_RESPONSE);*/
            }
        });
    }
}
