package com.techtown.android.a04_explicitintenttest;

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

    public void onClickButton(View view){
        Intent intent1 = new Intent(MainActivity.this,Activity2.class);
        startActivity(intent1);

    }
}
