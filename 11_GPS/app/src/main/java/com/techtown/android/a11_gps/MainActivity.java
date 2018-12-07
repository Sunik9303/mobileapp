package com.techtown.android.a11_gps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final Integer APP_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        askForPermission(Manifest.permission.ACCESS_FINE_LOCATION, APP_PERMISSION);

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                showNewLocation(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
            return;

        if (locationManager.getAllProviders().contains(LocationManager.NETWORK_PROVIDER))
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0, locationListener);

        if (locationManager.getAllProviders().contains(LocationManager.GPS_PROVIDER))
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0, locationListener);


    }


    private void askForPermission(String permission, Integer requestCode)
    {
        if(ContextCompat.checkSelfPermission(MainActivity.this, permission)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permission)) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[] {permission }, requestCode);
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[] {permission }, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(ActivityCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
        }

    }

    public void showNewLocation(Location location) { // ver 1
        // Provider
        EditText txt = (EditText)findViewById(R.id.editText1);
        txt.setText(location.getProvider());

        // Accuracy
        txt = (EditText)findViewById(R.id.editText2);
        if (location.hasAccuracy()) {
            txt.setText(" " + location.getAccuracy());
        } else {
            txt.setText("Unknown");
        }

        // Longitude
        txt = (EditText)findViewById(R.id.editText3);
        txt.setText(" " + location.getLongitude());

        // Latitude
        txt = (EditText)findViewById(R.id.editText4);
        txt.setText(" " + location.getLatitude());

        txt = (EditText)findViewById(R.id.editText5);
        if (location.hasAltitude()) {
            txt.setText(" " + location.getAltitude());
        } else {
            txt.setText("Unknown");
        }

        // Time
        txt = (EditText)findViewById(R.id.editText6);
        txt.setText(" " + location.getTime());

        // Bearing
        txt = (EditText)findViewById(R.id.editText7);
        if (location.hasBearing()) {
            txt.setText(" " + location.getBearing());
        } else {
            txt.setText("Unknown");
        }

        // Speed
        txt = (EditText)findViewById(R.id.editText8);
        if (location.hasSpeed()) {
            txt.setText(" " + location.getSpeed());
        } else {
            txt.setText("Unknown");
        }

        // Extras
        txt = (EditText)findViewById(R.id.editText9);
        if (location.getExtras() != null) {
            txt.setText( location.getExtras().toString());
        } else {
            txt.setText("None");
        }
    } // showNewLocation




}
