package com.hmkcode.android.sign.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.hmkcode.android.sign.JSONParser;
import com.hmkcode.android.sign.JavaMD5Hash;
import com.hmkcode.android.sign.SignInActivity;

import android.test.ActivityInstrumentationTestCase2;


public class SignInTest extends ActivityInstrumentationTestCase2 < SignInActivity > {

	public SignInTest() {
		super(SignInActivity.class);
	} 

	private JSONObject setParamsAndMakeHttpReq(String email, String password) throws Exception{
		JavaMD5Hash myMD5 = new JavaMD5Hash();

		JSONParser jParser = new JSONParser();
		  
		List<NameValuePair> params = new ArrayList<NameValuePair>();	  
		params.add(new BasicNameValuePair("email", email));
		String hashedPW = myMD5.md5(password);

		params.add(new BasicNameValuePair("password", hashedPW));
		
		JSONObject jsonLogin = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/check_login_credentials.php", "GET", params);
		JSONArray emailArray = jsonLogin.getJSONArray("email");
		JSONObject c = emailArray.getJSONObject(0);
		
		return c;
	}

	public void testInvalidCredentials() throws Exception{
		JSONObject c = setParamsAndMakeHttpReq("invalidEmail", "invalidPassword");
		
		assertEquals(Integer.parseInt(c.getString("email")), 0);
	}
	
	public void testValidCredentials() throws Exception{
		JSONObject c = setParamsAndMakeHttpReq("test@test.com", "test");
		
		assertEquals(Integer.parseInt(c.getString("email")), 1);
	}

}