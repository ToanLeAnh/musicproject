package com.music.objectmapping;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import android.media.MediaMetadataRetriever;
import android.provider.MediaStore.Files;
import android.util.Log;

import com.music.model.MediaFile;
import com.music.utility.AudioFileFilter;

public class Datasource_mediafile {
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
	
    protected String TAG = "Datasource_mediafile";
    
    public Datasource_mediafile(){
    	
    }
    
    
    public List<MediaFile> getAllMediaFromSpecifiedFolders(){
    	List<MediaFile> lst_media = new ArrayList<MediaFile>();
    	String hd = "/sdcard/Download";
    	
    	File f = new File(hd);
    	Log.d(TAG,"Kiem tra folder");
    	File[] ttt  = f.listFiles();
    	for (File temp : ttt){
    		Log.d(TAG,temp.getName());
    	}
    	
    	MediaMetadataRetriever getMeta = new MediaMetadataRetriever(); 
    	
    	File[] file = f.listFiles(new AudioFileFilter());
    	
    	Log.i(TAG,f.getName());
    	
    	for (File fff : file){
    		Log.i(TAG,fff.getName());
    		getMeta.setDataSource(fff.getPath());
    		String albumName = getMeta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
    		Log.i(TAG,albumName);
    	}
    		
    	return lst_media;
    }
    
    
        
}





