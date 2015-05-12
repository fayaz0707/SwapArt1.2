package com.example.ibrahim.swapart123;

/**
 * Created by kamranyusaf on 19/03/15.
 */

import android.app.Activity;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.util.Patterns;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ibrahim.swapart1.R;

import java.util.regex.Pattern;

public class Logind extends Activity implements OnClickListener {

    Button logIndKnap;
    EditText email;
    EditText kode;
    TextView tv;//vbnvnvn
    WebView wb;
    CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_ind);
        wb = new WebView(this);
        logIndKnap = (Button) findViewById(R.id.Log_indButton);
        email = (EditText) findViewById(R.id.EmailEditText);
        kode = (EditText) findViewById(R.id.KodeEditText);
        tv = (TextView)findViewById(R.id.textView3);
        checkBox= (CheckBox)findViewById(R.id.checkBox);
        tv.setOnClickListener(this);
        logIndKnap.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {
        String em = email.getText().toString();
        String ko = kode.getText().toString();

        if(v == logIndKnap) {
            if (!validEmail(em)) {
                email.setError("Forkert email indtastet");
                email.requestFocus();
            } else if (!validPassword(ko)) {
                kode.setError("Der skal være mindst 6 bogstaver/tal i din kode");
                kode.requestFocus();
            } else if(!checkBox.isChecked()){
                Toast.makeText(getApplicationContext(),"Du mangler at læse reglerne og klikke i boksen",
                        Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Du har nu oprettet din konto !!",
                        Toast.LENGTH_LONG).show();
            }
        }

        if(v == tv)
        {
            wb.loadUrl("http://www.google.dk");
            setContentView(wb);
        }

    }
    private boolean validEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
    private boolean validPassword(String kode){
        if (kode != null && kode.length() > 6) {
            return true;
        }
        return false;
    }
}
