package com.techtown.android.a04_explicitintenttest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edit = (EditText)findViewById(R.id.edit);
    }

    public void onClickButton(View view){
        Intent intent = new Intent();
        intent.putExtra("INPUT_TEXT",edit.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
