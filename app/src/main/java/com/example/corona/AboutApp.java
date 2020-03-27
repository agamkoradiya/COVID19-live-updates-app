package com.example.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.appolica.flubber.Flubber;
import com.google.android.material.card.MaterialCardView;

public class AboutApp extends AppCompatActivity {

    MaterialCardView first,second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);

        Flubber.with()
                .animation(Flubber.AnimationPreset.FADE_IN_LEFT) // Slide up animation
                .repeatCount(0)                              // Repeat once
                .duration(2000)                              // Last for 1000 milliseconds(1 second)
                .createFor(first)                             // Apply it to the view
                .start();
        first.setVisibility(View.VISIBLE);

        Flubber.with()
                .animation(Flubber.AnimationPreset.FADE_IN_RIGHT) // Slide up animation
                .repeatCount(0)                              // Repeat once
                .duration(2000)                              // Last for 1000 milliseconds(1 second)
                .createFor(second)                             // Apply it to the view
                .start();
        second.setVisibility(View.VISIBLE);
    }

    public void insta(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse("https://www.instagram.com/code.fun/"));

        startActivity(intent);

    }

    public void tel(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse("https://t.me/joinchat/Kg3NKhZEYE0SC-MRgWheFQ"));

        startActivity(intent);
    }

    public void git(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse("https://github.com/agamkoradiya"));

        startActivity(intent);
    }

    public void source_link(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse("https://www.mohfw.gov.in/"));

        startActivity(intent);
    }
}
