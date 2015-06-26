package com.hmkcode.android.sign;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
    }

	@SuppressLint("NewApi")
	public void register(View view){
		  EditText email = (EditText)findViewById(R.id.etEmail);
		  EditText username = (EditText)findViewById(R.id.etUserName);
		  EditText password = (EditText)findViewById(R.id.etPass);
		  JSONParser jParser = new JSONParser();
		  
		  List<NameValuePair> params = new ArrayList<NameValuePair>();
		  
		  JavaMD5Hash myMD5 = new JavaMD5Hash();
		 
		  
		  try {
			  params.add(new BasicNameValuePair("email", email.getText().toString()));
			  JSONObject jsonEmail = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/check_if_email_in_use.php", "GET", params);
			  JSONArray emailArray = jsonEmail.getJSONArray("email");
			  JSONObject c = emailArray.getJSONObject(0);
			  if (Integer.parseInt(c.getString("email")) > 0) {
				  Toast.makeText(getApplicationContext(), "Email already in use", Toast.LENGTH_LONG).show();
			  }
			  else {
				  params = new ArrayList<NameValuePair>();
				  params.add(new BasicNameValuePair("email", email.getText().toString()));
				  params.add(new BasicNameValuePair("user", username.getText().toString()));
				  
				  String hashedPW = myMD5.md5(password.getText().toString());

				  params.add(new BasicNameValuePair("password", hashedPW));
				 				  
				  
				  JSONObject jsonRegister = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/register.php", "POST", params);
				  Toast.makeText(getApplicationContext(), "Account successfully created", Toast.LENGTH_LONG).show();
				    
				  Intent intent = new Intent(this, MainActivity.class);
				  startActivity(intent);					  
			  }		
		  } catch (JSONException e) {
			  e.printStackTrace();
		  }    
	}
	
	public void login(View view) {
		
	}
	
	
    
}
