package com.music.model;

public class MediaPlayList {
	public final static String Col_PLAYLIST = "PLAYLIST";
	public final static String Col_IS_SYSTEM = "IS_SYSTEM";
	
	private String playlist = "";
	private String is_system = "";
	
	public String getPlaylist() {
		return playlist;
	}
	public void setPlaylist(String playlist) {
		this.playlist = playlist;
	}
	
	
	public String getIs_system() {
		return is_system;
	}
	public void setIs_system(String is_system) {
		this.is_system = is_system;
	}
	
	
	
}
