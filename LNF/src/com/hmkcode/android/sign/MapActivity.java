package com.hmkcode.android.sign;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v4.app.FragmentActivity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MapActivity class
 * This Activity is used for running Google Map API in order to get the location of items
 * @author Ryan
 */
public class MapActivity extends FragmentActivity implements LocationListener, OnMapClickListener
{
    GoogleMap googleMap;
    LatLng curr_point = null;
    
    //variables from the previous form(LostForm Activity, FoundForm Activity)
    String email;
	String category;
	String subcategory;
	String color;
	String company;
	String make;
	String size;
	String lost_found;
	String date;
	String time;
	String loggedInAs;
	String desc;
	
	//latitude and longitude for the location
	double latitude;
	double longitude;
	
	/**
	 * Function that runs as soon as the MapActivity is accessed
	 * 1. Get reference to the SupportMapFragment of activity_map.xml
	 * 2. Get GoogleMap object from the fragment
	 * 3. Enable MyLocation Layer of Google Map
	 * 4. Get LocationManager object from System Service LOCATION_SERVICE
	 * 5. Create a criteria object to retrieve provider
	 * 6. Get the name of the best provider
	 * 7. Get Current Location
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
        
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		String loggedInAs = preferences.getString("User","");
        
        
        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            email = extras.getString("email");
            category = extras.getString("category");
        	subcategory = extras.getString("subcategory");
        	color = extras.getString("color");
        	company = extras.getString("company");
        	make = extras.getString("make");
        	size = extras.getString("size");
        	date = extras.getString("date");
        	time = extras.getString("time");
        	lost_found = extras.getString("lost_found");
        	desc = extras.getString("desc");
        }

        //Google Play Services are not available
        if(status!=ConnectionResult.SUCCESS)
        {

            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();

        }
        //Google Play Services are available
        else
        { 
            
            SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);            
            googleMap = fm.getMap();
            googleMap.setMyLocationEnabled(true);
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            String provider = locationManager.getBestProvider(criteria, true);
            Location location = locationManager.getLastKnownLocation(provider);
            if(location!=null)
            {
                onLocationChanged(location);
            }
            locationManager.requestLocationUpdates(provider, 20000, 0, this);
            googleMap.setOnMapClickListener(this);
            googleMap.getUiSettings().setZoomControlsEnabled(true);
        }
	}
	
	
	/**
	 * Function that is called whenever new GPS location is detect by the system
	 * 1. It gets the location and move the camera to that location
	 * 2. Zoom is fixed
	 */
	@Override
    public void onLocationChanged(Location location)
	{
		TextView tvLocation = null;
		
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        
        LatLng latLng = new LatLng(latitude, longitude);
        
		try
		{
			tvLocation = (TextView) findViewById(R.id.tv_location);
	        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
	        googleMap.animateCamera(CameraUpdateFactory.zoomTo(14));
	        
	        tvLocation.setText("Latitude:" +  latitude  + ", Longitude:"+ longitude );
		}
		catch(Exception e)
		{
			
		}
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public void onMapClick(LatLng point) {
		curr_point = point;
		googleMap.clear();
		googleMap.addMarker(new MarkerOptions()
        .position(point)
        .title(point.toString()));
		Toast.makeText(getApplicationContext(),
                "New marker added@" + point.toString(), Toast.LENGTH_LONG)
                .show();
		Double.toString(point.latitude);
		Double.toString(point.longitude);
	}
	
	/**
	 * Function that submits the form
	 * 1. Access php file with proper parameters
	 * 2. Save data in the SQL database
	 * @param view
	 */
	public void submitForm(View view)
	{
		Toast.makeText(getApplicationContext(), curr_point.toString(), Toast.LENGTH_LONG).show();
		
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		String lat_long = Double.toString(curr_point.latitude) + "," + Double.toString(curr_point.longitude);
		
		params.add(new BasicNameValuePair("location", lat_long));
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("category", category));
		params.add(new BasicNameValuePair("subcategory", subcategory));
		params.add(new BasicNameValuePair("color", color));
		params.add(new BasicNameValuePair("company", company));
		params.add(new BasicNameValuePair("make", make));
		params.add(new BasicNameValuePair("size", size));
		params.add(new BasicNameValuePair("dateTime", date+" "+time));
		params.add(new BasicNameValuePair("desc", desc));
		
		String name = company + ' ' + subcategory;		
		params.add(new BasicNameValuePair("name", name));
			
		//check whether LostFormActivity or FoundFormActivity accessed current MapActivity
		if (curr_point != null)
		{
			Comparator cmp = new Comparator();
			String[] cmpResult;
			if(lost_found.equals("lost"))
			{
				jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params);
				cmpResult = cmp.compare(lat_long, name, color, date+" "+time, "lost", loggedInAs);
			}
			else
			{
				jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/foundForm.php", "POST", params);
				cmpResult = cmp.compare(lat_long, name, color, date+" "+time, "found", loggedInAs);
			}
			
				int ID = Integer.parseInt(cmpResult[0]);
			if (ID != -1) {
				params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("id", cmpResult[0]));
				params.add(new BasicNameValuePair("email1", email));
				params.add(new BasicNameValuePair("email2", cmpResult[1]));
				
				jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/create_notification.php", "POST", params);
			}
			
			Toast.makeText(getApplicationContext(), "Form successfully added", Toast.LENGTH_LONG).show();
			
			
			Intent intent = new Intent(this, HomeActivity.class);
			startActivity(intent);	
		}
		else
		{
			Toast.makeText(getApplicationContext(), "You didn't select the position.", Toast.LENGTH_LONG).show();
		}
	}
	
	public double getLatitude()
	{
		return latitude;
	}
	
	public double getLongitude()
	{
		return longitude;
	}

}