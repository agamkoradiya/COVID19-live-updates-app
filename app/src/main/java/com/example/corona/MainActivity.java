package com.example.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.appolica.flubber.Flubber;
import com.google.android.material.card.MaterialCardView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView active,discharge,death,passenger;
    Button info_btn;
    MaterialCardView card1,card2,card3,card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CALL ALL TEXTVIEW  :

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);


        active = (TextView) findViewById(R.id.active);
        discharge = (TextView) findViewById(R.id.discharge);
        death = (TextView) findViewById(R.id.death);
        passenger = (TextView) findViewById(R.id.passenger);
        info_btn = (Button) findViewById(R.id.info_btn);

        
            info_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    
                    ConnectivityManager ConnectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();
                    if (networkInfo != null && networkInfo.isConnected() == true) {
                        new INDIA().execute();
                        
                     }else{
                        Toast.makeText(MainActivity.this, "Check Your Internet Connection!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        
    }


    class INDIA extends AsyncTask<Void, ArrayList,ArrayList>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList doInBackground(Void... voids) {

            ArrayList<String> arrayList = new ArrayList<>();

            try {
                String url = "https://www.mohfw.gov.in/";
                Document document = Jsoup.connect(url).get();
                Elements elements = document.getElementsByClass("icount");

                arrayList.add(elements.get(0).text());
                arrayList.add(elements.get(1).text());
                arrayList.add(elements.get(2).text());
                arrayList.add(elements.get(3).text());

            }catch (IOException e) {
                e.printStackTrace();
            }
            return arrayList;
        }

        @Override
        protected void onPostExecute(ArrayList arrayList) {

            // SET ANIMATION :

            Flubber.with()
                    .animation(Flubber.AnimationPreset.FADE_IN_RIGHT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1500)                              // Last for 1000 milliseconds(1 second)
                    .createFor(card1)                             // Apply it to the view
                    .start();
            card1.setVisibility(View.VISIBLE);

            Flubber.with()
                    .animation(Flubber.AnimationPreset.FADE_IN_LEFT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1500)                              // Last for 1000 milliseconds(1 second)
                    .createFor(card2)                             // Apply it to the view
                    .start();
            card2.setVisibility(View.VISIBLE);

            Flubber.with()
                    .animation(Flubber.AnimationPreset.FADE_IN_RIGHT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1500)                              // Last for 1000 milliseconds(1 second)
                    .createFor(card3)                             // Apply it to the view
                    .start();
            card3.setVisibility(View.VISIBLE);

            Flubber.with()
                    .animation(Flubber.AnimationPreset.FADE_IN_LEFT) // Slide up animation
                    .repeatCount(0)                              // Repeat once
                    .duration(1500)                              // Last for 1000 milliseconds(1 second)
                    .createFor(card4)                             // Apply it to the view
                    .start();
            card4.setVisibility(View.VISIBLE);


            // SET VALUES :

            passenger.setText(""+arrayList.get(0));
            active.setText(""+arrayList.get(1));
            discharge.setText(""+arrayList.get(2));
            death.setText(""+arrayList.get(3));
            super.onPostExecute(arrayList);
        }
    }
    public void about_app(View view){
        Intent intent = new Intent(this,AboutApp.class);
        startActivity(intent);
    }
}
