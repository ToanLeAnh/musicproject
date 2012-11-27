package com.music.objectmapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;

import com.music.model.MediaFile;

public class DataSource_groupmedia {
	
	List<HashMap<String,List<MediaFile>>> group; 
	Object lock = new Object();
	protected String TAG="DataSource_groupmedia";
	
	public List<HashMap<String, List<MediaFile>>> getGroup() {
		return group;
	}

	
	public DataSource_groupmedia(){
		group = new ArrayList<HashMap<String,List<MediaFile>>>();
		Log.d(TAG,"Init Group");
	}
	
	public void add_MediaFileToAlbums(MediaFile mediaFile){
		Log.d(TAG,"Add here");
		synchronized(lock){
			Log.d(TAG,"Inside Method");
			String nameAlbums = mediaFile.getAlbum();
			
			int i = 0 ;
			int isFound =1;
			for(i = 0;i < group.size() ; i ++){
				isFound = 1;
				if (group.get(i).containsKey(nameAlbums)){
					group.get(i).get(nameAlbums).add(mediaFile);
					isFound = 0;
					Log.d(TAG,"Add new MediaFile");
					break;
				}
			}
			
			if (isFound == 1){
				HashMap<String, List<MediaFile>> new1= new HashMap<String, List<MediaFile>>();
				ArrayList<MediaFile> a = new ArrayList<MediaFile>();
				a.add(mediaFile);
				new1.put(nameAlbums,a);
				group.add(new1);
				Log.d(TAG,"Add new MediaFile");
			}
		}
	}
	
	
	
	
	
}












