package com.hmkcode.android.sign.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.test.ActivityInstrumentationTestCase2;

import com.hmkcode.android.sign.DisplayItemActivity;
import com.hmkcode.android.sign.JSONParser;

public class EmailTest extends ActivityInstrumentationTestCase2 < DisplayItemActivity >
{
	public EmailTest()
	{
		super(DisplayItemActivity.class);
	}
	
	public void addLostForm() throws Exception
	{	
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", "admin@test.com"));
		params.add(new BasicNameValuePair("color", "red"));
		params.add(new BasicNameValuePair("location", "40.689060, -74.044636"));
		params.add(new BasicNameValuePair("category", "electronics"));
		params.add(new BasicNameValuePair("subcategory", "laptop"));
		params.add(new BasicNameValuePair("company", "alienware"));
		params.add(new BasicNameValuePair("name", "Alienware M17x"));
		params.add(new BasicNameValuePair("size", "10"));
		params.add(new BasicNameValuePair("dateTime", "2015-04-02 00:00:00"));
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params);
	}
	
	public void addLostForm2() throws Exception
	{	
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", "test@test.com"));
		params.add(new BasicNameValuePair("color", "white"));
		params.add(new BasicNameValuePair("location", "65.231, 21.19894"));
		params.add(new BasicNameValuePair("category", "electronics"));
		params.add(new BasicNameValuePair("subcategory", "laptop"));
		params.add(new BasicNameValuePair("company", "Acer"));
		params.add(new BasicNameValuePair("name", "Acer"));
		params.add(new BasicNameValuePair("size", "10"));
		params.add(new BasicNameValuePair("dateTime", "2015-03-14 00:00:00"));
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params);
	}
	
	public void addLostForm3() throws Exception
	{	
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", "test@admin.com"));
		params.add(new BasicNameValuePair("color", "blue"));
		params.add(new BasicNameValuePair("location", "123.489, -32.234527"));
		params.add(new BasicNameValuePair("category", "electronics"));
		params.add(new BasicNameValuePair("subcategory", "laptop"));
		params.add(new BasicNameValuePair("company", "alienware"));
		params.add(new BasicNameValuePair("name", "Apple"));
		params.add(new BasicNameValuePair("size", "Apple"));
		params.add(new BasicNameValuePair("dateTime", "2015-02-23 00:00:00"));
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params);
	}


	public void testOwnerEmail() throws Exception
	{	
		addLostForm();
		
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject jsonDetails = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_last_added_item.php", "GET", params);
		
		JSONArray detailsArray = jsonDetails.getJSONArray("details");
		JSONObject c = detailsArray.getJSONObject(0);
		
		String ownerEmail = (String) c.get("ownerEmail");
		
		assertEquals("admin@test.com", ownerEmail);
		
		deleteMockFormData();
	} 
	
	public void testOwnerEmail2() throws Exception
	{	
		addLostForm2();
		
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject jsonDetails = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_last_added_item.php", "GET", params);
		
		JSONArray detailsArray = jsonDetails.getJSONArray("details");
		JSONObject c = detailsArray.getJSONObject(0);
		
		String ownerEmail = (String) c.get("ownerEmail");
		
		assertEquals("test@test.com", ownerEmail);
		
		deleteMockFormData();
	}
	
	public void testOwnerEmail3() throws Exception
	{	
		addLostForm3();
		
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject jsonDetails = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_last_added_item.php", "GET", params);
		
		JSONArray detailsArray = jsonDetails.getJSONArray("details");
		JSONObject c = detailsArray.getJSONObject(0);
		
		String ownerEmail = (String) c.get("ownerEmail");
		
		assertEquals("test@admin.com", ownerEmail);
		
		deleteMockFormData();
	}

	public void deleteMockFormData() throws Exception
	{
		
		JSONParser jParser3 = new JSONParser();
		List<NameValuePair> params3 = new ArrayList<NameValuePair>();	  

		JSONObject jsonForm = jParser3.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "POST", params3);
		
		
		//super.tearDown();
	}
	
}
