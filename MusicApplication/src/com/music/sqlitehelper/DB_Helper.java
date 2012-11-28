package com.music.sqlitehelper;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.music.model.MediaDirectory;
import com.music.model.MediaFile;
import com.music.objectmapping.DataSource_playlist;
import com.music.objectmapping.Datasource_directories;

public class DB_Helper extends SQLiteOpenHelper {
	
	Context contextObj;
	
	static final String TAG = "DB_Helper";
	
	static final String DB_NAME = "database.db";
	static final int DB_VERSION = 6;
	
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
		List<ContentValues> lst_contents;
		
		String sql = Datasource_directories.commandCreateDirectoryTable();
		String sql1 = DataSource_playlist.commandCreatePlayListsTable();
		lst_contents = DataSource_playlist.commandInsertPlayListTable();
		
		db.execSQL(sql);
		db.execSQL(sql1);
		
		for(ContentValues insertValue : lst_contents){
			Log.d(TAG,String.valueOf(insertValue.get(DataSource_playlist.Col_PLAYLIST)));
			Log.d(TAG,String.valueOf(insertValue.get(DataSource_playlist.Col_IS_SYSTEM)));
			
			db.insert(DataSource_playlist.Table, null, insertValue);
		}
		
		
		Log.d(TAG, "End on Create Table");
	} 

	//Called whenever oldVersion != newVersion.
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.d(TAG,"Start On Upgrate");
		
		String sql_mediafile = Datasource_directories.commandRemoveDrectoryTable();
		String sql_playlist = DataSource_playlist.commandRemovePlayListTable();
		
		db.execSQL(sql_mediafile);
		db.execSQL(sql_playlist);
		
		
		Log.d(TAG, "End On Upgrate ");
		onCreate(db);
	}

}
