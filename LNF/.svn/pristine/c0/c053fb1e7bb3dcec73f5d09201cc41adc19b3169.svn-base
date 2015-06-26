package com.hmkcode.android.sign.test;

import android.location.Location;

import com.hmkcode.android.sign.MapActivity;
import com.hmkcode.android.sign.MockLocationProvider;

import junit.framework.TestCase;

public class MapActivityTest extends TestCase
{
	//test whether gps is properly stored in the system
	public void testGPS() throws Exception
	{
		//create fake gps location
		MockLocationProvider moc = new MockLocationProvider();
		Location location = moc.getMockLocation(1.234, 3.456);
		
		MapActivity map_act = new MapActivity(); 
		
		//send emulator the fake location that is created
		map_act.onLocationChanged(location);
		
		//check whether emulator has gps location that I provided
		double latitude = map_act.getLatitude();
		double longitude = map_act.getLongitude();
		
		assertEquals(latitude, 1.234);
		assertEquals(longitude, 3.456);
	}
}
