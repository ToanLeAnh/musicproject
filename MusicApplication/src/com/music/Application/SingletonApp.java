package com.music.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

import android.content.Context;
import android.util.Log;

import com.music.model.MediaAlbums;
import com.music.model.MediaFile;
import com.music.objectmapping.Datasource_mediafile;

public class SingletonApp {
	private static List<MediaFile> list_combine = null;
	private static List<MediaFile> list_media = null;
	private static List<MediaFile> list_media_folder = null;
	private static MediaAlbums dic_albums=null;
	private static Context context = null;
	private static Lock lock = null;
	
	private static String TAG = "SingletonApp";
	
	
	public static void init(Context contextObj){
		list_combine = new ArrayList<MediaFile>();
		list_media = new ArrayList<MediaFile>();
		list_media_folder = new ArrayList<MediaFile>();
		dic_albums = new MediaAlbums();
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
						Log.d("Nghia",a.getPath());
						Log.d("Nghia",b.getPath());
						if (a.equals(b)){
							push = 0 ;
							break;
						}
					}
					
					if ((c != null) && (push == -1)) {
						Log.d("kkk",String.valueOf(push));
						list_combine.add(c);
					}
				}
			};
		}.start();
	}
	
	public static List<MediaFile> getList_media() {
		return list_combine;
	}
	
	public static List<MediaFile> getList_media_folder(){
		return list_media_folder;
	}
	
	
}
