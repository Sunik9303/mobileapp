package com.techtown.android.a11_sensortest;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> listSensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

        String output = "count=" + listSensor.size() + "\n\n";

        for(Sensor sensor: listSensor) {
            output += ("name=" + sensor.getName() + "\n\ttype=" + sensor.getType() +
                    "\n\tvender=" + sensor.getVendor() + "\n\tversion=" + sensor.getVersion() +
                    "\n\tpower=" + sensor.getPower() + "\n\tres=" + sensor.getResolution() +
                    "\n\trange=" + sensor.getMaximumRange() + "\n\n");
        }

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(output);


    }
}
