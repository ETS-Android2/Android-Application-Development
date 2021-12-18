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
package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class NumbersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        String[] word = new String[10];
       word[0]="One";
        word[0]="Two";
        word[0]="Three";
        word[0]="Four";
        word[0]="Five";
        word[0]="Six";
        word[0]="Seven";
        word[0]="Eight";
        word[0]="Nine";
        word[0]="Ten";
        Log.v("NumbersActivity","Words at index 0: "+word[0]);
        Log.v("NumbersActivity","Words at index 1: "+word[1]);
        Log.v("NumbersActivity","Words at index 2: "+word[2]);
        Log.v("NumbersActivity","Words at index 3: "+word[3]);
        Log.v("NumbersActivity","Words at index 4: "+word[4]);
        Log.v("NumbersActivity","Words at index 5: "+word[5]);
        Log.v("NumbersActivity","Words at index 6: "+word[6]);
        Log.v("NumbersActivity","Words at index 7: "+word[7]);
        Log.v("NumbersActivity","Words at index 8: "+word[8]);
        Log.v("NumbersActivity","Words at index 9: "+word[9]);


    }
}
