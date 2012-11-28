package com.music.objectmapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;

import com.music.model.MediaFile;

public class DataSource_groupmedia {
	
	//This is support for group album
	List<HashMap<String,ArrayList<MediaFile>>> group;
	
	//
	List<HashMap<String,ArrayList<MediaFile>>> groupArtist;
	
	Object lock = new Object();
	Object lock2 = new Object();
	private String unknow = "Unknow";
	
	
	protected String TAG="DataSource_groupmedia";
	
	public List<HashMap<String, ArrayList<MediaFile>>> getGroup() {
		return group;
	}

	public List<HashMap<String, ArrayList<MediaFile>>> getArtist(){
		return groupArtist;
	}
	
	public DataSource_groupmedia(){
		group = new ArrayList<HashMap<String,ArrayList<MediaFile>>>();
		groupArtist = new ArrayList<HashMap<String,ArrayList<MediaFile>>>();
	}
	
	public void add_MediaFileToAlbums(MediaFile mediaFile){
		String nameAlbums = mediaFile.getAlbum();
		int i = 0 ;
		int isFound =1;
		
		if (nameAlbums == ""){
			nameAlbums = unknow;
		}
		
		synchronized(lock){
			for(i = 0;i < group.size() ; i ++){
				isFound = 1;
				if (group.get(i).containsKey(nameAlbums)){
					group.get(i).get(nameAlbums).add(mediaFile);
					isFound = 0;
					break;
				}
			}
			
			if (isFound == 1){
				HashMap<String, ArrayList<MediaFile>> new1= new HashMap<String, ArrayList<MediaFile>>();
				ArrayList<MediaFile> a = new ArrayList<MediaFile>();
				a.add(mediaFile);
				new1.put(nameAlbums,a);
				group.add(new1);
			}
		}
	}
	
	public void add_MediaFileToArtist(MediaFile mediaFile){
		String artist = mediaFile.getArtist();
		int i = 0 ;
		int isFound =1;
		if (artist == ""){
			artist = unknow;
		}
		
		synchronized(lock2){
			for(i = 0;i < groupArtist.size() ; i ++){
				isFound = 1;
				if (groupArtist.get(i).containsKey(artist)){
					groupArtist.get(i).get(artist).add(mediaFile);
					isFound = 0;
					break;
				}
			}
			
			if (isFound == 1){
				HashMap<String, ArrayList<MediaFile>> new1= new HashMap<String, ArrayList<MediaFile>>();
				ArrayList<MediaFile> a = new ArrayList<MediaFile>();
				a.add(mediaFile);
				new1.put(artist,a);
				groupArtist.add(new1);
			}
		}
	}
	
	
	
	
	
}












