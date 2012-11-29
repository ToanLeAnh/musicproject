package com.example.musicapplication;

import com.music.model.MediaPlayParcel;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class StreamMediaActivity extends Activity {

	VideoView videorun;
	protected String TAG = "StreamMediaActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_stream_media);
		
		String path;
		Intent intent = getIntent();
		Bundle a = intent.getBundleExtra("parcel");
		MediaPlayParcel info = (MediaPlayParcel)a.getParcelable("infObj");   
		path = info.getPathMedia();
		VideoView  video = (VideoView)findViewById(com.example.musicapplication.R.id.videoView1);
		
		MediaController mc = new MediaController(this);
		mc.setAnchorView(video);
		mc.setMediaPlayer(video);
		
		video.setVideoPath(path);
		video.setMediaController(new MediaController(this));
		video.requestFocus();
		video.start();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_stream_media, menu);
		return true;
	}

}
