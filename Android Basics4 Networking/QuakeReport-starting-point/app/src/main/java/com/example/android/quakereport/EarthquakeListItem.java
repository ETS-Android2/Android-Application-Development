package com.example.android.quakereport;

public class EarthquakeListItem {
    private  String mMagnitude;
    private String mLocation;
    private String mDate;

    public EarthquakeListItem(String magnitude, String location, String date) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mDate = date;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getDate() {
        return mDate;
    }

    public String getLocation() {
        return mLocation;
    }
}
