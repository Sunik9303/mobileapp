package com.example.test.practice8_4;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static final int G_NOTIFY_NUM = 1; // 식별ID
    NotificationManager m_NotiManager;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_NotiManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }

    public void onClicked(View view){

        editText = (EditText)findViewById(R.id.editText);
        int time = Integer.parseInt(editText.getText().toString());

        Calendar cal=Calendar.getInstance();
        Date date=cal.getTime();
        final String today=(new SimpleDateFormat("yyyyMMddHHmmss").format(date));

        Toast.makeText(this,time+"초 뒤 알람이 시작 됩니다.",Toast.LENGTH_SHORT).show();
        view.postDelayed( new Runnable()  {
            public void run() {
                int icon = MainActivity.this.getApplicationInfo().icon;
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent content = PendingIntent.getActivity(
                        MainActivity.this, 0, intent, 0);
                Notification notification = new Notification.Builder(MainActivity.this)
                        .setContentTitle("현재 시간")
                        .setContentText(today)
                        .setSmallIcon(icon)
                        .setContentIntent(content)
                        .setWhen(System.currentTimeMillis())
                        .build();
                m_NotiManager.notify(MainActivity.G_NOTIFY_NUM, notification);
            }
        }, time*1000 );

    }
}
