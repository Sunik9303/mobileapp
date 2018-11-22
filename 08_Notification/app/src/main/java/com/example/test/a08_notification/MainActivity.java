package com.example.test.a08_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int G_NOTIFY_NUM = 1; // 식별ID
    NotificationManager m_NotiManager;

    Toast mMsg= null;
    int mCnt = 0;

    DialogInterface.OnClickListener mClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int button) {
            switch (button) {
                case DialogInterface.BUTTON_POSITIVE:
                    Toast.makeText(MainActivity.this,
                            "난 긍정적인 사람이 좋더라~", Toast.LENGTH_SHORT).show();
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    Toast.makeText(MainActivity.this,
                            "중립적이시군요.", Toast.LENGTH_SHORT).show();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    Toast.makeText(MainActivity.this,
                            "이런, 부정적인 사람같으니~", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_NotiManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }

    public void onClickButton(View v){
        switch (v.getId()){
            case R.id.button1:
                Toast.makeText(this,"짧은 내용",Toast.LENGTH_SHORT).show();
                v.postDelayed( new Runnable()  {
                    public void run() {
                        int icon = MainActivity.this.getApplicationInfo().icon;
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        PendingIntent content = PendingIntent.getActivity(
                                MainActivity.this, 0, intent, 0);
                        Notification notification = new Notification.Builder(MainActivity.this)
                                .setContentTitle("짧은 알림")
                                .setContentText("짧은 내용의 알림입니다.")
                                .setSmallIcon(icon)
                                .setContentIntent(content)
                                .setWhen(System.currentTimeMillis())
                                .build();
                        m_NotiManager.notify(MainActivity.G_NOTIFY_NUM, notification);
                    }
                    }, 5*1000 );
                break;
            case R.id.button2:
                Toast.makeText(this,"긴 시간 토스트",Toast.LENGTH_LONG).show();
                break;
            case R.id.button3:
                if(mMsg!=null)
                    mMsg.cancel();
                mCnt++;
                mMsg = Toast.makeText(this,mCnt+"번째 토스트",Toast.LENGTH_LONG);
                mMsg.setGravity(Gravity.BOTTOM|Gravity.LEFT,0,0);
                mMsg.show();
                break;
            case R.id.button4:
                if(mMsg==null)
                    mMsg = Toast.makeText(this,"",Toast.LENGTH_SHORT);
                mCnt++;
                mMsg.setGravity(Gravity.BOTTOM|Gravity.LEFT,0,0);
                mMsg.setText(mCnt+"번째 토스트");
                mMsg.show();
                break;
            case R.id.button5:
                LinearLayout toastView = (LinearLayout)View.inflate(
                        this,R.layout.toast,null);
                Toast t = new Toast(this);
                t.setView(toastView);
                t.setDuration(Toast.LENGTH_LONG);
                t.show();
                break;
            case R.id.button6:
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setTitle("Android란?");
                dlg.setMessage("PC 운영체제인 ‘윈도우’처럼 스마트폰에서 프로그램을 "
                        + "실행하도록 하는 구글이 만든 모바일 전용 운영체제다. "
                        + "애플 아이폰 콘텐츠 장터인 ‘앱스토어’와 같이 "
                        + "‘Google Playstore’가 있어서 누구나 원하는 게임, 뉴스, "
                        + "음악 등 콘텐츠를 내려 받을 수 있으며 구글 검색도 초기화면에서"
                        + " 쉽게 할 수 있다. 특히 애플이 폐쇄적으로 운영중인 아이폰 체제와 "
                        + "달리 운영체제를 공개하고 있어 휴대폰 제조업체는 물론 SK텔레콤"
                        + " 등 이동통신사도 채택할 수 있는 것이 특징이다.");
                dlg.show();
                break;
            case R.id.button7:  // ver1
                new AlertDialog.Builder(this)
                        .setTitle("안드로이드 수업 설문조사")
                        .setMessage("안드로이드 수업 재미 있다?없다? ")
                        .setPositiveButton("닫기",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }
                        )
                        .show();
                break;
            case R.id.button8:
                new AlertDialog.Builder(this)
                        .setTitle("대세는 누구?")
                        .setItems(R.array.mobilegroup,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String[] mobilegroup =
                                                getResources().getStringArray(R.array.mobilegroup);
                                        Toast.makeText(MainActivity.this,"역시 "+mobilegroup[which]+" 최고!",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                        )
                        .setNegativeButton("없어!",mClick)
                        .setCancelable(false)
                        .show();
                break;
            case R.id.button9:
                LinearLayout dialogView = (LinearLayout)View.inflate(
                        this,R.layout.dialog,null);
                new AlertDialog.Builder(this)
                        .setTitle("원하는 결과는?")
                        .setView(dialogView)
                        .setPositiveButton("열심히", mClick)
                        .setNegativeButton("포기",mClick)
                        .setCancelable(false)
                        .show();
                break;
        }

    }

}
