package com.techtown.android.a02_application2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Act2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        final Button go_act1 = (Button)findViewById(R.id.btn_act2_go1);
        final Button go_act3 = (Button)findViewById(R.id.btn_act2_go3);


        go_act1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Log.i("Act1_btn_act2_go1","onClick");
            }
        });


        go_act3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Act2.this,Act3.class);
                startActivity(intent);
                Log.i("Act1_btn_act2_go3","onClick");
            }
        });

    }

    @Override
    protected void onStart() {
        Log.i("Act2", "Act2_onStart");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.i("Act2", "Act2_onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("Act2", "Act2_onStop");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.i("Act2", "Act2_onResume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.i("Act2", "Act2_onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i("Act2", "Act2_onDestroy");
        super.onDestroy();
    }

}
