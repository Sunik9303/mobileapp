package com.techtown.android.a04_implicitintenttest;

import android.content.Intent;
import android.net.Uri;
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
        int id = view.getId();
        Intent intent;

        switch (id){
            case R.id.call:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0539507678"));
                startActivity(intent);
                break;
            case R.id.phone:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
                startActivity(intent);
                break;
            case R.id.map:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.58,126.98"));
                startActivity(intent);
                break;
            case R.id.web:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
                startActivity(intent);
                break;
            case R.id.button:
                intent = new Intent(Intent.ACTION_EDIT);
                startActivity(intent);
                break;
        }

    }

}
