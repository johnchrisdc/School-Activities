package com.potato.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoComplete extends Activity {

	AutoCompleteTextView auto;
	private ArrayAdapter<String> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.autocomplete);
		//The autobotz
	    auto = (AutoCompleteTextView)findViewById(R.id.auto);
	    
	    
	    //The array
		String [] lol = getResources().getStringArray(R.array.colorList);

		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lol);

		auto.setAdapter(adapter);
	}
	
}
