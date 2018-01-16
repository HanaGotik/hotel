package net.source.hotelku.hotelku.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import net.source.hotelku.hotelku.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,View.OnClickListener {

    private GoogleMap mMap;
    private FloatingActionButton fab_zoom_in, fab_zoom_out;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fab_zoom_in = findViewById(R.id.fab_zoom_in);
        fab_zoom_out = findViewById(R.id.fab_zoom_out);

        fab_zoom_in.setOnClickListener(this);
        fab_zoom_out.setOnClickListener(this);
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
        LatLng Daffam = new LatLng(-8.1656062,113.697109);
        float zoom = 17.5f;
        mMap.addMarker(new MarkerOptions().position(Daffam).title("Marker in Daffam"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Daffam, zoom));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(Daffam));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public  void onClick(View v){
        if (v == fab_zoom_in){
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }

        if (v == fab_zoom_out){
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }
}
