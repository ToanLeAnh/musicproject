package com.music.model;

import android.provider.MediaStore;
import android.util.Log;

public class MediaFile {
	
	private String path;
	private String duration;
	private String type;
	private String picture;
	private String title;
	private String size;
	private String artist;
	private String album;
	private String composer;
	private String genre;
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
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
	
	/*
	 * (non-Javadoc)
	 * For this object i just take care the path when i compare Object 
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		Log.d("chuoi",this.path);
		String s = "";
		s = this.path;
		return s.hashCode();
	}	
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		
		if (o == null){
			return false;
		}
		
		if(getClass() != o.getClass()){
			return false;
		}
		Log.d("Sao ky vay ta"," khong hieu gi het");
		if (this.hashCode() == o.hashCode()){
			return true;
		}
		
		return false;
		//return super.equals(o);
	}
		
}
