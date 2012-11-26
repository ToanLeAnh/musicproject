package com.music.objectmapping;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import android.app.DownloadManager.Query;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.util.Log;

import com.music.model.MediaAlbums;
import com.music.model.MediaFile;
import com.music.utility.AudioFileFilter;
import com.music.utility.Common;

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
    
    Context context;
    
    private final static String[] projection = {android.provider.MediaStore.Audio.AudioColumns.DATA,
    					   					   android.provider.MediaStore.Audio.AudioColumns.DURATION,
    					   
    					   
    					   					   android.provider.MediaStore.Audio.AudioColumns.TITLE,
    					   					   android.provider.MediaStore.Audio.AudioColumns.SIZE,
    					   					   android.provider.MediaStore.Audio.AudioColumns.ARTIST,
    					   
    					   					   android.provider.MediaStore.Audio.AudioColumns.ALBUM
    					   
    };
    
    public Datasource_mediafile(Context context){
    	this.context = context;
    }
    
    public Datasource_mediafile(){
    }
    
    
    public List<MediaFile> getAllMediaFromSpecifiedFolders(){
    	List<MediaFile> lst_media = new ArrayList<MediaFile>();
    	MediaMetadataRetriever getMeta = new MediaMetadataRetriever(); 
    	String hd = "/mnt/sdcard/Download";
    	
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
    		
    		musicFile.setPath(fff.getPath());
    		musicFile.setAlbum(Common.checkData(getMeta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM)));
    		musicFile.setArtist(Common.checkData(getMeta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST)));
    		musicFile.setDuration(Common.checkData(getMeta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)));
    		musicFile.setSize(String.valueOf(fff.length()));
    		musicFile.setTitle(fff.getName());
    		musicFile.setComposer(Common.checkData(getMeta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_COMPOSER)));
    		musicFile.setGenre(Common.checkData(getMeta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE)));
    		lst_media.add(musicFile);
    	}
    		
    	return lst_media;
    }
    
    
    public List<MediaFile> getAllMediaFromExternalDevices(Context context){
    	List<MediaFile> lst_media;
    	this.context = context;
    	lst_media = this.getAllMediaFromExternalDevices();
    	return lst_media;
    }
    
    public List<MediaFile> getAllMediaFromExternalDevices(){
    	List<MediaFile> lst_media = new ArrayList<MediaFile>();
    	int data_position = 0;
    	int duration_position = 0;
    	int type_position = 0;
    	int picture_position = 0;
    	int title_position = 0;
    	int size_position = 0 ;
    	int artist_position = 0;
    	int genre_position = 0;
    	int album_position =0;
    	
    	Cursor cursor =context.getContentResolver().query(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, Datasource_mediafile.projection, null, null, null);
    	
    	cursor.moveToFirst();
    	
    	data_position = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.DATA);
    	duration_position = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.DURATION);
    	//ToDo : Miss type and picture field. 
    	title_position = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.TITLE);
    	size_position = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.SIZE);
    	artist_position = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.ARTIST);
    	album_position = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.ALBUM);
    	//ToDo : Miss genre filed.
    	
    	while(cursor.isAfterLast() == false){
    		Log.d(TAG,"Nghia");
    		MediaFile mediaFile = new MediaFile();
    		mediaFile.setPath(cursor.getString(data_position));
    		mediaFile.setDuration(cursor.getString(duration_position));
    		//Todo:
    		mediaFile.setTitle(cursor.getString(title_position));
    		mediaFile.setSize(cursor.getString(size_position));
    		mediaFile.setAlbum(cursor.getString(album_position));
    		mediaFile.setArtist(cursor.getString(artist_position));
    		
    		lst_media.add(mediaFile);
    		cursor.moveToNext();
    	}
    	
    	return lst_media;
    }
      
    /*public MediaAlbums getAlbumsFromExteralDevices(){
    	MediaAlbums albums;
    	//context.getContentResolver().query(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projection, selection, selectionArgs, sortOrder)
    	return albums;
    }
    */
    
}





