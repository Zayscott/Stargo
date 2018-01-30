package com.example.antho.stargo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Antho on 06/12/2017.
 */

public class InscriptionActivity extends AppCompatActivity {
    private EditText mPrenom;
    private EditText mNom;
    private EditText mPseudo;
    private EditText mMdp;
    private EditText mMdp2;
    private EditText mEmail;
    private Button mInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // lien entre mes id du fichier activity_inscription.xml et mes variables
        mPrenom = (EditText) findViewById(R.id.activity_inscription_text_prenom);
        mNom = (EditText) findViewById(R.id.activity_inscription_text_nom);
        mPseudo = (EditText) findViewById(R.id.activity_inscription_text_pseudo);
        mMdp = (EditText) findViewById(R.id.activity_inscription_text_mdp);
        mMdp2 = (EditText) findViewById(R.id.activity_inscription_text_mdp2);
        mEmail = (EditText) findViewById(R.id.activity_inscription_text_email);
        mInscription = (Button) findViewById(R.id.activity_inscription_button_envoieinscription)

        mInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityconnexion = new Intent(InscriptionActivity.this, ConnexionActivity.class);
                startActivity(activityconnexion);
            }
        });
    }

}
