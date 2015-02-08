package com.potato.DataBass;


import android.app.Activity;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	MyDataBaseAdapter mh;
	
	EditText name;
	EditText pass;
	
	String mName;
	String mPass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		
		//INS/TAN/SHIT 
		name = (EditText)findViewById(R.id.editTextName);
		pass =(EditText)findViewById(R.id.editTextPass);
		
		mh = new MyDataBaseAdapter(this);
		
	}
	
	//Button event for Add
	public void addUser(View xxx){
		mName = name.getText().toString();
		mPass = pass.getText().toString();
	
		long id = mh.helpah.insertData(mName, mPass);
		
		if(id < 0){
			Message.message(this, "Insert failed");
		}else{
			Message.message(this, "Insert success");
		}
		
	}
	
	//Button event for View
	public void viewDetails(View v ){
		String datax = mh.helpah.getAllData();
		
		Message.message(this, datax);
	}

}
