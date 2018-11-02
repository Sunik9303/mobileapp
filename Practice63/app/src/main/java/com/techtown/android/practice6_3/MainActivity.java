package com.techtown.android.practice6_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String name;
    String phone;
    EditText editName;
    EditText editPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText)findViewById(R.id.name);
        editPhone = (EditText)findViewById(R.id.phone);


        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editName.getText().toString();
                phone = editPhone.getText().toString();
                Intent intent = new Intent(MainActivity.this, MiddleActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("phone",phone);
                startActivity(intent);

            }
        });


    }
}
