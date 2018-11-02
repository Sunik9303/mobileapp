package com.techtown.android.a04_explicitintenttest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int GET_STRING = 1;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.edit);
    }


    public void onClickButton(View view){

        Intent intent1 = new Intent(MainActivity.this , SubActivity.class);
        startActivityForResult(intent1,GET_STRING);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GET_STRING){
            if(resultCode==RESULT_OK){
                text.setText(data.getStringExtra("INPUT_TEXT"));
            }
        }
    }
}
