package com.techtown.android.a09_broadcastreceivertest2;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

public class FakeNewsDaemon extends Service {
    public FakeNewsDaemon() {    }

    boolean mStop = true;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1) {
                Toast.makeText(FakeNewsDaemon.this,
                        "안드로이드 뉴스\n" + (String) msg.obj, Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "안드로이드 뉴스 초기화", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Toast.makeText(this, "안드로이드 뉴스 시작", Toast.LENGTH_SHORT).show();
        mStop = false;
        NewsThread news = new NewsThread(mHandler);
        news.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "안드로이드 뉴스 종료", Toast.LENGTH_SHORT).show();
        mStop = true;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    class NewsThread extends Thread {
        Handler mHandler;
        String[] newsArray = {
                "1.5 ver, 컵케이크",  "1.6 ver, 도넛",
                "2.0~2.1 ver, 이클레어",  "2.2 ver, 프로요",
                "2.3~2.3.7 ver, 진저브레드",  "3.1~3.2 ver, 허니콤",
                "4.0.3~4.0.4 ver, 아이스크림 샌드위치", "4.1.x~4.2.x ver, 젤리빈",
                "4.4, 킷캣",  "5.0~5.1.1, 롤리팝",
                "6.0, 마쉬멜로우", "7.0 누가"
        };

        NewsThread(Handler handler) {
            mHandler = handler;
        }

        public void run() {
            int idx = 0;
            while (!mStop) {
                Message msg = Message.obtain();
                msg.what = 1;
                msg.obj = newsArray[idx];
                mHandler.sendMessage(msg);
                idx++;
                idx %= newsArray.length;
                try {
                    sleep(5000);
                } catch (InterruptedException e) {;}
            }
        }
    }

}
