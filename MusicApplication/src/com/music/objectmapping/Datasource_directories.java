package com.music.objectmapping;

import java.util.ArrayList;
import java.util.List;

import com.music.model.MediaDirectory;
import com.music.model.MediaFile;
import com.music.sqlitehelper.DB_Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Contacts.Intents.Insert;
import android.util.Log;

public class Datasource_directories {
	
	public final static String Table = "tbl_directories";
	public final static String Col_DIRECTORY_NAME = "DIRECTORY_NAME";
	public final static String Col_DiRECTORY_PATH = "DIRECTORY_PATH";
	
	SQLiteDatabase db;
	DB_Helper dbhelper;
	
	String TAG = "Datasource_directories";
	String[] allCols = {Col_DIRECTORY_NAME,Col_DiRECTORY_PATH};
		
	public static String commandCreateDirectoryTable(){
		String sql = "";
		sql = "Create Table " + Table + " ( ";
		sql = sql + Col_DiRECTORY_PATH + " text PRIMARY KEY  ,";
		sql = sql + Col_DIRECTORY_NAME + " text )";
		return sql; 
	}
	
	public static String commandRemoveDrectoryTable(){
		String sql = "";
		sql = "drop table if exists " + Table;
		return sql;
	}
	
	public Datasource_directories(Context context){
		dbhelper = new DB_Helper(context);
	}
	
	public void open() throws SQLException{
		db = dbhelper.getWritableDatabase(); 
	}
	
	public void close(){
		db.close();
	}
	
	public List<MediaDirectory> getListAllDirectories(){
		int position_name = 0;
		int position_path = 0;
		List<MediaDirectory> lstDir = new ArrayList<MediaDirectory>();

		open();
		
		Cursor cursor =  db.query(Table, allCols, null, null, null, null, null);
		position_name = cursor.getColumnIndex(Col_DIRECTORY_NAME);
		position_path = cursor.getColumnIndex(Col_DiRECTORY_PATH);
				
		cursor.moveToFirst();
		while(cursor.isAfterLast() == false){
			MediaDirectory dir = new MediaDirectory();
			dir.setName(cursor.getString(position_name));
			dir.setPath(cursor.getString(position_path));
			lstDir.add(dir);
			cursor.moveToNext();
		}
		
		close();
		
		return lstDir;
	}
	
	public boolean save(MediaDirectory directory){
		ContentValues content = new ContentValues();
		
		if (directory != null){
			try{
				open();
				content.put(Col_DIRECTORY_NAME,directory.getName());
				content.put(Col_DiRECTORY_PATH,directory.getPath());
				db.insert(Table, null, content);
				close();
				Log.d(TAG,"Create successfully");
				return true;
			}
			catch(Exception ex){
				Log.d(TAG, ex.toString());
			}
		}
		return false;
	}
	
	public void delete(MediaDirectory directory){
		String pathKey = "";
		String sql = Col_DiRECTORY_PATH + " = " ;
		if (directory != null){
			open();
			pathKey = directory.getPath();
			sql = sql + pathKey;
			db.delete(Table, sql,null);
			close();
		}
	}
	
}
