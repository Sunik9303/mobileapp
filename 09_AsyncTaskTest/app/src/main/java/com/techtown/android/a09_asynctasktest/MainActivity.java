package com.techtown.android.a09_asynctasktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    CounterTask mTask;
    boolean mBreak = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startWork(View v) {
        EditText editText =(EditText)findViewById(R.id.editText);
        int count = Integer.parseInt(editText.getText().toString());

        if (mBreak) {
            mBreak = false ;
            mTask = new CounterTask();
            mTask.setOutputView((TextView)findViewById(R.id.textView1) );
            mTask.execute(count);  // 10은 doInBackground(Integer... integers)의 integers로 전달
        } else {
            mBreak = true;
        }
    }
    public void cancelWork(View v) {
        mTask.cancel(true);
    }

}
