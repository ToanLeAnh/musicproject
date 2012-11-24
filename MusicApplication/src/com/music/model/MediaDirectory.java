package com.music.model;

public class MediaDirectory {
	
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
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		String s="";
		s = this.name + this.path;
		return s.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (o == null){
			return false;
		}
			
		if (getClass() != o.getClass()){
			return false;
		}
		
		if (this.hashCode() == o.hashCode()){
			return true;
		}
				
		return false;
	}
}
