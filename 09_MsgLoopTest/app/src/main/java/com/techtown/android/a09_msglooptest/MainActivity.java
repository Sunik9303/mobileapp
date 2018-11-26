package com.techtown.android.a09_msglooptest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CalcThread mThread;
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            String output = "";

            switch (msg.what) {
                case 1:// 제곱 계산
                    output = "제곱 계산";
                    output += "\n누적값: " + msg.arg1;
                    output += "\n제곱: " + msg.arg2;
                    break;
                case 2:// 제곱근 계산
                    output = "제곱근 계산";
                    output += "\n누적값: " + msg.arg1;
                    output += "\n제곱근: " + ((Double) msg.obj).doubleValue();
                    break;
            }
            TextView txt = (TextView) findViewById(R.id.textView2);
            txt.setText(output);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mThread = new CalcThread(mHandler);
        mThread.setDaemon(true);
        mThread.start();
    }

    public void calcNumber(View view) {
        TextView txt = (TextView) findViewById(R.id.textView2);
        EditText edit = (EditText) findViewById(R.id.editText1);
        int num = Integer.parseInt(edit.getText().toString());

        Message msg;
        switch (view.getId()) {
            case R.id.button1:
                msg = Message.obtain(mHandler, 1, num, 0);
                //mThread.mCalcHandler.sendMessage(msg);
                mThread.getHandler().sendMessage(msg);
                txt.setText("제곱 계산 중...");
                break;

            case R.id.button2:
                msg = Message.obtain(mHandler, 2, num, 0);
                //mThread.mCalcHandler.sendMessage(msg);
                mThread.getHandler().sendMessage(msg);
                txt.setText("제곱근 계산 중...");
                break;
        }
    }
}
