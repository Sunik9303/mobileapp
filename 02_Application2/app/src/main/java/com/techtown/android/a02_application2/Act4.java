package com.techtown.android.a02_application2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Act4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act4);


        final Button go_act3 = (Button)findViewById(R.id.btn_act4_go3);


        go_act3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Log.i("Act1_btn_act4_go3","onClick");
            }
        });

    }

    @Override
    protected void onStart() {
        Log.i("Act4", "Act4_onStart");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.i("Act4", "Act4_onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("Act4", "Act4_onStop");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.i("Act4", "Act4_onResume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.i("Act4", "Act4_onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i("Act4", "Act4_onDestroy");
        super.onDestroy();
    }


}
