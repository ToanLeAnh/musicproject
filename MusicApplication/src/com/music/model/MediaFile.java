package com.music.model;

import android.provider.MediaStore;

public class MediaFile {
	
	public final static String Table = "tbl_media";
	
	public final static String Col_PATH =	"PATH";
	public final static String Col_DURATION = "DURATION";
	public final static String Col_TYPE = "TYPE";
	public final static String Col_PICTURE = "PICTURE";
	public final static String Col_TITLE = "TITLE";
	public final static String Col_SIZE =	"SIZE";
	public final static String Col_ARTIST = "ARTIST";
    public final static String Col_GENER = "GENER";
    public final static String Col_ALBUM = "ALBUM";
							
	private String path;
	private String duration;
	private String type;
	private String picture;
	private String title;
	private String size;
	private String artist;
	private String album;
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	
						
}
