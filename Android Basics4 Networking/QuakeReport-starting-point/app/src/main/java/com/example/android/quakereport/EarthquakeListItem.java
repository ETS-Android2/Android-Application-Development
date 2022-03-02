package com.example.android.quakereport;

public class EarthquakeListItem {
    private  String mMagnitude;
    private String mLocation;
    /** Time of the earthquake */
    private long mTimeInMilliseconds;
    /**
     * Constructs a new {@link EarthquakeListItem} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *  earthquake happened
     */

    public EarthquakeListItem(String magnitude, String location, long timeInMilliseconds) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getMagnitude() {
        return mMagnitude;
    }
    /**
     * Returns the time of the earthquake.
     */
    public long getTimeInMilliseconds() { return mTimeInMilliseconds; }

    public String getLocation() {
        return mLocation;
    }
}
