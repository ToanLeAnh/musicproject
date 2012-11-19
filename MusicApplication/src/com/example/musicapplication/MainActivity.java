package com.example.musicapplication;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends SherlockActivity {

	com.actionbarsherlock.app.ActionBar actionBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actionBar = getSupportActionBar();
		
					
	}
	
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		// TODO Auto-generated method stub
		 
		//return super.onCreateOptionsMenu(menu);
		
		//create menu songs
		MenuItem menuItemSongs = menu.add("Songs");
		menuItemSongs.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		menuItemSongs.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				Intent songsIntent = new Intent(MainActivity.this,SongsActivity.class);
				startActivity(songsIntent);
				
				return true;
			}
		});
		
		//add menu artist, album, playslist
		
		menu.add("Artists").setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		menu.add("Albums").setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		menu.add("Playlists").setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		
		return true;
		
	}

	 

}
