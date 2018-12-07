package com.techtown.android.a11_googlemap2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng knuE9 = new LatLng(35.886869, 128.608408);
        mMap.addMarker(new MarkerOptions().position(knuE9).title("KNU E9"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(knuE9, 16));

        MarkerOptions cafeteriaMarker[] = {
                new MarkerOptions().position ( new LatLng
                        (35.888345,  128.609668)).title("cafeteria1"),
                new MarkerOptions().position ( new LatLng
                        (35.886971,  128.609196)).title("cafeteria2"),
                new MarkerOptions().position ( new LatLng
                        (35.891792, 128.610631)).title("cafeteria3")
        };

        for(int i = 0;  i<3 ; ++i){
            cafeteriaMarker[i].icon(BitmapDescriptorFactory.fromResource(R.drawable.meal24));
            googleMap.addMarker(cafeteriaMarker[i]);
        }

    }
}
