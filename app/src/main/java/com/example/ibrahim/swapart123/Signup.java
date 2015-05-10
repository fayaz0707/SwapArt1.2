package com.example.ibrahim.swapart123;

/**
 * Created by kamranyusaf on 07/04/15.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ibrahim.swapart1.R;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.regex.Pattern;

public class Signup extends Activity implements OnClickListener {

    Button signUpKnap;
    EditText email;
    EditText kode;
    TextView tv;
    WebView wb;
    CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

         //Enable Local Datastore./kjhkjhkjh     //https://github.com/fayaz0707/SwapArt.git
         Parse.enableLocalDatastore(this);

        Parse.initialize(this, "SypVmMOGroZ9crfo7fCJsaJgW7qI9f1YBcVmJlLa", "HCsmkcvyULayHEDwud0mO8z2cohrfAv3UwiVWuUT");


        wb = new WebView(this);
        signUpKnap = (Button) findViewById(R.id.Sign_upButton);
        email = (EditText) findViewById(R.id.EmailEditText);
        kode = (EditText) findViewById(R.id.KodeEditText);
        tv = (TextView)findViewById(R.id.textView3);
        checkBox= (CheckBox)findViewById(R.id.checkBox);
        tv.setOnClickListener(this);
        signUpKnap.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {
        String em = email.getText().toString();
        String ko = kode.getText().toString();

        if(v == signUpKnap) {
            if (!validEmail(em)) {
                email.setError("Forkert email indtastet");
                email.requestFocus();
            } else if (!validPassword(ko)) {
                kode.setError("Der skal være mindst 6 bogstaver/tal i din kode");
                kode.requestFocus();
            } else {
                if (!checkBox.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Du mangler at læse reglerne og klikke i boksen",
                            Toast.LENGTH_LONG).show();
                } else {
                    ParseUser Users = new ParseUser();
                    Users.setUsername(em);
                    Users.setPassword(ko);

                    Users.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {

                            if (e == null) {
                                // Success!!

                                Intent intent = new Intent(Signup.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "Du har nu oprettet din konto !!",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Signup.this);
                                builder.setMessage(e.getMessage())
                                        .setTitle("Fejl i indtastning")
                                        .setPositiveButton(android.R.string.ok, null);
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }
                        }


                    });

                }
            }


            if (v == tv) {
                wb.loadUrl("http://www.google.dk");
                setContentView(wb);
            }
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