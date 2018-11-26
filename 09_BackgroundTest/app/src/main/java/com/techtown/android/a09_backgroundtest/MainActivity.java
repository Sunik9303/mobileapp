package com.techtown.android.a09_backgroundtest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mForeCount = 0;
    int mBackCount = 0;
    boolean mBreak = true;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 1){
                showCount();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*public void onClickButton(View view) {
        mForeCount++;
        String output = "카운트 증가";
        output += "\nForeCount: " + mForeCount;
        output += "\nBackCount: " + mBackCount;
        TextView txt = (TextView)findViewById(R.id.textView1);
        txt.setText(output);
    }*/

    /*public void startWork(View view) {    // ver1
        mBreak = false;
        while (!mBreak) {
            mBackCount++;
            Log.d(" Main : ", "BackCount: " + mBackCount);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                ;
            }
        }
    }*/

    /*public void startWork(View view) {    // ver2
        if (mBreak) {
            mBreak = false;
            Button start = (Button)findViewById(R.id.button1);
            start.setText("작업 중지!");
            BackCounter thread = new BackCounter();
            thread.setDaemon(true);
            thread.start();
        } else {
            mBreak = true;
            Button start = (Button)findViewById(R.id.button1);
            start.setText("작업 시작!");
        }
    }*/

    public void showCount() {
        String output = "카운트 증가";
        output += "\nForeCount: " + mForeCount;
        output += "\nBackCount: " + mBackCount;
        TextView txt = (TextView)findViewById(R.id.textView1);
        txt.setText(output);
    }

    public void onClickButton(View view) {
        mForeCount++;
        showCount();
    }

    public void startWork(View view) {    // ver3
        if (mBreak) {
            mBreak = false;
            Button start = (Button)findViewById(R.id.button1);
            start.setText("작업 중지!");
            Thread thread = new Thread(new BackCounter());
            thread.setDaemon(true);
            thread.start();
        } else {
            mBreak = true;
            Button start = (Button)findViewById(R.id.button1);
            start.setText("작업 시작!");
        }
    }


    @Override
    protected void onDestroy() {
        mBreak =true;
        super.onDestroy();
    }

    /*class BackCounter extends Thread { // ver 1
        public void run() {
            while (!mBreak) {
                mBackCount++;
                Log.d("Main", "BackCount: " + mBackCount);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    ;
                }
            }
        }
    }*/

    /*class BackCounter implements Runnable { // ver 2
        public void run() {
            while (!mBreak) {
                mBackCount++;
                Log.d("Main", "BackCount: " + mBackCount);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    ;
                }
            }
        }
    }*/

    /*class BackCounter implements Runnable { // ver 3
        public void run() {
            while (!mBreak) {
                mBackCount++;
                mHandler.sendEmptyMessage(1);
                Log.d("Main", "BackCount: " + mBackCount);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    ;
                }
            }
        }
    }*/

    class BackCounter implements Runnable { // ver 5
        public void run() {
            while (!mBreak) {
                mBackCount++;
                //mHandler.sendEmptyMessage(1);
                /*Message msg = Message.obtain(mHandler, 1, 0, 0);
                mHandler.sendMessage(msg);*/
                Message msg = Message.obtain();
                msg.what = 1;
                mHandler.sendMessage(msg);
                Log.d("Main", "BackCount: " + mBackCount);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    ;
                }
            }
        }
    }
}
