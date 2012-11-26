package com.music.Application;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.music.model.MediaAlbums;
import com.music.model.MediaFile;
import com.music.objectmapping.Datasource_mediafile;

public class SingletonApp {
	
	private static List<MediaFile> list_media = null;
	private static MediaAlbums dic_albums;
	private static Context context;
	
	private static String TAG = "SingletonApp";
	
	public static void init(Context contextObj){
		list_media = new ArrayList<MediaFile>();
		dic_albums = new MediaAlbums();
		context = contextObj;
		Log.d(TAG,"init");
	}
	
	public static void getListMediaFileFromExternal(){
		Log.d(TAG,"start 1");
		//Log.d(TAG,String.valueOf(list_media.size()));
		if (list_media.size() == 0){
			Datasource_mediafile transfer_mediafile = new Datasource_mediafile(context);
			Log.d(TAG,"start 3");
			list_media = transfer_mediafile.getAllMediaFromExternalDevices();
			
			Log.d(TAG,"getListMediaFileFromExternal");
		}
		else{
			Log.d(TAG,"sao ky vay ta");
		}
		
		
	}
	
	public static List<MediaFile> getList_media() {
		
		return list_media;
	}
	
}
