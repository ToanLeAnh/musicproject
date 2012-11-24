package com.music.utility;

import java.io.File;
import java.io.FileFilter;

import android.util.Log;

public class AudioFileFilter implements FileFilter {
	
	protected final String TAG = "AudioFileFilter";
	
	
	private enum SupportedExtensionFile{
		MP3("MP3"),
		MP4("MP4");
		
		private String filExtension;
		
		SupportedExtensionFile(String fileExtension){
			this.filExtension = fileExtension;
		}
		
		public String getFileExtension(){
			return this.filExtension;
		}
	};

	private String getExtensionFile(File file){
		return getExtensionFile(file.getName());
	}
	
	private String getExtensionFile(String fileName){
		String extension = "";
		int position = fileName.indexOf(".");
		if (position > 0){
			extension = fileName.substring(position +1);
			return extension;
		}
		else{
			return "";
		}
	}
	
	private boolean checkExtensionFile(File file){
		String extension = "";
		extension = getExtensionFile(file);
		
		if (extension != ""){
			try{
				Log.d(TAG,SupportedExtensionFile.valueOf(extension.toUpperCase()).toString());
				
				if (SupportedExtensionFile.valueOf(extension.toUpperCase()) != null){
					return true;
				}
			}
			catch(Exception ex){}
		}
		
		return false;
	}
	
	
	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		
		if ((file.isHidden() == true) || (!file.canRead())){
			return false;
		}
		
		if (file.isDirectory()){
			return false;
		}
		
		if (checkExtensionFile(file)){
			return true;
		}
		
		return false;
	};
		
	
	
}
