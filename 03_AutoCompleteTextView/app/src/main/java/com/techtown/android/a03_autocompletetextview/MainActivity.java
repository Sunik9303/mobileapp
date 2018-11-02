package com.techtown.android.a03_autocompletetextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView acTextView = (AutoCompleteTextView)findViewById(R.id.acTextView);

        String[] words = {"apple", "appose","application"};

        acTextView.setAdapter(
                new ArrayAdapter<String>(
                        this,R.layout.support_simple_spinner_dropdown_item, words
                )
        );


        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i( "MainActivitiy","beforeTextChanged('" + s + "', "
                        + String.valueOf(start) + ", "
                        + String.valueOf(count) + ", "
                        + String.valueOf(after) + ")" );

                int cnt = s.toString().length();
                Button btn = (Button)findViewById(R.id.button);
                btn.setText(String.valueOf(cnt) + "/" + 160);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i( "MainActivitiy","onTextChanged('" + s + "', "
                        + String.valueOf(start) + ", "
                        + String.valueOf(before) + ", "
                        + String.valueOf(count) + ")" );
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i( "MainActivity", "afterTextChanged");
            }
        };
        acTextView.addTextChangedListener(textWatcher);
    }
}
