package com.example.ibrahim.swapart123;

/**
 * Created by ibrahim on 19/03/15.
 */
import com.parse.Parse;
import com.parse.ParseACL;

import com.parse.ParseUser;

import android.app.Application;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        
        // Enable Local Datastore./kjhkjhkjh     https://github.com/fayaz0707/SwapArt.git
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "SypVmMOGroZ9crfo7fCJsaJgW7qI9f1YBcVmJlLa", "HCsmkcvyULayHEDwud0mO8z2cohrfAv3UwiVWuUT");
    }

}