package com.potato.activity;

import com.potato.activity.calculator.Calculator;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;

public class MainShitz extends PreferenceActivity implements OnPreferenceClickListener{

	Preference auto;
	Preference calc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.main);
		
		auto = (Preference) findPreference("auto");
		auto.setOnPreferenceClickListener(this);
		
		calc = (Preference) findPreference("calc");
		calc.setOnPreferenceClickListener(this);
	}
	
	@Override
	public boolean onPreferenceClick(Preference preference) {
		// TODO Auto-generated method stub
		//Shortcutz :P
		if (preference==auto){
			Intent i = new Intent(this,AutoComplete.class);
			startActivity(i);
		}
		
		if (preference==calc){
			Intent i = new Intent(this,Calculator.class);
			startActivity(i);
		}
		
		return false;
	}
}
