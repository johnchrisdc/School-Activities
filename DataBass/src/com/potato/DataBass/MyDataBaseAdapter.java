package com.potato.DataBass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBaseAdapter {

	static MyHelper helpah;
	
	public MyDataBaseAdapter(Context context){
		helpah = new MyHelper(context);
	}
	
	static class MyHelper extends SQLiteOpenHelper{
		
		private static final String DATABASS_NAME = "MyDB";
		private static final String TABLE_NAME = "tblTestJr";
		private static final int DATABASS_VERSION = 3;

		private static final String UID = "_id";
		private static final String NAME = "Name";
		private static final String PASSWORD = "Password";
		private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
				+ " (" + UID + " integer primary key autoincrement, " + NAME
				+ " varchar," + PASSWORD + " varchar(50))";

		private Context context;
		
		//Create DB
		public MyHelper(Context context) {
			//Create databass :P
			super(context, DATABASS_NAME, null, DATABASS_VERSION);
			this.context = context;
			
			Message.message(context, "Constructor called");
			
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				db.execSQL(CREATE_TABLE);   //Create Table
				Message.message(context, "Table created");
			} catch (SQLException e) {
				Message.message(context, "" + e);			
			}
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		}
		
		public long insertData( String name, String pass ){
			SQLiteDatabase db = helpah.getWritableDatabase();
			ContentValues con = new ContentValues();
			//Insert values to con
			con.put(MyHelper.NAME, name);
			con.put(MyHelper.PASSWORD, pass);
			
			//More insert
			long id = db.insert(MyHelper.TABLE_NAME, null, con);
			db.close();
			
			//Return!!!
			return id;
		}
		
		public String getAllData(){
			SQLiteDatabase db = helpah.getWritableDatabase();
			String[] columns = {MyHelper.UID , MyHelper.NAME, MyHelper.PASSWORD};
			
			Cursor c = db.query(MyHelper.TABLE_NAME, columns, null, null, null, null, null);
			StringBuffer buffer = new StringBuffer();
			
			while (c.moveToNext()){
				int cid = c.getInt(0);
				String name = c.getString(1);
				String pass = c.getString(2);
			
				buffer.append(cid + " " + name + " " + pass + "\n");
			}
			
			return buffer.toString();
			
		}
	}

}
