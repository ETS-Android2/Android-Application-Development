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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<String> word=new ArrayList<String>();

        word.add("One");
        word.add("Two");
        word.add("Three");
        word.add("Four");
        word.add("Five");
        word.add("Six");
        word.add("Seven");
        word.add("Eight");
        word.add("Nine");
        word.add("Ten");
        /*Log.v("NumbersActivity","Words at index 0: "+word.get(0));
        Log.v("NumbersActivity","Words at index 1: "+word.get(1));
        Log.v("NumbersActivity","Words at index 2: "+word.get(2));
        Log.v("NumbersActivity","Words at index 3: "+word.get(3));
        Log.v("NumbersActivity","Words at index 4: "+word.get(4));
        Log.v("NumbersActivity","Words at index 5: "+word.get(5));
        Log.v("NumbersActivity","Words at index 6: "+word.get(6));
        Log.v("NumbersActivity","Words at index 7: "+word.get(7));
        Log.v("NumbersActivity","Words at index 8: "+word.get(8));
        Log.v("NumbersActivity","Words at index 9: "+word.get(9));

         */
        LinearLayout root =(LinearLayout)findViewById(R.id.rootView);


        int index=0;
        while ( index< word.size())
        {
        TextView wordView=new TextView(this);
        wordView.setText(word.get(index));
        root.addView(wordView);
        index +=1;
        };

    }
}
