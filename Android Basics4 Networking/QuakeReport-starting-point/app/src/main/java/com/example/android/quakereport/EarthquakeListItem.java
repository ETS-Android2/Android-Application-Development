package com.example.android.quakereport;

public class EarthquakeListItem {
    private  double mMagnitude;
    private String mLocation;
    /** Time of the earthquake */
    private long mTimeInMilliseconds;
    private String mUrl;
    /**
     * Constructs a new {@link EarthquakeListItem} object.
     *  @param magnitude is the magnitude (size) of the earthquake
     * @param location is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     * @param url
     */

    public EarthquakeListItem(double magnitude, String location, long timeInMilliseconds, String url) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
        this.mUrl=url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }
    /**
     * Returns the time of the earthquake.
     */
    public long getTimeInMilliseconds() { return mTimeInMilliseconds; }

    public String getLocation() {
        return mLocation;
    }

    public  String getUrl(){return mUrl;}
}
