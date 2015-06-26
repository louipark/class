package com.hmkcode.android.sign;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

public class SignInActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);
    }
    
    @SuppressLint("NewApi")
	public void login(View view){
		  EditText email = (EditText)findViewById(R.id.etEmail);
		  EditText password = (EditText)findViewById(R.id.etPass);
		  JavaMD5Hash myMD5 = new JavaMD5Hash();

		  JSONParser jParser = new JSONParser();
		  
		  List<NameValuePair> params = new ArrayList<NameValuePair>();	  
		    params.add(new BasicNameValuePair("email", email.getText().toString()));
			String hashedPW = myMD5.md5(password.getText().toString());

			params.add(new BasicNameValuePair("password", hashedPW));
		    
		    
		    JSONObject jsonLogin = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/check_login_credentials.php", "GET", params);
		    
			try {
				JSONArray emailArray = jsonLogin.getJSONArray("email");
				JSONObject c = emailArray.getJSONObject(0);
				if (Integer.parseInt(c.getString("email")) > 0) {
			        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
			        SharedPreferences.Editor editor = preferences.edit();
			        editor.putString("User", email.getText().toString());
			        editor.apply();
			        
					
					Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
					startActivity(intent);
					
				}
				else {
					Toast.makeText(getApplicationContext(), "Invalid login", Toast.LENGTH_LONG).show();
				}		
			} catch (JSONException e) {
				e.printStackTrace();
			}
    }
  
}
