package com.music.objectmapping;

import java.util.ArrayList;
import java.util.List;

import com.music.model.MediaPlayList;
import com.music.sqlitehelper.DB_Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataSource_playlist {
	public final static String Table = "tbl_playlists";
	
	public final static String Col_PLAYLIST = "PLAYLIST";
	public final static String Col_IS_SYSTEM = "IS_SYSTEM";
	
	private static String nameDefault1 = "Nghe Nhieu Nhat";
	private static String nameDefault2 = "Nghe Gan Nhat";
	
	private List<MediaPlayList> playplist;
	private DB_Helper dbhelper;
	private SQLiteDatabase db;
	private String[] allCols = {Col_PLAYLIST,Col_IS_SYSTEM};
	
	protected String TAG = "DataSource_playlist"; 
	
	Context context;
	
	public DataSource_playlist(){
		playplist = new ArrayList<MediaPlayList>();
	}
	
	public DataSource_playlist(Context context){
		playplist = new ArrayList<MediaPlayList>();
		dbhelper = new DB_Helper(context);
		this.context = context;
	}
	
	public List<MediaPlayList> getPlayplist(){
		return playplist;
	}
	
	public static String commandCreatePlayListsTable(){
		String sql = "";
		sql = "Create Table " + Table + " ( ";
		sql = sql + Col_PLAYLIST + " text PRIMARY KEY  ,";
		sql = sql + Col_IS_SYSTEM + " text )";
		return sql; 
	}
	
	public static String commandRemovePlayListTable(){
		String sql = "";
		sql = "drop table if exists " + Table;
		return sql;
	}
	
	public void open(){
		db = dbhelper.getWritableDatabase();
	}
	
	public void close(){
		db.close();
	}
	
	public static List<ContentValues> commandInsertPlayListTable(){
		
		List<ContentValues> lst_ContentValues = new ArrayList<ContentValues>();
		
		ContentValues value1 = new ContentValues();
		value1.put(Col_PLAYLIST, nameDefault1);
		value1.put(Col_IS_SYSTEM,"Y");
		
		ContentValues value2 = new ContentValues();
		value2.put(Col_PLAYLIST, nameDefault2);
		value2.put(Col_IS_SYSTEM,"Y");
		
		lst_ContentValues.add(value1);
		lst_ContentValues.add(value2);
		
		return lst_ContentValues;
	}
	
	public void getAllThePlayPlistFromDB(){
		int name_position= 0;
		int isSystem_position = 0;
		
		String namePlayPlist = "";
		String isSystemPlayPlist = "";
		
		open();
		Cursor cursor ;
		cursor = db.query(Table,allCols, null, null, null, null, null);
		
		cursor.moveToFirst();
		name_position = cursor.getColumnIndex(Col_PLAYLIST);
		isSystem_position = cursor.getColumnIndex(Col_IS_SYSTEM);
		
		
		while(cursor.isAfterLast()== false){
			namePlayPlist = cursor.getString(name_position);
			isSystemPlayPlist = cursor.getString(isSystem_position);
			MediaPlayList playplistObj = new MediaPlayList();
			playplistObj.setPlaylist(namePlayPlist);
			playplist.add(playplistObj);
			Log.d(TAG,"PlayLisst");
			cursor.moveToNext();
		}
		
		close();
	}
	
	

}
