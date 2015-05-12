package com.example.ibrahim.swapart123;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ibrahim.swapart1.R;
import com.parse.Parse;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibrahim on 19/03/15.
 */
public class SwapArt extends Activity implements View.OnClickListener {
    Button tilbageBtn, acceptBtn;
    ArrayList featureList;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swap_art);
        tilbageBtn = (Button)findViewById(R.id.tilbageBtn);
        tilbageBtn.setOnClickListener(this);
        acceptBtn = (Button)findViewById(R.id.acceptBtn);
        acceptBtn.setOnClickListener(this);

        imageView = (ImageView)findViewById(R.id.imageView);
    }

    @Override
    public void onClick(View v)
    {
        if(v == acceptBtn)
        {
            //setFeatureData(this,"Billede","image",);
        }
        if(v == tilbageBtn)
        {
            finish();
            //ghjsgafhgaskjdfgaisg
            //hkjdfkjsdhfks
            //gfgfhmoinmi
            //bjdajfbjbf fayaz
        }
    }
    public void setFeatureData(Context context, String className, String itemSelected,
                               String[] valueToGet, String colName) {
        featureList = new ArrayList<String>();
        ParseQuery query = new ParseQuery(className);
        query.whereEqualTo(colName, itemSelected);
        try {
            List<ParseObject> dataHolder = query.find();
            if(dataHolder!= null){
                for(int counter =0;counter<dataHolder.size();counter++){
                    for (int innerCounter = 0 ; innerCounter < valueToGet.length; innerCounter ++) {
                        String datas = dataHolder.get(counter).getString(valueToGet[innerCounter]);
                        featureList.add(datas);
                    }
                }
            }
           String objectId = dataHolder.get(0).getObjectId();
            ParseObject fileHolder = query.get(objectId);
            ParseFile bum = (ParseFile) fileHolder.get("Image");
            byte[] file = bum.getData();
            Bitmap image = BitmapFactory.decodeByteArray(file, 0, file.length);
            imageView.setImageBitmap(image);

        } catch (com.parse.ParseException e) {
            e.printStackTrace();
        }
    }
}
