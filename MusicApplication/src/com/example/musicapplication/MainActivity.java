package com.example.musicapplication;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;


import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.component.tab.AlbumsFragment;
import com.component.tab.ArtistFragment;
import com.component.tab.FoldersFragment;
import com.component.tab.PlayListFragment;
import com.component.tab.SongsFragment;

public class MainActivity extends SherlockFragmentActivity{

	com.actionbarsherlock.app.ActionBar actionBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
 
        actionBar.setDisplayShowTitleEnabled(true);
 
        Tab tab = actionBar.newTab()
                    .setText("Songs")
                    .setTabListener(new SongsFragment());
                    //.setIcon(R.drawable.songs);
        
        actionBar.addTab(tab);
        
        Tab tab_Album = actionBar.newTab()
                .setText("Albums")
                .setTabListener(new AlbumsFragment());
                //.setIcon(R.drawable.songs);

        actionBar.addTab(tab_Album);
        
        Tab tab_Artist = actionBar.newTab()
                .setText("Artist")
                .setTabListener(new ArtistFragment());
                //.setIcon(R.drawable.songs);

        actionBar.addTab(tab_Artist);

        Tab tab_Playlist = actionBar.newTab()
                .setText("Playlist")
                .setTabListener(new PlayListFragment());
                //.setIcon(R.drawable.songs);

        actionBar.addTab(tab_Playlist);

        Tab tab_Folder = actionBar.newTab()
                .setText("Folders")
                .setTabListener(new FoldersFragment());
                //.setIcon(R.drawable.songs);

        actionBar.addTab(tab_Folder);

        
		//setContentView(R.layout.activity_main);
		//actionBar = getSupportActionBar();
		
					
	}
	
	/*
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

	 */

}
