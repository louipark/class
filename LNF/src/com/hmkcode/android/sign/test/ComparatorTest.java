package com.hmkcode.android.sign.test;

import com.hmkcode.android.sign.Comparator;

import android.test.ActivityInstrumentationTestCase2;


public class ComparatorTest extends ActivityInstrumentationTestCase2 <LostFormActivity> {

	public ComparatorTest() {
		super(LostFormActivity.class);
	}
	
	public void testLocationTooFar() throws Exception{
		
		Comparator cm = new Comparator();
		
		String color = "White";
		String desc = "Acer Laptop";
		String time = "2015-04-10 18:59:00";
		String location = "39.431547621861135,-122.08752829581498";
		
		String[] ret = cm.compare(location, desc, color, time, "found", "test@test.com");
		
		int returnID = Integer.parseInt(ret[0]);
		assertEquals(returnID, -1);
		
		
	}
	
	public void testColorDifferent() throws Exception{
		
		Comparator cm = new Comparator();
		
		String color = "Black";
		String desc = "Acer Laptop";
		String time = "2015-04-10 18:59:00";
		String location = "37.431547621861135,-122.08752829581498";
		
		String[] ret = cm.compare(location, desc, color, time, "found", "test@test.com");
		
		int returnID = Integer.parseInt(ret[0]);
		assertEquals(returnID, -1);
		
	}
	
	public void testDescDifferent() throws Exception{
		
		Comparator cm = new Comparator();
		
		String color = "White";
		String desc = "Dell Laptop";
		String time = "2015-04-10 18:59:00";
		String location = "37.431547621861135,-122.08752829581498";
		
		String[] ret = cm.compare(location, desc, color, time, "found", "test@test.com");
		
		int returnID = Integer.parseInt(ret[0]);
		assertEquals(returnID, -1);
		
	}
	
	public void testTimeInvalid() throws Exception{
		
		Comparator cm = new Comparator();
		
		String color = "White";
		String desc = "Acer Laptop";
		String time = "2015-04-10 17:55:00";
		String location = "37.431547621861135,-122.08752829581498";
		
		String[] ret = cm.compare(location, desc, color, time, "found", "test@test.com");
		
		int returnID = Integer.parseInt(ret[0]);
		assertEquals(returnID, -1);
		
	}
	
	public void testSuccess() throws Exception{
		
		Comparator cm = new Comparator();
		
		String color = "White";
		String desc = "Acer Laptop";
		String time = "2015-04-10 18:56:00";
		String location = "37.431547621861135,-122.08752829581498";
		
		String[] ret = cm.compare(location, desc, color, time, "found", "test@test.com");
		
		boolean isMatch = false;
		int returnID = Integer.parseInt(ret[0]);
		if (returnID != -1) {
			isMatch = true;
		}
		assertEquals(isMatch, true);
	}
}