package com.example.antho.stargo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Antho on 06/12/2017.
 */

public class ConnexionActivity extends AppCompatActivity {
    private Button mButtonLogin;
    private Button mButtonInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        // lien entre mes id du fichier activity_connexion.xml et mes variables
        mButtonLogin = (Button) findViewById(R.id.activity_connexion_button_login);
        mButtonInscription = (Button) findViewById(R.id.activity_connexion_button_inscription);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activitymain = new Intent(ConnexionActivity.this, MainActivity.class);
                startActivity(activitymain);
            }
        });

        // action à effectuer au click sur TUS (Trouver Une Star)
        mButtonInscription.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent activityinscription = new Intent(ConnexionActivity.this, InscriptionActivity.class);
                startActivity(activityinscription);
            }
        });
    }
}
