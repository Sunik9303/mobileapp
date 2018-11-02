package com.techtown.android.a03_layoutusingcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);

        Button b1 = new Button(this);
        b1.setText("버튼1");
        container.addView(b1);

        Button b2 = new Button(this);
        b2.setText("버튼2");
        container.addView(b2);

        setContentView(container);
    }
}
