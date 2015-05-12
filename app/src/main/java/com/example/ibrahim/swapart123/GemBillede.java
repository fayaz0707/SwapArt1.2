package com.example.ibrahim.swapart123;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.ibrahim.swapart1.R;
import com.parse.Parse;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * Created by kamranyusaf on 07/05/15.
 */
public class GemBillede extends Activity implements View.OnClickListener {
    ImageView image;
    EditText navn,størrelse,værdi;
    Button gemBtn;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billede_info);

        // Parse.enableLocalDatastore(this);

        //Parse.initialize(this, "SypVmMOGroZ9crfo7fCJsaJgW7qI9f1YBcVmJlLa", "HCsmkcvyULayHEDwud0mO8z2cohrfAv3UwiVWuUT");

        image = (ImageView)findViewById(R.id.imageView7);
        navn = (EditText)findViewById(R.id.editNavn);
        størrelse = (EditText)findViewById(R.id.editStr);
        værdi = (EditText)findViewById(R.id.editVærdi);
        gemBtn = (Button)findViewById(R.id.gemBtn);
        gemBtn.setOnClickListener(this);


    }
    @Override
    public void onClick(View v){
        if(v== gemBtn){
            ParseUser currentUser = ParseUser.getCurrentUser();
            if (currentUser != null) {

            }

            //SharedPreferences shre = PreferenceManager.getDefaultSharedPreferences(this);
            //String previouslyEncodedImage = shre.getString("image_data", "");

            /*if( !previouslyEncodedImage.equalsIgnoreCase("") ){
                byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
                 bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
                //imageConvertResult.setImageBitmap(bitmap);
            }*/

           Bitmap bmp = Bitmap.createBitmap(getImageBitmap(this,"billede","png"));
                  // BitmapFactory.decodeResource(getResources(),
                 //  R.drawable.bg);
                   //getImageBitmap(this,"billede","png");

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] image = stream.toByteArray();

            ParseFile file = new ParseFile(image);


            ParseObject billede= new ParseObject("Billede");
            billede.put("userID", currentUser.getObjectId());
            billede.put("likedByID", "");
            billede.put("name", navn.getText().toString());
            billede.put("size", størrelse.getText().toString());
            billede.put("value", værdi.getText().toString());
            billede.put("image", file);

            billede.saveInBackground();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);//hgf
        }





    }

    public Bitmap getImageBitmap(Context context,String name,String extension){
        name=name+"."+extension;
        try{
            FileInputStream fis = context.openFileInput(name);
            Bitmap b = BitmapFactory.decodeStream(fis);
            fis.close();
            return b;
        }
        catch(Exception e){
        }
        return null;
    }
}
