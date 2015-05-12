package com.example.ibrahim.swapart123;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.ibrahim.swapart1.R;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by kamranyusaf on 07/05/15.
 */
public class GemBillede extends Activity implements View.OnClickListener {
    ImageView image;
    EditText navn,størrelse,værdi;
    Button gem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billede_info);

         Parse.enableLocalDatastore(this);

        Parse.initialize(this, "SypVmMOGroZ9crfo7fCJsaJgW7qI9f1YBcVmJlLa", "HCsmkcvyULayHEDwud0mO8z2cohrfAv3UwiVWuUT");

        image = (ImageView)findViewById(R.id.imageView7);
        navn = (EditText)findViewById(R.id.editNavn);
        størrelse = (EditText)findViewById(R.id.editStr);
        værdi = (EditText)findViewById(R.id.editVærdi);
        gem = (Button)findViewById(R.id.gemBtn);
        gem.setOnClickListener(this);


    }
    @Override
    public void onClick(View v){

        ParseObject billede= new ParseObject("Billede");
        billede.put("userID", "1234");
        billede.put("likedByID", "1444");
        billede.put("name", "fayaz");
        billede.put("size", "32323");
        billede.put("value", "12312");

        billede.saveInBackground();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);//hgf



    }
}
