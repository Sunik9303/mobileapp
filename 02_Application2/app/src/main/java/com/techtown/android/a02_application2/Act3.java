package com.techtown.android.a02_application2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Act3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);


        final Button go_act2 = (Button)findViewById(R.id.btn_act3_go2);
        final Button go_act4 = (Button)findViewById(R.id.btn_act3_go4);


        go_act2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Log.i("Act1_btn_act3_go2","onClick");
            }
        });


        go_act4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Act3.this ,Act4.class);
                startActivity(intent);
                Log.i("Act1_btn_act3_go4","onClick");
            }
        });


    }

    @Override
    protected void onStart() {
        Log.i("Act3", "Act3_onStart");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.i("Act3", "Act3_onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("Act3", "Act3_onStop");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.i("Act3", "Act3_onResume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.i("Act3", "Act3_onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i("Act3", "Act3_onDestroy");
        super.onDestroy();
    }


}
