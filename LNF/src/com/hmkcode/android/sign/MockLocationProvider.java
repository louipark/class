package com.hmkcode.android.sign;

import android.location.Location;
import android.location.LocationManager;

public class MockLocationProvider
{
	public static Location getMockLocation(double latitude, double longitude)
	{
		Location location = new Location(LocationManager.GPS_PROVIDER);
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		return location;
	}

}
