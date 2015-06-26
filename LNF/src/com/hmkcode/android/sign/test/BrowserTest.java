package com.hmkcode.android.sign.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.test.ActivityInstrumentationTestCase2;

import com.hmkcode.android.sign.JSONParser;
import com.hmkcode.android.sign.Browser;

public class BrowserTest extends ActivityInstrumentationTestCase2 < Browser >
{
	public BrowserTest()
	{
		super(Browser.class);
	}
	
	private List<NameValuePair> setParams(String email, String findE, String lostE, String col, String loc, 
			String cat, String sCat, String com, String name, String desc, String size, String dateT){
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("color", col));
		params.add(new BasicNameValuePair("location", loc));
		params.add(new BasicNameValuePair("category", cat));
		params.add(new BasicNameValuePair("subcategory", sCat));
		params.add(new BasicNameValuePair("company", com));
		params.add(new BasicNameValuePair("name", name));
		params.add(new BasicNameValuePair("description", desc));
		params.add(new BasicNameValuePair("dateTime", dateT));
		params.add(new BasicNameValuePair("size", size));
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("finderEmail", findE));
		params.add(new BasicNameValuePair("ownerEmail", lostE));
		
		return params;
	}

	public void testAfterLostFormSubmit() throws Exception
	{
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "name"));
		params.add(new BasicNameValuePair("filterBy", "%"));
		JSONObject jsonObj = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		JSONArray items = jsonObj.getJSONArray("items");
		
		int num_list_before = items.length();
		
		/*(email, findE, lostE, col, loc, cat, sCat, com, name, desc, size, dateT)*/
		List<NameValuePair> params2 = setParams("admin@test.com", "", "", "red", "-36.597913896972855,12.656256034970284",
				"electronics", "laptop", "alienware", "Alienware M17x", "", "10", "2015-04-06 20:43:00");
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params2);
		
		JSONObject jsonObj2 = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		items = jsonObj2.getJSONArray("items");
		
		int num_list_after = items.length();
		
		//number of items should be increased for the browser
		assertEquals(num_list_before+1, num_list_after);
		
		List<NameValuePair> params3 = new ArrayList<NameValuePair>();
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "GET", params3);
		
	}
	
	public void testAfterFoundFormSubmit() throws Exception
	{
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "name"));
		params.add(new BasicNameValuePair("filterBy", "%"));
		JSONObject jsonObj = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		JSONArray items = jsonObj.getJSONArray("items");
		
		int num_list_before = items.length();
		
		/*(email, findE, lostE, col, loc, cat, sCat, com, name, desc, size, dateT)*/
		List<NameValuePair> params2 = setParams("admin@test.com", "", "", "red", "-36.597913896972855,12.656256034970284",
				"electronics", "laptop", "alienware", "Alienware M17x", "", "10", "2015-04-06 20:43:00");
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/foundForm.php", "POST", params2);
		
		JSONObject jsonObj2 = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		items = jsonObj2.getJSONArray("items");
		
		int num_list_after = items.length();
		
		//number of items should be same for the browser
		assertEquals(num_list_before, num_list_after);
		
		List<NameValuePair> params3 = new ArrayList<NameValuePair>();
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "GET", params3);
	}
	
	public void testSortDoesNotAffectResultSize() throws Exception {
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "name"));
		params.add(new BasicNameValuePair("filterBy", "%"));
		JSONObject jsonObj = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		JSONArray items = jsonObj.getJSONArray("items");
		
		int num_list_1 = items.length();
		
		params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "name"));
		jsonObj = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		items = jsonObj.getJSONArray("items");
		
		int num_list_2 = items.length();	
		assertEquals(num_list_1, num_list_2);
	}
	
	public void testSortNameTopOfList() throws Exception
	{
		JSONParser jParser = new JSONParser();
		
		/*(email, findE, lostE, col, loc, cat, sCat, com, name, desc, size, dateT)*/
		List<NameValuePair> params2 = setParams("admin@test.com", "", "", "red", "-36.597913896972855,12.656256034970284",
				"electronics", "laptop", "alienware", "AAAAAAAAAAA", "", "10", "2015-04-06 20:43:00");
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params2);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "name"));
		params.add(new BasicNameValuePair("filterBy", "%"));
		JSONObject jsonObj2 = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		JSONArray items = jsonObj2.getJSONArray("items");
		JSONObject c = items.getJSONObject(0);
		String desc = c.getString("name");
		assertEquals(desc, "AAAAAAAAAAA");
		
		
		List<NameValuePair> params3 = new ArrayList<NameValuePair>();
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "GET", params3);
	}	
	
	
	public void testSortNameBottomOfList() throws Exception
	{
		JSONParser jParser = new JSONParser();
		/*(email, findE, lostE, col, loc, cat, sCat, com, name, desc, size, dateT)*/
		List<NameValuePair> params2 = setParams("admin@test.com", "", "", "red", "-36.597913896972855,12.656256034970284",
				"electronics", "laptop", "alienware", "ZZZZZZZZZZ", "", "10", "2015-04-06 20:43:00");
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params2);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "name"));
		params.add(new BasicNameValuePair("filterBy", "%"));
		JSONObject jsonObj2 = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		JSONArray items = jsonObj2.getJSONArray("items");
		JSONObject c = items.getJSONObject(items.length()-1);
		String desc = c.getString("name");
		assertEquals(desc, "ZZZZZZZZZZ");
		
		List<NameValuePair> params3 = new ArrayList<NameValuePair>();
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "GET", params3);
	}	
	
	
	public void testSortTimeTopOfList() throws Exception
	{
		JSONParser jParser = new JSONParser();
		/*(email, findE, lostE, col, loc, cat, sCat, com, name, desc, size, dateT)*/
		List<NameValuePair> params2 = setParams("admin@test.com", "", "", "red", "-36.597913896972855,12.656256034970284",
				"electronics", "laptop", "alienware", "", "ZZZZZZZZZZ", "10", "2000-04-06 20:43:00");
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params2);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "time"));
		params.add(new BasicNameValuePair("filterBy", "%"));
		JSONObject jsonObj2 = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		JSONArray items = jsonObj2.getJSONArray("items");
		
		JSONObject c = items.getJSONObject(0);
		
		String dateTime = c.getString("time");
		assertEquals(dateTime, "2000-04-06 20:43:00");
		
		List<NameValuePair> params3 = new ArrayList<NameValuePair>();
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "GET", params3);
	}	
	
	public void testSortTimeBottomOfList() throws Exception
	{
		JSONParser jParser = new JSONParser();
		/*(email, findE, lostE, col, loc, cat, sCat, com, name, desc, size, dateT)*/
		List<NameValuePair> params2 = setParams("admin@test.com", "", "", "red", "-36.597913896972855,12.656256034970284",
				"electronics", "laptop", "alienware", "", "ZZZZZZZZZZ", "10", "2025-04-06 20:43:00");
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params2);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "time"));
		params.add(new BasicNameValuePair("filterBy", "%"));
		JSONObject jsonObj2 = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		JSONArray items = jsonObj2.getJSONArray("items");
		
		JSONObject c = items.getJSONObject(items.length()-1);
		
		String dateTime = c.getString("time");
		assertEquals(dateTime, "2025-04-06 20:43:00");
		
		List<NameValuePair> params3 = new ArrayList<NameValuePair>();
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "GET", params3);
	}	
	
	
	/////following tests are for filtering
	
	public void testFilterElectronics() throws Exception
	{
		JSONParser jParser = new JSONParser();
		/*(email, findE, lostE, col, loc, cat, sCat, com, name, desc, size, dateT)*/
		List<NameValuePair> params2 = setParams("admin@test.com", "", "", "red", "-36.597913896972855,12.656256034970284",
				"electronics", "laptop", "alienware", "", "ZZZZZZZZZZ", "10", "2025-04-06 20:43:00");
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params2);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "time"));
		params.add(new BasicNameValuePair("filterBy", "Electronics"));
		JSONObject jsonObj2 = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		JSONArray items = jsonObj2.getJSONArray("items");
		JSONObject c = items.getJSONObject(items.length()-1);
		String category = c.getString("category");
		
		assertEquals(category, "electronics");
		assertEquals(category, "electronics");
		
		List<NameValuePair> params3 = new ArrayList<NameValuePair>();
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "GET", params3);
	}	
	
	public void testFilterKeys() throws Exception
	{
		JSONParser jParser = new JSONParser();
		/*(email, findE, lostE, col, loc, cat, sCat, com, name, desc, size, dateT)*/
		List<NameValuePair> params2 = setParams("admin@test.com", "", "", "red", "-36.597913896972855,12.656256034970284",
				"keys", "", "", "", "ZZZZZZZZZZ", "10", "2025-04-06 20:43:00");
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params2);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "time"));
		params.add(new BasicNameValuePair("filterBy", "Keys"));
		JSONObject jsonObj2 = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		JSONArray items = jsonObj2.getJSONArray("items");
		
		JSONObject c = items.getJSONObject(items.length()-1);
		
		String category = c.getString("category");
		assertEquals(category, "keys");
		assertEquals(category, "keys");
		
		List<NameValuePair> params3 = new ArrayList<NameValuePair>();
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "GET", params3);
	}
	
	public void testFilterClothing() throws Exception
	{
		JSONParser jParser = new JSONParser();
		/*(email, findE, lostE, col, loc, cat, sCat, com, name, desc, size, dateT)*/
		List<NameValuePair> params2 = setParams("admin@test.com", "", "", "red", "-36.597913896972855,12.656256034970284",
				"clothing", "", "", "", "ZZZZZZZZZZ", "10", "2025-04-06 20:43:00");
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params2);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "time"));
		params.add(new BasicNameValuePair("filterBy", "Clothing"));
		JSONObject jsonObj2 = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		JSONArray items = jsonObj2.getJSONArray("items");
		
		JSONObject c = items.getJSONObject(items.length()-1);
		
		String category = c.getString("category");
		assertEquals(category, "clothing");
		assertEquals(category, "clothing");
		
		List<NameValuePair> params3 = new ArrayList<NameValuePair>();
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "GET", params3);
	}
	
	public void testFilterAccessories() throws Exception
	{
		JSONParser jParser = new JSONParser();
		/*(email, findE, lostE, col, loc, cat, sCat, com, name, desc, size, dateT)*/
		List<NameValuePair> params2 = setParams("admin@test.com", "", "", "red", "-36.597913896972855,12.656256034970284",
				"accessories", "", "", "", "ZZZZZZZZZZ", "10", "2025-04-06 20:43:00");
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params2);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "time"));
		params.add(new BasicNameValuePair("filterBy", "Accessories"));
		JSONObject jsonObj2 = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		JSONArray items = jsonObj2.getJSONArray("items");
		
		JSONObject c = items.getJSONObject(items.length()-1);
		
		String category = c.getString("category");
		assertEquals(category, "accessories");
		assertEquals(category, "accessories");
		
		List<NameValuePair> params3 = new ArrayList<NameValuePair>();
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "GET", params3);
	}		
	
	public void testFilterBackpack() throws Exception
	{
		JSONParser jParser = new JSONParser();
		/*(email, findE, lostE, col, loc, cat, sCat, com, name, desc, size, dateT)*/
		List<NameValuePair> params2 = setParams("admin@test.com", "", "", "red", "-36.597913896972855,12.656256034970284",
				"backpack", "", "", "", "ZZZZZZZZZZ", "10", "2025-04-06 20:43:00");
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/lostForm.php", "POST", params2);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", "time"));
		params.add(new BasicNameValuePair("filterBy", "Backpack"));
		JSONObject jsonObj2 = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);
		
		JSONArray items = jsonObj2.getJSONArray("items");
		
		JSONObject c = items.getJSONObject(items.length()-1);
		
		String category = c.getString("category");
		assertEquals(category, "backpack");
		assertEquals(category, "backpack");
		
		List<NameValuePair> params3 = new ArrayList<NameValuePair>();
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/delete_test.php", "GET", params3);
	}		
}
