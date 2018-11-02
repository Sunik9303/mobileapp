package com.techtown.android.a04_explicitintenttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
    }

    public void onClickButton(View view){
        finish();
    }
}
