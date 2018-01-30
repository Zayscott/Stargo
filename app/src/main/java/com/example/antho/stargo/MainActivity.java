package com.example.antho.stargo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class MainActivity extends AppCompatActivity {

    // Déclaration des variables
    private TextView mText1;
    private TextView mText2;
    private TextView mText3;
    private Button mButtonTUS;
    private Button mButtonMUS;

    private static final int PLACE_PICKER_REQUEST = 1;

    private static final LatLngBounds BOUNDS_MOUNTAIN_VIEW = new LatLngBounds(
            new LatLng(37.398160, -122.180831), new LatLng(37.430610, -121.972090));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // lien entre mes id du fichier activity_main.xml et mes variables
        mText1 = (TextView) findViewById(R.id.activity_main_text_1);
        mText2 = (TextView) findViewById(R.id.activity_main_text_2);
        mText3 = (TextView) findViewById(R.id.activity_main_text_3);
        mButtonTUS = (Button) findViewById(R.id.activity_main_button_tus);
        mButtonMUS = (Button) findViewById(R.id.activity_main_button_mus);



        // action à effectuer au click sur TUS (Trouver Une Star)
        mButtonTUS.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent activityTUS = new Intent(MainActivity.this, TUSActivity.class);
                startActivity(activityTUS);
            }
        });

        // action à effectuer au click sur MUS (Marquer Une Star)
        mButtonMUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PlacePicker.IntentBuilder intentBuilder =
                            new PlacePicker.IntentBuilder();
                    intentBuilder.setLatLngBounds(BOUNDS_MOUNTAIN_VIEW);
                    Intent intent = intentBuilder.build(MainActivity.this);
                    startActivityForResult(intent, PLACE_PICKER_REQUEST);

                } catch (GooglePlayServicesRepairableException
                        | GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PLACE_PICKER_REQUEST
                && resultCode == RESULT_OK) {

            final Place place = PlacePicker.getPlace(this, data);
            final CharSequence name = place.getName();
            final CharSequence address = place.getAddress();
            String attributions = (String) place.getAttributions();
            /* Double latitude = place.getLatLng().latitude;
            Double longitude = place.getLatLng().longitude; */
            if (attributions == null) {
                attributions = "";
            }

            Intent musactivity = new Intent(MainActivity.this, MUSActivity.class);
            musactivity.putExtra("NAME", name);
            musactivity.putExtra("ADDRESS", address);
            musactivity.putExtra("ATTRIBUTIONS", attributions);
            startActivity(musactivity);



        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
