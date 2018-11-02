package com.techtown.android.practice6_3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MiddleActivity extends AppCompatActivity {

    String name;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);

        Intent intent = getIntent();
        name = intent.getExtras().getString("name");
        phone = intent.getStringExtra("phone");


        TextView nameView = (TextView)findViewById(R.id.namedata);
        TextView phoneView = (TextView)findViewById(R.id.phonedata);

        nameView.setText("이름 :    " + name);
        phoneView.setText("전화번호 : " + phone);

        phone = "tel:"+phone;

        Button button = (Button)findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent makeCall = new Intent(Intent.ACTION_DIAL,Uri.parse(phone));
                startActivity(makeCall);
            }
        });




    }
}
