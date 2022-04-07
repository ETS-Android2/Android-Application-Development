package com.example.android.quakereport;

import android.preference.Preference;

public interface EarthquakePreferenceFragment {
    boolean onPreferenceChange(Preference preference, Object value);
}
