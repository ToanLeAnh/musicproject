package com.music.sqlitehelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.music.model.MediaDirectory;
import com.music.model.MediaFile;
import com.music.objectmapping.Datasource_directories;

public class DB_Helper extends SQLiteOpenHelper {
	
	Context contextObj;
	
	static final String TAG = "DB_Helper";
	
	static final String DB_NAME = "database.db";
	static final int DB_VERSION = 2;
	
	public DB_Helper(Context context){
		super(context,DB_NAME,null,DB_VERSION);
		this.contextObj = context; 
		Log.d(TAG, "Constructor...");
	}
	
	
	//Called Once when DB is created.
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.d(TAG,"Start on Create Table");
		String sql = Datasource_directories.commandCreateDirectoryTable();
		db.execSQL(sql);
		Log.d(TAG, "End on Create Table");
	} 

	//Called whenever oldVersion != newVersion.
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.d(TAG,"Start On Upgrate");
		
		String sql_mediafile = Datasource_directories.commandRemoveDrectoryTable();
		db.execSQL(sql_mediafile);
		
		
		
		Log.d(TAG, "End On Upgrate ");
		onCreate(db);
	}

}
