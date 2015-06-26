package com.hmkcode.android.sign;


import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

public class Browser extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browser);
		
		
		
		  SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		  String sortBy = preferences.getString("SortBy","");
		  String filterBy = preferences.getString("FilterBy","");
		  
		  if (sortBy.length() == 0) {
			  sortBy = "time";
		  }
		  if (filterBy.length() == 0 || filterBy.equals("All")) {
			  filterBy = "%";
		  }
		
	    TableLayout tl = (TableLayout) findViewById(R.id.Browser);
	    TableRow tr = new TableRow(this);
	    LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	    tr.setLayoutParams(lp);
	    
	    int numRows = tl.getChildCount();
	    
/*	    if (numRows > 2) {
	    for(int i = 2; i < numRows; i++){ 
	        TableRow row = (TableRow) tl.getChildAt(i); 
	       tl.removeView(row); 
	    } 
	    }*/
	    
		JSONParser jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("orderBy", sortBy));
		params.add(new BasicNameValuePair("filterBy", filterBy));
		JSONObject jsonDrinks = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/get_list_of_all_lost_reports.php", "GET", params);

/*		if (jsonDrinks.length() == 0) {
			tr = new TableRow(this);
			tr.setLayoutParams(lp);
			TextView tv = new TextView(this);
			tv.setLayoutParams(lp);
			tv.setText("nothing");
			tr.addView(tv);
    	    tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));	  

			return;
		}*/
        try {	
            JSONArray items = jsonDrinks.getJSONArray("items");
    	//	Toast.makeText(getApplicationContext(), Integer.toString(jsonDrinks.length()), Toast.LENGTH_LONG).show();

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
	
	@SuppressLint("NewApi")
	public void refresh(View view) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
	    SharedPreferences.Editor editor = preferences.edit();
	    
		  Spinner spinnerSort = (Spinner)findViewById(R.id.spinner1);
		  String orderBy = spinnerSort.getSelectedItem().toString();
	    editor.putString("SortBy", orderBy);
	   
		  Spinner spinnerFilter = (Spinner)findViewById(R.id.spinner2);
		  String filterBy = spinnerFilter.getSelectedItem().toString();
		  
	    editor.putString("FilterBy", filterBy);
	    editor.apply();
	    
	    TableLayout tl = (TableLayout) findViewById(R.id.Browser);
	    tl.removeAllViews();
	    
	    finish();
	    startActivity(getIntent());
	}
}
