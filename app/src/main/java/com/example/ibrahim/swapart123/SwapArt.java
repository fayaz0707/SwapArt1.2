package com.example.ibrahim.swapart123;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ibrahim.swapart1.R;

/**
 * Created by ibrahim on 19/03/15.
 */
public class SwapArt extends Activity implements View.OnClickListener {
    Button tilbageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swap_art);
        tilbageBtn = (Button)findViewById(R.id.tilbageBtn);
        tilbageBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == tilbageBtn)
        {
            finish();
            //ghjsgafhgaskjdfgaisg
            //hkjdfkjsdhfks
            //gfgfhmoinmi
        }
    }
}
