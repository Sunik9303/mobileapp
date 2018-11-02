package com.techtown.android.a04_implicitintenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        String act = getIntent().getAction();
        EditText txt = (EditText)findViewById(R.id.edit);

        if(act.compareTo(Intent.ACTION_VIEW)==0){
            txt.setText("VIEW");
        }
        else if(act.compareTo(Intent.ACTION_EDIT)==0) {
            txt.setText("EDIT");
        }
        else{
            txt.setText("Unknown: "+act);
        }
    }
}
