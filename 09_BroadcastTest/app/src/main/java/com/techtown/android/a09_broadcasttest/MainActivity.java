package com.techtown.android.a09_broadcasttest;

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

    public void onClickSend(View view) {
        Intent intent = new Intent();               // empty Intent
        intent.setAction("com.broadcast.ANDROID");  // action name
        sendBroadcast(intent); //Broadcast the given intent to all interested
        // BroadcastReceivers
    }
}
