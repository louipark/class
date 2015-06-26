package com.hmkcode.android.sign.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.test.ActivityInstrumentationTestCase2;

import com.hmkcode.android.sign.AccountSettingsActivity;
import com.hmkcode.android.sign.JSONParser;
import com.hmkcode.android.sign.JavaMD5Hash;

public class AccountSettingsActivityTest extends ActivityInstrumentationTestCase2 < AccountSettingsActivity >
{
	public AccountSettingsActivityTest()
	{
		super(AccountSettingsActivity.class);
	}
	
	private List<NameValuePair> setParams(String email, String password){
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));
		return params;
	}

	public void testValidPasswordChange() throws Exception
	{
		JSONParser jParser = new JSONParser();
		
		List<NameValuePair> params = setParams("admin@test.com", "1");
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/update_password.php", "POST", params);
	    
	    JSONObject jsonLogin = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/check_login_credentials.php", "GET", params);
		JSONArray emailArray = jsonLogin.getJSONArray("email");
		JSONObject c = emailArray.getJSONObject(0);
		
		assertEquals(0, Integer.parseInt(c.getString("email")));
	}
	
	public void testCheckHashing() throws Exception
	{
		JavaMD5Hash myMD5 = new JavaMD5Hash();
		JSONParser jParser = new JSONParser();
		
		String hashedPW = myMD5.md5("1");
		List<NameValuePair> params = setParams("admin@test.com", hashedPW);
		jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/update_password.php", "POST", params);
		    
		List<NameValuePair> params2 = setParams("admin@test.com", "1");
		
		JSONObject jsonLogin = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/check_login_credentials.php", "GET", params2);
		JSONArray emailArray = jsonLogin.getJSONArray("email");
		JSONObject c = emailArray.getJSONObject(0);
		
		assertEquals(0, Integer.parseInt(c.getString("email")));
	}
}