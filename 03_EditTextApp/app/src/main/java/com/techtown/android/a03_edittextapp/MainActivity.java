package com.techtown.android.a03_edittextapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View v){
        EditText edit =(EditText)findViewById(R.id.editText);
        String input = edit.getText().toString();

        Toast msg = Toast.makeText(
                this,
                "'"+input+"'을 입력했습니다.",
                Toast.LENGTH_SHORT);
        msg.show();

        edit.setText("입력완료");
    }
}
