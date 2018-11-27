package com.techtown.android.a02_application2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Act1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);

        final Button go_act2 = (Button)findViewById(R.id.btn_act1_go2);


        go_act2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Act1.this,Act2.class);
                startActivity(intent);
                Log.i("Act1_btn_act1_go2","onClick");
            }
        });

    }

    @Override
    protected void onStart() {
        Log.i("Act1", "Act1_onStart");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.i("Act1", "Act1_onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("Act1", "Act1_onStop");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.i("Act1", "Act1_onResume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.i("Act1", "Act1_onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i("Act1", "Act1_onDestroy");
        super.onDestroy();
    }





}
