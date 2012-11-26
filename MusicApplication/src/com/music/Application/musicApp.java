package com.music.Application;

import com.music.objectmapping.Datasource_mediafile;

import android.app.Application;
import android.util.Log;

public class musicApp extends Application {
	
	protected String TAG ="musicApp";
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		SingletonApp.init(getApplicationContext());
		Log.d(TAG,"App is on Create");
		
	}
	
	
}
