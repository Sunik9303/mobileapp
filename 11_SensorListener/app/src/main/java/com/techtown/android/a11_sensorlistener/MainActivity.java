package com.techtown.android.a11_sensorlistener;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onPause() {
        super.onPause();
        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensorManager.unregisterListener(mSensorListenr);
    }

    @Override
    protected void onResume() {
        super.onResume();

        int delay = SensorManager.SENSOR_DELAY_UI;
        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(mSensorListenr,
                sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), delay);
        sensorManager.registerListener(mSensorListenr,
                sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY), delay);
        sensorManager.registerListener(mSensorListenr,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), delay);
        sensorManager.registerListener(mSensorListenr,
                sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), delay);
    }


    SensorEventListener mSensorListenr = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE)
                return;

            String output = "";
            float[] v = event.values;

            switch (event.sensor.getType()) {
                case Sensor.TYPE_ORIENTATION:
                    output += "\n azimuth : " + v[0] +
                            "\n pitch : " + v[1] +
                            "\n roll : " + v[2] + "\n";
                    TextView textView1 = (TextView) findViewById(R.id.textView1);
                    textView1.setText(output);
                    break;
                case Sensor.TYPE_GRAVITY:
                    output += "\n X : " + v[0] +
                            "\n Y : " + v[1] +
                            "\n Z : " + v[2] + "\n";
                    TextView textView2 = (TextView) findViewById(R.id.textView2);
                    textView2.setText(output);
                    break;

                case Sensor.TYPE_ACCELEROMETER:
                    output += "\n X : " + v[0] +
                            "\n Y : " + v[1] +
                            "\n Z : " + v[2] + "\n";
                    TextView textView3 = (TextView) findViewById(R.id.textView3);
                    textView3.setText(output);
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    output += "\n X : " + v[0] +
                            "\n Y : " + v[1] +
                            "\n Z : " + v[2] + "\n";
                    TextView textView4 = (TextView) findViewById(R.id.textView4);
                    textView4.setText(output);
                    break;
            }
        }
    };
}
