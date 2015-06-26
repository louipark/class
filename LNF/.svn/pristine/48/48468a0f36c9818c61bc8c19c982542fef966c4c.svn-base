package com.hmkcode.android.sign;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayItemActivity extends Activity {

	String name;
	String ownerEmail;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_item);
		
		Bundle extras = getIntent().getExtras();
		String key = "";
		if (extras != null) {
		    key = extras.getString("key");
		}
		showDetails(key);
	}
	
	private void setSelectField(JSONObject obj, String fieldNameJSON, String fieldName, int id){
		String s = "";
		try{
			s = (String) obj.get(fieldNameJSON);
		}catch(JSONException e){
			e.printStackTrace();
		}
		s = fieldName + s;
		TextView selection = (TextView)findViewById(id);
		selection.setText(s);
	}
	
	public void showDetails(String key){
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		params.add(new BasicNameValuePair("key", key));

		JSONObject jsonDetails = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_lost_item_details.php", "GET", params);
		
		try {
			JSONArray detailsArray = jsonDetails.getJSONArray("details");
			JSONObject c = detailsArray.getJSONObject(0);
			
			setSelectField(c, "name", "", R.id.name);
			
			setSelectField(c, "description", "    Description :   ", R.id.description);
			
			setSelectField(c, "color", "    Color :   ", R.id.color);
			
			setSelectField(c, "time", "    Time :   ", R.id.time);
			
			setSelectField(c, "ownerEmail", "    OwnerEmail :   ", R.id.finderEmail);
			
			setSelectField(c, "categoryName", "    Category :   ", R.id.categoryName);
			
			setSelectField(c, "subcategoryName", "    Subcategory :   ", R.id.subcategoryName);
			
			setSelectField(c, "companyName", "    Company :   ", R.id.companyName);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void sendEmail(View view){
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND); 
		emailIntent.setType("plain/text"); 
		String aEmailList[] = { ownerEmail };  
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList); 
		String subject = "Lost_And_Found(" + name + ")";
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
		startActivity(Intent.createChooser(emailIntent, "Send email..."));
	}
}
