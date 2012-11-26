package com.music.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediaAlbums {
	
	Map<String,List<MediaFile>> albums;
	
	public MediaAlbums(){
		albums = new HashMap<String, List<MediaFile>>();
	}
	
	public Map<String, List<MediaFile>> getAlbums() {
		return albums;
	}

	public void setAlbums(Map<String, List<MediaFile>> albums) {
		this.albums = albums;
	}

	
	
	public void addAlbum(String nameAlbums){
		if (!albums.containsKey(nameAlbums)){
			//albums[nameAlbums] = new ArrayList<MediaFile>();;
			albums.put(nameAlbums, new ArrayList<MediaFile>());
		}
	}
	
	public void addMediaToAlbum(String nameAlbums,MediaFile mediaFile){
		if (!this.albums.containsKey(nameAlbums)){
			albums.put(nameAlbums, new ArrayList<MediaFile>());
			this.albums.get(nameAlbums).add(mediaFile);
		}
		else{
			this.albums.get(nameAlbums).add(mediaFile);
		}
		
	}
	
	
}
