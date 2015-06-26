package com.hmkcode.android.sign;


import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class FoundFormActivity extends Activity{
	private Spinner spnrColor;
	private Spinner spnrCat;
	private Spinner spnrSubCat;
	private Spinner spnrCompany;
	private Spinner spnrSize;
	private String email;
	private EditText descF;
	private EditText otherCat;
	private EditText otherCompany;
	private EditText make;
	private DatePicker date;
	private TimePicker time;
	//private Spinner spnrPlace;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_found_form);
		
		addListenerOnSpinnerItemSelection();
	}

	private void addListenerOnSpinnerItemSelection() {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		email = preferences.getString("User","");
		
		descF = (EditText)findViewById(R.id.descF);
		otherCat = (EditText)findViewById(R.id.etCat);
		otherCompany = (EditText)findViewById(R.id.etCompany);
		spnrCat =  (Spinner) findViewById(R.id.spnrCat);
		spnrSubCat =  (Spinner) findViewById(R.id.spnrSubCat);
		spnrColor = (Spinner) findViewById(R.id.spnrColor);
		spnrCompany = (Spinner) findViewById(R.id.spnrCompany);
		make = (EditText)findViewById(R.id.make);
		spnrSize = (Spinner) findViewById(R.id.spnrSize);
		time = (TimePicker) findViewById(R.id.timeP);
		date = (DatePicker) findViewById(R.id.dateP);
		//spnrPlace = (Spinner) findViewById(R.id.spnrPlace);		
	}
	
	public void submitForm(View view){
		String cat = spnrCat.getSelectedItem().toString();
		String company = spnrCompany.getSelectedItem().toString();
		
		Form f = new Form();
		if (f.validate(descF.getText().toString(), cat, spnrSubCat.getSelectedItem().toString(), company)){
			Toast.makeText(getApplicationContext(), "Information successfully added", Toast.LENGTH_LONG).show();
			
			Intent intent = new Intent(this, MapActivity.class);
			
			intent.putExtra("email", email);
			if(cat.equals("Other")){
				intent.putExtra("category", otherCat.getText().toString());
			}else{
				intent.putExtra("category", spnrCat.getSelectedItem().toString());
			}
			intent.putExtra("subcategory", spnrSubCat.getSelectedItem().toString());
			intent.putExtra("color", spnrColor.getSelectedItem().toString());
			if (company.equals("Other")){
				intent.putExtra("company", otherCompany.getText().toString());
			}else{
				intent.putExtra("company", spnrCompany.getSelectedItem().toString());
			}
			intent.putExtra("make", make.getText().toString());
			intent.putExtra("size", spnrSize.getSelectedItem().toString());
			
			int day = date.getDayOfMonth();
			int month = date.getMonth() + 1;
			int year = date.getYear();
			String d = ""+year+"-"+month+"-"+day;
			intent.putExtra("date", d);
			
			time.setIs24HourView(true);
			int hour = time.getCurrentHour();
			int minute = time.getCurrentMinute();
			String t = ""+hour+":"+minute+":00";
			intent.putExtra("time", t);
			
			intent.putExtra("desc", descF.getText().toString());
			
			intent.putExtra("lost_found", "found");
			
			startActivity(intent);
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Invalid Form, please try again", Toast.LENGTH_LONG).show();
		}
	}
}