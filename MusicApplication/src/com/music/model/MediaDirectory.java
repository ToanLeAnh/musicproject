package com.music.model;

public class MediaDirectory {
	
	public final static String Table = "tbl_directories";
	public final static String Col_DIRECTORY = "DIRECTORY";
	
	private String path;
	private String name;
	private String isChecked = "N";
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
