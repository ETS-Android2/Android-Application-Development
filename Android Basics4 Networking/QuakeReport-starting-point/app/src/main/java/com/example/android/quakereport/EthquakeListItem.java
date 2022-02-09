package com.example.android.quakereport;

public class EthquakeListItem {
    private  int mMagnitude;
    private String mLocation;
    private String mDate;

    public EthquakeListItem(int magnitude, String location, String date) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mDate = date;
    }

    public int getmMagnitude() {
        return mMagnitude;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmLocation() {
        return mLocation;
    }
}
