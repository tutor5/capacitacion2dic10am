package com.tutor.capacitacion2dic10am;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActicty extends FragmentActivity implements OnMapReadyCallback {
GoogleMap map;
Button otroboton;
EditText numero1,numero2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_acticty);
        numero1 = findViewById(R.id.editTextNumber);
        numero2 = findViewById(R.id.editTextNumber2);
        otroboton = findViewById(R.id.button2);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        otroboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarmarcador(map);
            }
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
    map = googleMap;

        LatLng latLng = new LatLng(7.1214,-73.1286);
        map.addMarker(new MarkerOptions().position(latLng).title("Bucaramanga"));
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        map.moveCamera(CameraUpdateFactory.zoomTo(12));



    }


    public void pasarmarcador(GoogleMap map){


        Double lat = Double.parseDouble(numero1.getText().toString());
        Double lon = Double.parseDouble(numero2.getText().toString());
        Log.d("test", "" + lat);
        Log.d("test", "" + lon);
        LatLng otralat = new LatLng(lat,lon);
        map.addMarker(new MarkerOptions().position(otralat).title("Otra latitud"));
        map.moveCamera(CameraUpdateFactory.newLatLng(otralat));
        //map.moveCamera(CameraUpdateFactory.zoomTo(12));

    }

}