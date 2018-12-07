package com.techtown.android.a11_pedometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView gx, gy, gz;
    private TextView stepsTextView;

    private SensorManager sensorManager;    

    private float previousY, currentY;
    private int steps;
    int threshold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gx = (TextView)findViewById(R.id.gx);
        gy = (TextView)findViewById(R.id.gy);
        gz = (TextView)findViewById(R.id.gz);

        stepsTextView = (TextView)findViewById(R.id.steps);

        threshold = 10;
        previousY = currentY = steps = 0;

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(stepDetector,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);

    }

    private SensorEventListener stepDetector = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            currentY = y;
            if(Math.abs(currentY - previousY) > threshold) {
                steps++;
                stepsTextView.setText((String.valueOf(steps)));
            }

            gx.setText(String.valueOf(x));
            gy.setText(String.valueOf(y));
            gz.setText(String.valueOf(z));
            previousY = y;
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };


}
