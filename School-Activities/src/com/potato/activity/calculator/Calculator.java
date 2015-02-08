package com.potato.activity.calculator;

import com.potato.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Calculator extends Activity {
	
	public static final String THE_DATA = "com.potato.activity.calculator.Calculator";

	EditText num1, num2; //Hirap mag type :P
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.calculator);
	    //Set layout muna coz we can't find the kung ano man tawag dito child ba
	    //or kung ano if we do not declare the layout first
	    
	    num1 = (EditText)findViewById(R.id.editText1);
	    num2 = (EditText)findViewById(R.id.editText2);
	    
	}

	//Hindi tayo pwedeng gumamit ng OnResume (wag daw mag Advance so dito natin kunin ung value)
	
	public void add(View v) {
		//Super shortcut WTF
		//Not advisable mga pogi lang gumagawa nito
		Intent i = new Intent(this,Result.class);
		
		int ans = Integer.valueOf(num1.getText().toString()) 
				+ Integer.valueOf(num2.getText().toString());
		
		i.putExtra(THE_DATA, "The sum is " + ans);
		startActivity(i);
	}
	
	public void minus(View v) {
		//Super shortcut WTF
		//Not advisable mga pogi lang gumagawa nito
		Intent i = new Intent(this,Result.class);
		int ans = Integer.valueOf(num1.getText().toString()) 
				- Integer.valueOf(num2.getText().toString());
		
		i.putExtra(THE_DATA, "The difference is " + ans);
		startActivity(i);
	}
	
	public void multi(View v) {
		//Super shortcut WTF
		//Not advisable mga pogi lang gumagawa nito
		Intent i = new Intent(this,Result.class);
		int ans = Integer.valueOf(num1.getText().toString()) 
				* Integer.valueOf(num2.getText().toString());
		
		i.putExtra(THE_DATA, "The product is " + ans);
		startActivity(i);
	}
	
	public void divi(View v) {
		//Super shortcut WTF
		//Not advisable mga pogi lang gumagawa nito
		Intent i = new Intent(this,Result.class);
		int ans = Integer.valueOf(num1.getText().toString()) 
				/ Integer.valueOf(num2.getText().toString());
		
		i.putExtra(THE_DATA, "The quotient is " + ans);
		
		//May error pag infinite ek ek (wala daw forever sabi ni sir Gubz)
		try {
			startActivity(i);
		} catch (Exception e) {
			Toast.makeText(getBaseContext(), "DEYM", 1).show();
		}
		
	}
}
