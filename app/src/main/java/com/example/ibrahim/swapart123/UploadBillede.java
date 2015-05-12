package com.example.ibrahim.swapart123;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.ibrahim.swapart1.R;
import com.parse.Parse;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by kamranyusaf on 23/03/15.
 */
public class UploadBillede extends Activity implements View.OnClickListener {

    Button galleriButton, kameraButton, uploadButton;
    ImageView imageView3;
    private int VÆLG_BILLEDE=1111;
    private int TAG_BILLEDE = 2222;
    static Bitmap bmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Parse.enableLocalDatastore(this);

       // Parse.initialize(this, "SypVmMOGroZ9crfo7fCJsaJgW7qI9f1YBcVmJlLa", "HCsmkcvyULayHEDwud0mO8z2cohrfAv3UwiVWuUT");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_billede);

        imageView3=(ImageView) findViewById(R.id.imageView3);
        //imageView3.setImageResource(R.drawable.logo);
        galleriButton=(Button)findViewById(R.id.galleri_Button);
        galleriButton.setOnClickListener(this);
        kameraButton=(Button)findViewById(R.id.kamera_Button);
        kameraButton.setOnClickListener(this);
        uploadButton=(Button)findViewById(R.id.upload_Button);
        uploadButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        try {
            if (v==galleriButton){
                Intent i= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(i, VÆLG_BILLEDE);
            }
            else if (v == kameraButton){
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, TAG_BILLEDE);
            }

            else if (v == uploadButton){
                Intent intent = new Intent(this, GemBillede.class);
                startActivity(intent);

            }
        }
        catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Du mangler Googles udvidelser på denne telefon:\n" + e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent resIntent) {
        ContentResolver cr= getContentResolver();
        if (resultCode== RESULT_OK){
            try{
                if (requestCode== VÆLG_BILLEDE){
                    AssetFileDescriptor filDS = getContentResolver().openAssetFileDescriptor(resIntent.getData(), "r");
                    Bitmap bmp = BitmapFactory.decodeStream(filDS.createInputStream());
                    int nh = (int) ( bmp.getHeight() * (1800.0 / bmp.getWidth()) );
                    Bitmap scaled = Bitmap.createScaledBitmap(bmp, 1024, nh, true);
                    imageView3.setImageBitmap(scaled);




                    saveImage(this,bmp,"billede","png");


                    /*ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] b = baos.toByteArray();

                    String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
                    //textEncode.setText(encodedImage);
                    Log.d("Image Log:", encodedImage);

                    SharedPreferences shre = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor edit=shre.edit();
                    edit.putString("image_data",encodedImage);
                    edit.commit();*/





                }else if (resultCode==TAG_BILLEDE){
                    bmp = (Bitmap) resIntent.getExtras().get("data");
                    //ImageView imageView3= new ImageView(this);
                    imageView3.setImageBitmap(bmp);
                }
            }catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }

        }

    public void saveImage(Context context, Bitmap b,String name,String extension){
        name=name+"."+extension;
        FileOutputStream out;
        try {
            out = context.openFileOutput(name, Context.MODE_PRIVATE);
            b.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }


