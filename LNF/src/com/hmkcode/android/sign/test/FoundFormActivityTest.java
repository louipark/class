package com.hmkcode.android.sign.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.hmkcode.android.sign.JSONParser;
import com.hmkcode.android.sign.SignInActivity;

import android.test.ActivityInstrumentationTestCase2;


public class FoundFormActivityTest extends ActivityInstrumentationTestCase2 < SignInActivity > {

public FoundFormActivityTest() {

  super(SignInActivity.class);
 }

	private List<NameValuePair> setParams(String email, String findE, String lostE, String col, String loc, 
			String cat, String sCat, String com, String name, String size, String dateT){
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("color", col));
		params.add(new BasicNameValuePair("location", loc));
		params.add(new BasicNameValuePair("category", cat));
		params.add(new BasicNameValuePair("subcategory", sCat));
		params.add(new BasicNameValuePair("company", com));
		params.add(new BasicNameValuePair("name", name));
		params.add(new BasicNameValuePair("dateTime", dateT));
		params.add(new BasicNameValuePair("size", size));
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("finderEmail", findE));
		params.add(new BasicNameValuePair("ownerEmail", lostE));
		
		return params;
	}

public void addFoundForm() throws Exception {
	
	JSONParser jParser = new JSONParser();
	/*(email, findE, lostE, col, loc, cat, sCat, com, name, size, dateT)*/
	List<NameValuePair> params = setParams("admin@test.com", "", "", "red", "40.689060, -74.044636", "electronics", 
			"laptop", "alienware", "Alienware M17x", "10", "2015-04-02 00:00:00");
	JSONObject jsonRegister = jParser.makeHttpRequest(
			"http://lostandfound.web.engr.illinois.edu/foundForm.php", "POST", params);
	
	
	//super.setUp();
}

public void testFoundFormSubmission() throws Exception{
	
	addFoundForm();
	
	JSONParser jParser2 = new JSONParser();
	List<NameValuePair> params2 = setParams("", "admin@test.com", "", "red", "40.689060, -74.044636", 
			"electronics", "laptop", "alienware", "Alienware M17x", "", "2015-04-02 00:00:00");
	
	JSONObject jsonForm = jParser2.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/check_item_exists.php", "GET", params2);
	
	JSONArray formArray = jsonForm.getJSONArray("email");
	JSONObject object = formArray.getJSONObject(0);
	
	System.out.print(Integer.parseInt(object.getString("email")));
	assertEquals(1, Integer.parseInt(object.getString("email")));
	 
	deleteMockFormData();
} 

public void deleteMockFormData() throws Exception {
	
	JSONParser jParser3 = new JSONParser();
	List<NameValuePair> params3 = new ArrayList<NameValuePair>();	  

	JSONObject jsonForm = jParser3.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "POST", params3);
	
	//super.tearDown();
}

}