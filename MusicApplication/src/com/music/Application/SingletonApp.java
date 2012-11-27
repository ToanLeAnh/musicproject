package com.music.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;

import android.content.Context;
import android.util.Log;

import com.music.model.MediaFile;
import com.music.objectmapping.Datasource_mediafile;
import com.music.objectmapping.DataSource_groupmedia;

public class SingletonApp {
	private static List<MediaFile> list_combine = null;
	private static List<MediaFile> list_media = null;
	private static List<MediaFile> list_media_folder = null;
	private static DataSource_groupmedia dic_albums=null;
	private static Context context = null;
	private static Object lock1 = new Object();
	
	private static String TAG = "SingletonApp";
	
	
	public static void init(Context contextObj){
		list_combine = new ArrayList<MediaFile>();
		list_media = new ArrayList<MediaFile>();
		list_media_folder = new ArrayList<MediaFile>();
		dic_albums = new DataSource_groupmedia();
		context = contextObj;
	}
	
	public static void getListMediaFileFromExternal(){
		//Log.d(TAG,String.valueOf(list_media.size()));
		if (list_media.size() == 0){
			Datasource_mediafile transfer_mediafile = new Datasource_mediafile(context);
			list_media = transfer_mediafile.getAllMediaFromExternalDevices();
			list_combine = list_media;
		}
	}
	
	public static void getListMediaFileFromFolders(){
		try{
			//lock.lock();
			if (list_media_folder.size() == 0){
				Datasource_mediafile transfer_mediafile = new Datasource_mediafile();
				list_media_folder = transfer_mediafile.getAllMediaFromSpecifiedFolders();
			}
		}
		finally{
			//lock.unlock();
		}
	}

	public static void sync(){
		new Thread(){
			public void run() {			
				getListMediaFileFromFolders();
				
				for (MediaFile a : list_media_folder){
					/*if (!list_combine.contains(a.getc)){
						list_combine.add(a);
					}
					*/
					int push = -1;
					MediaFile c = new MediaFile();;
					c= a;
					for (MediaFile b : list_media){
						if (a.equals(b)){
							push = 0 ;
							break;
						}
					}
					
					if ((c != null) && (push == -1)) {
						list_combine.add(c);
					}
				}
			};
		}.start();
	}
	
	public static void add_MediaToAlbum(MediaFile mediaFile){
		final MediaFile mediaFileTemp = mediaFile;
		new Thread(){
			public void run() {
				dic_albums.add_MediaFileToAlbums(mediaFileTemp);
			};
		}.start();
	}
	
	public static List<MediaFile> getList_media() {
		return list_combine;
	}
	
	public static List<MediaFile> getList_media_folder(){
		return list_media_folder;
	}
	
	public static List<HashMap<String,List<MediaFile>>> getGroupAlbums(){
		return dic_albums.getGroup();
	}
	
}
