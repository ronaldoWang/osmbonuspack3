package com.example.ronaldo.osmbonuspack2;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.osmdroid.api.IGeoPoint;
import org.osmdroid.api.IMapController;
import org.osmdroid.events.MapEventsReceiver;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.Projection;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.Polyline;

import java.util.ArrayList;

public class MainActivity extends Activity implements MapEventsReceiver, MapView.OnFirstLayoutListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    LocationManager locationManager;
    MapView map;
    private IMapController mapController;
    ArrayList<GeoPoint> l;
    Button position;
    Button reset;
    Marker startMarker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = (MapView) findViewById(R.id.map);
        position = (Button) findViewById(R.id.position);
        reset = (Button) findViewById(R.id.reset);
        mapController = map.getController();
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER, 1 * 1000, 1000,
                locationListener);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = locationManager
                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        GeoPoint startPoint = new GeoPoint(31.26531, 121.70664);
        map.setTileSource(new OnlineTileSourceBase("taixin:gaosu_polyline", 0, 15, 256, "",
                new String[]{"http://192.168.0.105:8080/geoserver/gwc/service/gmaps?layers=taixin:gaosu_polyline"}, "gaosu") {
            @Override
            public String getTileURLString(MapTile aTile) {
                return getBaseUrl() + "&zoom=" + aTile.getZoomLevel() + "&x=" + aTile.getX() + "&y=" + aTile.getY();
            }
        });
        mapController.setZoom(15);

        startMarker = new Marker(map);
        startMarker.setPosition(startPoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        startMarker.setTitle("Start point");
        startMarker.setDraggable(true);
        //  startMarker.setOnMarkerDragListener(new OnMarkerDragListenerDrawer());

        position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                i = 0;
                startMarker.setPosition(l.get(0));
                animateMarker(startMarker, null);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                i = 0;
                startMarker.setPosition(l.get(0));
                map.postInvalidate();
            }
        });
        Polyline pl = new Polyline();
        l = new ArrayList();
        l.add(new GeoPoint(31.26531, 121.70664));
        l.add(new GeoPoint(31.26462, 121.70698));
        l.add(new GeoPoint(31.26428, 121.70767));
        l.add(new GeoPoint(31.26393, 121.70767));
        l.add(new GeoPoint(31.26359, 121.70801));
        l.add(new GeoPoint(31.26325, 121.70801));
        l.add(new GeoPoint(31.2629, 121.70801));
        l.add(new GeoPoint(31.26256, 121.70801));
        l.add(new GeoPoint(31.26256, 121.70836));
        l.add(new GeoPoint(31.26222, 121.70836));
        l.add(new GeoPoint(31.26187, 121.70836));
        l.add(new GeoPoint(31.26153, 121.7087));
        l.add(new GeoPoint(31.26119, 121.7087));
        l.add(new GeoPoint(31.26119, 121.70904));
        l.add(new GeoPoint(31.26084, 121.70904));
        l.add(new GeoPoint(31.2605, 121.70939));
        l.add(new GeoPoint(31.26016, 121.70973));
        l.add(new GeoPoint(31.25981, 121.70973));
        l.add(new GeoPoint(31.25947, 121.71007));
        l.add(new GeoPoint(31.25913, 121.71007));
        l.add(new GeoPoint(31.25878, 121.71042));
        l.add(new GeoPoint(31.25844, 121.71042));
        l.add(new GeoPoint(31.2581, 121.71076));
        l.add(new GeoPoint(31.25775, 121.7111));
        l.add(new GeoPoint(31.25741, 121.7111));
        l.add(new GeoPoint(31.25707, 121.7111));
        l.add(new GeoPoint(31.25672, 121.71145));
        l.add(new GeoPoint(31.25638, 121.71145));
        l.add(new GeoPoint(31.25604, 121.71145));
        l.add(new GeoPoint(31.2557, 121.71179));
        l.add(new GeoPoint(31.25501, 121.71179));
        l.add(new GeoPoint(31.25467, 121.71179));
        l.add(new GeoPoint(31.25398, 121.71213));
        l.add(new GeoPoint(31.25364, 121.71213));
        l.add(new GeoPoint(31.25329, 121.71248));
        l.add(new GeoPoint(31.25261, 121.71282));
        l.add(new GeoPoint(31.25226, 121.71316));
        l.add(new GeoPoint(31.25192, 121.71316));
        l.add(new GeoPoint(31.25158, 121.71316));
        l.add(new GeoPoint(31.25123, 121.71316));
        l.add(new GeoPoint(31.25089, 121.71351));
        l.add(new GeoPoint(31.25055, 121.71385));
        l.add(new GeoPoint(31.2502, 121.71419));
        l.add(new GeoPoint(31.2502, 121.71454));
        l.add(new GeoPoint(31.24986, 121.71488));
        l.add(new GeoPoint(31.24952, 121.71522));
        l.add(new GeoPoint(31.24952, 121.71557));
        l.add(new GeoPoint(31.24917, 121.71625));
        l.add(new GeoPoint(31.24917, 121.7166));
        l.add(new GeoPoint(31.24883, 121.71728));
        pl.setPoints(l);
        map.getOverlays().add(pl);
        map.getOverlays().add(startMarker);

        map.getController().animateTo(startPoint);
    }

    @Override
    public boolean singleTapConfirmedHelper(GeoPoint p) {
        return false;
    }

    @Override
    public boolean longPressHelper(GeoPoint p) {
        return false;
    }

    @Override
    public void onFirstLayout(View v, int left, int top, int right, int bottom) {

    }

    private LocationListener locationListener = new LocationListener() {
        // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        // Provider被enable时触发此函数，比如GPS被打开
        @Override
        public void onProviderEnabled(String provider) {

        }

        // Provider被disable时触发此函数，比如GPS被关闭
        @Override
        public void onProviderDisabled(String provider) {

        }

        // 当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
        @Override
        public void onLocationChanged(Location location) {
            if (location != null) {
                GeoPoint geoPoint = new GeoPoint(location.getLatitude(), location.getLongitude());
                mapController.setCenter(geoPoint);
            }
        }
    };

    private class MyTask extends AsyncTask<String, Integer, String> {
        //onPreExecute方法用于在执行后台任务前做一些UI操作
        @Override
        protected void onPreExecute() {
        }

        //doInBackground方法内部执行后台任务,不可在此方法内修改UI
        @Override
        protected String doInBackground(String... params) {
            return null;
        }

        //onProgressUpdate方法用于更新进度信息
        @Override
        protected void onProgressUpdate(Integer... progresses) {
        }

        //onPostExecute方法用于在执行完后台任务后更新UI,显示结果
        @Override
        protected void onPostExecute(String result) {

        }

        //onCancelled方法用于在取消执行中的任务时更改UI
        @Override
        protected void onCancelled() {
        }
    }

    int i = 0;

    public void animateMarker(final Marker marker, final GeoPoint toPosition) {
        try {
            final Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (i < l.size()) {
                        marker.setPosition(l.get(i));
                        handler.postDelayed(this, 200);
                        map.postInvalidate();
                        i++;
                    } else {
                        handler.removeCallbacks(this);
                    }
                }
            };
            handler.postDelayed(runnable, 200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
