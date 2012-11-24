package com.music.objectmapping;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import android.media.MediaFormat;
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
    	MediaMetadataRetriever getMeta = new MediaMetadataRetriever(); 
    	String hd = "/sdcard/Download";
    	
    	File f = new File(hd);
    	/*
    	File[] ttt  = f.listFiles();
    	for (File temp : ttt){
    		Log.d(TAG,temp.getName());
    	}
    	*/
    	File[] file = f.listFiles(new AudioFileFilter());
    	
    	for (File fff : file){
    		MediaFile musicFile = new MediaFile();
    				
    		getMeta.setDataSource(fff.getPath());
    		musicFile.setAlbum(getMeta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
    		musicFile.setArtist(getMeta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
    		musicFile.setDuration(getMeta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
    		musicFile.setSize(String.valueOf(fff.length()));
    		musicFile.setTitle(getMeta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
    		musicFile.setComposer(getMeta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_COMPOSER));
    		musicFile.setGenre(getMeta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE));
    		lst_media.add(musicFile);
    	}
    		
    	return lst_media;
    }
    
    
        
}





