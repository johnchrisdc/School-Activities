package com.potato.activity.calculator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class Result extends Activity {
	
	TextView lol;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    lol = new TextView(getBaseContext());
	    lol.setTextColor(Color.BLACK);
	    
	    lol.setGravity(Gravity.CENTER);
	    lol.setTextSize(18.0f);
	    
	    //Ahhh getIntent() pala dapat hindi new Intent()
	    Intent i = getIntent();
	    lol.setText(i.getStringExtra(Calculator.THE_DATA));
	     
	    setContentView(lol);
	}

}
