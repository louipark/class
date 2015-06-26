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
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

public class ViewMatched extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_matched);
		
	    TableLayout tl = (TableLayout) findViewById(R.id.BrowserMatch);
	    TableRow tr = new TableRow(this);
	    LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	    tr.setLayoutParams(lp);
	    
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		
		params.add(getUser());
		
		JSONObject otherJSON = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_matched_reports.php", "GET", params);
		
		
        try {	
            JSONArray items = otherJSON.getJSONArray("items");
                       
		        for (int i = 0; i < items.length(); i++) {
		            JSONObject c = items.getJSONObject(i);
		            
		            final String id = c.getString("id");
		            String name = c.getString("name");
		            String time = c.getString("time");
		            
		            tr = new TableRow(this);
		    	    tr.setLayoutParams(lp);
		    	   
		            
		    	    Button btnDetails = new Button(this);
		    	    btnDetails.setLayoutParams(lp);
		    	    btnDetails.setText("Details");
		    	    btnDetails.setOnClickListener(new Button.OnClickListener() {
	
		    	    public void onClick(View v) {
		    	            Intent myIntent = new Intent(v.getContext(), DisplayItemActivity.class);
		    	            myIntent.putExtra("key", id);
		    	            startActivity(myIntent);
		    	        }
		    	    });
		    	    
		    	    TextView tvName = new TextView(this);
		    	    tvName.setLayoutParams(lp);
		    	    tvName.setText(name);
		    	    
		    	    TextView tvTime = new TextView(this);
		    	    tvTime.setLayoutParams(lp);
		    	    tvTime.setText(time);	    
		    	    
		    	    
		    	    tr.addView(btnDetails);
		    	    tr.addView(tvName);
		    	    tr.addView(tvTime);
	
		    	    
		    	    tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));	  
		            
		       
            }
		} catch (JSONException e) {
			e.printStackTrace();
		}		
	}
	
	public BasicNameValuePair getUser(){
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		String loggedInAs = preferences.getString("User","");
		BasicNameValuePair user = new BasicNameValuePair("email", loggedInAs);
		return user;
	}
}
