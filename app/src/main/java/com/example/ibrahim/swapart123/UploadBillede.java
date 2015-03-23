package com.example.ibrahim.swapart123;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.ibrahim.swapart1.R;

import java.io.IOException;

/**
 * Created by kamranyusaf on 23/03/15.
 */
public class UploadBillede extends Activity implements View.OnClickListener {

    Button galleriButton, kameraButton, uploadButton;
    private int VÆLG_BILLEDE=1111;
    private int TAG_BILLEDE = 2222;
    ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_billede);

        imageView3=(ImageView) findViewById(R.id.imageView3);
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
                if (resultCode== VÆLG_BILLEDE){
                    AssetFileDescriptor filDS = getContentResolver().openAssetFileDescriptor(resIntent.getData(), "r");
                    Bitmap bmp = BitmapFactory.decodeStream(filDS.createInputStream());
                    imageView3.setImageBitmap(bmp);

                }else if (resultCode==TAG_BILLEDE){
                    Bitmap bmp = (Bitmap) resIntent.getExtras().get("data");
                    imageView3.setImageBitmap(bmp);
                }
            }catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }

        }
    }


