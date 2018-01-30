package com.example.antho.stargo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Antho on 18/10/2017.
 */

public class MUSActivity extends AppCompatActivity {

    private TextView mName;
    private TextView mAddress;
    private TextView mAttributions;
    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mus);

        mName = (TextView) findViewById(R.id.textView);
        mAddress = (TextView) findViewById(R.id.textView2);
        mAttributions = (TextView) findViewById(R.id.textView3);
        mSubmit = (Button) findViewById(R.id.activity_mus_btn_4);

        String donnees1;
        String donnees2;
        String donnees3;



        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                donnees1 = null;
                donnees2 = null;
                donnees3 = null;
            } else {
                donnees1 = extras.getString("NAME");
                donnees2 = extras.getString("ADDRESS");
                donnees3 = extras.getString("ATTRIBUTIONS");
            }
        } else {
            donnees1 = (String) savedInstanceState.getSerializable("NAME");
            donnees2 = (String) savedInstanceState.getSerializable("ADDRESS");
            donnees3 = (String) savedInstanceState.getSerializable("ATTRIBUTIONS");
        }

        mName.setText(donnees1);
        mAddress.setText(donnees2);
        mAttributions.setText(donnees3);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endMarquage();
            }
        });
    }


    private void endMarquage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Uploaded !")
                .setMessage("Vous venez de marquer" + "STAR" + "à " + mName + "se déplaçant")  //associé le radio button coché)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // end the activty
                        Intent activityTUS = new Intent();
                        startActivity(activityTUS);
                    }
                })
                .setCancelable(false)
                .create()
                .show();
    }
}
