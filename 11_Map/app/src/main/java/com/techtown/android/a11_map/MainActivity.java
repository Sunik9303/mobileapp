package com.techtown.android.a11_map;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showLocation(View view) {
        double longitude = 128.6116701;
        double latitude = 35.888005;
        int zoom = 18;
        String pos = String.format("geo:%f,%f?z=%d", latitude, longitude, zoom);
        Uri geo = Uri.parse(pos);
        Intent intent = new Intent(Intent.ACTION_VIEW, geo);
        startActivity(intent);
    }

}
