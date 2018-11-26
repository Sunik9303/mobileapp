package com.techtown.android.a09_broadcastreceivertest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNews(View view) {
        Intent test = new Intent(this, FakeNewsDaemon.class);
        startService(test);
    }

    public void stopNews(View view) {
        Intent test = new Intent(this, FakeNewsDaemon.class);
        stopService(test);
    }

}
