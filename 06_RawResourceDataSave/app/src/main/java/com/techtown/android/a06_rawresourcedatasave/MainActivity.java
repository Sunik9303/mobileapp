package com.techtown.android.a06_rawresourcedatasave;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            InputStream is = getResources().openRawResource(R.raw.rawtext);
            byte[] data = new byte[is.available()];
            while(is.read(data)!=-1){;}
            is.close();

            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(new String(data));

        }catch(IOException e){

            e.printStackTrace();

        }

    }
}
