package com.techtown.android.a09_msglooptest;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class CalcThread extends Thread {

    Handler mMainHandler;
    Handler mCalcHandler;

    CalcThread(Handler main) {
        mMainHandler = main;
    }

    public void run() {
        Looper.prepare();
        mCalcHandler = new CalcHandler();
        Looper.loop();
    }

    public Handler getHandler() {
        return mCalcHandler;
    }


    class CalcHandler extends Handler {
        public void handleMessage(Message msg) {
            Message retMsg = Message.obtain();
            retMsg.what = msg.what;
            retMsg.arg1 = 0;
            for (int n = 1; n <= msg.arg1; n++) {
                retMsg.arg1 += n;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    ;
                }
            }
            // 선택된 계산 수행
            switch (msg.what) {
                case 1:// 제곱 계산
                    retMsg.arg2 = retMsg.arg1 * retMsg.arg1;
                    break;
                case 2:// 제곱근 계산
                    retMsg.obj = new Double(Math.sqrt((double) retMsg.arg1));
                    break;
            }
            // 메인 메세지 루프로 전달
            mMainHandler.sendMessage(retMsg);
        }
    }
}
