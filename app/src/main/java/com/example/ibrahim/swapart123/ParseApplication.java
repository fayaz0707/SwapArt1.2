package com.example.ibrahim.swapart123;

/**
 * Created by ibrahim on 19/03/15.
 */
import com.parse.Parse;
import com.parse.ParseACL;

import com.parse.ParseUser;

import android.app.Application;
import android.content.Intent;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
       // super.onCreate(); jasjajsfa

        // Enable Local Datastore./kjhkjhkjh     https://github.com/fayaz0707/SwapArt.git
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "SypVmMOGroZ9crfo7fCJsaJgW7qI9f1YBcVmJlLa", "HCsmkcvyULayHEDwud0mO8z2cohrfAv3UwiVWuUT");
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }

}
