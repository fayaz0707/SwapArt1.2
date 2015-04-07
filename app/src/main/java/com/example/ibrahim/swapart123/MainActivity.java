package com.example.ibrahim.swapart123;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ibrahim.swapart1.R;
import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends Activity implements View.OnClickListener{

    ImageView imageView1, imageView2,imageView3;
    Button swapBtn,oploadBtn,editBtn,matchBtn,instillingerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//jhgjhg

        // Enable Local Datastore./kjhkjhkjh     https://github.com/fayaz0707/SwapArt.git
       // Parse.enableLocalDatastore(this);

        //Parse.initialize(this, "SypVmMOGroZ9crfo7fCJsaJgW7qI9f1YBcVmJlLa", "HCsmkcvyULayHEDwud0mO8z2cohrfAv3UwiVWuUT");

        //ParseObject testObject = new ParseObject("TestObject");
        //testObject.put("foo", "bar");
        //testObject.saveInBackground();
        imageView1 = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        //imageView3 = (ImageView)findViewById(R.id.imageView3);
        imageView1.setImageResource(R.drawable.girl);
        imageView2.setImageResource(R.drawable.castle);
        //imageView3.setImageResource(R.drawable.logo);
        swapBtn = (Button)findViewById(R.id.swapBtn);
        swapBtn.setOnClickListener(this);
        oploadBtn = (Button)findViewById(R.id.oploadBtn);
        oploadBtn.setOnClickListener(this);
        editBtn = (Button)findViewById(R.id.editBtn);
        editBtn.setOnClickListener(this);
        matchBtn = (Button)findViewById(R.id.matchBtn);
        matchBtn.setOnClickListener(this);
        instillingerBtn = (Button)findViewById(R.id.instillingerBtn);
        instillingerBtn.setOnClickListener(this);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);//
    }

    @Override
    public void onClick(View v)
    {
        if(v == swapBtn)
        {
            Intent intent = new Intent(this, SwapArt.class);
            startActivity(intent);
        }
    }
}
