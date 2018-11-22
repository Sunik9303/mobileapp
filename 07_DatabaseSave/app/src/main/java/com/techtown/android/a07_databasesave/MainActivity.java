package com.techtown.android.a07_databasesave;

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

    public void showListAct(View view){
        Intent i = new Intent(this,ListAct.class);
        startActivity(i);
    }

    public void showInsAct(View view){
        Intent i = new Intent(this,InsAct.class);
        startActivity(i);
    }

    public void showDelAct(View view){
        Intent i = new Intent(this,DelAct.class);
        startActivity(i);
    }

    public void showUpAct(View view){
        Intent i = new Intent(this,UpAct.class);
        startActivity(i);
    }
    public void showCosAct(View view){
        Intent i = new Intent(this,CosAct.class);
        startActivity(i);
    }

}
