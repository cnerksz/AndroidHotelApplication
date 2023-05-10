package com.example.hotella.home.home.nearby;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.hotella.R;
import com.google.android.gms.location.FusedLocationProviderClient;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


public class NearbyFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap map;
    private FusedLocationProviderClient fusedLocationProviderClient;
    public static int LOCATİON_REQUEST_CODE = 100;
    private double lat, longitude;
    private LatLng userLocation;

    ImageButton hospitalButton, historicalButton, entertainmentButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_nearby, container, false);
        hospitalButton = v.findViewById(R.id.hospitals_nearby);
        historicalButton = v.findViewById(R.id.historical_nearby);
        entertainmentButton = v.findViewById(R.id.entertainment);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        checkLocationPermission();


        hospitalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.clear();
                GetNearbyPlaces getNearbyPlaces = new GetNearbyPlaces();
                StringBuilder googleURL = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                googleURL.append("location=" + lat + "," + longitude);
                googleURL.append("&radius=10000");
                googleURL.append("&type=hospital");
                googleURL.append("&sensor=true");
                googleURL.append("&key=AIzaSyBfDOlQN2MtNgi_RTzlHwxYO4fDeIEO6us");
                String url = googleURL.toString();
                Object transferData[] = new Object[2];
                transferData[0] = map;
                transferData[1] = url;

                getNearbyPlaces.execute(transferData);
                Toast.makeText(getActivity(), "Hastaneler gösteriliyor..", Toast.LENGTH_LONG).show();
            }
        });
        historicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.clear();
                GetNearbyPlaces getNearbyPlaces = new GetNearbyPlaces();
                StringBuilder googleURL = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                googleURL.append("keyword=tarihi+yerler");
                googleURL.append("&location=" + lat + "," + longitude);
                googleURL.append("&radius=10000");
                googleURL.append("&sensor=true");
                googleURL.append("&key=AIzaSyBfDOlQN2MtNgi_RTzlHwxYO4fDeIEO6us");
                String url = googleURL.toString();
                Object transferData[] = new Object[2];
                transferData[0] = map;
                transferData[1] = url;

                getNearbyPlaces.execute(transferData);
                Toast.makeText(getActivity(), "Tarihi yerler gösteriliyor..", Toast.LENGTH_LONG).show();

            }
        });
        entertainmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetNearbyPlaces getNearbyPlaces = new GetNearbyPlaces();
                StringBuilder googleURL = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                googleURL.append("keyword=eğlence+yerleri");
                googleURL.append("&location=" + lat + "," + longitude);
                googleURL.append("&radius=10000");
                googleURL.append("&sensor=true");
                googleURL.append("&key=AIzaSyBfDOlQN2MtNgi_RTzlHwxYO4fDeIEO6us");
                String url = googleURL.toString();
                Object transferData[] = new Object[2];
                transferData[0] = map;
                transferData[1] = url;

                getNearbyPlaces.execute(transferData);
                Toast.makeText(getActivity(), "Eğlence yerleri gösteriliyor..", Toast.LENGTH_LONG).show();

            }
        });
        return v;
    }


    private void checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getUserLocation();
        } else {
            requestForPermissions();
        }
    }

    private void getUserLocation() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    lat = location.getLatitude();
                    longitude = location.getLongitude();

                    userLocation = new LatLng(lat, longitude);
                    map.animateCamera(CameraUpdateFactory.newLatLng(userLocation));
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 12));

                }
            }
        });
    }

    private void requestForPermissions() {
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, LOCATİON_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATİON_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getActivity(), "İzin Kabul Edildi", Toast.LENGTH_LONG).show();
                getUserLocation();

            } else {
                Toast.makeText(getActivity(), "İzin Reddedildi", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setMyLocationButtonEnabled(true);
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        map.setMyLocationEnabled(true);

        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                map.clear();
                hospitalButton.setVisibility(View.VISIBLE);
                entertainmentButton.setVisibility(View.VISIBLE);
                historicalButton.setVisibility(View.VISIBLE);
            }
        });
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
               hospitalButton.setVisibility(View.INVISIBLE);
               entertainmentButton.setVisibility(View.INVISIBLE);
               historicalButton.setVisibility(View.INVISIBLE);
                return false;
            }
        });


    }
}
