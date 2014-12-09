package com.potato.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainShitz extends PreferenceActivity implements OnPreferenceClickListener{

	Preference auto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.main);
		
		auto = (Preference) findPreference("auto");
		auto.setOnPreferenceClickListener(this);
		
	}

	@Override
	public boolean onPreferenceClick(Preference preference) {
		// TODO Auto-generated method stub
		
		if (preference==auto){
			Intent i = new Intent(this,AutoComplete.class);
			startActivity(i);
		}
		
		return false;
	}
}
